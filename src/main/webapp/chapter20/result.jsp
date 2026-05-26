<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="product" class="chapter20.Product" scope="request" />
<jsp:setProperty name="product" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報の確認</title>
</head>
<body>

<h2>入力された商品情報</h2>

商品ID:<jsp:getProperty property="id" name="product"/><br>
商品名:<jsp:getProperty property="name" name="product"/><br>
価格:<jsp:getProperty property="price" name="product"/>円

</body>
</html>