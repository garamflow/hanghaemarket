package com.github.garamflow.hanghaemarket.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Builder
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

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
