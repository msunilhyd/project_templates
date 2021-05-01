<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Varela+Round"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
body {
	font-family: 'Varela Round', sans-serif;
}

.form-control {
	box-shadow: none;
	font-weight: normal;
	font-size: 13px;
}

.form-control:focus {
	border-color: #33cabb;
	box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
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
	color: #fff199;
	border-radius: 50%;
	width: 36px;
	height: 36px;
	margin: -8px 0;
	float: left;
	margin-right: 10px;
}

.navbar .navbar-brand, .navbar .navbar-brand:hover, .navbar .navbar-brand:focus
	{
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

.search-box {
	position: relative;
}

.search-box input {
	padding-right: 35px;
	border-color: #dfe3e8;
	border-radius: 4px !important;
	box-shadow: none
}

.search-box .input-group-addon {
	min-width: 35px;
	border: none;
	background: transparent;
	position: absolute;
	right: 0;
	z-index: 9;
	padding: 7px;
	height: 100%;
}

.search-box i {
	color: #a0a5b1;
	font-size: 19px;
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

.navbar ul.nav li.active a, .navbar ul.nav li.open>a {
	background: transparent !important;
}

.navbar .nav .get-started-btn {
	min-width: 120px;
	margin-top: 8px;
	margin-bottom: 8px;
}

.navbar ul.nav li.open>a.get-started-btn {
	color: #fff199;
	background: #f44242 !important;
}

.navbar .dropdown-menu {
	border-radius: 1px;
	border-color: #e5e5e5;
	box-shadow: 0 2px 8px rgba(0, 0, 0, .05);
}

.navbar .nav .dropdown-menu li {
	color: #999;
	font-weight: normal;
}

.navbar .nav .dropdown-menu li a, .navbar .nav .dropdown-menu li a:hover,
	.navbar .nav .dropdown-menu li a:focus {
	padding: 8px 20px;
	line-height: normal;
	color: #9B1905;
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

.navbar .dropdown-menu.form-wrapper a:hover {
	text-decoration: underline;
}

.navbar .form-wrapper .hint-text {
	text-align: center;
	margin-bottom: 15px;
	font-size: 13px;
}

.navbar .form-wrapper .social-btn .btn, .navbar .form-wrapper .social-btn .btn:hover
	{
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

.navbar .form-wrapper .form-footer a:hover {
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

@media ( min-width : 1200px) {
	.form-inline .input-group {
		width: 300px;
		margin-left: 30px;
	}
}

@media ( max-width : 768px) {
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

.dropdown-menu li, .cust-hand {
	cursor: pointer;
}

.modal-content {
	border-radius: 0px;
}

.cust-smll-btn {
	padding: 0px 10px;
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
curphonevar = numval.replace(/[\\A-Za-z!"£$%^&\,*+_={};:'@#~,.Š\/<>?|`¬\]\[]/g,'');
phone.value = maintainplus + curphonevar;
var maintainplus = '';	
}

</script>

</head>

<body>
	<nav class="navbar navbar-default navbar-expand-lg navbar-light">
		<div class="navbar-header d-flex col">
			<a class="navbar-brand" href="#">House<b>Joy</b></a>
			<button type="button" data-target="#navbarCollapse"
				data-toggle="collapse" class="navbar-toggle navbar-toggler ml-auto">
				<span class="navbar-toggler-icon"></span> <span class="icon-bar"></span>
				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
		</div>
		<!-- Collection of nav links, forms, and other content for toggling -->
		<div id="navbarCollapse"
			class="collapse navbar-collapse justify-content-start">
			<ul class="nav navbar-nav">
				<li class="nav-item"><a href="RAMController?action=logout"
					class="nav-link">LogOut</a></li>
			</ul>
		</div>
	</nav>
	
	
	<c:if test="${message ne null }">
		<h3> ${message} </h3>
	</c:if>
	
	
	<c:if test="${admin eq null}">	
	   <%
	    response.sendRedirect("home.jsp");			
	   %>
	</c:if>
	
	
	
	
	<div class="container">
		<div class="col-md-9 col-sm-12 col-xs-12">
			<h2>
				Reliable <b>Services</b>
			</h2>
			<br />
			<br />
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<ul class="nav navbar-nav">
						<li><a onclick="doAction('home')" class="cust-hand">Home</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a onclick="doAction('add_category')">Add a Category</a></li>
								<li><a onclick="doAction('list_categories')">Available Categories</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">SubCategory <span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a onclick="doAction('add_subcategory')">Add a SubCategory</a></li>
								<li><a onclick="doAction('list_subcategories')">Available SubCategories</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">ServiceType <span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a onclick="doAction('add_servicetype')">Add ServiceType</a></li>
								<li><a onclick="doAction('list_servicetypes')">Available ServiceTypes</a></li>
							</ul></li>
						<!-- <li><a href="#">Page 2</a></li> -->
					</ul>
				</div>
			</nav>
			<div class="col-sm-12 col-md-12">

				<div class="all_details" id="home">
					<h3>Pending Approvals</h3>
					<table id="add_form_tbl" class="table table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>ServiceType</th>
								<th>Experience</th>
								<th>Approved</th>
							</tr>
						</thead>
						<tbody id="tbl_data">

							<c:forEach items="${unapprovedskills}" var="skill">
								<tr id="${skill.user.id}${skill.serviceType.id}">
									<td>${skill.user.id}</td>
									<td>${skill.user.name}</td>
									<td>${skill.serviceType.description}</td>
									<fmt:parseNumber var = "i" integerOnly = "true" type = "number" value = "${skill.experience / 12}" />
									<td>${i} Yr - ${skill.experience mod 12} Months</td>
									<td>${skill.approved}</td>

									<td>
										<div class="btn-group">
											<button type="button" class="btn btn-primary"
												onclick="apvlForm('Y', '${skill.user.id}', '${skill.serviceType.id}')">Yes</button>
											<button type="button" class="btn btn-danger"
												onclick="apvlForm('N', '${skill.user.id}','${skill.serviceType.id}')">No</button>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div class="all_details" id="add_servicetype" style="display: none;">
					<h3>Add ServiceType</h3>
					<form action="RAMController" method="post">
						<div id="sub_list" class="form-group">						
							<select class="form-control" name="subCategoryList" id="subCategoryList"  required="required">
								<option value="">-- Select SubCategory --</option>
								<c:forEach items="${subcategories}" var="subcategory">
									<option value="${subcategory.id}">${subcategory.type}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<input type="text" name="serviceTypeName" class="form-control"
								placeholder="Enter ServiceType"  required="required" />
						</div>
						<div class="form-group">
							<input type="text" name="approxPrice" class="form-control"  
								placeholder="Enter Approximate Price"  required="required"  maxlength="3" onkeyup="validatephone(this);" />
						</div>
						<br />						
						<input type="hidden" value="add_servicetype" name="action" />
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>

				<div class="all_details" id="add_category" style="display: none;">
					<h3>Add Category</h3>
					<form action="RAMController" method="post"  enctype="multipart/form-data">
						<div class="form-group">
							<input type="text" name="categoryName" class="form-control required"
								placeholder="Enter Category" />
						</div>
						<div class="form-group">
							<input type="file" name="file" class="form-control"  required>
						</div>

						<input type="hidden" value="add_category" name="action" />
						<button type="submit" class="btn btn-primary">Add</button>
					</form>
				</div>

				<div class="all_details" id="add_subcategory" style="display: none;">
					<h3>Add SubCategory</h3>
					<form action="RAMController" method="post"  enctype="multipart/form-data">
						<div class="form-group">
							<select class="form-control" name="category"  required>
								<option value="">-- Select Category --</option>
								<c:forEach items="${categories}" var="category">
								<option value="${category.id}">${category.type}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<input type="text" name="subCategoryName" class="form-control" placeholder="Enter SubCategory" />
						</div>
						<div class="form-group">
							<input type="file" name="file" class="form-control">
						</div>

						<input type="hidden" value="add_subcategory" name="action" />
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>

				<div class="all_details" id="list_categories" style="display: none;">
					<h3>List of Categories</h3>
					<table class="table table-bordered ">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>								
							</tr>
						</thead>
						<tbody id="tbl_data">
							<c:forEach items="${categories}" var="category">
								<tr id="${category.id}">
									<td>${category.id}</td>
									<td>${category.type}</td>																	
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				
				<div class="all_details" id="list_subcategories" style="display: none;">
					<h3>List of SubCategories</h3>
					<table class="table table-bordered ">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>CategoryId</th>								
							</tr>
						</thead>
						<tbody id="tbl_data">						
							<c:forEach items="${subcategories}" var="subcategory">
							<tr>
								<td>${subcategory.id}</td>
								<td>${subcategory.type}</td>
								<td>${subcategory.category.type}</td>								
							</tr>
							</c:forEach>							
						</tbody>
					</table>
				</div>

				<div class="all_details" id="list_servicetypes"
					style="display: none;">
					<h3>List of ServiceTypes</h3>
					<table class="table table-bordered ">
						<thead>
							<tr>
								<th>Id</th>
								<th>Description</th>
								<th>Approx Price</th>								
							</tr>
						</thead>
						<tbody id="tbl_data">
						  <c:forEach items="${services}" var="service">
							<tr id="${service.id}">
								<td>${service.id}</td>
								<td>${service.description}</td>
								<td>${service.approxPrice}</td>									
							</tr>
							</c:forEach>							
						</tbody>
					</table>
				</div>
			</div>
		</div>		

		
		<div class="col-md-3">

			<!-- Add stuff -->


		</div>
		
		
		
		<script>
		
		
            function doAction(type){
            	$('.all_details').hide();	
            	$('#'+type).show();
            };				
			
			function apvlForm(type, userid, ser_id){
				$.ajax({
					url: 'RAMController',
					type: 'POST',
					data: {'serviceid':ser_id, 'userid':userid, 'action': 'accepting', 'type': type},
					success:function(response){
						if('Y'== type)
							$('#'+userid+ser_id).remove();						
					},
					error:function(){}
					
				});
			};
         </script>
	</div>
</body>
</html>