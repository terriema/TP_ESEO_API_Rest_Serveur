package com.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Ville;
import com.dao.VilleDao;

@RestController
public class VilleController {

	
	// fonction pour récupérer le contenu de la BDD
		@GetMapping(value="/villes")
		public ArrayList<Ville> getVilles() {
			System.out.println("get");
			
			VilleDao villeDao = new VilleDao();
			ArrayList<Ville> villes = villeDao.recupererVilles();

			return villes;
		}
		
		
	// fonction pour récupérer le contenu de la BDD
	@GetMapping(value="/ville/{codePostal}")
	public ArrayList<Ville> getVilleParCodePostal(@PathVariable String codePostal) {
		System.out.println("get");
		
		VilleDao villeDao = new VilleDao();
		ArrayList<Ville> villes = villeDao.recupererVillesParCodePostal(codePostal);

		return villes;
	}
	
//	// fonction pour enregistrer un element dans la BDD
//	@RequestMapping(value="/enregistrer", method=RequestMethod.POST)
//	public void postVille(@RequestParam(required = true, value="codePostal") String codePostal, @RequestParam(required = true, value="nomCommune") String nomCommune) {
//		System.out.println("post");
//		
//		VilleDao villeDao = new VilleDao();
//		villeDao.ajouterVille(codePostal, nomCommune);
//	}
	
	// fonction pour enregistrer un element dans la BDD
		@PostMapping(value="/ville")
		public ResponseEntity<Ville> postVille(@RequestBody Ville nouvVille) {
			System.out.println("post");
			
			try {
				
			}
			Ville ville = new Ville(codeINSEE, codePostal, nomCommune)
			
			VilleDao villeDao = new VilleDao();
			villeDao.ajouterVille(ville);
		}

}