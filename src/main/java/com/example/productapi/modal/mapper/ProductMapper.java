package com.example.productapi.modal.mapper;

import com.example.productapi.modal.Category;
import com.example.productapi.modal.Product;
import com.example.productapi.modal.dto.ProductRequestDTO;
import com.example.productapi.modal.dto.ProductResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product getrequest(ProductRequestDTO productRequestDTO, Category category) {
        Product product = new Product();
        product.setCategory(category);
        product.setName(productRequestDTO.getNom());
        product.setPrice(productRequestDTO.getPrix());
        return product;
    }

    public ProductResponseDTO getresponse(Product product){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setNom(product.getName());
        productResponseDTO.setPrix(product.getPrice());
        productResponseDTO.setNomCategorie(product.getCategory().getName());
        return productResponseDTO;


    }
}
