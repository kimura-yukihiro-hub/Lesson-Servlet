<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String username = request.getParameter("username");
	
	if (username != null && !username.trim().isEmpty()) {
	
	session.setAttribute("user", username);
	response.sendRedirect("secure/mypage.jsp");
	} else {
	response.sendRedirect("login2.jsp");
	}
	%>
