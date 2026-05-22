<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../header.html"%>

<p>商品情報の変更</p>


<form action="Update" method="post">

	<input type="hidden" name="id" value="${id}">
	
	<p>商品ID: ${id}（変更不可）</p>
	
	<p>
		商品名: <input type="text" name="name" value="${name}" required>
	</p>
	<p>
		価格: <input type="number" name="price" value="${price}" required> 円
	</p>
	
	<p>
		<input type="submit" value="変更を保存する">
	</p>
</form>

<br>
<a href="Sort">商品一覧に戻る</a>

<%@include file="../footer.html"%>
