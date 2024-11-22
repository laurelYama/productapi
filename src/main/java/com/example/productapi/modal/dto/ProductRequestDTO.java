package com.example.productapi.modal.dto;

public class ProductRequestDTO {
    private String nom;
    private String prix;

    public ProductRequestDTO(String prix, String nom) {
        this.prix = prix;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }




}
