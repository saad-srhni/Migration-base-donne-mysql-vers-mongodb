package mysqlToMongodb;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

import entites.Client;
import entites.Compte;
import mysqlToMongodb.dao.Mysqldao;

public class Test {

	public static void main(String[] args) throws UnknownHostException, MongoException {
		try {
			// TODO Auto-generated method stub
			Mysqldao mysql = new Mysqldao();
			Collection<Client> clients = mysql.findAllClientCompte();

			Iterator<Client> it = clients.iterator();
			Gson gson = new Gson();
			List<DBObject> listobj = new ArrayList<DBObject>();

			while (it.hasNext()) {
				String jsonClients = gson.toJson(it.next());
				DBObject obj = (DBObject) JSON.parse(jsonClients);
				listobj.add(obj);

			}

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("mysqltomongodb");
			DBCollection collection = db.getCollection("clientsCompte");

			collection.insert(listobj);
			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
