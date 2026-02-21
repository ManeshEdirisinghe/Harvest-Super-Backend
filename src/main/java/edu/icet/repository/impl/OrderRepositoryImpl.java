package edu.icet.repository.impl;

import edu.icet.model.Order;
import edu.icet.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean addOrder(Order order) {
        String sql = "INSERT INTO orders VALUES (?, ?)";
        return jdbcTemplate.update(sql,
                order.getId(),
                Date.valueOf(order.getDate())) > 0;
    }

    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Order order = new Order();
            order.setId(rs.getInt(1));
            order.setDate(rs.getDate(2).toLocalDate());
            return order;
        });
    }

    @Override
    public boolean updateOrder(Order order) { return false; }

    @Override
    public boolean deleteOrder(Integer id) { return false; }
}