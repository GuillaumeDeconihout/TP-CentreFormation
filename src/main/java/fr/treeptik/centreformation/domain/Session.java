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

@Entity
public class Session implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numeroSession;
	
	private Date dateSession;
	
	private Date heureDebut;
	private Date heureFin;
	
	@JoinColumn(name="codeSeminaire")
	@ManyToOne(fetch=FetchType.LAZY)
	private Seminaire seminaire;
	
	public Session() {
	}

	public Session(Integer numeroSession, Date dateSession, Date heureDebut,
			Date heureFin, Seminaire semainaire) {
		super();
		this.numeroSession = numeroSession;
		this.dateSession = dateSession;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.seminaire = semainaire;
	}

	public Integer getNumeroSession() {
		return numeroSession;
	}

	public void setNumeroSession(Integer numeroSession) {
		this.numeroSession = numeroSession;
	}

	public Date getDateSession() {
		return dateSession;
	}

	public void setDateSession(Date dateSession) {
		this.dateSession = dateSession;
	}

	public Date getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	public Seminaire getSemainaire() {
		return seminaire;
	}

	public void setSemainaire(Seminaire semainaire) {
		this.seminaire = semainaire;
	}
	
	
	

}
