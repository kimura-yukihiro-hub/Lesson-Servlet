<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%
Connection con = null;
PreparedStatement st = null;
ResultSet rs = null;

try {
	InitialContext ic = new InitialContext();
	DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/book");
	con = ds.getConnection();

	st = con.prepareStatement("select * from product");
	rs = st.executeQuery();
%>

<table border="1">
	<tr>
		<th>商品ID</th>
		<th>商品名</th>
		<th>価格(円)</th>
	</tr>
	<%
	while (rs.next()) {
	%>
	<tr>
		<td><%=rs.getInt("id")%></td>
		<td><%=rs.getString("name")%></td>
		<td><%=rs.getInt("price")%></td>
	</tr>
	<%
	}
	%>
</table>

<%
} catch (Exception e) {
out.println("データの取得に失敗しました:" + e.getMessage());
e.printStackTrace();
} finally {
if (rs != null)
	try {
		rs.close();
	} catch (Exception e) {
	}
if (st != null)
	try {
		st.close();
	} catch (Exception e) {
	}
if (con != null)
	try {
		con.close();
	} catch (Exception e) {
	}
}
%>
