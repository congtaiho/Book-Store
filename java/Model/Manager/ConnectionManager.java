/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isi
 */

public class ConnectionManager {

    private static String login = "root";
    private static String password = "abc123...";
    private static String urlServeur = "jdbc:mariadb://localhost:3310/bdEBoutiqueLivres";
    private static Connection connection = null;
    public static PreparedStatement getPs(String query) {
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(urlServeur, login, password);
            preparedStatement = connection.prepareStatement(query);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return preparedStatement;
    }
    public static void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
