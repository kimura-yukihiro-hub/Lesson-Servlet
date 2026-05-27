<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.html"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="total" value="0" />

<c:forEach var="product" items="${list}">

	${product.id} : ${product.name} : ${product.price}円<br>
	
	<c:set var="total" value="${total + product.price}" />
</c:forEach>

<br>
合計金額: ${total}円

<%@include file="../footer.html"%>
