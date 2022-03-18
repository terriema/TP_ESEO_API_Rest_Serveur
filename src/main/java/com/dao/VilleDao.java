package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;



public class VilleDao {
private Connection connexion;
    
    public ArrayList<String> recupererVilles(String codePostal) {
    	ArrayList<String> listVille = new ArrayList<String>();
        ResultSet resultat = null;

        loadDatabase();
        
        try {
        	
        	connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/twicmaven", "root", "");
        	
            // Ex�cution de la requ�te
            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT nom_commune FROM ville_france WHERE code_postal = ?;");
            preparedStatement.setString(1, codePostal);
            
            resultat = preparedStatement.executeQuery();
            // R�cup�ration des donn�es
            while (resultat.next()) {
               
                String ville = resultat.getString(1);
            	listVille.add(ville);
            }
        } catch (SQLException e) {
        	 e.printStackTrace();
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException e) {
            	 e.printStackTrace();
            }
        }
        
        return listVille;
    }
    
    public void ajouterVille(String codePostal, String nomCommune) {
        ResultSet resultat = null;

        loadDatabase();
        
        try {
        	
        	connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/twicmaven", "root", "");
        	
            // Ex�cution de la requ�te
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO ville_france VALUES('',?,?,'','','','');");
            preparedStatement.setString(1, nomCommune);
            preparedStatement.setString(2, codePostal);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
        	 e.printStackTrace();
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException e) {
            	 e.printStackTrace();
            }
        }
        
    }
    
    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("org.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        	 e.printStackTrace();
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/twicmaven", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    
}
