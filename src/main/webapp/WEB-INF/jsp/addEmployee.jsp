<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<jsp:include page="menu.jsp" />
<body>
<a href="/logout">Logout</a>
	<h3 style="color: red;">Add New Employee</h3>

	<div id="addEmployee">
		<form:form action="/addNewEmployee" method="post"
			modelAttribute="emp">
		<%-- 	<p>
				<label>Enter Employee Id</label>
				<form:input path="empId" />
			</p> --%>
			<p>
				<label>Enter Name</label>
				<form:input path="empName" />
				<form:errors path="empName" cssClass="error"></form:errors>
			</p>
			<p>
				<label>Enter Phone</label>
				<form:input path="phone" />
				<form:errors path="phone" cssClass="error"></form:errors>
				
			</p>
			
			
<%-- 				<p>
				<label>Vehicles</label>
				<form:select path="vehicles" items="${vehicles}" itemLabel="vehicleName" itemValue="vehicleId">
					
				</form:select>
			</p> --%>
			
			<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>

</body>
</html>
