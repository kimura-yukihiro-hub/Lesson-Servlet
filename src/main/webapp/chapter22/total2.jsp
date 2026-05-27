<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.html"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>商品一覧(200円以上の商品)</h2>
	
	<c:forEach var="product" items="${list}">
		<c:if test="${product.price >= 200}">
			ID : ${product.id}<br>
			商品名 : ${product.name}<br>
			価格 : ${product.price}円<br><br>
		</c:if>
	</c:forEach>
</body>
</html>

<%@include file="../footer.html"%>