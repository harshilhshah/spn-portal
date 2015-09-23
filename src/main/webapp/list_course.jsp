<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*, servlet.ConnectionManager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
		Connection conn = ConnectionManager.getConnection();
		String url = "jdbc:mysql://localhost:3306/test";
        String uname = "root";
        String pwd = "RashmikA1994";
			PreparedStatement ps = null;
			String sql = "select Distinct c_name, start_time, end_time FROM class l, Course s WHERE l.c_id = s.c_id";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		%>
		<h1 style = text-align:center>List Of Courses</h1>
		
  		<table align = "center" ; style ="border:1px solid black">
  		 
    	<tr><th>Course Name</th><th>Start Time</th><th>End Time</th></tr>
		<%
			while (rs.next()) {
				String course = rs.getString("c_name");
				String stime = rs.getString("start_time");
				String etime = rs.getString("end_time");
		%>
			
    	<tr><td><%=course%></td><td><%=stime %></td><td><%= etime %></td></tr>
			<% }%>
		
		</table>
		</div>
	</form>
</div>
</body>
</html>