<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.html"%>
<%@page import="java.util.Date"%>
<%
Date today = new Date();
%>
<p>
	現在の日時:
	<%=today%></p>
<%@include file="../footer.html"%>
