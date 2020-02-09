<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title><spring:message code="signup.addNewUser" /></title>
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
			    	<h3 class="panel-title"><spring:message code="signup.signup" /></h3>
			 	</div>
			  	<div class="panel-body">
			  	<c:if test="${not empty error}">
					<div class="alert alert-danger">
						${error}
					</div>
				</c:if>
					<form:form  modelAttribute="userSignup" method="post" action="signup" class="form-horizontal"  >
						<fieldset>
							<legend><spring:message code="signup.addNewUser" /></legend>

							<form:errors path="*" cssClass="alert alert-danger" element="div"/>
							<div class="form-group">
								<label class="control-label col-lg-2 col-lg-2" for="userName"><spring:message code="signup.userName" /></label>
								<div class="col-lg-10">
									<form:input id="userName" path="userName" type="text" class="form:input-large"/>
									<form:errors path="userName" cssClass="text-danger"/>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-2 col-lg-2" for="password"><spring:message code="signup.password" /></label>
								<div class="col-lg-10">
									<form:input id="password" path="password" type="text" class="form:input-large"/>
									<form:errors path="password" cssClass="text-danger"/>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-2" for="firstName"><spring:message code="signup.firstName" /></label>
								<div class="col-lg-10">
									<form:input id="firstName" path="firstName" type="text" class="form:input-large"/>
									<form:errors path="firstName" cssClass="text-danger"/>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-2" for="lastName"><spring:message code="signup.lastName" /></label>
								<div class="col-lg-10">
									<div class="form:input-prepend">
										<form:input id="lastName" path="lastName" type="text" class="form:input-large"/>
										<form:errors path="lastName" cssClass="text-danger"/>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-2" for="phone"><spring:message code="signup.phone" /></label>
								<div class="col-lg-10">
									<div class="form:input-prepend">
										<form:input id="phone" path="phone" type="text" class="form:input-large"/>
										<form:errors path="phone" cssClass="text-danger"/>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-2" for="email"><spring:message code="signup.email" /></label>
								<div class="col-lg-10">
									<div class="form:input-prepend">
										<form:input id="email" path="email" type="text" class="form:input-large"/>
										<form:errors path="email" cssClass="text-danger"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-lg-2" for="roles"><spring:message code="signup.role" /></label>
								<div class="col-lg-10">
									<div class="form:input-prepend">
										<form:select path="roles" id="roles">
											<form:option value="ADMIN"> <spring:message code="signup.admin" /></form:option>
											<form:option value="OWNER"> <spring:message code="signup.owner" /></form:option>
											<form:option value="RENTER"> <spring:message code="signup.renter" /></form:option>
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
