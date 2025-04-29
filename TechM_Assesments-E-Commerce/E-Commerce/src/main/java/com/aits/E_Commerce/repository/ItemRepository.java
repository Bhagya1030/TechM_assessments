package com.aits.E_Commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aits.E_Commerce.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
