<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<table>
		<tr>
			<td>#</td>
			<td>Name</td>
			<td>Type</td>
		</tr>
		
		<c:forEach items="${catalogs}" var="catalog">
			
		<tr>
			<td>#</td>
			<td>${catalog.name}</td>
			<td>${catalog.type}</td>
		</tr>
					
		</c:forEach>	
	
	</table>	
</body>
</html>