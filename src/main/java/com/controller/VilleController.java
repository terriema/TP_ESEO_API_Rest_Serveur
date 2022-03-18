package com.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.VilleDao;

@RestController
public class VilleController {

	// fonction pour récupérer le contenu de la BDD
	@RequestMapping(value="/ville", method=RequestMethod.GET)
	public ArrayList<String> get(@RequestParam(required  = false, value="codePostal") String codePostal) {
		System.out.println("get");
		
		VilleDao villeDao = new VilleDao();
		ArrayList<String> villes = villeDao.recupererVilles(codePostal);

		return villes;
	}
	
	// fonction pour enregistrer un element dans la BDD
	@RequestMapping(value="/enregistrer", method=RequestMethod.POST)
	public void post(@RequestParam(required = true, value="codePostal") String codePostal, @RequestParam(required = true, value="nomCommune") String nomCommune) {
		System.out.println("post");
		
		VilleDao villeDao = new VilleDao();
		villeDao.ajouterVille(codePostal, nomCommune);
	}

}