package edu.icet.service.impl;

import edu.icet.model.Item;
import edu.icet.repository.ItemRepository;
import edu.icet.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public boolean addItem(Item item) {
        return itemRepository.addItem(item);
    }

    @Override
    public boolean updateItem(Item item) {
        return itemRepository.updateItem(item);
    }

    @Override
    public boolean deleteItem(String code) {
        return itemRepository.deleteItem(code);
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.getAllItems();
    }
}