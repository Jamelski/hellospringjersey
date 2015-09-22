<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/hellospringjersey/css/mystyles.css">
<link type="text/css" rel="stylesheet" href="/hellospringjersey/dist/css/jquery.mmenu.all.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
		<script type="text/javascript" src="/hellospringjersey/dist/js/jquery.mmenu.min.all.js"></script>
<script type="text/javascript">
   $(document).ready(function() {
      $("#my-menu").mmenu();
   });
</script>
<style>
	.form-group{
		margin-left:30px;
	}
	.form-control{
		margin-top:30px;
		width:350px;
		height:55px;
		font-size:28px;
		padding-left:15px;
	}
	
	.sub-content{
		height:auto;
		padding-bottom:30px;
	}
	
	.submit-button{
		background-image:url(/hellospringjersey/images/background-640.png);
		color:#FFFFFF;
		margin-top:30px;
		float:left;
		clear:left;
		width:260px;
		height:80px;
		font-size:32px;
		border-radius:4px;
		border-color:orange;
	}
	
	#select-employee{
		width:369px;
	}
	@media screen and (max-width: 480px){
	
		.form-group{
			margin-left:0;
		}
		.my-form{
			margin-left:13px;
		}
		
		.form-control{
			margin-top:15px;
			width:225px;
			height:30px;
			font-size:14px;
			padding-left:15px;
		}
		
		.form-control-text-area{
			margin-top:30px;
			width:225px;
			height:115px;
			font-size:14px;
			padding-left:15px;
			font-family:helvetica, arial, sans-serif;
			padding-top:7px;
		}
		
		.choose-file-button{
			margin-top:30px;
			float:left;
			clear:left;
			width:101px;
			height:30px;
			font-size:16px;
			border-radius:4px;
			border-color:orange;
		}
		
		.submit-button{
			background-image:url(/hellospringjersey/images/background-640.png);
			color:#FFFFFF;
			margin-top:15px;
			float:left;
			clear:left;
			width:130px;
			height:50px;
			font-size:16px;
			border-radius:4px;
			border-color:orange;
		}
		
		#select-employee{
		width:244px;
	}
	}
</style>
<title>LL - Add Employee</title>
</head>

<body>
	<div id="container">
    	<div id="wrapper">
    	<div class="transparent">
        </div><!--End of Transparent-->
        <div class="wrap-logo"><div class="logo"></div></div>
        <div class="wrap-icon"><a href="#my-menu"><div class="menu-icon"></div></a></div>
        
        <nav id="my-menu">
            <ul>
            	<li><a href="#">Employee</a>
            		<ul>
            			<li><a href="#">View Employees</a></li>
            			<li><a href="#">Add Employee</a></li>
            		</ul>
               <li><a href="/hellospringjersey/do/item/viewItems">Item</a>
               		<ul>
               			<li><a href="/hellospringjersey/do/item/viewItems">View Items</a></li>
               			<li><a href="/hellospringjersey/do/item/request">Add Item</a></li>
               		</ul>
               </li>
               <li><a href="/hellospringjersey/do/logisticslead/viewWarehouses">Warehouse</a>
               		<ul>
               			<li><a href="/hellospringjersey/do/logisticslead/viewWarehouses">View Warehouses</a></li>
               			<li><a href="/hellospringjersey/do/logisticslead/request">Add Warehouse</a></li>
               		</ul>
               </li>
            </ul>
        </nav>
        
        <div class="page-title">ADD EMPLOYEE</div>
        <div class="main-content">
        	<div class="sub-content">
            	<form class="my-form" method="POST"
				action="${pageContext.request.contextPath}/do/employee/submit">
					<div class="form-group">
						
						<input  placeholder="First Name" class="form-control" type="text" name="firstname"/>
						<input  placeholder="Last Name" class="form-control" type="text" name="lastname"/>
						<input  placeholder="Email" class="form-control" type="email" name="email"/>
						<input  placeholder="Password" class="form-control" type="password" name="password"/>
						<input  placeholder="Confirm Password" class="form-control" type="password" name="confirmPassword"/>
						<select class="form-control" id="select-employee" name="role">
							<option>Select Role...</option>
							<option value="lead">Logistics Lead</option>
							<option value="warehouseManager">Warehouse Manager</option>
							<option value="outletManager">Outlet Manager</option>
						</select>
						<button class="submit-button" type="submit">+ Add Employee</button>
					</div>
				</form>
                
            </div>
            
        </div><!--End of Main Content-->
        </div><!--End of Wrapper-->
    </div><!--End of Container-->
</body>
</html>