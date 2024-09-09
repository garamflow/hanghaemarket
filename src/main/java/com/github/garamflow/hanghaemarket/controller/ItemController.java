package com.github.garamflow.hanghaemarket.controller;

import com.github.garamflow.hanghaemarket.domain.Item;
import com.github.garamflow.hanghaemarket.dto.ItemResponse;
import com.github.garamflow.hanghaemarket.dto.UpdateItemRequest;
import com.github.garamflow.hanghaemarket.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item createdItem = itemService.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @GetMapping
    public ResponseEntity<List<ItemResponse>> getAllItems() {
        List<ItemResponse> items = itemService.getAllItems()
                .stream().map(ItemResponse::new)
                .toList();
        return ResponseEntity.ok(items);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id ,@RequestBody UpdateItemRequest request) {
        Item updatedItem = itemService.updateItem(id, request);

        return ResponseEntity.ok()
                .body(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);

        Map<String, String> response = new HashMap<>();
        response.put("msg", "삭제완료");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
