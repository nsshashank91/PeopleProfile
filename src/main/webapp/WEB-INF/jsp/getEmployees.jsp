<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Show Employees</title>
</head>
<body>
<a href="/logout">Logout</a>
	<jsp:include page="menu.jsp" />
	      
	<h3 style="color: red;">Show All Employees</h3>
	<ul>
		<c:forEach var="listValue" items="${employees}">
			<li>${listValue.empName} | ${listValue.phone} |
<%-- 			|${listValue.vehicles} --%>
			 <a href="${contextPath}/updateEmployee/${listValue.empId}">Update</a> |
			 <a href="${contextPath}/deleteEmployee/${listValue.empId}">Delete</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>