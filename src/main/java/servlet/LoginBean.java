package servlet;

public class LoginBean {
    private String username;
    private String password;
    private String userType;

    public boolean valid;
    
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String newPassword)
    {
        password = newPassword;
    }
    public String getUsername()
    {
        return username;
    }
    public void setUserName(String newUsername)
    {
        username = newUsername;
    }
    public String getUserType(){
    	return this.userType;
    }
    public void setUserType(String uT){
    	userType = uT;
    }
    public boolean isValid()
    {
        return valid;
    }
    public void setValid(boolean newValid)
    {
        valid = newValid;
    }
}