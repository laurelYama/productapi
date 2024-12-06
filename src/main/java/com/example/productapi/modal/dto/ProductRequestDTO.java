package com.example.productapi.modal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRequestDTO {
    private String nom;
    private double prix;
    private String nomCategorie;
}
