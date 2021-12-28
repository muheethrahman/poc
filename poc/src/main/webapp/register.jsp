<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<script>
fountion validate(){
	var password=document.getElementById("password").value, confirm=document.getElementById("confirm").value;
	if (password == "") {
		alert('Field cant be empty');
		return false;
	} else if (password != confirmPassword) {
		alert('Password didnt match ..try again');
		return false;

	} else if (password == confirmPassword) {

		return true;
	}
}
</script>
</head>
<body>
<h1> register the details</h1>
<h3>${msg}</h3>
<form action="register.do">
<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Create Account</h4>
	<p class="text-center">Get started with your free account</p>
	<p>
		
	</p>
	<p class="divider-text">
        
    </p>
	<form>
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="username" class="form-control" placeholder="Enter EmailID " type="text">
    </div> <!-- form-group// -->
    <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
		</div>
		
    	<input name="phone" class="form-control" placeholder="Phone number" type="text">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
		</div>
		<input name="city" class="form-control" placeholder="City" type="text">
	</div> 
	<div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
		</div>
		<input name="state" class="form-control" placeholder="State" type="text">
	</div>
	<div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
		</div>
		<input name="country" class="form-control" placeholder="Country" type="text">
	</div>
	<div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
		</div>
		<input name="pincode" class="form-control" placeholder="Pin_code" type="text">
	</div>
	
	<!-- form-group end.// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input class="form-control" placeholder="Create password" type="password">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input class="form-control" placeholder="Repeat password" type="password">
    </div> <!-- form-group// -->                                      
    <div class="form-group">
       <input type="submit"  value="submit" class="btn float-right login_btn btn btn-secondary">
    </div> <!-- form-group// -->      
    <p class="text-center">Have an account? <a href="clickregister.do">Log In</a> </p>                                                                 
</form>
</article>
</div> <!-- card.// -->

</div> 
<!--container end.//-->

<br><br>
<article class="bg-secondary mb-3">  
<div class="card-body text-center">
    <h3 class="text-white mt-3">Xworkz POC</h3>
<p class="h5 text-white">Im Creating Application using spring mvc hibernate Mysql JSp </p>   <br>
<p><a class="btn btn-warning" target="_blank" href="http://bootstrap-ecommerce.com/"> Xworkzodc.com  
 <i class="fa fa-window-restore "></i></a></p>
</div>
<br><br>
</article>




<!--<label>Username</label><input type="text" name="username">
<label>password</label><input type="password" name="password" id="password">
<label> Confirm-password</label><input type="password" name="confirm" id="confirm">
 <input type="submit"  value="contiune" class="btn float-right login_btn btn btn-secondary" onclick="validate()">
<label>Country-Name</label><input type="text" name="country">
<label>State-Name</label><input type="text" name="state">
<label>City-NAme</label><input type="text" name="city">
<label>Pin-Code</label><input type="text" name="pincode">-->


</form>
</body>
</html>