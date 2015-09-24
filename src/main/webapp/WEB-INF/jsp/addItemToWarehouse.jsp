<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
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
	.sub-content{
		overflow:hidden;
	}
	.offset{
		width:550px;
		height:315px;
	}
	
	.sub-content{
		height:420px;
	}
	.item-description{
		width:190px;
		height: 280px;
    	padding-top: 30px;
		margin-left:50px;
		padding-right:24px;
		float:left;
		border-right: 1px;
	    border-width: 1px;
	    border-style: solid;
	    border-left: 0;
	    border-top: 0;
	    border-bottom: 0;
		
	}
	
	.item-image{
		width:175px;
		float:left;
		margin-left:55px;
		margin-right:55px;
	}
	
	@media screen and (max-width: 480px){
		.offset{
			width:250px;
			height:150px;
		}
		.item-description{
			width:95px;
			height: 130px;
	    	padding-top: 15px;
			margin-left:21px;
			padding-right:12px;
			float:left;
			border-right: 1px;
		    border-width: 1px;
		    border-style: solid;
		    border-left: 0;
		    border-top: 0;
		    border-bottom: 0;
			
		}
		
		.item-image{
			width:80px;
			float:left;
			margin-left:28px;
			margin-right:0;
		}
	}
</style>
<title>LL - Items</title>
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
               <li><a href="/hellospringjersey/do/user/item/viewItems">Item</a>
               		<ul>
               			<li><a href="/hellospringjersey/do/user/item/viewItems">View Items</a></li>
               			<li><a href="/hellospringjersey/do/user/item/request">Add Item</a></li>
               		</ul>
               </li>
               <li><a href="/hellospringjersey/do/user/logisticslead/viewWarehouses">Warehouse</a>
               		<ul>
               			<li><a href="/hellospringjersey/do/user/logisticslead/viewWarehouses">View Warehouses</a></li>
               			<li><a href="/hellospringjersey/do/user/logisticslead/request">Add Warehouse</a></li>
               		</ul>
               </li>
            </ul>
        </nav>
        
        <div class="page-title">ITEMS</div>
        <div class="main-content">
        	
        	<c:forEach items="${myItems}" var="item">
	        	<div class="sub-content">
	            	<div class="sub-title"><p>${item.getName()}</p></div>
	            		<div class="offset">
	            			
							<p class="item-description">${item.getDescription()}</p>
							<img class="item-image" width="500" src="data:image/jpeg;base64, ${item.getBase()}"/>
							<form action="addItem" method="post">
								<input type="hidden" name="itemId" value="${item.getId()}"/>
								<div>Quantity: <input class="quantity" type="number" name="quantity"/></div>
								<div>Capacity: <input class="capacity" type="number" name="capacity"/></div>
								<div><button type="submit">Add Item</button></div>
							</form>
						</div>
				</div>
			</c:forEach>

        </div><!--End of Main Content-->
        </div><!--End of Wrapper-->
    </div><!--End of Container-->
</body>
</html>