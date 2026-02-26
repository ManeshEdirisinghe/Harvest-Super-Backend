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
        // 1. Order table ekata insert kireema
        String sqlOrder = "INSERT INTO orders VALUES (?, ?, ?)";
        boolean isOrderSaved = jdbcTemplate.update(sqlOrder,
                order.getOrderId(),
                Date.valueOf(order.getDate()),
                order.getCustId()) > 0;

        if (isOrderSaved) {
            String sqlDetail = "INSERT INTO orderdetail VALUES (?, ?, ?, ?)";
            for (OrderDetail detail : order.getOrderDetails()) {
                jdbcTemplate.update(sqlDetail,
                        order.getOrderId(),
                        detail.getItemCode(),
                        detail.getQty(),
                        detail.getDiscount());
            }
            return true;
        }
        return false;
    }

    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Order order = new Order();
            order.setOrderId(rs.getString("OrderID"));
            order.setDate(rs.getDate("OrderDate").toLocalDate());
            order.setCustId(rs.getString("custID"));
            return order;
        });
    }

}