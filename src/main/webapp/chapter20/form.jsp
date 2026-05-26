<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品入力フォーム</title>
</head>
<body>
<h2>商品情報の入力</h2>
<form action="result.jsp" method="post">
商品ID:<input type="text" name="id"><br>
商品名:<input type="text" name="name"><br>
価格:<input type="text" name="price"><br>
<input type="submit" value="送信">
</form>
</body>
</html>