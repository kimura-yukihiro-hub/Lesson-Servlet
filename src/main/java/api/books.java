package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class books
 */
@WebServlet("/api/books")
public class books extends HttpServlet {
	private List<String> bookList;

	public void init() throws ServletException {
		bookList = new ArrayList<>();
		bookList.add("Javaプログラミング基礎");
		bookList.add("サーブレット・JSP入門");
		bookList.add("web API設計の教科書");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		String titleParam = request.getParameter("title");

		if (titleParam == null || titleParam.trim().isEmpty()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().println("<h1>エラー(400)</h1>");
			response.getWriter().println("<p>検索キーワード(title)を指定してください。</p>");
			return;
		}

		List<String> results = new ArrayList<>();
		for (String book : bookList) {
			if (book.contains(titleParam)) {
				results.add(book);
			}
		}

		StringBuilder html = new StringBuilder();
		html.append("<h1>検索結果</h1>");
		if (results.isEmpty()) {
			html.append("<p>該当する本が見つかりませんでした。</p>");
		} else {
			html.append("<ul>");
			for (String book : results) {
				html.append("<li>").append(book).append("</li>");
			}
			html.append("</ul>");
		}

		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println(html.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8");

		StringBuilder body = new StringBuilder();
		try (BufferedReader reader = request.getReader()) {
			String line;
			while ((line = reader.readLine()) != null) {
				body.append(line);
			}
		}

		String requestBodyStr = body.toString().trim();

		if (requestBodyStr.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().println("<h1>エラー (400)</h1>");
			response.getWriter().println("<p>リクエストボディが空です。</p>");
			return;

		}

		bookList.add(requestBodyStr);

		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println("<h1>登録完了</h1>");
		response.getWriter().println("<p>『" + requestBodyStr + "』の登録が完了しました。</p>");
	}

}
