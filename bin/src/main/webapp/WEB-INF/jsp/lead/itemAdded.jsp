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
	.submit-button{
		background-image:url(/hellospringjersey/images/background-640.png);
			color:#FFFFFF;
			margin-top:30px;
			float:left;
			clear:left;
			width:260px;
			height:50px;
			font-size:32px;
			border-radius:4px;
			border-color:orange;
			border-width: 1px;
		    border-style: solid;
		    margin-left: 20px;
		    text-decoration: none;
		    text-align: center;
		    padding-top: 10px;
		    font-family: helvetica;
	}
	@media screen and (max-width: 480px){
	.submit-button{
			margin-top:15px;
			width:130px;
			height:30px;
			font-size:16px;
		    margin-left: 13px;
		    padding-top: 5px;
		}
	}
</style>
<title>LL - Item Added</title>
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
        
        <div class="page-title">ITEM ADDED</div>
        <div class="main-content">
        	<div class="sub-content">
            	<div class="sub-title">The item has been added to the database!</div>
            	<a class="submit-button" href="/hellospringjersey/do/item/request">Add Another Item</a>
                
            </div>
            
        </div><!--End of Main Content-->
        </div><!--End of Wrapper-->
    </div><!--End of Container-->
</body>
</html>
