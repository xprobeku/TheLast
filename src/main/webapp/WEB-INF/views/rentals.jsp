<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="../../resources/css/car.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title><spring:message code="rental.rentals.title" /></title>
</head>
<body>

	<div class="container">
		
		<table class="table table-hover">
			<tbody>
				<tr>
				    <th><spring:message code="rental.rentals.driver" /></th>
				    <th><spring:message code="rental.rentals.car" /></th>
				    <th><spring:message code="rental.rentals.from" /></th>
				    <th><spring:message code="rental.rentals.to" /></th>
				    <th><spring:message code="rental.rentals.status" /></th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th >&nbsp;</th>
				</tr>
				<c:forEach items="${rentals}" var="rental">
					<tr>
						<td>${rental.user.firstName} ${rental.user.firstName}</td>
						<td>${rental.car.carBrand}</td>
						<td>${rental.pickUpDate}</td>
						<td>${rental.returnDate}</td>
						<td>${rental.status}</td>
						<td><a href="<spring:url value="/rental/approve/${rental.id}"/>">Approve</a></td>
						<td><a href="<spring:url value="/rental/decline/${rental.id}"/>">Decline</a></td>

						<c:if test="${rental.status.toString().equals('PENDING')}">
							<td><a href="<spring:url value="/rental/returned/${rental.id}"/>">Returned</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
		<div class="vertical-placeholder"></div>
	
		<div class="navbar navbar-default navbar-fixed-bottom">
		<div class="centre">
		</div>
	</div>
</body>
</html>