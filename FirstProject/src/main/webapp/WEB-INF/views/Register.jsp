<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	jQuery(document).ready(
		function($) {
			$('#register').click(function(event) {
				//event.preventDefault();
				var data = {};
				data['username'] = $('#username').val();
				data['email'] = $('#email').val();
				data['password'] = $('#password').val();
				data['password_confirm'] = $('#password_confirm').val();

				$("#register").prop("disabled", true);
				$.ajax({
					type : "POST",
					url : "http://localhost:8080/FirstProject/newUser",
					data : JSON.stringify(data),
					headers : {
						'Accept' : 'application/json',
						'Content-Type' : 'application/json'
					},
					timeout : 600000,
					success : function(data) {
						alert(data);
						console.log("success: " + data.username + " " + data.email);
						$("#register").prop("disabled", false);
					},
					error : function(e) {
						alert(data);
						console.log("failed: " + data.username + " " + data.email);
						$("#register").prop("disabled", false);
					}
				});
			});
		});
</script>

</head>
<body>

	<h1>Register here</h1>

	<form:form class="form-horizontal" id="myform" method="post">
		<fieldset>
			<div id="legend"></div>
			<div class="control-group">
				<!-- Username -->
				<label class="control-label" for="username">Username</label>
				<div class="controls">
					<input type="text" id="username" name="username" placeholder=""
						class="input-xlarge">
				</div>
			</div>

			<div class="control-group">
				<!-- E-mail -->
				<label class="control-label" for="email">E-mail</label>
				<div class="controls">
					<input type="text" id="email" name="email" placeholder=""
						class="input-xlarge">
				</div>
			</div>

			<div class="control-group">
				<!-- Password-->
				<label class="control-label" for="password">Password</label>
				<div class="controls">
					<input type="password" id="password" name="password" placeholder=""
						class="input-xlarge">
				</div>
			</div>

			<div class="control-group">
				<!-- Password -->
				<label class="control-label" for="password_confirm">Password
					(Confirm)</label>
				<div class="controls">
					<input type="password" id="password_confirm"
						name="password_confirm" placeholder="" class="input-xlarge">
				</div>
			</div>
			<div>
				<br>
			</div>
			<div class="control-group">
				<!-- Button -->
				<div class="controls">
					<button class="btn btn-success" id='register'>Register</button>
				</div>
			</div>
		</fieldset>
	</form:form>
</body>
</html>