<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/logout">Logout</a>
	<jsp:include page="menu.jsp" />
	      
	<h3 style="color: red;">Show All Vehicles</h3>
	<ul>
		<c:forEach var="listValue" items="${vehicles}">
			<li>${listValue.vehicleName} | ${listValue.employee} |
			 <a href="${contextPath}/updateVehicle/${listValue.vehicleId}">Update</a> |
			 <a href="${contextPath}/deleteVehicle/${listValue.vehicleId}">Delete</a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>