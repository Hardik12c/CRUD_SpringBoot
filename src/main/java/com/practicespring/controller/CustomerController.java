package com.practicespring.controller;

import com.practicespring.model.Customer;
import com.practicespring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    //    Get all users
    @GetMapping("/")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }


    //    Get customer by its id
    @GetMapping("{CustomerId}")
    public ResponseEntity<Customer> getCustomerbyId(@PathVariable("CustomerId") Integer id) {
        return customerService.getCustomerbyId(id);
    }

    //add the Customer
    @PostMapping("/addcustomer")
    public ResponseEntity<String> addcustomer(@RequestBody Customer customer) {
        return customerService.addcustomer(customer);
    }

    //    update the customer
    @PutMapping("{CustomerId}")
    public ResponseEntity<Customer> updatetheuser(@RequestBody Customer customer, @PathVariable("CustomerId") Integer id) {
        return customerService.updateuser(customer, id);
    }

    //    Deleting the customer
    @DeleteMapping("{CustomerId}")
    public ResponseEntity<String> deletecustomer(@PathVariable("CustomerId") Integer id) {
        return customerService.deletecustomer(id);
    }
}
