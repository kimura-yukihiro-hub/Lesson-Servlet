<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="user" class="bean.User" scope="request" />
<jsp:setProperty name="user" property="name" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>${user.name == "admin" ? "管理者としてログイン中" :
	(empty user.name ? "ユーザー名が未設定です" : "こんにちは、".concat(user.name).concat("さん！"))}
	</p>

	<p>
		<a href="el3.jsp">戻る</a>
	</p>
</body>
</html>