<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String username = request.getParameter("username");

if (username == null || username.trim().isEmpty()) {
%>
<jsp:forward page="error.jsp" />
<%
} else if ("admin".equals(username)) {

response.sendRedirect("admin.jsp");
} else {
%>
<jsp:forward page="home.jsp" />
<%
}
%>
