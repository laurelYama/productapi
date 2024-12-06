package com.example.productapi.service;

import com.example.productapi.modal.Product;
import com.example.productapi.modal.dto.ProductRequestDTO;
import com.example.productapi.modal.dto.ProductResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    // Récupérer tous les produits (sans pagination)
    List<ProductResponseDTO> getAllProducts();

    // Récupérer un produit par son ID
    ProductResponseDTO getProductById(Long id);

    // Créer un nouveau produit
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    // Mettre à jour un produit existant
    ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO);

    // Supprimer un produit par son ID
    void deleteProduct(Long id);

    // Récupérer tous les produits avec pagination
    Page<ProductResponseDTO> getAllProducts(Pageable pageable);

    ProductResponseDTO getProductByName(String name);
}
