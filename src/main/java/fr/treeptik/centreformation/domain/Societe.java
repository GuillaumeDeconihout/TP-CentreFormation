package fr.treeptik.centreformation.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Societe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codeSociete;
	
	private String nomSociete;
	
	public Societe() {
	}

	
	
	public Societe(Integer codeSociete, String nomSociete) {
		super();
		this.codeSociete = codeSociete;
		this.nomSociete = nomSociete;
	}



	public Integer getCodeSociete() {
		return codeSociete;
	}

	public void setCodeSociete(Integer codeSociete) {
		this.codeSociete = codeSociete;
	}

	public String getNomSociete() {
		return nomSociete;
	}

	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}

	

}
