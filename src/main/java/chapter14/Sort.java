package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sort
 */
@WebServlet("/chapter14/Sort")
public class Sort extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			String sort = request.getParameter("sort");

			String sql = "select * from product";

			if (sort != null && sort.equals("high")) {
				sql += " order by price desc";
			} else if (sort != null && sort.equals("low")) {
				sql += " order by price asc";
			}

			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup(
					"java:/comp/env/jdbc/book");
			Connection con = ds.getConnection();

			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				out.println(rs.getInt("id"));
				out.println(":");
				out.println(rs.getString("name"));
				out.println(":");
				out.println(rs.getInt("price"));
				out.println("円<br>");

				out.println("<a href='Update?id=" + rs.getInt("id") + "'>[変更]</a>");
				out.println("<br>");
			}

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}

	}
}
