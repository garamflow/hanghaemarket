package com.github.garamflow.hanghaemarket.dto;

import com.github.garamflow.hanghaemarket.domain.Item;
import lombok.Getter;

@Getter
public class ItemResponse {
    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;

    public ItemResponse(Item item) {
        this.id = item.getId();
        this.username = item.getUsername();
        this.title = item.getTitle();
        this.content = item.getContent();
        this.price = item.getPrice();
    }
}
