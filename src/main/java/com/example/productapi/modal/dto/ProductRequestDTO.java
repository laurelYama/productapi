package com.example.productapi.modal.dto;

public class ProductRequestDTO {
    private String nom;
    private double prix;

    public ProductRequestDTO(double prix, String nom) {
        this.prix = prix;
        this.nom = nom;
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
