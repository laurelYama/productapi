package com.example.productapi.modal.mapper;

import com.example.productapi.modal.Product;
import com.example.productapi.modal.dto.ProductRequestDTO;
import com.example.productapi.modal.dto.ProductResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product getrequest(ProductRequestDTO productRequestDTO){
        Product product = new Product();
        product.setName(productRequestDTO.getNom());
        product.setPrice(product.getPrice());
        return product;
    }

    public ProductResponseDTO getresponse(Product product){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setNom(product.getName());
        productResponseDTO.setPrix(product.getPrice());
        return productResponseDTO;


    }
}
