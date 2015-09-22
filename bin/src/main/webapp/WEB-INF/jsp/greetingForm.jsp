<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<sf:form method="POST" modelAttribute="greeting"
			action="${pageContext.request.contextPath}/do/greeting/submit">
			<div class="form-group">
				<label>Name:</label>
				<sf:errors path="name" cssClass="alert alert-danger" />
				<sf:input cssClass="form-control" path="name" />
				<label>Greeting:</label>
				<sf:errors path="greeting" cssClass="alert alert-danger" />
				<sf:input cssClass="form-control" path="greeting" />
				<input class="btn btn-default" type="submit" />
			</div>
		</sf:form>
	</div>
</body>
</html>