<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>dashboard</title>
<%@ include file="header.jsp"%>
</head>
<body>
<h2>Welcome to Dashboard page</h2>	
</body>
Welcome,<%=useremailheader%>
	
	<sql:query dataSource="${webappDataSource}" var="result">
	SELECT * FROM advjjava.profile WHERE useremail="<%=useremailheader%>";
</sql:query>

	<table border="1">
		<tbody>
			<tr>
				<th>profileid</th>
				<th>username</th>
				<th>usercity</th>
				<th>usermobile</th>
				<th>useremail</th>
			</tr>
			<c:forEach var="row" items="${result.rows}">
				<tr>
					<td>${row.profileid}</td>
					<td>${row.username}</td>
					<td>${row.usercity}</td>
					<td>${row.usermobile}</td>
					<td>${row.useremail}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	

</html>