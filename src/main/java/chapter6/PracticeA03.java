package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PracticeA03
 */
@WebServlet("/chapter6/PracticeA03")
public class PracticeA03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PracticeA03() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String[] comments = request.getParameterValues("comment");

		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>アンケート結果</title></head><body>");
			out.println("<h2>あなたのコメント一覧</h2>");

			boolean hasValidComment = false;

			if (comments != null && comments.length > 0) {
				out.println("<ul>");
				for (String comment : comments) {
					if (comment != null && !comment.trim().isEmpty()) {
						out.println("<li>" + comment + "</li>");
						hasValidComment = true;
					}
				}
				out.println("</ul>");

			}
			if (!hasValidComment) {
				out.println("<p>コメントがありませんでした。</p>");
			}
			out.println("<p><a href='javascript:history.back()'>戻る</a></p>");
			out.println("</body></html>");
		}

	}
}
