<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
</head>
<body>
	<section>

		<div class="jumbotron">
			<div class="container">
				<h1> ${greeting} </h1>
				<p> ${tagline} </p>
				<p> <security:authorize access="isAuthenticated()">
  					Welcome  <security:authentication property="principal.username" />
				</security:authorize>
		<img src="<spring:url value="/resources/images/error_page.jpg"/>">
			</div>
				</div>
	 			<div class="pull-left"> <h3>${SpecialBlurb}</h3> </div>

	</section>

</body>
</html>
