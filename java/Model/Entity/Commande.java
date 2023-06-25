/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import java.util.ArrayList;

/**
 *
 * @author isi
 */
public class Commande {
    ArrayList<Livre>listLivres;
    String dateCommmande;
    int idClient;
    int idCommmande;

    public Commande() {
    }

    public Commande(ArrayList<Livre> listLivres, String dateCommmande, int idClient, int idCommmande) {
        this.listLivres = listLivres;
        this.dateCommmande = dateCommmande;
        this.idClient = idClient;
        this.idCommmande = idCommmande;
    }

    public ArrayList<Livre> getListLivres() {
        return listLivres;
    }

    public void setListLivres(ArrayList<Livre> listLivres) {
        this.listLivres = listLivres;
    }

    public String getDateCommmande() {
        return dateCommmande;
    }

    public void setDateCommmande(String dateCommmande) {
        this.dateCommmande = dateCommmande;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdCommmande() {
        return idCommmande;
    }

    public void setIdCommmande(int idCommmande) {
        this.idCommmande = idCommmande;
    }

    
}
