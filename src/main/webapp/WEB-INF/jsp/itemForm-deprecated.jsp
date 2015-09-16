<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logical Logistics - Add Item</title>
</head>
<body>
	<div class="container">
		<%-- <sf:form method="POST" modelAttribute="item"
			action="${pageContext.request.contextPath}/do/item/submit">
			<div class="form-group">
				<sf:errors path="name" cssClass="alert alert-danger" />
				<sf:input placeholder="Name" cssClass="form-control" path="name" />
				
				<sf:errors path="description" cssClass="alert alert-danger" />
				<sf:textarea placeHolder="Description" cssClass="form-control" path="description" />
				
				<sf:input type="file" path="photo"/>
				<button class="btn btn-default" type="submit">Add Item</button> 
			
				
				
				<!-- <input placeholder="Name" class="form-control" name="userName" />
				
				
				<textarea placeholder="Description" class="form-control" name="description"></textarea>
				
				<input type="file" name="photo"/>
				<button class="btn btn-default" type="submit">Add Item</button>  -->
			</div>
		</sf:form> --%>
		
		<form method="POST" enctype="multipart/form-data"
			action="${pageContext.request.contextPath}/do/item/submit">
			<div class="form-group">
				
				<input  class="form-control" type="text" name="name" />
				
				
				<input type="text"  class="form-control" name="description"/>
				
				<input type="file" name="file"/>
				<input class="btn btn-default" type="submit"/>
			
				
				
				<!-- <input placeholder="Name" class="form-control" name="userName" />
				
				
				<textarea placeholder="Description" class="form-control" name="description"></textarea>
				
				<input type="file" name="photo"/>
				<button class="btn btn-default" type="submit">Add Item</button>  -->
			</div>
		</form>
	</div>
</body>
</html>