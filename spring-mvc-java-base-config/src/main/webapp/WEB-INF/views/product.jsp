<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style type="text/css">
	.error{
		color:red;
		/* position: fixed;
		margin-left: 30px;
		text-align: left; */
	}
</style>
<script type="text/javascript">
	function validate() {
		var title = document.getElementById("pt").value;
		var name = document.getElementById("cn").value;
		var price = document.getElementById("prc").value;
		
		if(title === '' || title == null)
		{
			alert("title="+title);
			return false;
		}
		
		if(name === '' || name == null)
		{
			alert("name="+name);			
			return false;
		}
		
		if(price==0.0 || price== null)
		{
			alert("price must be greater than 0.00");
			document.getElementById("priceError").innerHTML="price must be greater than 0.0";
			alert("price must be greater than 0");
			
		
			return false;
		}
		
		return true;
		
	}
	
</script>
</head>
<body>

	<form:form action="/spring-mvc-java-base-config/add-product" method="post"
		modelAttribute="productDTO" onsubmit="validate()">

		<div align="center">
			<table border="1" bgcolor="lime" width="30%">
				<form:hidden path="productId"/>
				<tr bgcolor="pink">
					<th colspan="2"><h2>Add New Product</h2></th>
				</tr>
				<tr>
					<td align="right"><label for="pt">Product Title*</label></td>
					<td><form:input type="text" id="pt" path="title" />
					<form:errors path="title" cssClass="error"/></td>
				</tr>
				<tr>
					<td align="right"><label for="cn">Company Name*</label></td>
					<td><form:input type="text" id="cn" path="companyName"/>
					<form:errors path="companyName" cssClass="error"/></td>
				</tr>
				<tr>
					<td align="right"><label for="prc">Price*</label></td>
					<td><form:input type="text" id="prc" path="price"/>
				 <form:errors path="price" cssClass="error"/><p style="color:blue;" id="priceError"></p></td> 
					
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Add Product">
					</td>
				</tr>
			</table>
		</div>
	</form:form>
</body>
</html>