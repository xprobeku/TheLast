<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><tiles:insertAttribute name="title" /></title>

<link href="<c:url value="/resources/css/car.css" />" rel="stylesheet">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="<spring:url value="/resource/js/ajax.js"/>"></script>
</head>
<body>

	<div class="container">
		<div class="header">
			<ul class="nav nav-pills pull-right">
				<tiles:insertAttribute name="navigation" />
			</ul>
			<h3 class="text-muted">CAR RENTAL WEBSITE</h3>
		</div>


		<div class="jumbotron">
			<h1>
				<tiles:insertAttribute name="heading" />
			</h1>
		</div>

		<div class="row">
			<tiles:insertAttribute name="body" />
		</div>

		<div>
			<tiles:insertAttribute name="footer" />
		</div>
</body>
</html>
