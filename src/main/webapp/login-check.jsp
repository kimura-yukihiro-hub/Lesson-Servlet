<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.html"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="userName" value="渡邊" scope="session" />

<c:choose>

	<c:when test="${!empty userName}">
		ようこそ、${userName}さん！
	</c:when>
	
	<c:otherwise>
		ログインしてください。
	</c:otherwise>
</c:choose>

<%@include file="../footer.html"%>
