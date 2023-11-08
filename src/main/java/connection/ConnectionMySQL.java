package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {


	 private static final String USERNAME = "root";
	    private static final String PASSWORD = "258014esz"; 

	    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/buscadores_aventuras";

	    public static Connection createConnectionToMySQL() throws Exception {
	        
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/buscadores_aventuras", "root",  "258014esz"); 
	        return connection;
	    }

	    public static void main(String[] args) throws Exception {
	        Connection con = createConnectionToMySQL();

	        if (con != null) {
	            System.out.println("Conexão obtida com sucesso! " + con);
	            con.close();
	        }
	    }
}
