package edu.icet.service;

import edu.icet.model.Customer;
import edu.icet.model.Item;

import java.util.List;

public interface CustomerService {

    boolean addCustomer(Customer customer);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomer(String id);

    List<Customer> getAll();
}