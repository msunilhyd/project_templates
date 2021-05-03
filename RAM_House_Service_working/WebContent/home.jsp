<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
	body{
		font-family: 'Varela Round', sans-serif;
	}
	.form-control {
		box-shadow: none;		
		font-weight: normal;
		font-size: 13px;
	}
	.form-control:focus {
		border-color: #33cabb;
		box-shadow: 0 0 8px rgba(0,0,0,0.1);
	}
	.navbar-header.col {
		padding: 0 !important;
	}	
	.navbar {
		background: #bd4646;
		padding-left: 16px;
		padding-right: 16px;
		border-bottom: 1px solid #dfe3e8;
		border-radius: 0;
	}
	.nav-link img {
		color : #fff199;
		border-radius: 50%;
		width: 36px;
		height: 36px;
		margin: -8px 0;
		float: left;
		margin-right: 10px;
	}
	.navbar .navbar-brand, .navbar .navbar-brand:hover, .navbar .navbar-brand:focus {
		padding-left: 0;
		font-size: 40px;
		padding-right: 50px;
		color: #deef21;
	}
	.navbar .navbar-brand b {
		font-weight: bold;
		color: #fff199;		
	}
	.navbar .form-inline {
        display: inline-block;
    }
	.navbar .nav li {
		position: relative;
	}
	.navbar .nav li a {
		color: #fff199;
	}
	.navbar .nav .btn-primary, .navbar .nav .btn-primary:active {
		color: #fff199;
		background: #bd4646;
		padding-top: 8px;
		padding-bottom: 6px;
		vertical-align: middle;
		border: none;
	}	
	.navbar .nav .btn-primary:hover, .navbar .nav .btn-primary:focus {		
		color: #fff199;
		outline: none;
		background: #f44242;
	}
	.navbar .navbar-right li:first-child a {
		padding-right: 30px;
	}
	.navbar .nav-item i {
		font-size: 18px;
	}
	.navbar .dropdown-item i {
		font-size: 16px;
		min-width: 22px;		
	}
	.navbar ul.nav li.active a, .navbar ul.nav li.open > a {
		background: transparent !important;
	}	
	.navbar .nav .get-started-btn {
		min-width: 120px;
		margin-top: 8px;
		margin-bottom: 8px;
	}
	.navbar ul.nav li.open > a.get-started-btn {
		color: #fff199;
		background: #f44242 !important;
	}
	.navbar .dropdown-menu {
		border-radius: 1px;
		border-color: #e5e5e5;
		box-shadow: 0 2px 8px rgba(0,0,0,.05);
	}
	.navbar .nav .dropdown-menu li {
		color: #999;
		font-weight: normal;
	}
	.navbar .nav .dropdown-menu li a, .navbar .nav .dropdown-menu li a:hover, .navbar .nav .dropdown-menu li a:focus {
		padding: 8px 20px;
		line-height: normal;
	}
	.navbar .navbar-form {
		border: none;
	}
	.navbar .dropdown-menu.form-wrapper {
		width: 280px;
		padding: 20px;
		left: auto;
		right: 0;
        font-size: 14px;
	}
	.navbar .dropdown-menu.form-wrapper a {		
		color: #33cabb;
		padding: 0 !important;
	}
	.navbar .dropdown-menu.form-wrapper a:hover{
		text-decoration: underline;
	}
	.navbar .form-wrapper .hint-text {
		text-align: center;
		margin-bottom: 15px;
		font-size: 13px;
	}
	.navbar .form-wrapper .social-btn .btn, .navbar .form-wrapper .social-btn .btn:hover {
		color: #fff;
        margin: 0;
		padding: 0 !important;
		font-size: 13px;
		border: none;
		transition: all 0.4s;
		text-align: center;
		line-height: 34px;
		width: 47%;
		text-decoration: none;
    }	
	.navbar .social-btn .btn-primary {
		background: #507cc0;
	}
	.navbar .social-btn .btn-primary:hover {
		background: #4676bd;
	}
	.navbar .social-btn .btn-info {
		background: #64ccf1;
	}
	.navbar .social-btn .btn-info:hover {
		background: #4ec7ef;
	}
	.navbar .social-btn .btn i {
		margin-right: 5px;
		font-size: 16px;
		position: relative;
		top: 2px;
	}
	.navbar .form-wrapper .form-footer {
		text-align: center;
		padding-top: 10px;
		font-size: 13px;
	}
	.navbar .form-wrapper .form-footer a:hover{
		text-decoration: underline;
	}
	.navbar .form-wrapper .checkbox-inline input {
		margin-top: 3px;
	}
	.or-seperator {
        margin-top: 32px;
		text-align: center;
		border-top: 1px solid #e0e0e0;
    }
    .or-seperator b {
		color: #666;
        padding: 0 8px;
		width: 30px;
		height: 30px;
		font-size: 13px;
		text-align: center;
		line-height: 26px;
		background: #fff;
		display: inline-block;
		border: 1px solid #e0e0e0;
		border-radius: 50%;
		position: relative;
		top: -15px;
		z-index: 1;
    }
    .navbar .checkbox-inline {
		font-size: 13px;
	}
	.navbar .navbar-right .dropdown-toggle::after {
		display: none;
	}
	@media (min-width: 1200px){
		.form-inline .input-group {
			width: 300px;
			margin-left: 30px;
		}
	}
	@media (max-width: 768px){
		.navbar .dropdown-menu.form-wrapper {
			width: 100%;
			padding: 10px 15px;
			background: transparent;
			border: none;
		}
		.navbar .form-inline {
			display: block;
		}
		.navbar .input-group {
			width: 100%;
		}
		.navbar .nav .btn-primary, .navbar .nav .btn-primary:active {
			display: block;
		}
	}
	
	
	
	h2 {
	color: #000;
	font-size: 26px;
	font-weight: 300;
	text-align: center;
	text-transform: uppercase;
	position: relative;
	margin: 30px 0 80px;
}
h2 b {
	color: #ffc000;
}
h2::after {
	content: "";
	width: 100px;
	position: absolute;
	margin: 0 auto;
	height: 4px;
	background: rgba(0, 0, 0, 0.2);
	left: 0;
	right: 0;
	bottom: -20px;
}
.carousel {
	margin: 50px auto;
	padding: 0 70px;
}
.carousel .item {
	min-height: 330px;
    text-align: center;
	overflow: hidden;
}
.carousel .item .img-box {
	height: 100px;
	width: 100%;
	position: relative;
}
.carousel .item img {	
	max-width: 130%;
	max-height: 130%;
	display: inline-block;
	position: absolute;
	bottom: 0;
	margin: 0 auto;
	left: 0;
	right: 0;
}
.carousel .item h4 {
	font-size: 18px;
	margin: 8px 0;
}
.carousel .item .btn {
	color: #333;
    border-radius: 0;
    font-size: 11px;
    text-transform: uppercase;
    font-weight: bold;
    background: none;
    border: 1px solid #ccc;
    padding: 5px 10px;
    margin-top: 5px;
    line-height: 16px;
}
.carousel .item .btn:hover, .carousel .item .btn:focus {
	color: #fff;
	background: #000;
	border-color: #000;
	box-shadow: none;
}
.carousel .item .btn i {
	font-size: 14px;
    font-weight: bold;
    margin-left: 5px;
}
.carousel .thumb-wrapper {
	text-align: center;
}
.carousel .thumb-content {
	padding: 15px;
}
.carousel .carousel-control {
	height: 50px;
    width: 40px;
    background: none;
    margin: auto 0;
    background: rgba(0, 0, 0, 0.2);
}
.carousel .carousel-control i {
    font-size: 30px;
    position: absolute;
    top: 50%;
    display: inline-block;
    margin: -16px 0 0 0;
    z-index: 5;
    left: 0;
    right: 0;
    color: rgba(0, 0, 0, 0.8);
    text-shadow: none;
    font-weight: bold;
}
.carousel .item-price {
	font-size: 13px;
	padding: 2px 0;
}
.carousel .item-price strike {
	color: #999;
	margin-right: 5px;
}
.carousel .item-price span {
	color: #86bd57;
	font-size: 110%;
}
.carousel .carousel-control.left i {
	margin-left: -3px;
}
.carousel .carousel-control.left i {
	margin-right: -3px;
}
.carousel .carousel-indicators {
	bottom: 100px;
}
.carousel-indicators li, .carousel-indicators li.active {
	width: 10px;
	height: 10px;
	margin: 2px;
	border-radius: 50%;
	border-color: transparent;
}
.carousel-indicators li {	
	background: rgba(0, 0, 0, 0.2);
}
.carousel-indicators li.active {	
	background: rgba(0, 0, 0, 0.6);
}

</style>

<script type="text/javascript">
	// Prevent dropdown menu from closing when click inside the form
	$(document).on("click", ".navbar-right .dropdown-menu", function(e){
		e.stopPropagation();
	});	
		

$(document).ready(function (e) {

  var maxsize = 500 * 1024; // 500 KB

  $('#max-size').html((maxsize/1024).toFixed(2));

 

  $('#file').change(function() {

    $('#message').empty();

    var file = this.files[0];
    var match = ["image/jpeg", "image/png", "image/jpg"];

    if ( !( (file.type == match[0]) || (file.type == match[1]) || (file.type == match[2]) ) )
    {
      

      $('#message').html('<div class="alert alert-warning" role="alert">Invalid image format. Allowed formats: JPG, JPEG, PNG.</div>');

	  $("#file").val(null);
      return false;
    }

    if ( file.size > maxsize )
    {
     

      $('#message').html('<div class=\"alert alert-danger\" role=\"alert\">The size of image you are attempting to upload is ' + (file.size/ 1024).toFixed(2) + ' KB maximum size allowed is ' + (maxsize/1024).toFixed(2) + ' KB</div>');

      return false;
    }

    

  });

});




	
	
	function validatephone(phone) 
	{
    var maintainplus = '';
    var numval = phone.value	
    if ( numval.charAt(0)=='+' )
    {
        var maintainplus = '';
    }
    curphonevar = numval.replace(/[\\A-Za-z!"Â£$%^&\,*+_={};:'@#~,.Å \/<>?|`Â¬\]\[]/g,'');
    phone.value = maintainplus + curphonevar;
    var maintainplus = '';	
	}	
	
</script>
</head> 

<body>
<nav class="navbar navbar-default navbar-expand-lg navbar-light">
	<div class="navbar-header d-flex col">
		<a class="navbar-brand" href="#">House<b>Services</b></a>  		
		<button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle navbar-toggler ml-auto">
			<span class="navbar-toggler-icon"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
	</div>
	<!-- Collection of nav links, forms, and other content for toggling -->
	<div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
		
		<ul class="nav navbar-nav navbar-right ml-auto">			
			<li class="nav-item">
				<a data-toggle="dropdown" class="nav-link dropdown-toggle" href="#">Login</a>
				<ul class="dropdown-menu form-wrapper">					
					<li>
						<form action="Login As User" method="post">
							<p class=class="btn btn-primary pull-left">Login</p>
							<div class="form-group">
								<input type="email" class="form-control" placeholder="Email" name="loginEmail" id="email" required="required" onchange="email_validate(this.value);">
								<div class="status" id="status0"></div>
							</div>
							<div class="form-group">
								<input type="password" class="form-control" name="loginPassword" placeholder="Password" id="pwd" required="required">
							</div>
							<input type="submit" name="action" class="btn btn-primary btn-block" value="Login As User">
							<div class="or-seperator"><b>or</b></div>
							<input type="submit" name="action" class="btn btn-primary btn-block" value="Login As Force">
							
						</form>
					</li>
				</ul>
			</li>
			<li class="nav-item">
				<a href="#" data-toggle="dropdown" class="btn btn-primary dropdown-toggle get-started-btn mt-1 mb-1">Sign up as User</a>				
				<ul class="dropdown-menu form-wrapper">					
					<li>
						<form action="signUpUser" method="post">
							<p class="hint-text">Create your account!</p>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Username" name="uname" id="uname" required="required">
							</div>
							<div class="form-group">
								<input type="email" class="form-control" placeholder="Email" name="uemail" id="uemail"  required="required">
								<div class="status" id="status1"></div>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Mobile Number" name="phone" pattern="[1-9]{1}[0-9]{9}" id="phone"  required="required" maxlength="10" onkeyup="validatephone(this);">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" placeholder="Password" name="upwd" id="upwd"  required="required">
							</div>
							<input type="hidden" name="action" value="signUpUser" />
							<input type="submit" class="btn btn-primary btn-block" value="Sign up">
						</form>
					</li>
				</ul>
			</li>			
			<li class="nav-item">
				<a href="#" data-toggle="dropdown" class="btn btn-primary dropdown-toggle get-started-btn mt-1 mb-1">Sign up As Force</a>				
				<ul class="dropdown-menu form-wrapper">					
					<li>
						<form action="signUpForce" method="post"  enctype="multipart/form-data" >
							<p class="hint-text">Register as Skilled Person!</p>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Username" name="fname" id="fname" required="required">
							</div>
							<div class="form-group">
								<input type="email" class="form-control" placeholder="Email" id="femail" name="femail" required="required">
								<div class="status" id="status2"></div>
							</div>
							<div class="form-group">
								<input type="phone" class="form-control" placeholder="Mobile Number" name="fphone" id="fphone" required="required" pattern="[1-9]{1}[0-9]{9}" maxlength="10" onkeyup="validatephone(this);">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" placeholder="Password" name="fpwd" id="fpwd" required="required">
							</div>							
							<div id="message"></div>
							<input type="hidden" name="action" value="signUpForce" />
							<input type="submit" name="formType" class="btn btn-primary btn-block" value="Sign up">
						</form>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</nav>


<c:if test="${message ne null }">
	<h3> ${message} </h3>
</c:if>
 
 <center>
 
 <h1> Welcome to RAM House Services</h1>
<h2> By Rahul and Manohar</h2>

 </center>
</body>

</html>
