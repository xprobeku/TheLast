<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new user</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
    $(document).ready(function() {  
            $("#roles").removeAttr("multiple");
    });
</script> 
	<style type="text/css">
.panel.panel-default {
    width: 517px;
    margin: 0 auto;
}
form#userSignup {
    width: 500px;
}
.col-lg-10 {
    width: 70% !important;
}
select#roles {
    height: 25px;
}
label.control-label.col-lg-2.col-lg-2 {
    width: 125px;
}
</style>
</head>
<body>
<div class="container">
    <div class="row">
		<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			    	<h3 class="panel-title">Sign up</h3>
			 	</div>
			  	<div class="panel-body">
			  	<c:if test="${not empty error}">
					<div class="alert alert-danger">
						${error}
					</div>
				</c:if>
					<form:form  modelAttribute="userSignup" method="post" action="signup" class="form-horizontal"  >
						<fieldset>
							<legend>Add new User</legend>

							<form:errors path="*" cssClass="alert alert-danger" element="div"/>
							<div class="form-group">
								<label class="control-label col-lg-2 col-lg-2" for="userName"> User Name</label>
								<div class="col-lg-10">
									<form:input id="userName" path="userName" type="text" class="form:input-large"/>
									<form:errors path="userName" cssClass="text-danger"/>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-2 col-lg-2" for="password">Password</label>
								<div class="col-lg-10">
									<form:input id="password" path="password" type="text" class="form:input-large"/>
									<form:errors path="password" cssClass="text-danger"/>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-2" for="firstName">First Name</label>
								<div class="col-lg-10">
									<form:input id="firstName" path="firstName" type="text" class="form:input-large"/>
									<form:errors path="firstName" cssClass="text-danger"/>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-2" for="lastName">Last Name</label>
								<div class="col-lg-10">
									<div class="form:input-prepend">
										<form:input id="lastName" path="lastName" type="text" class="form:input-large"/>
										<form:errors path="lastName" cssClass="text-danger"/>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-2" for="phone">Phone</label>
								<div class="col-lg-10">
									<div class="form:input-prepend">
										<form:input id="phone" path="phone" type="text" class="form:input-large"/>
										<form:errors path="phone" cssClass="text-danger"/>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-2" for="email">Email</label>
								<div class="col-lg-10">
									<div class="form:input-prepend">
										<form:input id="email" path="email" type="text" class="form:input-large"/>
										<form:errors path="email" cssClass="text-danger"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-lg-2" for="roles">Role</label>
								<div class="col-lg-10">
									<div class="form:input-prepend">
										<form:select path="roles" id="roles">
											<form:option value="ADMIN"> ADMIN</form:option>
											<form:option value="OWNER"> OWNER</form:option>
											<form:option value="RENTER"> RENTER</form:option>
										</form:select>
								<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-lg-offset-2 col-lg-10">
									<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
								</div>
							</div>

						</fieldset>
						<security:csrfInput />
			      	</form:form>

			    </div>
			</div>
		</div>
	</div>
</div>
</body>
