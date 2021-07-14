package controleur;

public class Vehicule 
{
	private int idVehicule; 
	private String matricule, marque, energie; 
	private int nbkm, idClient;
	
	
	public Vehicule(int idVehicule, String matricule, String marque, String energie, int nbkm, int idClient) {
		this.idVehicule = idVehicule;
		this.matricule = matricule;
		this.marque = marque;
		this.energie = energie;
		this.nbkm = nbkm;
		this.idClient = idClient;
	}
	public Vehicule( String matricule, String marque, String energie, int nbkm, int idClient) {
		this.idVehicule = 0;
		this.matricule = matricule;
		this.marque = marque;
		this.energie = energie;
		this.nbkm = nbkm;
		this.idClient = idClient;
	}
	public Vehicule( )
	{
		this.idVehicule = 0;
		this.matricule = "";
		this.marque = "";
		this.energie = "";
		this.nbkm = 0;
		this.idClient = 0;
	}

	public int getIdVehicule() {
		return idVehicule;
	}
	
	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getEnergie() {
		return energie;
	}
	public void setEnergie(String energie) {
		this.energie = energie;
	}
	public int getNbkm() {
		return nbkm;
	}
	public void setNbkm(int nbkm) {
		this.nbkm = nbkm;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	} 
	
	
}


 