<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 14-11-2023
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body><a href="/Demo">Home</a>
<h1>All Student Details</h1>


<table border="1">
    <thead>
    <tr>
        <th>Select Page:</th>
        <c:forEach var="page" begin="1" end= "${countROw}">
            <th><a href="studentView?id=${page-1}">${page}</a></th>
        </c:forEach>
    </tr>
    </thead>
</table>



<table border="2">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Mobile</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <h5><a href="form">ADD </a> </h5>
    <c:set var="iterationCount" value="0" />
    <c:forEach var="getAllStudent" items="${getAllStudent}">
        <c:set var="iterationCount" value="${iterationCount + 1}" />
        <tr>
            <th>${getAllStudent.id}</th>
            <th>${getAllStudent.name}</th>
            <th>${getAllStudent.mobile}</th>
            <th>${getAllStudent.address}</th>
            <th><a href="update?id=${getAllStudent.id}"> Update </th>
            <td><a href="delete?id=${getAllStudent.id}" onclick="if(!(confirm('Are you sure you want to delete this product?'))) return false">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p>Total Record Show : ${iterationCount}, in this page</p>





</body>
</html>
