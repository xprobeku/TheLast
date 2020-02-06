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
    <title>Car list</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/car.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-5">
                    <h2>Add new car</h2>
                </div>
            </div>
        </div>
        <form:form modelAttribute="car" method="POST" action="save">
            <form:errors path="*" cssClass="alert alert-danger" element="div"/>
            <table >
                <tr>
                    <td>Car Brand : </td>
                    <td>
                        <form:select path="carBrand">
                            <form:options items="${brandList}"></form:options>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>Model :</td>
                    <td><form:input path="model" />
                        <form:errors path="model" cssClass="text-danger"/>
                    </td>
                </tr>
                <tr>
                    <td>Year :</td>
                    <td><form:input path="year" />
                        <form:errors path="year" cssClass="text-danger"/>
                    </td>
                </tr>
                <tr>
                    <td>Price :</td>
                    <td><form:input path="price" />
                        <form:errors path="price" cssClass="text-danger"/>
                    </td>
                </tr>
                <tr>
                    <td>Seats :</td>
                    <td><form:input path="seats" />
                        <form:errors path="seats" cssClass="text-danger"/>
                    </td>
                </tr>
<%--                <tr>--%>
<%--                    <td>User Name :</td>--%>
<%--                    <td><form:hidden path="owner.id" value="1" /></td>--%>
<%--                </tr>--%>
                <tr>
                    <td>Pick up location :</td>
                    <td><form:input path="pickUpLocation" />
                        <form:errors path="pickUpLocation" cssClass="text-danger"/>
                    </td>
                </tr>
                <tr>
                    <td>Description :</td>
                    <td><form:input path="description" /></td>
                </tr>
                <tr>
                    <td>Description :</td>
                    <td><form:input path="cover"  type="file" /></td>
                </tr>
<%--                <tr>--%>
<%--                    <td>Status :</td>--%>
<%--                    <td>--%>
<%--                        <select id="status" name="status" disabled>--%>
<%--                            <option value="PENDING" selected>PENDING</option>--%>
<%--                            <option value="APPROVED">APPROVED</option>--%>
<%--                            <option value="DECLINED">DECLINED</option>--%>
<%--                            <option value="RETURNED">RETURNED</option>--%>
<%--                            <option value="OVERDUE">OVERDUE</option>--%>
<%--                        </select>--%>
<%--                    </td>--%>
<%--                </tr>--%>
                <tr>
                    <td> </td>
                    <td><input type="submit" value="Save" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</div>
</body>
</html>