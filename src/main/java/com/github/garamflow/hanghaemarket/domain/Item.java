package com.github.garamflow.hanghaemarket.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column
    private int price;

    @Builder
    public Item(Long id, String username, String title, String content, int price) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.price = price;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
