/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Manager;

import Model.Entity.Livre;
import Model.Entity.Panier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isi
 */
public class LivreManager {

    public static ArrayList<Livre> getAllLives() {
        ArrayList<Livre> lives = null;
        String query = "select * from livres";
        PreparedStatement preparedStatement = ConnectionManager.getPs(query);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            //permet de savoir s il y a des données dans le resultset
            if (resultSet.isBeforeFirst()) {
                lives = new ArrayList<>();
                while (resultSet.next()) {
                    lives.add(new Livre(resultSet));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivreManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionManager.close();
        return lives;
    }

    public ArrayList<Livre> getListLivreByCategorie(String categorie) {
        ArrayList<Livre> lives = new ArrayList<>();
        String query = "select * from livres where idCategorie like ?";
        PreparedStatement preparedStatement = ConnectionManager.getPs(query);

        try {
            preparedStatement.setString(1, categorie);
            ResultSet resultSet = preparedStatement.executeQuery();
            //permet de savoir s il y a des données dans le resultset
            if (resultSet.isBeforeFirst()) {
//                lives = new ArrayList<>();
                while (resultSet.next()) {
                    lives.add(new Livre(resultSet));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivreManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionManager.close();
        return lives;

    }

    public Livre getLivreById(String idLivre) {
        Livre unLive = null;
        String query = "select * from livres where idLivre like ?";
        PreparedStatement preparedStatement = ConnectionManager.getPs(query);

        try {
            preparedStatement.setString(1, idLivre);
            ResultSet resultSet = preparedStatement.executeQuery();
            //permet de savoir s il y a des données dans le resultset
            if (resultSet.isBeforeFirst()) {

                while (resultSet.next()) {
                    unLive = new Livre(resultSet);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivreManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionManager.close();
        return unLive;
    }

    public List<Panier> getCartProducts(ArrayList<Panier> panierList) {
        List<Panier> reserves = new ArrayList<>();
        try {
            if (panierList.size() > 0) {
                for (Panier item : panierList) {

                    String query = "select * from Livres where idLivre like ?";
                     PreparedStatement preparedStatement = ConnectionManager.getPs(query);
                    preparedStatement.setString(1, item.getIdLivre());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        Panier row = new Panier();
                        row.setIdLivre(resultSet.getString("idLivre"));
                        row.setTitleProd(resultSet.getString("libelleProd"));
                        row.setIdCatg(resultSet.getString("idCategorie"));
                        row.setPrix(resultSet.getDouble("prix")*item.getQuantite());
//                        row.setQuantite(item.getQuantite());
                        reserves.add(row);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return reserves;
    }
}
