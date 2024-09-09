package com.github.garamflow.hanghaemarket.repository;

import com.github.garamflow.hanghaemarket.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
