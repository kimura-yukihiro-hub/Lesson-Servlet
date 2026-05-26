<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.Product"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%
	Product p1 = new Product();
	p1.setId(1);
	p1.setName("鉛筆");
	p1.setPrice(120);
	
	Product p2 = new Product();
	p2.setId(2);
	p2.setName("消しゴム");
	p2.setPrice(80);
	
	Map<String, Product> productMap = new HashMap<>();
	productMap.put("A001", p1);
	productMap.put("B002", p2);
	
	request.setAttribute("products", productMap);
	
	request.getRequestDispatcher("el1-display.jsp").forward(request, response);
%>
