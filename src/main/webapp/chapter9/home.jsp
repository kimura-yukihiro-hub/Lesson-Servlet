<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>一般ユーザーページ</h3>
	<p>
		ようこそ、<%=request.getParameter("username")%>さん！
	</p>
	<p>(フォワード遷移のため、URLはvalidate.jspのままです)</p>
	<a href="login.jsp">ログアウト</a>

</body>
</html>