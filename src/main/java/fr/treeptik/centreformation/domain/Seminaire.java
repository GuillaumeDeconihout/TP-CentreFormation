package fr.treeptik.centreformation.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seminaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codeSeminaire;
	
	private Double prixSeminaire;
	private Integer dureeSeminaire;
	private String niveauSeminaire;
	private Integer nbPlacesSeminaire;
	
	
	
	public Seminaire() {
	}



	public Seminaire(Integer codeSeminaire, Double prixSeminaire,
			Integer dureeSeminaire, String niveauSeminaire,
			Integer nbPlacesSeminaire) {
		super();
		this.codeSeminaire = codeSeminaire;
		this.prixSeminaire = prixSeminaire;
		this.dureeSeminaire = dureeSeminaire;
		this.niveauSeminaire = niveauSeminaire;
		this.nbPlacesSeminaire = nbPlacesSeminaire;
	}



	public Integer getCodeSeminaire() {
		return codeSeminaire;
	}



	public void setCodeSeminaire(Integer codeSeminaire) {
		this.codeSeminaire = codeSeminaire;
	}



	public Double getPrixSeminaire() {
		return prixSeminaire;
	}



	public void setPrixSeminaire(Double prixSeminaire) {
		this.prixSeminaire = prixSeminaire;
	}



	public Integer getDureeSeminaire() {
		return dureeSeminaire;
	}



	public void setDureeSeminaire(Integer dureeSeminaire) {
		this.dureeSeminaire = dureeSeminaire;
	}



	public String getNiveauSeminaire() {
		return niveauSeminaire;
	}



	public void setNiveauSeminaire(String niveauSeminaire) {
		this.niveauSeminaire = niveauSeminaire;
	}



	public Integer getNbPlacesSeminaire() {
		return nbPlacesSeminaire;
	}



	public void setNbPlacesSeminaire(Integer nbPlacesSeminaire) {
		this.nbPlacesSeminaire = nbPlacesSeminaire;
	}
	
	

}
