package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Client;
import controleur.Main;
import controleur.Tableau;
import controleur.Vehicule;

public class VueVehicule extends JFrame implements ActionListener
{
	Font police = new Font("Calibri", Font.BOLD, 15);
	
	private JButton btRetour = new JButton("Retour au Menu") ; 
	/************************** Panel Ajout Vehicule *********/
	private JPanel panelInsert = new JPanel(); 
	private JTextField txtMatricule = new JTextField(); 
	private JTextField txtMarque= new JTextField(); 
	private JComboBox<String> cbxEnergie= new JComboBox<String>();  
	private JTextField txtNbkm = new JTextField(); 
	private JComboBox<String> cbxClient= new JComboBox<String>();
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	/************************** Panel Lister Vehicule *********/
	private JPanel panelLister = new JPanel(); 
	private JTable uneTable ; 
	private JScrollPane uneScroll ;
	private Tableau unTableau ; 
	
	/************************** Panel Filtrer Client *********/
	private JPanel panelFiltrer= new JPanel(); 
	private JLabel lbRecherche = new JLabel(""); 
	private JTextField txtMot = new JTextField(); 
	private JButton btFiltrer = new JButton("Filtrer");
	
	public VueVehicule() {
		this.setTitle("Gestion des Vehicules Fil'elec");
		this.setBounds(200, 200, 900, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color (84, 170, 255));
		
		/******************** Construction BT Retour **********/
		this.btRetour.setBounds(515, 410, 200, 30);
		this.add(this.btRetour); 
		this.btRetour.addActionListener(this);
		this.btRetour.setForeground(new Color (84, 170, 255));
		this.btRetour.setFont(police);
		
		/**************** Construction Panel Insert ***************/
		this.panelInsert.setBounds(40, 80, 280, 320);
		this.panelInsert.setBackground(new Color (84, 170, 255));
		this.panelInsert.setLayout(new GridLayout(6,2));
		this.panelInsert.add(new JLabel("Matricule : ")); 
		this.panelInsert.add(this.txtMatricule); 
		this.panelInsert.add(new JLabel("La Marque : ")); 
		this.panelInsert.add(this.txtMarque);
		this.panelInsert.add(new JLabel("Energie : ")); 
		this.panelInsert.add(this.cbxEnergie);
		this.panelInsert.add(new JLabel("Nb KM : ")); 
		this.panelInsert.add(this.txtNbkm);
		this.panelInsert.add(new JLabel("Le Client : ")); 
		this.panelInsert.add(this.cbxClient);
		this.panelInsert.add(this.btAnnuler); 
		this.panelInsert.add(this.btEnregistrer); 
		this.btAnnuler.setForeground(new Color (84, 170, 255));
		this.btAnnuler.setFont(police);
		this.btEnregistrer.setForeground(new Color (84, 170, 255));
		this.btEnregistrer.setFont(police);
		
		this.add(this.panelInsert); 
		
		/**************** Construction Panel Lister ***************/
		this.panelLister.setBounds(380, 80, 480, 320);
		this.panelLister.setBackground(new Color (84, 170, 255));
		this.panelLister.setLayout(null);
		String entetes[] = {"ID Véhicule","Matricule", "Marque", "Energie", "NB KM", "Le Client"};
		//instanciation de la classe tableau donnees et entetes 
		this.unTableau = new Tableau(this.remplirDonnees(""), entetes);
		//instanciation de la Jtable sur la tableModel unTableau
		this.uneTable = new JTable(unTableau); 
		
		this.uneScroll = new JScrollPane(this.uneTable); 
		this.uneScroll.setBounds(0, 20, 460, 280);
		this.panelLister.add(this.uneScroll); 
		this.add(this.panelLister); 
		
		/*********************** rendre les boutons *****************/
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
		/***************** REMPLIR LES CBX *************************/
		this.remplirCBXEnergie (); 
		this.remplirCBXClient ();
		
		/**************** Construction Panel Filtrer ***************/
		this.panelFiltrer.setBounds(360, 40, 380, 25);
		this.panelFiltrer.setBackground(new Color (84, 170, 255));
		this.panelFiltrer.setLayout(new GridLayout(1, 3));
		this.panelFiltrer.add(this.lbRecherche); 
		this.panelFiltrer.add(this.txtMot); 
		this.panelFiltrer.add(this.btFiltrer); 
		this.add(this.panelFiltrer);
		this.btFiltrer.addActionListener(this);
		this.btFiltrer.setForeground(new Color (84, 170, 255));
		this.btFiltrer.setFont(police);
		
		//gestion de la modification et de la suppression d'un client 
				this.uneTable.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount() >= 2) {
							int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce véhicule ?", 
									"Suppression Véhicule", JOptionPane.YES_NO_OPTION); 
							if (retour == 0)
							{
								JOptionPane.showMessageDialog(null, "Véhicule supprimé ");
								int indiceLigne = uneTable.getSelectedRow(); 
								int idVehicule = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
								Main.deleteVehicule(idVehicule);
								unTableau.supprimerLigne(indiceLigne);
							}
						}else if (e.getClickCount() == 1)
						{
							int indiceLigne = uneTable.getSelectedRow(); 
							txtMatricule.setText(unTableau.getValueAt(indiceLigne,1).toString()); 
							txtMarque.setText(unTableau.getValueAt(indiceLigne,2).toString()); 
							
							txtNbkm.setText(unTableau.getValueAt(indiceLigne,4).toString()); 
							 
							
							btEnregistrer.setText("Modifier");
						}
						
					}
				});
				
				
		this.setVisible(true);
	}
	
	
	public Object [][] remplirDonnees (String mot)
	{
		//cette fonction transforme l'ArrayList des lesVehicules en une matrice d'objets 
		ArrayList<Vehicule> lesVehicules = Main.selectAllVehicule(mot);
		Object [][] matrice = new Object [lesVehicules.size()][6];
		int i = 0; 
		for (Vehicule unVehicule : lesVehicules)
		{
			matrice [i][0] = unVehicule.getIdVehicule();
			matrice [i][1] = unVehicule.getMatricule();
			matrice [i][2] = unVehicule.getMarque();
			matrice [i][3] = unVehicule.getEnergie();
			matrice [i][4] = unVehicule.getNbkm();
			Client unClient = Main.selectWhereClient(unVehicule.getIdClient());
			matrice [i][5] = unClient.getNom();
			i++;
		}
		return matrice;
	}
	
	public void remplirCBXEnergie ()
	{
		this.cbxEnergie.removeAllItems();
		this.cbxEnergie.addItem("gazol");
		this.cbxEnergie.addItem("essence");
		this.cbxEnergie.addItem("électrique");
		this.cbxEnergie.addItem("hybride");
		this.cbxEnergie.addItem("autre");
	}
	public void remplirCBXClient ()
	{
		this.cbxClient.removeAllItems();
		for (Client unClient : Main.selectAllClient(""))
		{
			this.cbxClient.addItem(unClient.getIdclient() +" - " + unClient.getNom()
			+ " - " + unClient.getPrenom());
		}
	}
	public void viderChamps ()
	{
		this.txtMarque.setText("");
		this.txtMatricule.setText("");
		this.txtNbkm.setText("");
		this.btEnregistrer.setText("Enregistrer");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btRetour)
		{
			this.dispose(); //on tue la vue Clients 
			Main.rendreVisible(true);
			
		}
		else if (e.getSource() == this.btAnnuler)
		{
			this.viderChamps (); 
		}
		else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Enregistrer"))
		{
			//on récupÃ¨re les données, on instancie un client, on l'ajoute au bdd 
			String matricule = this.txtMatricule.getText(); 
			String marque = this.txtMarque.getText(); 
			int nbKm =0; 
			try {
				nbKm = Integer.parseInt(this.txtNbkm.getText());
			} catch (NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, "Erreur de saisie du nbKM ");
			}
			String energie = this.cbxEnergie.getSelectedItem().toString();

			String chaine = this.cbxClient.getSelectedItem().toString();
			String tab[] = chaine.split(" - ");
			int idClient = Integer.parseInt(tab[0]);
			
			
			Vehicule unVehicule = new Vehicule(matricule, marque,energie, nbKm, idClient);
			Main.insertVehicule(unVehicule);
			JOptionPane.showMessageDialog(this, "Insertion réussie du nouveau véhicule !");
			this.viderChamps();
			
			//extraction de l'ID du dernier vehicule inséré
			unVehicule = Main.selectWhereVehicule(matricule);
			//actualisation de l'affichage 
			Client unClient = Main.selectWhereClient(idClient);
			Object ligne[] = {unVehicule.getIdVehicule(), matricule, marque,energie, nbKm, unClient.getNom()}; 
			this.unTableau.ajouterLigne(ligne);
		}
		else if (e.getSource() == this.btFiltrer)
		{
			String mot = this.txtMot.getText(); 
			this.unTableau.setDonnees(this.remplirDonnees(mot));
		}
		else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Modifier"))
		{
			int indiceLigne = uneTable.getSelectedRow(); 
			int idVehicule = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
			//on récupÃ¨re les données, on instancie un véhicule, on l'ajoute au bdd 
			String matricule = this.txtMatricule.getText(); 
			String marque = this.txtMarque.getText(); 
			int nbKm =0; 
			try{
				nbKm= Integer.parseInt(this.txtNbkm.getText()); 
			}
			catch (NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie du nbKM ");
			}
			String energie = this.cbxEnergie.getSelectedItem().toString(); 
			
			String chaine = this.cbxClient.getSelectedItem().toString(); 
			String tab [] = chaine.split(" - "); 
			int idClient = Integer.parseInt(tab[0]);
			
			
			Vehicule unVehicule = new Vehicule(matricule, marque,energie, nbKm, idClient);
			Main.updateVehicule(unVehicule);
			//actualisation de l'affichage 
			Client unClient = Main.selectWhereClient(idClient);
			Object ligne[] = {idVehicule, matricule, marque,energie, nbKm, unClient.getNom()}; 
			this.unTableau.modifierLigne(indiceLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification réussie du véhicule !");
			this.viderChamps();
		}
		
	}

}
