<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Force Home</title>
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


.content {
  width:100%;
  display: flex;
  justify-content: center;
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
	
	
	<c:if test="${force eq null}">	
	   <%
	    response.sendRedirect("home.jsp");			
	   %>
	</c:if>
	
	
	<c:if test="${message ne null }">
		<h3 class="content"> ${message} </h3>
	</c:if>
	

<div class="container">
         <div class="col-md-9 col-sm-12 col-xs-12">
            <br/><br/>
            <div class="col-sm-12 col-md-12">
			
				<div class="all_details" id="home">
				<h3>Posted Works</h3>
				   <table  class="table table-bordered " >
                     <thead>
                        <tr>
                           <th>Name</th>
                           <th>Email</th>
                           <th>Posted_Date</th>
                           <th>Service Type</th>
						   <th>Description</th>
						   <th>Status</th>
						   <th></th>
                        </tr>
                     </thead>
                     <tbody id="tbl_data">
                     <c:forEach items="${works}" var="work">
                        <tr>
                           <td>${work.postedBy.name}</td>
                           <td>${work.postedBy.emailId}</td>
                           <td>${work.postedDate}</td>
                           <td>${work.service.description}</td>
                           <td>${work.description}</td>	
                           <c:choose>		
                           	<c:when test="${work.status eq true}">		   
						   		<td>Pending</td>
						   	</c:when>
						   	<c:otherwise>
						   		<td>Done</td>
						   	</c:otherwise>
						   </c:choose>
						 
											
						   <td ><button type="button" class="btn btn-primary"
												onclick="apvlForm('Y', '${work.id}')">Update</button></td>
                        </tr>
                        </c:forEach>
                     </tbody>
                  </table>				
				</div>			
               <div class="all_details" id="add_skill" style="display: none;">
                  <h3>Add Skill</h3>
                  <form action="RAMController" method="post" >
                     <div class="form-group">
                        <select class="form-control" name="serviceType"  required="required">
                           <option value="">-- Select Service --</option>
                           <c:forEach items="${services}" var="service">
									<option value="${service.id}">${service.description}</option>
							</c:forEach>
                        </select>
                     </div>
                     
                     <h5>Experience</h5>
                     <div class="input-group">   
                     	
                        <select class="form-control" name="experience1"  required="required"  style="width: 50px !important; min-width: 80px; max-width: 80px;">                          
                          <c:forEach var = "i" begin = "0" end = "10">
                          <option value="${i}">${i}</option>
                          </c:forEach>                         
                        </select> Yrs                   
                     </div>
                     
                     <div class="input-group">                          
                        <select class="form-control" name="experience2"  required="required"  style="width: 50px !important; min-width: 80px; max-width: 80px;">                         
                          <c:forEach var = "j" begin = "0" end = "12">
                          <option value="${j}">${j}</option>
                          </c:forEach>                          
                        </select> Months
                        
                    <!-- <input id="experience" type="number" class="form-control" name="experience" placeholder="Experience"  required="required"  maxlength="3" onkeyup="validatephone(this);"> -->
                       
                     </div>
                     <br/>                    
                     <input type="hidden" value="add_skill" name="action"/>
                     <button type="submit" class="btn btn-primary">Submit</button>
                  </form>
               </div>
			   
               
               <div class="all_details" id="list_service" style="display:none;">
                  <h3>List of Skills</h3>
                  <table  class="table table-bordered " >
                     <thead>
                        <tr>
                           <th>Service Type</th>
                           <th>Experience</th>
                           <th>Approved</th>
                        </tr>
                     </thead>
                     <tbody id="tbl_data">
                     <c:forEach items="${skillsList}" var="skill">
                        <tr>
                           <td>${skill.serviceType.description}</td>
                           <fmt:parseNumber var = "i" integerOnly = "true" type = "number" value = "${skill.experience / 12}" />
                           <td>${i} Yr - ${skill.experience mod 12} Months</td>
                           <c:choose>		
                           	<c:when test="${skill.approved eq true}">		   
						   		<td>Yes</td>
						   	</c:when>
						   	<c:otherwise>
						   		<td>No</td>
						   	</c:otherwise>
						   </c:choose>	
                        </tr>
                       </c:forEach>
                     </tbody>
                  </table>
               </div>
               
               
               <div class="all_details" id="bids" style="display:none;">
                  <h3>Bids done Earlier</h3>
                  <table  class="table table-bordered " >
                     <thead>
                        <tr>                           
                           <th>Service</th>
                           <th>BidPrice</th>
                           <th>BidDate</th>
                           <th>Status</th>
                           <th>Customer</th>                                   
                           <th>Mobile</th>
                        </tr>
                     </thead>
                     <tbody id="tbl_data">
                     <c:forEach  items="${bidsList}"  var="bid">
                        <tr>                           
                           <td>${bid.work.service.description}</td>                                              
                           <td>${bid.bidPrice}</td>
                           <td>${bid.bidDate}</td>    
                           <td>${bid.status}</td>  
                           <td>${bid.work.postedBy.name}</td>
                           <td>${bid.work.postedBy.mobileNumber}</td>                     
                        </tr>
                      </c:forEach>
                     </tbody>
                  </table>
  				</div>             
               
            </div>
         </div>
		 
		   <div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">    
			  <!-- Modal content-->
			  <div class="modal-content">
				<div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal">&times;</button>
				  <h4 class="modal-title">Add Bid</h4>
				</div>
				<div class="modal-body">
				
					<form action="RAMController" method="post">
						<div class="form-group">
							<label>Bid Price</label>
							<input type="text" name="bid_price" class="form-control"  required="required"  maxlength="6" onkeyup="validatephone(this);"/>
						</div>
						<div class="form-group">
							<label>Comments</label>
							<textarea name="comments" class="form-control"></textarea>
						</div>
						<input type="hidden" value="add_bid" name="action"/>
						<input type="hidden" id="work_id" name="workId" />
						<button type="submit" class="btn btn-primary">submit</button>
					</form>
				
				
				</div>
				
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
			function bidThis(index){

				$('#work_id').val(index);
				$('#myModal').modal('show');
			};

			function apvlForm(type, workid){
				console.log('Hellow');

				$.ajax({
					url: 'RAMController',
					type: 'POST',
					data: {'workid':workid, 'action': 'accepting', 'type': type},
					success:function(response){
					    window.location.reload();		
					},
					error:function(){}
					
				});
			};
         </script>
      </div>

</body>
</html>