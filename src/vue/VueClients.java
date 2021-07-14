package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import controleur.Client;
import controleur.Main;
import controleur.Tableau;

public class VueClients extends JFrame implements ActionListener
{
	Font police = new Font("Calibri", Font.BOLD, 15);
	
	private JButton btRetour = new JButton("Retour au Menu") ; 
	/************************** Panel Ajout Client *********/
	private JPanel panelInsert = new JPanel(); 
	private JTextField txtNom = new JTextField(); 
	private JTextField txtPrenom = new JTextField(); 
	private JTextField txtAdresse= new JTextField(); 
	private JTextField txtEmail = new JTextField(); 
	private JTextField txtTel = new JTextField(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	/************************** Panel Lister Client *********/
	private JPanel panelLister = new JPanel(); 
	private JTable uneTable ; 
	private JScrollPane uneScroll ;
	private Tableau unTableau ; 
	
	/************************** Panel Filtrer Client *********/
	private JPanel panelFiltrer= new JPanel(); 
	private JLabel lbRecherche = new JLabel(""); 
	private JTextField txtMot = new JTextField(); 
	private JButton btFiltrer = new JButton("Filtrer");
	
	public VueClients() {
		this.setTitle("Gestion des Clients Fil'elec");
		this.setBounds(200, 200, 900, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color (84, 170, 255));
		
		ImageIcon uneImage = new ImageIcon("src/images/client.png"); 
		JLabel imgClient = new JLabel(uneImage); 
		imgClient.setBounds(130, 5, 70, 70);
		this.add(imgClient); 
		
		
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
		this.panelInsert.add(new JLabel("Nom Client : ")); 
		this.panelInsert.add(this.txtNom); 
		this.panelInsert.add(new JLabel("Prénom Client : ")); 
		this.panelInsert.add(this.txtPrenom);
		this.panelInsert.add(new JLabel("Adresse Client : ")); 
		this.panelInsert.add(this.txtAdresse);
		this.panelInsert.add(new JLabel("Email Client : ")); 
		this.panelInsert.add(this.txtEmail);
		this.panelInsert.add(new JLabel("Téléphone Client : ")); 
		this.panelInsert.add(this.txtTel);
		this.panelInsert.add(this.btAnnuler); 
		this.panelInsert.add(this.btEnregistrer); 
		this.btAnnuler.setForeground(new Color (84, 170, 255));
		this.btAnnuler.setFont(police);
		this.btEnregistrer.setForeground(new Color (84, 170, 255));
		this.btEnregistrer.setBackground(new Color (84, 170, 255));
		this.btEnregistrer.setFont(police);
		
		this.add(this.panelInsert); 
		
		/**************** Construction Panel Lister ***************/
		this.panelLister.setBounds(380, 80, 480, 320);
		this.panelLister.setBackground(new Color (84, 170, 255));
		this.panelLister.setLayout(null);
		String entetes[] = {"ID Client","Nom Client", "Prénom", "Adresse", "Email", "Téléphone"};
		//instanciation de la classe tableau donnees et entetes 
		this.unTableau = new Tableau(this.remplirDonnees(""), entetes);
		//instanciation de la Jtable sur la tableModel unTableau
		this.uneTable = new JTable(unTableau); 
		
		this.uneScroll = new JScrollPane(this.uneTable); 
		this.uneScroll.setBounds(0, 20, 460, 280);
		this.panelLister.add(this.uneScroll); 
		this.add(this.panelLister); 
		
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
		
		/*********************** rendre les boutons *****************/
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
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
					int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce client ?", 
							"Suppression Client", JOptionPane.YES_NO_OPTION); 
					if (retour == 0)
					{
						JOptionPane.showMessageDialog(null, "Client supprimé ");
						int indiceLigne = uneTable.getSelectedRow(); 
						int idClient = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
						Main.deleteClient(idClient);
						unTableau.supprimerLigne(indiceLigne);
					}
				}else if (e.getClickCount() == 1)
				{
					int indiceLigne = uneTable.getSelectedRow(); 
					txtNom.setText(unTableau.getValueAt(indiceLigne,1).toString()); 
					txtPrenom.setText(unTableau.getValueAt(indiceLigne,2).toString()); 
					txtAdresse.setText(unTableau.getValueAt(indiceLigne,3).toString()); 
					txtEmail.setText(unTableau.getValueAt(indiceLigne,4).toString()); 
					txtTel.setText(unTableau.getValueAt(indiceLigne,5).toString()); 
					
					btEnregistrer.setText("Modifier");
				}
				
			}
		});
		
		this.setVisible(true);
	}
	
	public Object [][] remplirDonnees (String mot)
	{
		//cette fonction transforme l'ArrayList des clients en une matride d'objets 
		ArrayList<Client> lesClients = Main.selectAllClient(mot);
		Object [][] matrice = new Object [lesClients.size()][6];
		int i = 0; 
		for (Client unClient : lesClients)
		{
			matrice [i][0] = unClient.getIdclient();
			matrice [i][1] = unClient.getNom();
			matrice [i][2] = unClient.getPrenom();
			matrice [i][3] = unClient.getAdresse();
			matrice [i][4] = unClient.getEmail();
			matrice [i][5] = unClient.getTel();
			i++;
		}
		return matrice;
	}
	
	public void viderChamps () {
		this.txtAdresse.setText("");
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtEmail.setText("");
		this.txtTel.setText("");
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
			String nom = this.txtNom.getText(); 
			String prenom = this.txtPrenom.getText(); 
			String adresse = this.txtAdresse.getText(); 
			String email = this.txtEmail.getText(); 
			String tel = this.txtTel.getText();
			Client unClient = new Client(nom, prenom,adresse, email, tel);
			this.txtNom.setBackground(new Color(64, 219, 119));
			this.txtPrenom.setBackground(new Color(64, 219, 119));
			this.txtAdresse.setBackground(new Color(64, 219, 119));
			this.txtEmail.setBackground(new Color(64, 219, 119));
			this.txtTel.setBackground(new Color(64, 219, 119));
			Main.insertClient(unClient);
			JOptionPane.showMessageDialog(this, "Insertion réussie du nouveau client !");
			this.viderChamps();
			this.txtNom.setBackground(Color.white);
			this.txtPrenom.setBackground(Color.white);
			this.txtAdresse.setBackground(Color.white);
			this.txtEmail.setBackground(Color.white);
			this.txtTel.setBackground(Color.white);
			
			//extraction de l'ID du dernier client inséré
			unClient = Main.selectWhereClient(email);
			//actualisation de l'affichage 
			Object ligne[] = {unClient.getIdclient(), nom, prenom, adresse, email, tel}; 
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
			int idClient = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
			//on récupÃ¨re les données, on instancie un client, on l'ajoute au bdd 
			String nom = this.txtNom.getText(); 
			String prenom = this.txtPrenom.getText(); 
			String adresse = this.txtAdresse.getText(); 
			String email = this.txtEmail.getText(); 
			String tel = this.txtTel.getText();
			Client unClient = new Client(idClient, nom, prenom,adresse, email, tel);
			Main.updateClient(unClient);
			//actualisation de l'affichage 
			Object ligne[] = {idClient, nom, prenom, adresse, email, tel}; 
			this.unTableau.modifierLigne(indiceLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification réussie du client !");
			this.viderChamps();
		}
	}
	

}








