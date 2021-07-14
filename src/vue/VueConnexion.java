package vue;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.*;

import controleur.Main;
import controleur.Technicien;

public class VueConnexion extends JFrame implements ActionListener, KeyListener
{
	/********************* Instanciation Panel Connexion ************/
	private JPanel panelConnexion = new JPanel(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btSeConnecter = new JButton("Se Connecter");
	private JTextField txtEmail = new JTextField(); 
	private JPasswordField txtMdp = new JPasswordField(); 
	
	/********************* Instanciation Panel Menu ************/
	private JPanel panelMenu = new JPanel(); 
	private JButton btClients = new JButton("Gestion Clients"); 
	private JButton btTechniciens = new JButton("Gestion Techniciens"); 
	private JButton btProduits = new JButton("Gestion Produits"); 
	private JButton btEntretiens = new JButton("Gestion Entretiens ");
	private JButton btStats = new JButton("Statistiques ");
	private JButton btQuitter = new JButton("Quitter"); 
	
	Font police = new Font("Calibri", Font.BOLD, 15);
	
	public  VueConnexion() {
		this.setTitle("Administrateur Fil'Elec");
		this.setBounds(200, 200, 700, 350);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color (84, 170, 255));
		
		
		ImageIcon uneImage = new ImageIcon("src/images/fillogo.png"); 
		JLabel monLogo = new JLabel(uneImage); 
		monLogo.setBounds(20, 60, 270, 200);
		this.add(monLogo); 
		
		/**************** Construction Panel Connexion ***************/
		this.panelConnexion.setBounds(320, 60, 340, 200);
		this.panelConnexion.setBackground(new Color (84, 170, 255));
		this.panelConnexion.setLayout(new GridLayout(3,2));
		this.panelConnexion.add(new JLabel("Email : ")); 
		this.panelConnexion.add(this.txtEmail); 
		this.panelConnexion.add(new JLabel("MDP :")); 
		this.panelConnexion.add(this.txtMdp); 
		this.panelConnexion.add(this.btAnnuler); 
		this.panelConnexion.add(this.btSeConnecter); 
		this.add(this.panelConnexion);
		
		/**************** Construction Panel MENU ***************/
		this.panelMenu.setBounds(320, 60, 340, 200);
		this.panelMenu.setBackground(new Color (84, 170, 255));
		this.panelMenu.setLayout(new GridLayout(3,2));
		this.panelMenu.add(this.btClients); 
		this.panelMenu.add(this.btTechniciens); 
		this.panelMenu.add(this.btProduits); 
		this.panelMenu.add(this.btEntretiens); 
		this.panelMenu.add(this.btStats); 
		this.panelMenu.add(this.btQuitter); 
		this.add(this.panelMenu); 
		this.panelMenu.setVisible(false);
		
		/****************** Rendre les boutons ecoutables ************/
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		this.btClients.addActionListener(this);
		this.btEntretiens.addActionListener(this);
		this.btProduits.addActionListener(this);
		this.btStats.addActionListener(this);
		this.btQuitter.addActionListener(this);
		this.btTechniciens.addActionListener(this);
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		//this.btSeConnecter.setBackground(new Color (84, 170, 255));
		this.btSeConnecter.setForeground(new Color (84, 170, 255));
		this.btSeConnecter.setFont(police);
		this.btAnnuler.setForeground(new Color (84, 170, 255));
		this.btAnnuler.setFont(police);
		
		this.btClients.setForeground(new Color (84, 170, 255));
		this.btClients.setFont(police);
		this.btEntretiens.setForeground(new Color (84, 170, 255));
		this.btEntretiens.setFont(police);
		this.btProduits.setForeground(new Color (84, 170, 255));
		this.btProduits.setFont(police);
		this.btStats.setForeground(new Color (84, 170, 255));
		this.btStats.setFont(police);
		this.btQuitter.setForeground(new Color (84, 170, 255));
		this.btQuitter.setFont(police);
		this.btTechniciens.setForeground(new Color (84, 170, 255));
		this.btTechniciens.setFont(police);
		
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 if (this.btAnnuler == e.getSource())
		 {
			 this.txtEmail.setText("");
			 this.txtMdp.setText("");
		 }
		 else if (e.getSource() == this.btSeConnecter)
		 {
			this.traitement (); 
		 }
		 else if (e.getSource() == this.btQuitter)
		 {
			 int retour = JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'application", 
					 	"Quitter l'application", JOptionPane.YES_NO_OPTION);
			 if (retour == 0) {
				 				this.panelConnexion.setVisible(true);
				 				this.panelMenu.setVisible(false);
			 	}
		 }
		 
		 else if (e.getSource() == this.btClients)
		 {
			 Main.rendreVisible(false);
			 Main.instancierVueClients();
		 }
		 else if (e.getSource() == this.btTechniciens)
		 {
			 Main.rendreVisible(false);
			 Main.instancierVueTechniciens();
		 }
		 else if (e.getSource() == this.btProduits)
		 {
			 Main.rendreVisible(false);
			 Main.instancierVueProduits();
		 }
		 else if (e.getSource() == this.btEntretiens)
		 {
			 Main.rendreVisible(false);
			 Main.instancierVueEntretiens();
		 }
		
	}

	public void traitement ()
	{
		 String email = this.txtEmail.getText(); 
		 String mdp = new String (this.txtMdp.getPassword());
		 //on demande au controleur de nous donner le technicien 
		 Technicien unTechnicien = Main.selectWhereTechnicien(email, mdp); 
		 if (unTechnicien == null)
		 {
			 JOptionPane.showMessageDialog(this, "Veuillez vérifier vos identifiants ");
		 }
		 else {
			 JOptionPane.showMessageDialog(this, "Bienvenue  "
					 		+unTechnicien.getNom()+" " + unTechnicien.getPrenom());
			 
			 //on ouvre le logiciel d'administration et on coupe la connexion 
			 this.panelConnexion.setVisible(false);
			 this.panelMenu.setVisible(true);
		 }
		 this.txtEmail.setText("");
		 this.txtMdp.setText("");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		//sur frappe de touche entrée 
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			this.traitement(); 
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}









