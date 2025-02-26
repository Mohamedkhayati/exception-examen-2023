package tp9;

import java.time.LocalDate;

public class Billet implements Publiable  {

	private LocalDate datePub ;
	private String auteur;

	public LocalDate getDatePub() {
		return datePub;
	}
	public void setDatePub(LocalDate datePub) {
		this.datePub = datePub;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public Billet(LocalDate datePub, String auteur) {
		this.datePub=datePub;
		this.auteur=auteur;
	}
	public String toString() {
		return "Billet [datePub=" + datePub + ", auteur=" + auteur + "]";
	}

}
