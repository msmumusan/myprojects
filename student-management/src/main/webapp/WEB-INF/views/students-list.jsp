<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">Selenium Express</h1>

	<div align="center">
		<form action="addStudent">
			<input type="submit" value="Add Student">
		</form>
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Phone</th>
				<th>Address</th>
			</tr>

			<c:forEach var="student" items="${students}">
				<tr>
					<th>${student.id}</th>
					<th>${student.name}</th>
					<th>${student.phone}</th>
					<th>${student.address}</th>
					<th><a
						href="/student-management/updateStudent?userId=${student.id}">Update</a></th>
					<th><a
						href="/student-management/deleteStudent?userId=${student.id}"
						onclick="if(!(confirm(' Are you sure want to delete thisstudent'))) return false">Delete</a>
					</th>
					<br />
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>