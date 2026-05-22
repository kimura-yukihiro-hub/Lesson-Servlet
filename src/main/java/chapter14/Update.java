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
 * Servlet implementation class Update
 */
@WebServlet("/chapter14/Update")
public class Update extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String idStr = request.getParameter("id");

		if (idStr == null || idStr.isEmpty()) {
			out.println("商品が指定されていません。<br>");
			return;
		}

		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
			Connection con = ds.getConnection();

			PreparedStatement st = con.prepareStatement("select * from product where id = ?");
			st.setInt(1, Integer.parseInt(idStr));
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				request.setAttribute("id", rs.getInt("id"));
				request.setAttribute("name", rs.getString("name"));
				request.setAttribute("price", rs.getInt("price"));

				request.getRequestDispatcher("/chapter14/update-input.jsp").forward(request, response);

			} else {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().println("該当する商品が見つかりません。");
			}
			st.close();
			con.close();
		} catch (Exception e) {
			response.setContentType("text/html; charset=UTF-8");
			e.printStackTrace(response.getWriter());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));

		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
			Connection con = ds.getConnection();

			PreparedStatement st = con.prepareStatement("update product set name = ?, price= ? where id = ?");

			st.setString(1, name);
			st.setInt(2, price);
			st.setInt(3, id);

			st.executeUpdate();

			st.close();
			con.close();
		} catch (Exception e) {
			response.setContentType("text/html; charset=UTF-8");
			e.printStackTrace(response.getWriter());
			return;
		}
		response.sendRedirect("Sort");

	}

}
