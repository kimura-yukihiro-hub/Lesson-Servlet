<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>送信結果</title>
</head>
<body>

	<h2>お問合せ内容の確認</h2>
	<p>以下の内容で送信が完了しました。</p>


	<ul>
		<li><b>氏名:</b> <%=request.getAttribute("user")%></li>
		<li><b>会社:</b> <%=request.getAttribute("company")%></li>
		<li><b>メールアドレス:</b> <%=request.getAttribute("email")%></li>
		<li><b>お問合せ内容:</b> <%=request.getAttribute("message")%></li>
		<li><b>資料請求希望:</b> <%=request.getAttribute("req")%></li>
	</ul>

	<br>
	<a href="form.jsp">フォームへ戻る</a>

</body>
</html>
