package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.net.URI;
import java.net.URISyntaxException;
 
public class ConnectionManager{
	
    static Connection conn;
 
    public static Connection getConnection() throws URISyntaxException, SQLException
    {
            URI dbUri = new URI("postgres://kqhvhqddmkrsqn:62Xce6oc7jDOtzdj_1zoS9cjeF@ec2-54-243-51-102.compute-1.amazonaws.com:5432/dbtqfktvp3vn22");
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            int port = dbUri.getPort();
            
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + port + dbUri.getPath() + "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
        conn = DriverManager.getConnection(dbUrl, username, password);;
        return conn;
    }
 
}