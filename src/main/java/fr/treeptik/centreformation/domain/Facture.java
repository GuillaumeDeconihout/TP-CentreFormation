package fr.treeptik.centreformation.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Facture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numeroFacture;
	
	private Date dateFacture;
	
	private Double montantFacture;
	
	private Integer nbrePlaceFacturee;
	
	public Facture() {
	}

	public Facture(Integer numeroFacture, Date dateFacture,
			Double montantFacture, Integer nbrePlaceFacturee) {
		super();
		this.numeroFacture = numeroFacture;
		this.dateFacture = dateFacture;
		this.montantFacture = montantFacture;
		this.nbrePlaceFacturee = nbrePlaceFacturee;
	}

	public Integer getNumeroFacture() {
		return numeroFacture;
	}

	public void setNumeroFacture(Integer numeroFacture) {
		this.numeroFacture = numeroFacture;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public Double getMontantFacture() {
		return montantFacture;
	}

	public void setMontantFacture(Double montantFacture) {
		this.montantFacture = montantFacture;
	}

	public Integer getNbrePlaceFacturee() {
		return nbrePlaceFacturee;
	}

	public void setNbrePlaceFacturee(Integer nbrePlaceFacturee) {
		this.nbrePlaceFacturee = nbrePlaceFacturee;
	}
	
	
	

}
