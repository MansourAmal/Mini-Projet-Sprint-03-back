package com.amal.theatre.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Pieceth {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idPieceth;
	    private String nomPieceth;
	    private String auteurPieceth;
	    private Date dateCreation;
	    
	    @ManyToOne
	    private Genre genre;


	    public Pieceth() {
	        super();
	    }

	    public Pieceth(String nomPieceth, String auteurPieceth, Date dateCreation) {
	        super();
	        this.nomPieceth = nomPieceth;
	        this.auteurPieceth = auteurPieceth;
	        this.dateCreation = dateCreation;
	    }

	    public Long getIdPieceth() {
	        return idPieceth;
	    }

	    public void setIdPieceth(Long idPieceth) {
	        this.idPieceth = idPieceth;
	    }

	    public String getNomPieceth() {
	        return nomPieceth;
	    }

	    public void setNomPieceth(String nomPieceth) {
	        this.nomPieceth = nomPieceth;
	    }

	    public String getAuteurPieceth() {
	        return auteurPieceth;
	    }

	    public void setAuteurPieceth(String auteurPieceth) {
	        this.auteurPieceth = auteurPieceth;
	    }

	    public Genre getGenre() {
			return genre;
		}

		public void setGenre(Genre genre) {
			this.genre = genre;
		}

		public Date getDateCreation() {
	        return dateCreation;
	    }

	    public void setDateCreation(Date dateCreation) {
	        this.dateCreation = dateCreation;
	    }

	    @Override
	    public String toString() {
	        return "Pieceth [idPieceth=" + idPieceth + ", nomPieceth=" + nomPieceth + ", auteurPieceth=" + auteurPieceth
	                + ", dateCreation=" + dateCreation + "]";
	    }
}
