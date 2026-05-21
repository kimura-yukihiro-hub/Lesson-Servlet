<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="chapter14.Post"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%-- 1. 指定の形式で共通ヘッダーをインクルード --%>
<%@include file="../header.html"%>

<div
	style='max-width: 600px; margin: 0 auto; background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05); font-family: Arial, sans-serif; color: #333;'>
	<h1 style='text-align: center; color: #4a5568;'>掲示板</h1>

	<!-- サーブレットでエラーが発生していた場合は表示する -->
	<%
	if (request.getAttribute("error") != null) {
	%>
	<p style="color: red;">
		エラーが発生しました:
		<%=request.getAttribute("error")%></p>
	<%
	}
	%>

	<!-- 投稿フォーム -->
	<form action='<%=request.getContextPath()%>/chapter14/Board'
		method='POST'>
		<input type='hidden' name='action' value='insert'>
		<div style='margin-bottom: 15px;'>
			<label for='name'
				style='display: block; margin-bottom: 5px; font-weight: bold;'>名前：</label>
			<input type='text' id='name' name='name' required
				placeholder='名前を入力してください'
				style='width: 100%; padding: 10px; border: 1px solid #cbd5e1; border-radius: 4px; box-sizing: border-box;'>
		</div>
		<div style='margin-bottom: 15px;'>
			<label for='content'
				style='display: block; margin-bottom: 5px; font-weight: bold;'>本文：</label>
			<textarea id='content' name='content' required
				placeholder='本文を入力してください'
				style='width: 100%; height: 100px; padding: 10px; border: 1px solid #cbd5e1; border-radius: 4px; box-sizing: border-box; resize: vertical;'></textarea>
		</div>
		<button type='submit'
			style='background-color: #007bff; color: white; border: none; padding: 10px 20px; border-radius: 4px; cursor: pointer; font-size: 14px;'>投稿</button>
	</form>

	<hr style='margin: 30px 0; border: 0; border-top: 1px solid #e2e8f0;'>

	<!-- 投稿一覧の出力 -->
	<div>
		<%
		List<Post> posts = (List<Post>) request.getAttribute("posts");
		if (posts != null && !posts.isEmpty()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			for (Post post : posts) {
		%>
		<div
			style='border-bottom: 1px solid #e2e8f0; padding: 15px 0; position: relative;'>
			<div
				style='color: #718096; font-size: 13px; margin-bottom: 5px; display: flex; justify-content: space-between; align-items: center;'>
				<div>
					<span style='font-weight: bold; color: #2d3748;'><%=post.getName()%></span>
					<span style='margin-left: 10px;'><%=sdf.format(post.getPostDate())%></span>
				</div>

				<!-- 削除ボタン用のフォーム -->
				<form action='<%=request.getContextPath()%>/chapter14/Board'
					method='POST' style='margin: 0;'>
					<input type='hidden' name='action' value='delete'> <input
						type='hidden' name='id' value='<%=post.getId()%>'>
					<button type='submit'
						style='background-color: #dc3545; color: white; border: none; padding: 4px 8px; border-radius: 4px; cursor: pointer; font-size: 11px;'
						onclick="return confirm('この投稿を削除してもよろしいですか？');">削除</button>
				</form>
			</div>
			<div
				style='white-space: pre-wrap; word-wrap: break-word; line-height: 1.5; padding-right: 60px;'><%=post.getContent()%></div>
		</div>
		<%
		}
		} else {
		%>
		<p style='text-align: center; color: #a0aec0;'>まだ投稿はありません。</p>
		<%
		}
		%>
	</div>
</div>

<%-- 2. 指定の形式で共通フッターをインクルード --%>
<%@include file="../footer.html"%>