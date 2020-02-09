<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:message code="language.language" /> : <a href="?language=en_US"><spring:message code="language.english" /></a>|<a href="?language=am_ET"><spring:message code="language.amharic" /></a>
<c:if test="${sessionScope.userName == null}">
    <li><a href=login><spring:message code="login.login" /></a></li>
    <li><a href="signup"><spring:message code="signup.signup" /></a></li>
</c:if>

<c:if test="${sessionScope.userName != null}">
    <li><a href="<spring:url value="/welcome"/>"><spring:message code="home.home" /></a></li>
    <li><a href="<spring:url value="/viewcar"/>"><spring:message code="rental.rentals.car" /></a></li>
    <li><a href="<spring:url value="/cars"/>"><spring:message code="car.carManagment" /></a></li>
    <c:if test="${sessionScope.role == 'ADMIN'}">
    <li><a href="<spring:url value="/viewapprovecar"/>"><spring:message code="car.approve" /></a></li>
    <li><a href="<spring:url value="/viewAllRentals"/>"><spring:message code="car.allRents" /></a></li>
	</c:if>
    <li><a href="<spring:url value="/logout"/>"><spring:message code="logout.logout" /></a></li>
</c:if>



<%--<c:set var="contains" value="false" />--%>
<%--<c:forEach var="item" items="${sessionScope.role}">--%>
<%--    <c:if test="${item == 1}">--%>
<%--        <c:set var="contains" value="true" />--%>
<%--    </c:if>--%>
<%--</c:forEach>--%>

