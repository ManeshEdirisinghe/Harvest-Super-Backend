package edu.icet.controller;

import edu.icet.model.Item;
import edu.icet.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
@CrossOrigin
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/add-item")
    public boolean addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @PutMapping("/update-item")
    public boolean updateItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }

    @DeleteMapping("/delete-item/{code}")
    public boolean deleteItem(@PathVariable String code) {
        return itemService.deleteItem(code);
    }

    @GetMapping("/get-all")
    public List<Item> getAll() {
        return itemService.getAll();
    }
}