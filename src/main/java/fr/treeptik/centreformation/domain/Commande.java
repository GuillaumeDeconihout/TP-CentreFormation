package fr.treeptik.centreformation.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Commande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numeroCommande;
	
	private Date dateCommande;
	private Integer nbrPlacesCommandees;
	
	@JoinColumn(name="codeSociete")
	@ManyToOne(fetch=FetchType.LAZY)
	private Societe societe;
	
	@JoinColumn(name="numeroSession")
	@ManyToOne(fetch=FetchType.LAZY)
	private Session session;
	
	@JoinColumn(name="numeroFacture")
	@OneToOne(fetch=FetchType.LAZY)
	private Facture facture;
	
	public Commande() {
	}

	public Commande(Integer numeroCommande, Date dateCommande,
			Integer nbrPlacesCommandees, Societe societe, Session session,
			Facture facture) {
		super();
		this.numeroCommande = numeroCommande;
		this.dateCommande = dateCommande;
		this.nbrPlacesCommandees = nbrPlacesCommandees;
		this.societe = societe;
		this.session = session;
		this.facture = facture;
	}

	public Integer getNumeroCommande() {
		return numeroCommande;
	}

	public void setNumeroCommande(Integer numeroCommande) {
		this.numeroCommande = numeroCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Integer getNbrPlacesCommandees() {
		return nbrPlacesCommandees;
	}

	public void setNbrPlacesCommandees(Integer nbrPlacesCommandees) {
		this.nbrPlacesCommandees = nbrPlacesCommandees;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
