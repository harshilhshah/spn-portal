package servlet;

import java.sql.*;
import java.net.URI;
import java.net.URISyntaxException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
 
public class LoginDAO
{
	static Connection currentCon = null;
	static ResultSet rs = null;
	public static LoginBean login(LoginBean bean)
	{
		Statement stmt = null;
		String username = bean.getUsername();
		String password = bean.getPassword();
		String userType = bean.getUserType();
		String searchQuery = "";
        
		if(userType.equalsIgnoreCase("Professor")){
            searchQuery = "select * from professor where p_name ='"
            + username + "' AND password ='" + password + "'";
        }
		else{
            searchQuery = "select * from student where netid = '"
             + username + "' AND password ='" + password + "'";
        }

		try
		{
			//connecting to the DB
			currentCon = getConnection();
			stmt=currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean userExists = rs.next();

			if (!userExists)
			{
				bean.setValid(false);
			}
			else if (userExists)
			{
				bean.setValid(true);
			}

		}
		catch (Exception ex)
		{
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}
		return bean;
	}
    
    
    private static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI("postgres://kqhvhqddmkrsqn:62Xce6oc7jDOtzdj_1zoS9cjeF@ec2-54-243-51-102.compute-1.amazonaws.com:5432/dbtqfktvp3vn22");
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        int port = dbUri.getPort();
        
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + port + dbUri.getPath() + "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
        return DriverManager.getConnection(dbUrl, username, password);
    }
}