package entites;

import java.util.ArrayList;
import java.util.Collection;

public class Client {
	private String id;
	private String nom;
	private String prenom;
	private String ville;
	private Collection<Compte> comptes;
	public Client(int id, String nom, String prenom, String ville) {
		super();
		this.id =Integer.toString(id);
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.comptes=new ArrayList<Compte>();
	}
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	public String getId() {
		return id;
	}
	public void setId(int id) {
		this.id =Integer.toString(id);
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public void addcomptes(Compte c) {
		this.comptes.add(c);
	}

}
