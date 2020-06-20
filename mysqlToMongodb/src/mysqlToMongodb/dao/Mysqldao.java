package mysqlToMongodb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import entites.Client;
import entites.Compte;

public class Mysqldao {
	public Collection<Client> findAllClientCompte() {
		Connection connection = (Connection) MysqlConnector.getInstance().getConnection();
		Collection<Client> clients = new ArrayList<Client>();
		Collection<Compte> comptes = new ArrayList<Compte>();

		try {
			PreparedStatement stmt;
			stmt = (PreparedStatement) connection.prepareStatement("SELECT * FROM clients");
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				String ville = result.getString("ville");
				PreparedStatement stmt1;
				stmt1 = (PreparedStatement) connection.prepareStatement("SELECT * FROM comptes WHERE client_id=?");
				stmt1.setInt(1, id);
				ResultSet result1 = stmt1.executeQuery();
				while (result1.next()) {
					Compte compte = new Compte(result1.getInt("id"), result1.getDouble("solde"));
					comptes.add(compte);
				}
				Client client = new Client(id, nom, prenom, ville);
				client.setComptes(comptes);
				clients.add(client);
				comptes = null;
				comptes = new ArrayList<Compte>();

			}
			return clients;

		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}

		return null;
	}

}
