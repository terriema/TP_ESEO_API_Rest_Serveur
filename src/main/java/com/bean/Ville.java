package com.bean;

public class Ville {
	private String codeINSEE;
	private String codePostal;
	private String nomCommune;
	private String libelleAcheminement;
	private String ligne5;
	private String latitude;
	private String longitude;
	
	public Ville(String codeINSEE,String codePostal,String nomCommune) {
		this.codeINSEE=codeINSEE;
		this.codePostal=codePostal;
		this.nomCommune=nomCommune;
	}
	
	public Ville(String codeINSEE,String codePostal,String nomCommune, String libelleAcheminement, String ligne5, String latitude, String longitude) {
		this.codeINSEE=codeINSEE;
		this.codePostal=codePostal;
		this.nomCommune=nomCommune;
		this.libelleAcheminement=libelleAcheminement;
		this.ligne5=ligne5;
		this.latitude=latitude;
		this.longitude=longitude;
	}

	public String getCodeINSEE() {
		return codeINSEE;
	}

	public void setCodeINSEE(String codeINSEE) {
		this.codeINSEE = codeINSEE;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}

	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}

	public String getLigne5() {
		return ligne5;
	}

	public void setLigne5(String ligne5) {
		this.ligne5 = ligne5;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
	
	
}
