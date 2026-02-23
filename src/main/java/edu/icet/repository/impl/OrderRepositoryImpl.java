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
        String sql = "INSERT INTO orders (OrderID, OrderDate, CustID) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql,
                order.getOrderId(),
                Date.valueOf(order.getDate()),
                order.getCustId()
        ) > 0;
    }

    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Order order = new Order();
            order.setOrderId(rs.getString("OrderID"));
            order.setDate(rs.getDate("OrderDate").toLocalDate());
            order.setCustId(rs.getString("CustID"));
            return order;
        });
    }
}