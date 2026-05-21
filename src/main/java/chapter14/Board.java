package chapter14;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Board
 */
@WebServlet("/chapter14/Board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Post> posts = new ArrayList<>();

		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/post");
			Connection con = ds.getConnection();

			String sql = "select id, name, content, post_date from posts order by post_date desc, id desc";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Post post = new Post(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("content"),
						rs.getTimestamp("post_date"));
				posts.add(post);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			// エラーが発生した場合はリクエスト属性にセットしてJSP側で表示できるようにする
			request.setAttribute("error", e.getMessage());
		}

		// 取得した投稿リストをリクエスト属性に保存
		request.setAttribute("posts", posts);

		// 画面表示の役割を専用のJSPファイルにバトンタッチ（フォワード）
		request.getRequestDispatcher("/chapter14/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/post");
			Connection con = ds.getConnection();

			if ("delete".equals(action)) {
				//削除処理
				String idStr = request.getParameter("id");
				if (idStr != null && !idStr.isEmpty()) {
					int id = Integer.parseInt(idStr);
					String sql = "delete from posts where id = ?";
					PreparedStatement st = con.prepareStatement(sql);
					st.setInt(1, id);
					st.executeUpdate();
					st.close();
				}
			} else {
				//新規投稿処理
				String name = request.getParameter("name");
				String content = request.getParameter("content");

				//入力チェック
				if (name != null && !name.trim().isEmpty() && content != null && !content.trim().isEmpty()) {
					String sql = "insert into posts (name, content) values (?, ?)";
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, name);
					st.setString(2, content);
					st.executeUpdate();
					st.close();
				}
			}
			con.close();
		} catch (Exception e) {
			response.setContentType("text/html; charset=UTF-8");
			e.printStackTrace(response.getWriter());
			return;
		}
		//二重投稿防止リダイレクト
		response.sendRedirect(request.getContextPath() + "/chapter14/Board");
	}
}
