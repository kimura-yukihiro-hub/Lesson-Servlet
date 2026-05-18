<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.html"%>

<%@page errorPage="error.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
String username = request.getParameter("username");
String ageStr = request.getParameter("age");

if (username == null || username.trim().isEmpty()) {
	throw new Exception("username error");
}

int age = 0;
try {
	if (ageStr == null) {
		throw new NumberFormatException();
	}
	age = Integer.parseInt(ageStr);
} catch (NumberFormatException e) {
	throw new Exception("age error");
}
%>

<p>
	ユーザ＾名:
	<%=username%></p>
<p>
	年齢:
	<%=age%></p>
