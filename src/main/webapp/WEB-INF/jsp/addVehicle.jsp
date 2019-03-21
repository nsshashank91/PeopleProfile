<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="menu.jsp" />
<body>
<a href="/logout">Logout</a>
	<h3 style="color: red;">Add New Vehicle</h3>

	<div id="addvehicle">
		<form:form action="/addVehicle" method="post"
			modelAttribute="veh">
			<%-- <p>
				<label>Vehicle Id</label>
				<form:input path="vehicleId" />
			</p> --%>
			<p>
				<label>Vehicle Name</label>
				<form:input path="vehicleName" />
			</p>
			
			<p>
				<label>Employee</label>
				<form:select path="employee" items="${employees}" itemLabel="empName" itemValue="empId">
					
				</form:select>
			</p>
			<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>

</body>
</html>