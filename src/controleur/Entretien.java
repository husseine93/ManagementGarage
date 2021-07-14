package controleur;

public class Entretien {

	private int identretien, idvehicule, idtech, montant; 
	private String description, dateentretien;
	
	public Entretien(int identretien, int idvehicule, int idtech, String description, int montant, String dateentretien) {
		
		this.identretien = identretien;
		this.idvehicule = idvehicule;
		this.idtech = idtech;
		this.description = description;
		this.montant = montant;
		this.dateentretien = dateentretien;
	} 
	
	public Entretien(int idvehicule, int idtech, String description, int montant, String dateentretien) {
		
		this.identretien = 0;
		this.idvehicule = idvehicule;
		this.idtech = idtech;
		this.description = description;
		this.montant = montant;
		this.dateentretien = dateentretien;
	} 
	
	public Entretien() {
		
		this.identretien = 0;
		this.idvehicule = 0;
		this.idtech = 0;
		this.description = "";
		this.montant = 0;
		this.dateentretien = "0000-00-00";
	}

	public int getIdentretien() {
		return identretien;
	}

	public void setIdentretien(int identretien) {
		this.identretien = identretien;
	}

	public int getIdvehicule() {
		return idvehicule;
	}

	public void setIdvehicule(int idvehicule) {
		this.idvehicule = idvehicule;
	}

	public int getIdtech() {
		return idtech;
	}

	public void setIdtech(int idtech) {
		this.idtech = idtech;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public String getDateentretien() {
		return dateentretien;
	}

	public void setDateentretien(String dateentretien) {
		this.dateentretien = dateentretien;
	} 

}
