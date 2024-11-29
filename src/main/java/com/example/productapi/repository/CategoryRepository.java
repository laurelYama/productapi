package com.example.productapi.repository;

import com.example.productapi.modal.Category;
import com.example.productapi.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByName(String name);
}
