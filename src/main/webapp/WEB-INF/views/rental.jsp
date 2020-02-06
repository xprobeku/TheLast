<%--
  Created by IntelliJ IDEA.
  User: meron
  Date: 2/5/2020
  Time: 3:44 PM
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
    <title>Rental Status</title>
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
                    <h2>Rental</h2>
                </div>
            </div>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>Car</th>
                <th>Status</th>
                <th>Created Date</th>
                <c:if test="${rental.status.toString().equals('APPROVED') }">
                    <th>Approval Date</th>
                    <th>Expected Date</th>
                    <th>Pickup Date</th>
                    <th>Return Date</th>
                    <th>Declined Date</th>
                    <th>Declined Description</th>
                </c:if>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${rental.car.carBrand}</td>
                    <td>${rental.status}</td>
                    <td>${rental.createDate}</td>
                    <c:if test="${rental.status.toString().equals('APPROVED') }">
                    <td>${rental.approvalDate}</td>
                    <td>${rental.expectedDate}</td>
                    <td>${rental.pickUpDate}</td>
                    <td>${rental.returnDate}</td>
                    <td>${rental.declinedDate}</td>
                    <td>${rental.declineDesc}</td>
                    </c:if>
                </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
