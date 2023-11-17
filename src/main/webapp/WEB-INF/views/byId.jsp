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
<h1>All Student Id</h1>
<h6>For more details click on Id/Name</h6>


<table border="2">
    <thead>
    <tr>
        <th>Id</th>
        <TH>NAME</TH>
    </tr>
    </thead>
    <tbody>
    <c:set var="iterationCount" value="0" />
    <c:forEach var="getAllStudent" items="${getAllStudent}">
        <c:set var="iterationCount" value="${iterationCount + 1}" />
        <tr>
            <th><a href="view?id=${getAllStudent.id}"> ${getAllStudent.id} </th>
            <th><a href="view?id=${getAllStudent.id}"> ${getAllStudent.name} </th>

        </tr>
    </c:forEach>
    </tbody>
</table>
<p>Total Record Show : ${iterationCount}, in this page</p>



<hr>
<table border="1">
    <thead>
    <tr>
        <th>Select Page:</th>
        <c:forEach var="page" begin="1" end= "${countROw}">
            <th><a href="byId?id=${page-1}">${page}</a></th>
        </c:forEach>
    </tr>
    </thead>
</table>
<hr>

</body>
</html>
