package edu.icet.service;

import edu.icet.model.Item;

import java.util.List;

public interface ItemService {
    boolean addItem(Item item);

    boolean updateItem(Item item);

    boolean deleteItem(String id);

    List<Item> getAll();
}
