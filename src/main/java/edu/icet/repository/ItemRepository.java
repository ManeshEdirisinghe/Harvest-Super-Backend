package edu.icet.repository;


import edu.icet.model.Item;

import java.util.List;

public interface ItemRepository {
        boolean addItem(Item item);
        boolean updateItem(Item item);
        boolean deleteItem(String id);
        List<Item> getAllItems();
}

