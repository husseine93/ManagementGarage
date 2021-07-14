package controleur;

public class Produit 
{

	private int idP; 
	private String name, detail; 
	private int price, quantity,idclient;
	
	
	public Produit(int idP, String name, String detail, int price, int quantity, int idclient) {
		super();
		this.idP = idP;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.quantity = quantity;
		this.idclient = idclient;
	}
	public Produit(String name, String detail, int price, int quantity, int idclient) {
		super();
		this.idP = 0;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.quantity = quantity;
		this.idclient = idclient;
	}
	public Produit() {
		this.idP = 0;
		this.name = "";
		this.detail = "";
		this.price = 0;
		this.quantity = 0;
		this.idclient = 0;
	}

	public int getIdP() {
		return idP;
	}
	public void setIdP(int idP) {
		this.idP = idP;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	
	
}


 