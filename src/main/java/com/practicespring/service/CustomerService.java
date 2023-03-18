package com.practicespring.service;


import constants.Crudconstants;
import com.practicespring.repository.CustomerRepository;
import com.practicespring.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;


    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public ResponseEntity<Customer> getCustomerbyId(int id){
        if(customerRepository.findByid(id)==null){
            return new ResponseEntity(Crudconstants.getIdNotFound(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerRepository.findByid(id),HttpStatus.OK);
    }

    public ResponseEntity<String> addcustomer(Customer customer){
        if (customer.getAge() != null && customer.getEmail() != null && customer.getName() != null) {
            customerRepository.save(customer);
            return new ResponseEntity<>("{\"message\":\"" + "Data saved successfully" + "\"}", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("{\"message\":\"" + "something went wrong" + "\"}", HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> deletecustomer(Integer id){
        if(customerRepository.findByid(id)==null){
            return new ResponseEntity<>(Crudconstants.getIdNotFound(),HttpStatus.NOT_FOUND);
        }
        customerRepository.deleteById(id);
        return new ResponseEntity<>("Data deleted successfully",HttpStatus.OK);
    }

    public ResponseEntity<Customer> updateuser(Customer customer,int id){
        Customer oldcustomer=(customerRepository.findByid(id));
        if(oldcustomer==null){
            return new ResponseEntity(Crudconstants.getIdNotFound(),HttpStatus.NOT_FOUND);
        }
        oldcustomer.setAge(customer.getAge());
        oldcustomer.setEmail(customer.getEmail());
        oldcustomer.setAge(customer.getAge());
        customerRepository.save(oldcustomer);
        return new ResponseEntity<>(oldcustomer,HttpStatus.OK);
    }

}
