package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PracticeA04
 */
@WebServlet("/chapter6/PracticeA04")
public class PracticeA04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PracticeA04() {
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

		String destination = request.getParameter("destination");
		String daysStr = request.getParameter("days");
		String transport = request.getParameter("transport");
		String campaign = request.getParameter("campaign");

		if (destination == null)
			destination = "";
		if (daysStr == null)
			daysStr = "0";
		if (transport == null)
			transport = "";
		if (campaign == null)
			campaign = "";

		StringBuilder errorMsg = new StringBuilder();

		if (destination.isEmpty()) {
			errorMsg.append("・行き先を入力してください。<br>");
		} else if (destination.length() >= 50) {
			errorMsg.append("・行き先は50文字未満で入力してください。<br>");
		}

		int days = 0;
		try {
			days = Integer.parseInt(daysStr);
			if (days < 1 || days > 30) {
				errorMsg.append("・日数は1〜30日の間で入力してください。<br>");
			}
		} catch (NumberFormatException e) {
			errorMsg.append("・日数に正しい数値を入力してください。<br>");
		}
		if (!"spring2025".equals(campaign)) {
			errorMsg.append("・不正なキャンペーンコードです。<br>");
		}

		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>予約結果</title></head><body>");

			if (errorMsg.length() > 0) {
				out.println("<h2 style='color: red;'>入力エラーがあります</h2>");
				out.println("<p>" + errorMsg.toString() + "</p>");
				out.println("<p><a href='javascript:history.back()'>戻る</a></p>");
			} else {
				String safeDestination = escapeHtml(destination);
				String safeTransport = escapeHtml(transport);

				out.println("<h2>予約が完了しました</h2>");
				out.println("「" + safeDestination + "」への旅行を" + days + "日間、交通手段は「" + safeTransport + "」で予約しました。<br>");
				out.println("春のキャンペーンを適用しました。");
			}

			out.println("</body></html>");

		}

	}

	private String escapeHtml(String str) {
		if (str == null)
			return "";
		return str.replace("&", "&amp;")
				.replace("<", "&lt;")
				.replace(">", "&gt;")
				.replace("\"", "&quot;")
				.replace("'", "&#39;");
	}
}
