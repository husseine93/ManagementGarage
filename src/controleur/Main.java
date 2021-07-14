package controleur;

import java.util.ArrayList;

import modele.Modele;
import vue.VueClients;
import vue.VueConnexion;
import vue.VueVehicule;
import vue.VueTechnicien;
import vue.VueEntretien;
import vue.VueProduits;

public class Main 
{
	private static VueConnexion uneVueConnexion ; 
	private static VueClients uneVueClients ;
	private static VueVehicule uneVueVehicules; 
	private static VueTechnicien uneVueTechniciens;
	private static VueEntretien uneVueEntretien;
	private static VueProduits uneVueProduits;
	
	
	public static void main (String args[])
	{
		uneVueConnexion = new VueConnexion();
	}
	public static void rendreVisible (boolean action)
	{
		Main.uneVueConnexion.setVisible(action);
	}
	public static void instancierVueClients ()
	{
		Main.uneVueClients = new VueClients(); 
	}
	public static void instancierVueVehicules ()
	{
		Main.uneVueVehicules = new VueVehicule(); 
	}
	public static void instancierVueProduits ()
	{
		Main.uneVueProduits = new VueProduits(); 
	}
	public static void instancierVueTechniciens ()
	{
		Main.uneVueTechniciens = new VueTechnicien(); 
	}
	public static void instancierVueEntretiens ()
	{
		Main.uneVueEntretien = new VueEntretien(); 
	}
	/********************************* Controleur Client *******************************/
	public static void insertClient (Client unClient)
	{
		//on controle les donnees avant insertion 
		Modele.insertClient(unClient);
	}
	public static void deleteClient(int idClient)
	{
		Modele.deleteClient(idClient);
	}
	public static void updateClient (Client unClient)
	{
		//on controle les donnees avant insertion 
		Modele.updateClient(unClient);
	}
	public static Client selectWhereClient(int idClient)
	{
		return Modele.selectWhereClient(idClient);
	}
	public static Client selectWhereClient(String email)
	{
		return Modele.selectWhereClient(email);
	}
	public static ArrayList<Client> selectAllClient(String mot)
	{
		return Modele.selectAllClient(mot);
	}
	/********************************* Controleur Vehicule *******************************/
	public static void insertVehicule (Vehicule unVehicule)
	{
		//on controle les donnees avant insertion 
		Modele.insertVehicule(unVehicule);
	}
	public static void deleteVehicule(int idVehicule)
	{
		Modele.deleteVehicule(idVehicule);
	}
	public static void updateVehicule (Vehicule unVehicule)
	{
		//on controle les donnees avant insertion 
		Modele.updateVehicule(unVehicule);
	}
	public static Vehicule selectWhereVehicule(int idVehicule)
	{
		return Modele.selectWhereVehicule(idVehicule);
	}
	public static Vehicule selectWhereVehicule(String matricule)
	{
		return Modele.selectWhereVehicule(matricule);
	}
	public static ArrayList<Vehicule> selectAllVehicule(String mot)
	{
		return Modele.selectAllVehicule(mot);
	}
	/********************************* Controleur Technicien *******************************/
	public static void insertTechnicien (Technicien unTechnicien)
	{
		//on controle les donnees avant insertion 
		Modele.insertTechnicien(unTechnicien);
	}
	public static void deleteTechnicien(int idTechnicien)
	{
		Modele.deleteTechnicien(idTechnicien);
	}
	public static void updateTechnicien (Technicien unTechnicien)
	{
		//on controle les donnees avant insertion 
		Modele.updateTechnicien(unTechnicien);
	}
	public static Technicien selectWhereTechnicien(int idTechnicien)
	{
		return Modele.selectWhereTechnicien(idTechnicien);
	}
	public static Technicien selectWhereTechnicien(String email)
	{
		return Modele.selectWhereTechnicien(email);
	}
	public static ArrayList<Technicien> selectAllTechnicien(String mot)
	{
		return Modele.selectAllTechnicien(mot);
	}
	public static Technicien selectWhereTechnicien(String email, String mdp)
	{
		return Modele.selectWhereTechnicien(email, mdp);
	}
	/********************************* Controleur Entretien *******************************/
	public static void insertEntretien (Entretien unEntretien)
	{
		//on controle les donnees avant insertion 
		Modele.insertEntretien(unEntretien);
	}
	public static void deleteEntretien(int idEntretien)
	{
		Modele.deleteEntretien(idEntretien);
	}
	public static void updateEntretien (Entretien unEntretien)
	{
		//on controle les donnees avant insertion 
		Modele.updateEntretien(unEntretien);
	}
	public static Entretien selectWhereEntretien(int idEntretien)
	{
		return Modele.selectWhereEntretien(idEntretien);
	}
	public static Entretien selectWhereEntretien(String description)
	{
		return Modele.selectWhereEntretien(description);
	}
	public static ArrayList<Entretien> selectAllEntretien(String mot)
	{
		return Modele.selectAllEntretien(mot);
	}
	public static void insertProduit (Produit unProduit)
	{
		//on controle les donnees avant insertion 
		Modele.insertProduit(unProduit);
	}
	public static void deleteProduit(int idP)
	{
		Modele.deleteProduit(idP);
	}
	public static void updateProduit (Produit unProduit)
	{
		//on controle les donnees avant insertion 
		Modele.updateProduit(unProduit);
	}
	public static Produit selectWhereProduit(int idP)
	{
		return Modele.selectWhereProduit(idP);
	}
	public static Produit selectWhereProduit(String detail)
	{
		return Modele.selectWhereProduit(detail);
	}
	public static ArrayList<Produit> selectAllProduit(String mot)
	{
		return Modele.selectAllProduit(mot);
	}
}
