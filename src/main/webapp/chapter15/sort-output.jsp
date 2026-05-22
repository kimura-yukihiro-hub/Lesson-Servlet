<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, bean.Product" %>
<!DOCTYPE html>
<%@include file="../header.html"%>

<h2>並び替え結果</h2>

<%-- 枠線のあるテーブルを廃止し、シンプルな箇条書き（または改行）でデータを出力します --%>
<div>
	<%
	List<Product> list = (List<Product>) request.getAttribute("list");
	if (list != null) {
		for (Product product : list) {
	%>
		<p>
			<%= product.getId() %> : 
			<%= product.getName() %> 
			(<%= product.getPrice() %>円)
		</p>
	<%
		}
	}
	%>
</div>

<br>

<p>
	<a href="sort.jsp">最初のページに戻る</a>
</p>

<%@include file="../footer.html"%>

