package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class Select
 */
@WebServlet("/chapter14/Select")
public class Select extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		request.setCharacterEncoding("UTF-8");
		String count = request.getParameter("count");
		String payment = request.getParameter("payment");
		String review = request.getParameter("review");
		String mail = request.getParameter("mail");

		String mailStatus = "希望しない";
		if (mail != null) {
			mailStatus = "希望する";
		}

		try {
			InitialContext ic = new InitialContext();

			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/form");
			Connection con = ds.getConnection();

			String sql = "insert into purchase (count, payment, review, mail) values (?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, Integer.parseInt(count));
			st.setString(2, payment);
			st.setString(3, review);
			st.setString(4, mailStatus);

			st.executeUpdate();

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}

		Page.header(out);
		out.println("<p>" + count + "個の商品をカートに入れました。</p>");
		out.println("<p>お支払方法を" + payment + "に設定しました。</p>");
		out.println("<p>ご感想ありがとうございます。</p>");
		out.println("<p>「" + review + "」</p>");
		if (mail != null) {
			out.println("<p>メールをお送りします。</p>");
		} else {
			out.println("<p>メールはお送りしません。</p>");
		}
		out.println("<p style=' color:green; font-weight:bold;'>context.xml経由でデータベースに保存しました。</p>");
		Page.footer(out);
	}

}
