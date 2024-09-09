package com.github.garamflow.hanghaemarket.dto;

import com.github.garamflow.hanghaemarket.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddItemRequest {

    private String username;
    private String title;
    private String content;
    private int price;

    public Item toItem() {
        return Item.builder()
                .username(username)
                .title(title)
                .content(content)
                .price(price)
                .build();
    }
}
