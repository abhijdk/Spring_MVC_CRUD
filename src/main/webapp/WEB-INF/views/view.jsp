<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 15-11-2023
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body><a href="/Demo">Home</a>

<h4><a href="byId?id=0">ById</a> </h4><hr>
<h1>Id: ${view.id}</h1>
<h1>Name: ${view.name}</h1>
<h1>Mobile: ${view.mobile}</h1>
<h1>Address: ${view.address}</h1>

<th><a href="update?id=${view.id}">Update</th><br>
<td><a href="delete?id=${view.id}" onclick="if(!(confirm('Are you sure you want to delete this product?'))) return false">Delete</a></td><hr>

<h1><a href="form">New Student ADD</a> </h1>

</body>
</html>
