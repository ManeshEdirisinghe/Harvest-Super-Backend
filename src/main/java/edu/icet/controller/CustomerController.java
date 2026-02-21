package edu.icet.controller;

import edu.icet.model.Customer;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/add-customer")
    public boolean addCustomer(@RequestBody Customer customer){
       return customerService.addCustomer(customer);
    }

    @PutMapping("/update-customer")
    public boolean updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete-customer/{id}")
    public boolean deleteCustomer(@PathVariable String id){
        return customerService.deleteCustomer(id);
    }


    @GetMapping("/get-all")
    public List<Customer> getAll(){

        return customerService.getAll();
    }
}

