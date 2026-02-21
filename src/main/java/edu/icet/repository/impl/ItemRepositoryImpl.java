package edu.icet.repository.impl;

import edu.icet.model.Item;
import edu.icet.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean addItem(Item item) {
        String sql = "INSERT INTO item VALUES (?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
                item.getCode(),
                item.getDescription(),
                item.getPackSize(),
                item.getUnitPrice(),
                item.getQtyOnHand()
        ) > 0;
    }

    @Override
    public List<Item> getAllItems() {
        String sql = "SELECT * FROM item";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Item item = new Item();
            item.setCode(rs.getString(1));
            item.setDescription(rs.getString(2));
            item.setPackSize(rs.getString(3));
            item.setUnitPrice(rs.getDouble(4));
            item.setQtyOnHand(rs.getInt(5));
            return item;
        });
    }

    @Override
    public boolean updateItem(Item item) {
        return false;
    }

    @Override
    public boolean deleteItem(String code) {
        return false;
    }
}