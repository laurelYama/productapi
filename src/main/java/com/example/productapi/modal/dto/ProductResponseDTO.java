package com.example.productapi.modal.dto;

public class ProductResponseDTO {
    private String nom;
    private double prix;

    public ProductResponseDTO(double prix, String nom) {
        this.prix = prix;
        this.nom = nom;
    }
    public ProductResponseDTO(){

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
