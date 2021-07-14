package controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel
{
	private String entetes []; 
	private Object donnees [][]; 
	
	public Tableau (Object donnees [][], String entetes[]) {
		this.donnees = donnees; 
		this.entetes = entetes;
	}
	
	@Override
	public int getRowCount() {
		return this.donnees.length;
	}

	@Override
	public int getColumnCount() {
		
		return this.entetes.length;
	}

	@Override
	public Object getValueAt(int indiceLigne, int indiceColonne) {
		return this.donnees[indiceLigne][indiceColonne];
	}

	@Override
	public String getColumnName(int indiceColonne) {
		return this.entetes[indiceColonne];
	}
	
	public void ajouterLigne (Object [] ligne)
	{
		Object matrice [] [] = new Object[this.donnees.length +1 ][this.entetes.length];
		int i = 0; 
		for (i = 0; i <this.donnees.length; i++)
		{
			matrice [i] = this.donnees[i]; // recopie ligne par ligne 
		}
		matrice[this.donnees.length] = ligne; 
		//actualisation des données 
		this.donnees = matrice ; 
		this.fireTableDataChanged();
	}
	public void supprimerLigne(int indiceLigne)
	{
		Object matrice [] [] = new Object[this.donnees.length -1 ][this.entetes.length];
		int i = 0, j = 0; 
		for (i = 0; i <this.donnees.length; i++)
		{
			if(i != indiceLigne)
			{
				matrice [j] = this.donnees[i]; // recopie ligne par ligne 
				j++;
			}
		}
		//actualisation des données 
		this.donnees = matrice ; 
		this.fireTableDataChanged();
	}
	public void modifierLigne(int indiceLigne, Object  ligne[])
	{
		Object matrice [] [] = new Object[this.donnees.length][this.entetes.length];
		int i = 0, j = 0; 
		for (i = 0; i <this.donnees.length; i++)
		{
			if(i != indiceLigne)
			{
				matrice [j] = this.donnees[i]; // recopie ligne par ligne 
				j++;
			}else {
				matrice [j] = ligne; //injecte la nouvelle ligne
				j++; 
			}
		}
		//actualisation des données 
		this.donnees = matrice ; 
		this.fireTableDataChanged();
	}
	public void setDonnees (Object matrice [] [])
	{
		//actualisation des données 
		this.donnees = matrice ; 
		this.fireTableDataChanged();
	}
}
