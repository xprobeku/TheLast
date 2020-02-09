<%--
  Created by IntelliJ IDEA.
  User: edy
  Date: 2/4/20
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add new car</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="../../resources/css/car.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
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
    width: 150px;
}
.footer {
    padding-top: 100px !important;
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
        			<form:form  modelAttribute="car" method="POST" action="save" class="form-horizontal"  >
						<fieldset>
							<legend>Add new Car</legend>

							<form:errors path="*" cssClass="alert alert-danger" element="div"/>
							<div class="form-group">
								<label class="control-label col-lg-2 col-lg-2" for="carBrand"> Car Brand : </label>
								<div class="col-lg-10">
									<form:select path="carBrand" id="carBrand">
		                           	 <form:options items="${brandList}"></form:options>
		                        	</form:select>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-2 col-lg-2" for="model">Model : </label>
								<div class="col-lg-10">
									<form:input path="model" type="text" class="form:input-large" id="model"/>
                        			<form:errors path="model" cssClass="text-danger"/>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-2" for="year">Year : </label>
								<div class="col-lg-10">
									<form:input id="year" path="year" type="text" class="form:input-large"/>
									<form:errors path="year" cssClass="text-danger"/>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-2" for="price">Price :</label>
								<div class="col-lg-10">
									<div class="form:input-prepend">
										<form:input id="price" path="price" type="text" class="form:input-large"/>
										<form:errors path="price" cssClass="text-danger"/>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-2" for="seats">Seats : </label>
								<div class="col-lg-10">
									<div class="form:input-prepend">
										<form:input id="seats" path="seats" type="text" class="form:input-large"/>
										<form:errors path="seats" cssClass="text-danger"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-lg-2" for="status">Status : </label>
								<div class="col-lg-10">
									<div class="form:input-prepend">
										<form:input id="status" path="status" type="text" class="form:input-large"/>
										<form:errors path="status" cssClass="text-danger"/>
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-lg-2" for="pickUpLocation">Pickup Location :</label>
								<div class="col-lg-10">
									<div class="form:input-prepend">
										<form:input id="pickUpLocation" path="pickUpLocation" type="text" class="form:input-large"/>
										<form:errors path="pickUpLocation" cssClass="text-danger"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-lg-2" for="description">Description :</label>
								<div class="col-lg-10">
									<div class="form:input-prepend">
										<form:input id="description" path="description" type="text" class="form:input-large"/>
										<form:errors path="description" cssClass="text-danger"/>
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-lg-offset-2 col-lg-10">
									<input type="submit" id="btnAdd" class="btn btn-primary" value ="Save"/>
								</div>
							</div>
						</fieldset>
						</form:form>
			    </div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
