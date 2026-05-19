<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>ログイン画面</h2>
	<p style="color: red;">認証が必要なエリアです。ログインしてください。</p>

	<form action="login2_prosess.jsp" method="post">
		ユーザー名:<input type="text" name="username" value="テストユーザー"><br>
		<br> <input type="submit" value="ログインする">
	</form>

</body>
</html>