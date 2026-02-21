package edu.icet.service.impl;

import edu.icet.model.Order;
import edu.icet.repository.OrderRepository;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public boolean addOrder(Order order) {
        return orderRepository.addOrder(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.getAllOrders();
    }
}