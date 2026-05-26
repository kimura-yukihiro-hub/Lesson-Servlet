<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パラメータの送信</title>
</head>
<body>

<jsp:forward page="destination.jsp">
<jsp:param value="taro" name="username"/>
<jsp:param value="admin" name="role"/>
</jsp:forward>

</body>
</html>