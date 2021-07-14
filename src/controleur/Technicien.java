package controleur;

public class Technicien {
	private int idtech ; 
	private String nom, prenom, qualification, email, mdp, tel;
	public Technicien(int idtech, String nom, String prenom, String qualification, String email, String mdp,
			String tel) {
		
		this.idtech = idtech;
		this.nom = nom;
		this.prenom = prenom;
		this.qualification = qualification;
		this.email = email;
		this.mdp = mdp;
		this.tel = tel;
	} 
	public Technicien(String nom, String prenom, String qualification, String email, String mdp,
			String tel) {
		
		this.idtech = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.qualification = qualification;
		this.email = email;
		this.mdp = mdp;
		this.tel = tel;
	} 
	public Technicien() {
		
		this.idtech = 0;
		this.nom = "";
		this.prenom = "";
		this.qualification = "";
		this.email = "";
		this.mdp = "";
		this.tel = "";
	}
	public int getIdtech() {
		return idtech;
	}
	public void setIdtech(int idtech) {
		this.idtech = idtech;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	} 
	
	
}
