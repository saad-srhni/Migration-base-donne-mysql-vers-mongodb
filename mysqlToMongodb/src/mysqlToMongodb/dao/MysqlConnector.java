package mysqlToMongodb.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnector {

	private static MysqlConnector instance;
	private MysqlConnector() {
		
	}
	
	public static MysqlConnector getInstance() {
		if(instance == null) {
			instance = new MysqlConnector();
		}
		return instance;
	}
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mysqltomongodb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		} catch (Exception e) {
			System.out.println("Erreur " + e.getMessage());
		}
		return connection;

}



}
