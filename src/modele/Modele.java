package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;
import controleur.Technicien;
import controleur.Vehicule;
import controleur.Entretien;
import controleur.Produit;

public class Modele 
{
	
	private static BDD uneBdd = new BDD("172.20.95.148", "garage_JV", "husseine", "husseine"); //pour PC
	
	public static void executerRequete (String requete )
	{
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
	}
	/************************************************ Modele Client *************************************/

	public static void insertClient (Client unClient)
	{
		String requete ="insert into client values (null, '"+unClient.getNom()+"','"+unClient.getPrenom()+"','"+unClient.getAdresse()
						+"','"+unClient.getEmail()+"','"+unClient.getTel()+"');" ; 
		executerRequete(requete);
	}
	
	public static void deleteClient (int idClient)
	{
		String requete ="delete from client where idclient =  " + idClient +";"; 
		executerRequete(requete);
	}
	
	public static void updateClient (Client unClient)
	{
		String requete ="update client set nom = '"+unClient.getNom()+"',prenom ='"+unClient.getPrenom()+"',"
				+ "adresse = '"+unClient.getAdresse() +"',email = '"+unClient.getEmail()+"',tel='"+unClient.getTel()+"'"
						+ " where idclient =  " + unClient.getIdclient() +" ; "; 
		executerRequete(requete);
	}
	
	public static Client selectWhereClient (int idClient)
	{
		Client unClient = null; 
		String requete ="select * from client where idclient =  " + idClient +";"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unClient = new Client (
							unRes.getInt("idclient"), unRes.getString("nom"), unRes.getString("prenom"), 
							unRes.getString("adresse"), unRes.getString("email") , unRes.getString("tel")
							);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unClient; 
	}
	
	public static Client selectWhereClient (String email)
	{
		Client unClient = null; 
		String requete ="select * from client where email =  '" + email +"' ;"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unClient = new Client (
							unRes.getInt("idclient"), unRes.getString("nom"), unRes.getString("prenom"), 
							unRes.getString("adresse"), unRes.getString("email") , unRes.getString("tel")
							);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unClient; 
	}
	public static ArrayList<Client> selectAllClient (String mot)
	{
		ArrayList<Client> lesClients = new ArrayList<Client>();  
		String requete =""; 
		if (mot.equals("")) {
			requete = "select * from client ;"; 
		}else {
			 requete ="select * from client where nom like '%"+mot+"%'  or prenom like '%"+mot+"%' "
					+ " or adresse like '%"+mot+"%' ; ";
		}
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
					//instanciation du produit resultat 
				Client unClient = new Client (
						desRes.getInt("idclient"), desRes.getString("nom"), desRes.getString("prenom"), 
						desRes.getString("adresse"), desRes.getString("email") , desRes.getString("tel")
							); 
				//Ajout du client dans la liste des clients 
				lesClients.add(unClient);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return lesClients; 
	}
	
	/************************************************ Modele Technicien *************************************/
	public static void insertTechnicien (Technicien unTechnicien)
	{
		String requete ="insert into technicien values (null, '"+unTechnicien.getNom()+"','"+unTechnicien.getPrenom()+"','"+unTechnicien.getQualification()
						+"','"+unTechnicien.getEmail()+"','"+unTechnicien.getMdp()+"','"+unTechnicien.getTel()+"');" ; 
		executerRequete(requete);
	}
	
	public static void deleteTechnicien (int idTechnicien)
	{
		String requete ="delete from technicien where idtech =  " + idTechnicien +";"; 
		executerRequete(requete);
	}
	
	public static void updateTechnicien (Technicien unTechnicien)
	{
		String requete ="update technicien set nom = '"+unTechnicien.getNom()+"',prenom ='"+unTechnicien.getPrenom()+"',"
				+ "qualification = '"+unTechnicien.getQualification() +"',email = '"+unTechnicien.getEmail()+"',mdp = '"+unTechnicien.getMdp()+"',tel='"+unTechnicien.getTel()+"'"
						+ " where idtech =  " + unTechnicien.getIdtech() +" ; "; 
		executerRequete(requete);
	}
	
	public static Technicien selectWhereTechnicien (int idTechnicien)
	{
		Technicien unTechnicien = null; 
		String requete ="select * from technicien where idtech =  " + idTechnicien +";"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unTechnicien = new Technicien (
							unRes.getInt("idtech"), unRes.getString("nom"), unRes.getString("prenom"), 
							unRes.getString("qualification"), unRes.getString("email") , unRes.getString("mdp") , unRes.getString("tel")
							);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unTechnicien; 
	}
	
	public static Technicien selectWhereTechnicien (String email)
	{
		Technicien unTechnicien = null; 
		String requete ="select * from technicien where email =  '" + email +"' ;"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unTechnicien = new Technicien (
							unRes.getInt("idtech"), unRes.getString("nom"), unRes.getString("prenom"), 
							unRes.getString("qualification"), unRes.getString("email") , unRes.getString("mdp") , unRes.getString("tel")
							);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unTechnicien; 
	}
	public static ArrayList<Technicien> selectAllTechnicien (String mot)
	{
		ArrayList<Technicien> lesTechniciens = new ArrayList<Technicien>();  
		String requete =""; 
		if (mot.equals("")) {
			requete = "select * from technicien ;"; 
		}else {
			 requete ="select * from technicien where nom like '%"+mot+"%'  or prenom like '%"+mot+"%' or qualification like '%"+mot+"%' or email like '%"+mot+"%' ; ";
		}
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
					//instanciation du produit resultat 
				Technicien unTechnicien = new Technicien (
						desRes.getInt("idtech"), desRes.getString("nom"), desRes.getString("prenom"), 
						desRes.getString("qualification"), desRes.getString("email") , desRes.getString("mdp") , desRes.getString("tel")
							); 
				//Ajout du Technicien dans la liste des Techniciens 
				lesTechniciens.add(unTechnicien);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return lesTechniciens; 
	}
	
	
	public static Technicien selectWhereTechnicien (String email, String mdp)
	{
		Technicien unTechnicien = null; 
		String requete ="select * from technicien where email =  '" + email +"' and mdp ='"+mdp+"' ;"; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unTechnicien = new Technicien (
							unRes.getInt("idtech"), unRes.getString("nom"), unRes.getString("prenom"), 
							unRes.getString("qualification"), unRes.getString("email") , unRes.getString("mdp"), unRes.getString("tel")
							);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unTechnicien; 
	}
	
	/************************************************ Modele Vehicule *************************************/

	public static void insertVehicule (Vehicule unVehicule)
	{
		String requete ="insert into vehicule values (null, '"+unVehicule.getMatricule()+"','"+unVehicule.getMarque()+"','"+unVehicule.getEnergie()
						+"','"+unVehicule.getNbkm()+"','"+unVehicule.getIdClient()+"');" ; 
		executerRequete(requete);
	}
	
	public static void deleteVehicule(int idVehicule)
	{
		String requete ="delete from client where idclient =  " + idVehicule +";"; 
		executerRequete(requete);
	}
	
	public static void updateVehicule (Vehicule unVehicule)
	{
		String requete ="update vehicule set matricule = '"+unVehicule.getMatricule()+"',marque ='"+unVehicule.getMarque()+"',"
				+ "energie = '"+unVehicule.getEnergie()+"',nbkm = '"+unVehicule.getNbkm()+"',idclient='"+unVehicule.getIdClient()+"' "
						+ "  where idvehicule =  " + unVehicule.getIdVehicule() +" ;  "; 
		executerRequete(requete);
	}
	
	public static Vehicule selectWhereVehicule (int idVehicule)
	{
		Vehicule unVehicule = null; 
		String requete ="select * from vehicule where idvehicule=  " + idVehicule +";"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unVehicule= new Vehicule (
							unRes.getInt("idvehicule"), unRes.getString("matricule"), unRes.getString("marque"), 
							unRes.getString("energie"), unRes.getInt("nbkm") , unRes.getInt("idclient")
							);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unVehicule; 
	}
	
	public static Vehicule selectWhereVehicule(String matricule)
	{
		Vehicule unVehicule = null; 
		String requete ="select * from vehicule where matricule =  '" + matricule +"' ;"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unVehicule = new Vehicule (
						unRes.getInt("idvehicule"), unRes.getString("matricule"), unRes.getString("marque"), 
						unRes.getString("energie"), unRes.getInt("nbkm") , unRes.getInt("idclient")
							);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unVehicule; 
	}
	public static ArrayList<Vehicule> selectAllVehicule (String mot)
	{
		ArrayList<Vehicule> lesVehicules = new ArrayList<Vehicule>();  
		String requete =""; 
		if (mot.equals("")) {
			requete = "select * from vehicule ;"; 
		}else {
			 requete ="select * from vehicule where matricule like '%"+mot+"%'  or marque like '%"+mot+"%' "
					+ " or energie like '%"+mot+"%' ; ";
		}
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
					//instanciation du produit resultat 
				Vehicule unVehicule= new Vehicule (
						desRes.getInt("idvehicule"), desRes.getString("matricule"), desRes.getString("marque"), 
						desRes.getString("energie"), desRes.getInt("nbkm") , desRes.getInt("idclient")
							); 
				//Ajout du client dans la liste des clients 
				lesVehicules.add(unVehicule);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return lesVehicules; 
	}
	
	/************************************************ Modele Entretien *************************************/

	public static void insertEntretien (Entretien unEntretien)
	{
		String requete ="insert into entretien values (null, "+unEntretien.getIdvehicule()+","+unEntretien.getIdtech()+",'"+unEntretien.getDescription()
						+"',"+unEntretien.getMontant()+",'"+unEntretien.getDateentretien()+"');" ; 
		executerRequete(requete);
	}
	
	public static void deleteEntretien (int idEntretien)
	{
		String requete ="delete from entretien where identretien =  " + idEntretien +";"; 
		executerRequete(requete);
	}
	
	public static void updateEntretien (Entretien unEntretien)
	{
		String requete ="update Entretien set idvehicule = "+unEntretien.getIdvehicule()+",idtech ="+unEntretien.getIdtech()+","
				+ "description = '"+unEntretien.getDescription() +",montant = "+unEntretien.getMontant()+",dateentretien='"+unEntretien.getDateentretien()+"'"
						+ " where identretien =  " + unEntretien.getIdentretien() +" ; "; 
		executerRequete(requete);
	}
	
	public static Entretien selectWhereEntretien (int idEntretien)
	{
		Entretien unEntretien = null; 
		String requete ="select * from Entretien where identretien =  " + idEntretien +";"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unEntretien = new Entretien (
							unRes.getInt("identretien"), unRes.getInt("idvehicule"), unRes.getInt("idtech"), 
							unRes.getString("description"), unRes.getInt("montant") , unRes.getString("dateentretien")
							);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unEntretien; 
	}
	
	public static Entretien selectWhereEntretien (String description)
	{
		Entretien unEntretien = null; 
		String requete ="select * from entretien where description =  '" + description +"' ;"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unEntretien = new Entretien (
						unRes.getInt("identretien"), unRes.getInt("idvehicule"), unRes.getInt("idtech"), 
						unRes.getString("description"), unRes.getInt("montant") , unRes.getString("dateentretien")
							);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unEntretien; 
	}
	public static ArrayList<Entretien> selectAllEntretien (String mot)
	{
		ArrayList<Entretien> lesEntretiens = new ArrayList<Entretien>();  
		String requete =""; 
		if (mot.equals("")) {
			requete = "select * from entretien ;"; 
		}else {
			 requete ="select * from entretien where description like '%"+mot+"%' ; ";
		}
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
					//instanciation du produit resultat 
				Entretien unEntretien = new Entretien (
						desRes.getInt("identretien"), desRes.getInt("idvehicule"), desRes.getInt("idtech"), 
						desRes.getString("description"), desRes.getInt("montant") , desRes.getString("dateentretien")
							); 
				//Ajout du Entretien dans la liste des Entretiens 
				lesEntretiens.add(unEntretien);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return lesEntretiens; 
	}

	//________________________________________Produit_____________________________________
	
	public static void insertProduit (Produit unProduit)
	{
		String requete ="insert into produit values (null, '"+unProduit.getName()+"','"+unProduit.getDetail()+"',"+unProduit.getPrice()
						+","+unProduit.getQuantity()+","+unProduit.getIdclient()+");" ; 
		executerRequete(requete);
	}
	
	public static void deleteProduit (int idP)
	{
		String requete ="delete from produit where idp =  " + idP +";"; 
		executerRequete(requete);
	}
	
	public static void updateProduit (Produit unProduit)
	{
		String requete ="update produit set name = '"+unProduit.getName()+"',detail ='"+unProduit.getDetail()+"',"
				+ "Price = "+unProduit.getPrice() +",quantity = "+unProduit.getQuantity()+",idclient='"+unProduit.getIdclient()+"'"
						+ " where idP =  " + unProduit.getIdP() +" ; "; 
		executerRequete(requete);
	}
	
	public static Produit selectWhereProduit (int idP)
	{
		Produit unProduit = null; 
		String requete ="select * from produit where idP =  " + idP +";"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unProduit = new Produit (
							unRes.getInt("idP"), unRes.getString("name"), unRes.getString("detail"), 
							unRes.getInt("quantity"), unRes.getInt("price") ,unRes.getInt("Idclient")
							);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'éxecuter la requete : " + requete);
		}
		return unProduit; 
	}
	
	public static Produit selectWhereProduit (String name)
	{
		Produit unProduit = null; 
		String requete ="select * from produit where name =  '" + name +"' ;"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unProduit = new Produit (
						unRes.getInt("idP"), unRes.getString("name"), unRes.getString("detail"), 
						unRes.getInt("quantity"), unRes.getInt("price") ,unRes.getInt("Idclient")
							);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'executer la requete : " + requete);
		}
		return unProduit; 
	}
	public static ArrayList<Produit> selectAllProduit (String mot)
	{
		ArrayList<Produit> lesProduits = new ArrayList<Produit>();  
		String requete =""; 
		if (mot.equals("")) {
			requete = "select * from produit ;"; 
		}else {
			 requete ="select * from produit where name like '%"+mot+"%'  or detail like '%"+mot+"%' or quantity like '%"+mot+"%' or price like '%"+mot+"%' ; ";
		}
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
					//instanciation du produit resultat 
				Produit unProduit = new Produit (
						desRes.getInt("idP"), desRes.getString("name"), desRes.getString("detail"), 
						desRes.getInt("quantity"), desRes.getInt("price") ,desRes.getInt("Idclient")
							); 
				
				lesProduits.add(unProduit);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'executer la requete : " + requete);
		}
		return lesProduits; 
	}
	
	
	
	
}
