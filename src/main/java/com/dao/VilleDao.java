package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.bean.Ville;



public class VilleDao {
private Connection connexion;

public ArrayList<Ville> recupererVilles() {
	ArrayList<Ville> listVille = new ArrayList<Ville>();
    ResultSet resultat = null;

    loadDatabase();
    
    try {
    	
    	connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/twicmaven", "root", "");
    	
        // Ex�cution de la requ�te
        PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM ville_france;");

        resultat = preparedStatement.executeQuery();
        // R�cup�ration des donn�es
        while (resultat.next()) {
           
        	Ville ville = new Ville(resultat.getString(1), resultat.getString(2), resultat.getString(3),resultat.getString(4),resultat.getString(5),resultat.getString(6),resultat.getString(7));
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
    
    public ArrayList<Ville> recupererVillesParCodePostal(String codePostal) {
    	ArrayList<Ville> listVille = new ArrayList<Ville>();
        ResultSet resultat = null;

        loadDatabase();
        
        try {
        	
        	connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/twicmaven", "root", "");
        	
            // Ex�cution de la requ�te
            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM ville_france WHERE code_postal = ?;");
            preparedStatement.setString(1, codePostal);
            
            resultat = preparedStatement.executeQuery();
            // R�cup�ration des donn�es
            while (resultat.next()) {
               
            	Ville ville =  new Ville(resultat.getString(1), resultat.getString(2), resultat.getString(3),resultat.getString(4),resultat.getString(5),resultat.getString(6),resultat.getString(7));
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
    
    public void ajouterVille(Ville ville) {
        ResultSet resultat = null;

        loadDatabase();
        
        try {
        	
        	connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/twicmaven", "root", "");
        	
            // Ex�cution de la requ�te
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO ville_france VALUES(?,?,?,'','','','');");
            preparedStatement.setString(1, ville.getCodeINSEE());
            preparedStatement.setString(2, ville.getCodePostal());
            preparedStatement.setString(3, ville.getNomCommune());
            
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
