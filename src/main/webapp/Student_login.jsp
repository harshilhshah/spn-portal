<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Login Page</title> </head>
<body>
<%	
	if(request.getAttribute("user")!= null && request.getAttribute("user").equals("fail")){ %>
	<p> <em> Authentication Failed </em> </p>
	<% } %>
	
<form name="studentForm" action="LoginServlet" method ="GET">
<table>
<tr><td>Enter your Username: </td><td><input type="text" name="uname"/></td></tr>
<tr><td>Enter your Password: </td><td><input type="password" name="password"/></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="submit"> </td></tr>
</table>
</form>

</body>
</html>