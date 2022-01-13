<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<script>
function validate() {
	var f = document.getElementById("form");
	validateUsername(f);
	validatePassword(f);
	document.username.action = "${pageContext.request.contextPath}/startotp.do";
    document.username.submit();
}
function validatePassword(form) {

	var password = form["password"].value;
	

	if (password == null || password == "") {
		 document.getElementById("password_p").innerHTML="*this flied is empty";
	}

}
function validateUsername(form){
var name = form["username"].value;
	

	if (name == null || name == "") {
		 document.getElementById("userP").innerHTML="*this flied is empty";
	}

	
}
function buttons(){
	 document.getElementById("myBtn").disabled = true;
}
</script>
</head>
<body >

<form action="login.do" id="form" method="post">
<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Login Account</h4>
	<p class="text-center">Get started with your free account</p>
	<p>
		
	</p>
	<p class="divider-text">
        
    </p>

	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="username" class="form-control" placeholder="Enter EmailID" type="text" id="username">
        <span id="userP" style="color:red;"></span>
    </div> <!-- form-group// -->
   
	
	<!-- form-group end.// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input class="form-control" placeholder="enter password" type="password" name="password" id="password">
         <span id="password_p" style="color:red;"></span>
    </div> <!-- form-group// -->
    
                                       
    <div class="form-group">
       <input type="submit"  value="Get OTP" class="btn float-right login_btn btn btn-secondary" onclick="return validate()" id="myBtn">
    </div> <!-- form-group// -->      
      </article>
</div> <!-- card.// -->                                                             
</form>
<h3>${msg}</h3>
<form action="veriffyOtp.do">
<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="otpNumber" class="form-control" placeholder="Enter OTP" type="number" id="otpNumber" onclick="buttons()">
        <span id="userP" style="color:red;"></span>
    </div> <!-- form-group// -->
     <div class="form-group">
       <input type="submit"  value="verify" class="btn float-right login_btn btn btn-secondary"  id="myBtn1">
    </div> <!-- form-group// --> 
    </article>
    </div>
</form>


</body>
</html>