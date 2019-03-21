<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<jsp:include page="menu.jsp" />
<body>
<a href="/logout">Logout</a>
	<h3 style="color: red;">Update New Employee</h3>

	<div id="addEmployee">
		<form:form action="/updateEmployee" method="post"
			modelAttribute="emp">
			<p>
				
				<form:hidden path="empId" />
			</p>
			<p>
				<label>Enter Name</label>
				<form:input path="empName" />
			</p>
<!-- 				<p> -->
<!-- 				<label>Vehicles</label> -->
<%-- 				<form:select path="vehicles" items="${vehicles}" itemLabel="vehicleName" itemValue="vehicleId"> --%>
					
<%-- 				</form:select> --%>
<!-- 			</p> -->
			<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>

</body>
</html>
