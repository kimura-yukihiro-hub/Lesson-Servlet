<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パラメータの受信</title>
</head>
<body>

<h1>転送されたパラメータ</h1>

<%
String username = request.getParameter("username");
String role = request.getParameter("role");
%>

<p>ユーザー名:<%= username %></p>
<p>権限:<%= role %></p>
</body>
</html>