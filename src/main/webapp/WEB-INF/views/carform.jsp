<%--
  Created by IntelliJ IDEA.
  User: edy
  Date: 2/4/20
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add New Car</h1>
<form:form method="post" action="save">
    <table >
        <tr>
            <td>Name : </td>
            <td><form:input path="name"  /></td>
        </tr>
        <tr>
            <td>Owner :</td>
            <td><form:input path="owner" /></td>
        </tr>
        <tr>
            <td>Location :</td>
            <td><form:input path="location" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>