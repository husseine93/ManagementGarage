package vue;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

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

import controleur.Client;
import controleur.Main;
import controleur.Tableau;
import controleur.Produit;

public class VueProduits extends JFrame implements ActionListener
{
	Font police = new Font("Calibri", Font.BOLD, 15);
	
	private JButton btRetour = new JButton("Retour au Menu") ; 
	/************************** Panel Ajout Produit *********/
	private JPanel panelInsert = new JPanel(); 
	private JTextField txtName = new JTextField(); 
	private JTextField txtDetail= new JTextField(); 
	private JTextField txtQuantity = new JTextField();
	private JTextField txtPrice = new JTextField(); 
	private JComboBox<String> cbxClient= new JComboBox<String>();
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	/************************** Panel Lister Produit *********/
	private JPanel panelLister = new JPanel(); 
	private JTable uneTable ; 
	private JScrollPane uneScroll ;
	private Tableau unTableau ; 
	
	/************************** Panel Filtrer Client *********/
	private JPanel panelFiltrer= new JPanel(); 
	private JLabel lbRecherche = new JLabel(""); 
	private JTextField txtMot = new JTextField(); 
	private JButton btFiltrer = new JButton("Filtrer");
	
	
	public VueProduits() {
		this.setTitle("Gestion des Produits Fil'elec");
		this.setBounds(200, 200, 900, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color (84, 170, 255));
		
		ImageIcon uneImage = new ImageIcon("src/images/product.png"); 
		JLabel imgProduit = new JLabel(uneImage); 
		imgProduit.setBounds(140, 15, 60, 60);
		this.add(imgProduit); 
		
		/******************** Construction BT Retour **********/
		this.btRetour.setBounds(500, 400, 200, 30);
		this.add(this.btRetour); 
		this.btRetour.addActionListener(this);
		this.btRetour.setForeground(new Color (84, 170, 255));
		this.btRetour.setFont(police);
		
		/**************** Construction Panel Insert ***************/
		this.panelInsert.setBounds(40, 80, 280, 320);
		this.panelInsert.setBackground(new Color (84, 170, 255));
		this.panelInsert.setLayout(new GridLayout(6,2));
		this.panelInsert.add(new JLabel("Nom Produit : ")); 
		this.panelInsert.add(this.txtName); 
		this.panelInsert.add(new JLabel(" Détail : ")); 
		this.panelInsert.add(this.txtDetail);
		this.panelInsert.add(new JLabel("Quantité : ")); 
		this.panelInsert.add(this.txtQuantity);
		this.panelInsert.add(new JLabel("Prix Produit : ")); 
		this.panelInsert.add(this.txtPrice);
		this.panelInsert.add(new JLabel("Client : ")); 
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
		String entetes[] = {"ID","Nom", "Détail", "Quantité", "Prix", "Client"};
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
							int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce Produit?", 
									"Suppression Produit", JOptionPane.YES_NO_OPTION); 
							if (retour == 0)
							{
								JOptionPane.showMessageDialog(null, "Produit supprimé ");
								int indiceLigne = uneTable.getSelectedRow(); 
								int idProduit = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
								Main.deleteProduit(idProduit);
								unTableau.supprimerLigne(indiceLigne);
							}
						}else if (e.getClickCount() == 1)
						{
							int indiceLigne = uneTable.getSelectedRow(); 
							txtName.setText(unTableau.getValueAt(indiceLigne,1).toString()); 
							txtDetail.setText(unTableau.getValueAt(indiceLigne,2).toString()); 
							txtQuantity.setText(unTableau.getValueAt(indiceLigne,3).toString()); 
							txtPrice.setText(unTableau.getValueAt(indiceLigne,4).toString()); 
							 
							
							btEnregistrer.setText("Modifier");
						}
						
					}
				});
				
				
		this.setVisible(true);
	}
	
	
	public Object [][] remplirDonnees (String mot)
	{
		//cette fonction transforme l'ArrayList des lesProduits en une matrice d'objets 
		ArrayList<Produit> lesProduits = Main.selectAllProduit(mot);
		Object [][] matrice = new Object [lesProduits.size()][6];
		int i = 0; 
		for (Produit unProduit : lesProduits)
		{
			matrice [i][0] = unProduit.getIdP();
			matrice [i][1] = unProduit.getName();
			matrice [i][2] = unProduit.getDetail();
			matrice [i][3] = unProduit.getQuantity();
			matrice [i][4] = unProduit.getPrice();
			Client unClient = Main.selectWhereClient(unProduit.getIdclient());
			matrice [i][5] = unClient.getNom();
			i++;
		}
		return matrice;
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
		this.txtName.setText("");
		this.txtDetail.setText("");
		this.txtQuantity.setText("");
		this.txtPrice.setText("");
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
			String name = this.txtName.getText(); 
			String detail = this.txtDetail.getText(); 
			int quantity =0; 
			int price=0;
			try {
				quantity = Integer.parseInt(this.txtQuantity.getText());
			} catch (NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, "Erreur de saisie de la quantité ");
				this.txtQuantity.setBackground(new Color(231, 121, 137));
			}
			try {
				price = Integer.parseInt(this.txtPrice.getText());
			} catch (NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, "Erreur de saisie du prix ");
				this.txtPrice.setBackground(new Color(231, 121, 137));
				
			}
			
			String chaine = this.cbxClient.getSelectedItem().toString();
			String tab[] = chaine.split(" - ");
			int idClient = Integer.parseInt(tab[0]);
			if (quantity==0 || price==0 )
			{
				JOptionPane.showMessageDialog(this, "Vérifiez les données d'enregistrement ");
				this.txtQuantity.setBackground(Color.white);
				this.txtPrice.setBackground(Color.white);
			}
			
			else 
			{
			Produit unProduit = new Produit(name, detail,quantity, price, idClient);
			this.txtName.setBackground(new Color(64, 219, 119));
			this.txtDetail.setBackground(new Color(64, 219, 119));
			this.txtQuantity.setBackground(new Color(64, 219, 119));
			this.txtPrice.setBackground(new Color(64, 219, 119));
			Main.insertProduit(unProduit);
			JOptionPane.showMessageDialog(this, "Insertion réussie du nouveau Produit !");
			this.viderChamps();
			this.txtName.setBackground(Color.white);
			this.txtDetail.setBackground(Color.white);
			this.txtQuantity.setBackground(Color.white);
			this.txtPrice.setBackground(Color.white);
			
			//extraction de l'ID du dernier Produit insÃƒÂ©rÃƒÂ©
			unProduit = Main.selectWhereProduit(name);
			//actualisation de l'affichage 
			Client unClient = Main.selectWhereClient(idClient);
			Object ligne[] = {unProduit.getIdP(), name, detail,quantity, price, unClient.getNom()}; 
			this.unTableau.ajouterLigne(ligne);
			}
		}
		else if (e.getSource() == this.btFiltrer)
		{
			String mot = this.txtMot.getText(); 
			this.unTableau.setDonnees(this.remplirDonnees(mot));
		}
		else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Modifier"))
		{
			int indiceLigne = uneTable.getSelectedRow(); 
			int idProduit = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
			//on récupÃ¨re les données, on instancie un véhicule, on l'ajoute au bdd 
			String name = this.txtName.getText(); 
			String detail = this.txtDetail.getText(); 
			int quantity =0;
			int price=0;
			try{
				quantity=Integer.parseInt(this.txtQuantity.getText());
				price= Integer.parseInt(this.txtPrice.getText()); 
			}
			catch (NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie du prix ou de la quantité ");
			}
			 
			
			String chaine = this.cbxClient.getSelectedItem().toString(); 
			String tab [] = chaine.split(" - "); 
			int idClient = Integer.parseInt(tab[0]);
			
			
			Produit unProduit = new Produit(name, detail,quantity, price, idClient);
			Main.updateProduit(unProduit);
			//actualisation de l'affichage 
			Client unClient = Main.selectWhereClient(idClient);
			Object ligne[] = {idProduit, name, detail,quantity, price, unClient.getNom()}; 
			this.unTableau.modifierLigne(indiceLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification réussie du Produit !");
			this.viderChamps();
		}
		
	}
	@SuppressWarnings("serial")
	class IHMSon extends JPanel implements ActionListener {
		private JButton jouer = new JButton("jouer");
		@SuppressWarnings("deprecation")
		private java.applet.AudioClip son;

		@SuppressWarnings("deprecation")
		IHMSon() {
			// Premiere possibilite
			java.net.URL url =
				JouerSon.class.getResource("sons/oiseau.au");

			/* Seconde possibilite
				java.net.URL url = null; 
				try {	
				url = new java.net.URL("http://www.infres.enst.fr/~hudry/coursjava/images/sons/oiseau.au");
				} 
				catch (java.net.MalformedURLException exc) {
				exc.printStackTrace();
			}  */

			son = java.applet.Applet.newAudioClip(url);

			add(jouer);
			jouer.addActionListener(this);
		} 

		@SuppressWarnings("deprecation")
		public void actionPerformed(java.awt.event.ActionEvent e) {
			son.play();
		}
	}

	class JouerSon {
		public void main(String[] argv) {
			JFrame fenetre = new JFrame();
			fenetre.setContentPane(new IHMSon());
			fenetre.pack();
			fenetre.setLocation(100, 100);
			fenetre.setVisible(true);
			fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}
