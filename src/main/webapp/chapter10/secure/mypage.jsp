<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>マイページ</h2>

	<p>
		ようこそ、<%=session.getAttribute("user")%>さん！
	</p>
	<p style="color: green;">あなたは認証フィルタを通過してこのページにアクセスしています。</p>

	<br>
	<a href="../login2.jsp">ログアウトする。</a>

</body>
</html>