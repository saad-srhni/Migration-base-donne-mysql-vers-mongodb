package entites;

public class Compte {
	private String id;
	private double solde;
	public Compte(int id, double solde) {
		super();
		this.id = Integer.toString(id);
		this.solde = solde;		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public void addcompteclient(Client c) {
		c.addcomptes(this);
	}

}
