<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.html"%>

<form action="output.jsp" method="post">
	<p>
		ユーザー名：<input type="text" name="username">
	</p>
	<p>
		年齢：<input type="text" name="age">
	</p>
	<p>
		<input type="submit" value="送信">
	</p>
</form>
<%@include file="../footer.html"%>