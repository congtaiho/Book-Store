/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

/**
 *
 * @author isi
 */
public class DetailCommande {
    int quantite;
    double prix;
    int idCommande;
    int idLivre;

    public DetailCommande() {
    }

    public DetailCommande(int quantite, double prix, int idCommande, int idLivre) {
        this.quantite = quantite;
        this.prix = prix;
        this.idCommande = idCommande;
        this.idLivre = idLivre;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }
    
}
