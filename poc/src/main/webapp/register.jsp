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
$(document).ready(function(){
    // Countries
    var country_arr = new Array("Select Country","AUSTRALIA","INDIA","NEW ZEALAND","USA","UAE","MAURITIUS");

    $.each(country_arr, function (i, item) {
        $('#country').append($('<option>', {
            value: item,
            text : item,
        }, '</option>' ));
    });

    // States
    var s_a = new Array();
   
    s_a['AUSTRALIA']="Select State|QUEENSLAND|VICTORIA";
    s_a['INDIA']="Select State|ANDHRAPRADESH|KARNATAKA|TAMILNADU|DELHI|GOA|W-BENGAL|GUJARAT|MADHYAPRADESH|MAHARASHTRA|RAJASTHAN";
    s_a['NEW ZEALAND']="Select State|AUCKLAND";
    s_a['USA']="Select State|NEWJERSEY|ILLINOIS";
    s_a['UAE']="Select State|DUBAI";
    s_a['MAURITIUS']="Select State|MAURITIUS";

    // Cities
    var c_a = new Array();
    c_a['QUEENSLAND']="BRISBANE";
    c_a['VICTORIA']="MELBOURNE";
    c_a['ANDHRAPRADESH']="HYDERABAD";
    c_a['KARNATAKA']="BANGLORE|Mysore|Mandya|Mangalore|Udupi";
    c_a['TAMILNADU']="CHENNAI";
    c_a['DELHI']="DELHI";
    c_a['GOA']="GOA";
    c_a['W-BENGAL']="KOLKATA";
    c_a['GUJARAT']="AHMEDABAD1|AHMEDABAD2|AHMEDABAD3|BARODA|BHAVNAGAR|MEHSANA|RAJKOT|SURAT|UNA";
    c_a['MADHYAPRADESH']="INDORE";
    c_a['MAHARASHTRA']="MUMBAI|PUNE";
    c_a['RAJASTHAN']="ABU";
    c_a['AUCKLAND']="AUCKLAND";
    c_a['NEWJERSEY']="EDISON";
    c_a['ILLINOIS']="CHICAGO";
    c_a['MAURITIUS']="MAURITIUS";
    c_a['DUBAI']="DUBAI";


    $('#country').change(function(){
        var c = $(this).val();
        var state_arr = s_a[c].split("|");
        $('#state').empty();
        $('#city').empty();
        if(c==0){
            $('#state').append($('<option>', {
                value: '0',
                text: 'Select State',
            }, '</option>'));
        }else {
            $.each(state_arr, function (i, item_state) {
                $('#state').append($('<option>', {
                    value: item_state,
                    text: item_state,
                }, '</option>'));
            });
        }
        $('#city').append($('<option>', {
            value: '0',
            text: 'Select City',
        }, '</option>'));
    });

    $('#state').change(function(){
        var s = $(this).val();
        if(s=='Select State'){
            $('#city').empty();
            $('#city').append($('<option>', {
                value: '0',
                text: 'Select City',
            }, '</option>'));
        }
        var city_arr = c_a[s].split("|");
        $('#city').empty();

        $.each(city_arr, function (j, item_city) {
            $('#city').append($('<option>', {
                value: item_city,
                text: item_city,
            }, '</option>'));
        });


    });
});
	function validate() {
		var f = document.getElementById("form");

		validatePassword(f);

	}
	function validatePassword(form) {

		var password = form["password"].value;
		var confirm = form["confirm"].value;

		if (password == null || password == "") {
			 document.getElementById("password_p").innerHTML="*this flied is empty";
		}

		else if (confirm == null || confirm == "") {
			 document.getElementById("confirm_p").innerHTML="*this flied is empty";
		}

		else if (password.length<5 || password.length>10) {
			 document.getElementById("password_p").innerHTML="*Password has to be 5 to 10 chars";
		}

		else if (password != confirm) {
		 document.getElementById("password_p").innerHTML="*Password Does Not Match";
		 document.getElementById("confirm_p").innerHTML="*Password Does Not Match";
			  document.getElementById("myBtn").disabled = true;
		}

	}
</script>
</head>
<body>
	<h1>register the details</h1>
	<h3>${msg}</h3>
	<div class="card bg-light">
		<article class="card-body mx-auto" style="max-width: 400px;">
			<h4 class="card-title mt-3 text-center">Create Account</h4>
			<p class="text-center">Get started with your free account</p>
			<p></p>
			<p class="divider-text"></p>
			<form id="form" action="register.do">
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-user"></i>
						</span>
					</div>
					<input name="username" class="form-control"
						placeholder="Enter EmailID " type="text" required>
				</div>
				<!-- form-group// -->
				<!-- form-group// -->
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-phone"></i>
						</span>
					</div>

					<input name="phone" class="form-control" placeholder="Phone number"
						type="text" required>
				</div>
				<!-- form-group// -->
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-building"></i>
						</span>
					</div>
					<select name="country" id="country"></select>
				</div>
					<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-building"></i>
						</span>
					</div>
					<select name="state" id="state"></select>
				</div>
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-building"></i>
						</span>
					</div>
					<select name="city" id="city"></select>
				</div>
			
				
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-building"></i>
						</span>
					</div>
					<input name="pincode" class="form-control" placeholder="Pin_code"
						type="text" required>
				</div>

				<!-- form-group end.// -->
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-lock"></i>
						</span>
					</div>
					<input class="form-control" placeholder="Create password"
						type="password" name="password" required>
						<span id="password_p" style="color:red;"></span>
				</div>
				<!-- form-group// -->
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-lock"></i>
						</span>
					</div>
					<input class="form-control" placeholder="Repeat password"
						type="password" name="confirm" required>
						<span id="confirm_p" style="color:red;"></span>
				</div>
				<!-- form-group// -->
				<div class="form-group">
					<input type="submit" value="submit"
						class="btn float-right login_btn btn btn-secondary"
						onclick="return validate()" id="myBtn">
				</div>
				<!-- form-group// -->
				<p class="text-center">
					Have an account? <a href="clickregister.do">Log In</a>
				</p>
			</form>
		</article>
	</div>
	<!-- card.// -->

	<!--container end.//-->

	<br>
	<br>
	<article class="bg-secondary mb-3">
		<div class="card-body text-center">
			<h3 class="text-white mt-3">Xworkz POC</h3>
			<p class="h5 text-white">Im Creating Application using spring mvc
				hibernate Mysql JSp</p>
			<br>
			<p>
				<a class="btn btn-warning" target="_blank"
					href="http://bootstrap-ecommerce.com/"> Xworkzodc.com <i
					class="fa fa-window-restore "></i></a>
			</p>
		</div>
		<br>
		<br>
	</article>
</body>
</html>