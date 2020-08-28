<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<b>Add Product</b>
	<form:form action="addnewproduct" modelAttribute="product" method="post">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Enter the product name</td>
				<td><form:input id="productName" path="productName" name="productName" /></td>
			</tr>
			<tr>
				<td>Enter the quantity</td>
				<td><form:input id="quantity" name="quantity" path="quantity" /></td>
			</tr>
			<tr>
				<td>Enter the price</td>
				<td><form:input id="price" name="price" path="price" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Product" /></td>
				<td><input type="reset" value="Cancel Prduct" /></td>
			</tr>
		</table>


	</form:form>
</body>
</html>