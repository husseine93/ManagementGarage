package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Main;
import controleur.Tableau;
import controleur.Vehicule;
import controleur.Entretien;
import controleur.Technicien;

public class VueEntretien extends JFrame implements ActionListener
{
	Font police = new Font("Calibri", Font.BOLD, 15);
	
	private JButton btRetour = new JButton("Retour au Menu") ; 
	/************************** Panel Ajout Vehicule *********/
	private JPanel panelInsert = new JPanel(); 
	private JComboBox<String> cbxVehicule= new JComboBox<String>();  
	private JComboBox<String> cbxTechnicien= new JComboBox<String>();
	private JTextField txtDescription = new JTextField(); 
	private JTextField txtMontant= new JTextField();
	private JTextField txtDateentretien = new JTextField(); 
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
	
	public VueEntretien() {
		this.setTitle("Gestion des Entretiens Fil'elec");
		this.setBounds(200, 200, 900, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color (84, 170, 255));
		
		ImageIcon uneImage = new ImageIcon("src/images/entretien.png"); 
		JLabel imgEntretien = new JLabel(uneImage); 
		imgEntretien.setBounds(140, 10, 70, 70);
		this.add(imgEntretien); 
		
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
		this.panelInsert.add(new JLabel("Id Véhicule : ")); 
		this.panelInsert.add(this.cbxVehicule);
		this.panelInsert.add(new JLabel("Id Technicien: ")); 
		this.panelInsert.add(this.cbxTechnicien);
		this.panelInsert.add(new JLabel("Description : ")); 
		this.panelInsert.add(this.txtDescription); 
		this.panelInsert.add(new JLabel("Montant : ")); 
		this.panelInsert.add(this.txtMontant);
		this.panelInsert.add(new JLabel("Date d'Entretien : ")); 
		this.panelInsert.add(this.txtDateentretien);
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
		String entetes[] = {"ID Entretien","Id Véhicule", "Id Technicien", "Description", "Montant", "Date d'Entretien"};
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
		this.remplirCBXVehicule (); 
		this.remplirCBXTechnicien ();
		
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
							int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cet entretien ?", 
									"Suppression Entretien", JOptionPane.YES_NO_OPTION); 
							if (retour == 0)
							{
								JOptionPane.showMessageDialog(null, "Entretien supprimé ");
								int indiceLigne = uneTable.getSelectedRow(); 
								int idEntretien = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
								Main.deleteEntretien(idEntretien);
								unTableau.supprimerLigne(indiceLigne);
							}
						}else if (e.getClickCount() == 1)
						{
							int indiceLigne = uneTable.getSelectedRow(); 
							txtDescription.setText(unTableau.getValueAt(indiceLigne,3).toString()); 
							txtMontant.setText(unTableau.getValueAt(indiceLigne,4).toString()); 
							txtDateentretien.setText(unTableau.getValueAt(indiceLigne,5).toString()); 
							 
							
							btEnregistrer.setText("Modifier");
						}
						
					}
				});
				
				
		this.setVisible(true);
	}
	
	
	public Object [][] remplirDonnees (String mot)
	{
		//cette fonction transforme l'ArrayList des lesVehicules en une matrice d'objets 
		ArrayList<Entretien> lesEntretiens = Main.selectAllEntretien(mot);
		Object [][] matrice = new Object [lesEntretiens.size()][6];
		int i = 0; 
		for (Entretien unEntretien : lesEntretiens)
		{
			matrice [i][0] = unEntretien.getIdentretien();
			Vehicule unVehicule = Main.selectWhereVehicule(unEntretien.getIdvehicule());
			matrice [i][1] = unVehicule.getMatricule();
			Technicien unTechnicien = Main.selectWhereTechnicien(unEntretien.getIdtech());
			matrice [i][2] = unTechnicien.getIdtech();
			matrice [i][3] = unEntretien.getDescription();
			matrice [i][4] = unEntretien.getMontant();
			matrice [i][5] = unEntretien.getDateentretien();
			i++;
		}
		return matrice;
	}
	
	public void remplirCBXVehicule ()
	{
		this.cbxVehicule.removeAllItems();
		for (Vehicule unVehicule : Main.selectAllVehicule(""))
		{
			this.cbxVehicule.addItem(unVehicule.getIdVehicule() +" - " + unVehicule.getMatricule()
			+ " - " + unVehicule.getMarque());
		}
	}
	public void remplirCBXTechnicien()
	{
		this.cbxTechnicien.removeAllItems();
		for (Technicien unTechnicien : Main.selectAllTechnicien(""))
		{
			this.cbxTechnicien.addItem(unTechnicien.getIdtech() +" - " + unTechnicien.getNom()
			+ " - " + unTechnicien.getPrenom());
		}
	}
	public void viderChamps ()
	{
		this.txtDescription.setText("");
		this.txtMontant.setText("");
		this.txtDateentretien.setText("");
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
			String description = this.txtDescription.getText(); 
			String dateentretien = this.txtDateentretien.getText(); 
			int montant =0; 
			try{
				montant= Integer.parseInt(this.txtMontant.getText()); 
			}
			catch (NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie du Montant ");
			}
			
			String chaine = this.cbxVehicule.getSelectedItem().toString(); 
			String tab [] = chaine.split(" - "); 
			int idvehicule = Integer.parseInt(tab[0]);
			String chaine1 = this.cbxTechnicien.getSelectedItem().toString(); 
			String tab1 [] = chaine.split(" - "); 
			int idtech = Integer.parseInt(tab[0]);
			
			Entretien unEntretien = new Entretien(idvehicule, idtech, description, montant, dateentretien);
			this.txtDescription.setBackground(new Color(64, 219, 119));
			this.txtMontant.setBackground(new Color(64, 219, 119));
			this.txtDateentretien.setBackground(new Color(64, 219, 119));
			Main.insertEntretien(unEntretien);
			JOptionPane.showMessageDialog(this, "Insertion réussie du nouvel entretien !");
			this.viderChamps();
			this.txtDescription.setBackground(Color.white);
			this.txtMontant.setBackground(Color.white);
			this.txtDateentretien.setBackground(Color.white);
			
			//extraction de l'ID du dernier vehicule inséré
			unEntretien = Main.selectWhereEntretien(description);
			//actualisation de l'affichage 
			Vehicule unVehicule = Main.selectWhereVehicule(idvehicule);
			Technicien unTechnicien = Main.selectWhereTechnicien(idtech);
			Object ligne[] = {unEntretien.getIdentretien(), unVehicule.getMatricule(), unTechnicien.getNom(), description, montant ,dateentretien}; 
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
			int idEntretien = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
			//on récupÃ¨re les données, on instancie un véhicule, on l'ajoute au bdd 
			String description = this.txtDescription.getText(); 
			String dateentretien = this.txtDateentretien.getText(); 
			int montant =0; 
			try{
				montant= Integer.parseInt(this.txtMontant.getText()); 
			}
			catch (NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie du Montant ");
			}
			
			String chaine = this.cbxVehicule.getSelectedItem().toString(); 
			String tab [] = chaine.split(" - "); 
			int idvehicule = Integer.parseInt(tab[0]);
			
			String chaine1 = this.cbxTechnicien.getSelectedItem().toString(); 
			String tab1 [] = chaine.split(" - "); 
			int idtech = Integer.parseInt(tab[0]);
			
			
			Entretien unEntretien = new Entretien(idvehicule, idtech, description, montant, dateentretien);
			Main.updateEntretien(unEntretien);
			//actualisation de l'affichage 
			Vehicule unVehicule = Main.selectWhereVehicule(idvehicule);
			Technicien unTechnicien = Main.selectWhereTechnicien(idtech);
			Object ligne[] = {unEntretien.getIdentretien(), unVehicule.getMatricule(), unTechnicien.getNom(), description, montant ,dateentretien};  
			this.unTableau.modifierLigne(indiceLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification réussie de l'entretien !");
			this.viderChamps();
		}
		
	}

}
