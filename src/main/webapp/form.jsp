<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問合せ</title>
<style>
.error-msg {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<h2>お問合せフォーム</h2>
	<p>お問合せ内容と個人情報を入力してください。</p>


	<%
	if (request.getAttribute("error") != null) {
	%>
	<p class="error-msg"><%=request.getAttribute("error")%></p>
	<%
	}
	%>

	<form action="ContactServlet" method="post">
		<p>

			氏名（必須）:<br> <input type="text" name="user"
				value="<%=request.getAttribute("user") != null ? request.getAttribute("user") : ""%>"
				required>
		</p>
		<p>
			会社:<br> <input type="text" name="company"
				value="<%=request.getAttribute("company") != null ? request.getAttribute("company") : ""%>">
		</p>
		<p>

			メールアドレス（必須）:<br> <input type="email" name="email"
				value="<%=request.getAttribute("email") != null ? request.getAttribute("email") : ""%>"
				required>
		</p>
		<p>

			お問い合わせ内容（必須）:<br>
			<textarea id="message" name="message" rows="4" cols="40" required><%=request.getAttribute("message") != null ? request.getAttribute("message") : ""%></textarea>
		</p>
		<p>メルマガ種類:</p>
		<ul>
			<li><input type="checkbox" id="1" name="news" value="総合案内">総合案内</li>
			<li><input type="checkbox" id="2" name="news" value="セミナー案内">セミナー案内</li>
			<li><input type="checkbox" id="3" name="news" value="求人採用情報">求人採用情報</li>
		</ul>

		<p>
			資料請求希望: Yes <input type="radio" id="yes" name="req" value="Yes"
				checked> No <input type="radio" id="no" name="req"
				value="No">
		</p>
		<p>
			<input type="submit" value="送信">
		</p>
	</form>
</body>
</html>
