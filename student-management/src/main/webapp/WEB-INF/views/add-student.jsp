<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<form:form action="save-student" modelAttribute="student"
			method="POST">
			<form:hidden path="id" />
			<p>
				<label>Name</label>
				<form:input path="name" />

			</p>
			<p>
				<label>Phone</label>
				<form:input path="phone" />
			</p>
			<p>
				<label>Address</label>
				<form:input path="address" />

			</p>
			<input type="submit" value="Add">



		</form:form>
	</div>
</body>
</html>