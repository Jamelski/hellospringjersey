<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
<script>
	$(function() {
		$('button')
				.on(
						'click',
						function() {
							var name = $('#namefield').val();
							$
									.ajax({
										type : "GET",
										dataType : "text",
										url : "http://localhost:9090/hellospringjersey/rest/greeting/report/" + name,
										success : function(data) {
											$('p').text(data);
										}
									});
						});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<p id="report">Report goes here</p>
		<div class="form-group">
			<input class="form-control" type="text" id="namefield" />
			<button class="btn btn-default">Generate Report</button>
		</div>
	</div>
</body>
</html>