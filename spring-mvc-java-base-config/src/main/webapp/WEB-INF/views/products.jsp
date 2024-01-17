<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Manager Home</title>
    </head>
    <body>
        <div align="center">
            <h1>Product List</h1>
            <h3><a href="/spring-mvc-java-base-config/product">Add New Product</a></h3>
            <table border="1">
            	<tr>
	                <th>Product Id</th>
	                <th>Title</th>
	                <th>Company Name</th>
	                <th>Price</th>
	                <th colspan="2">Action</th>
                </tr>
                 
                <c:forEach var="product" items="${productList}" >
                <tr>
                    <td>${product.productId}</td>
                    <td>${product.title}</td>
                    <td>${product.companyName}</td>
                    <td>${product.price}</td>
                    <td>
                        <a href="/spring-mvc-java-base-config/editProduct?id=${product.productId}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/spring-mvc-java-base-config/deleteProduct?id=${product.productId}">Delete</a>
                    </td>                            
                </tr>
                </c:forEach>            
            </table>
        </div>
    </body>
</html>