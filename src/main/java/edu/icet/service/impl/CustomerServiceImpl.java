package edu.icet.service.impl;

import edu.icet.model.Customer;
import edu.icet.model.Item;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public boolean addCustomer(Customer customer) {
        return customerRepository.addCustomer(customer);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerRepository.addCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(String id) {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAllCustomers();
    }
}

