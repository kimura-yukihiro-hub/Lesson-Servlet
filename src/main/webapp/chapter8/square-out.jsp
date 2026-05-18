<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.html"%>

<%@page errorPage="square-error.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
int cost = Integer.parseInt(request.getParameter("cost"));
%>

<p>
	入力した値:<%=cost %><br>
</p>
<p>
	>結果:<%=cost * cost %></p>

<%@include file="../footer.html"%>