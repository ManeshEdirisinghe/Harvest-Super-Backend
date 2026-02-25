package edu.icet.controller;

import edu.icet.model.Customer;
import edu.icet.model.Order;
import edu.icet.service.CustomerService;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;

    @PostMapping("/add-order")
    public boolean addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }

    @GetMapping("/get-all")
    public List<Order> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/get-all-customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAll();
    }
}