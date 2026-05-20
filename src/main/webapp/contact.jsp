<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問合せ</title>
</head>
<body>
	<h2>お問合せフォーム</h2>
	<p>お問合せ内容と個人情報を入力してください。</p>
	<form action="ContactServlet" method="post">
		<p>
			氏名:<br> <input type="text" name="user">
		</p>
		<p>
			会社:<br> <input type="text" name="company">
		</p>
		<p>
			メールアドレス:<br> <input type="text" name="email">
		</p>
		<p>
			お問い合わせ内容:<br>
			<textarea id="message" name="message" rows="4" cols="40" required></textarea>
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
