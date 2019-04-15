<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	ProductId:${ requestScope.product.productId }
	<br><br>
	ProductName:${ requestScope.product.productName }
	<br><br>
	ProductDesc:${ requestScope.product.productDesc }
	<br><br>
	ProductPrice:${ requestScope.product.productPrice }
	<br><br>
	
	
</body>
</html>