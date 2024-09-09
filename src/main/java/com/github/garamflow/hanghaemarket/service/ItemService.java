package com.github.garamflow.hanghaemarket.service;

import com.github.garamflow.hanghaemarket.domain.Item;
import com.github.garamflow.hanghaemarket.dto.UpdateItemRequest;
import com.github.garamflow.hanghaemarket.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Transactional
    public Item updateItem(Long id, UpdateItemRequest request) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾지 못했습니다." + id));

        item.update(request.getTitle(), request.getContent());

        return item;
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
