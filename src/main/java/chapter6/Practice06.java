package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Practice06
 */
@WebServlet("/chapter6/Practice06")
public class Practice06 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Practice06() {
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

		String[] menus = request.getParameterValues("menu");

		try (PrintWriter out = response.getWriter()) {

			if (menus == null || menus.length == 0) {
				out.println("サイドメニューなしでご提供します。<br>");

			} else {
				out.println("以下のサイドメニューを追加しました：<br><br>");

				int total = 0;
				boolean hasSalad = false;
				boolean hasSoup = false;
				;

				for (String menu : menus) {
					int price = 0;

					if ("サラダ".equals(menu)) {
						price = 300;
						hasSalad = true;
					} else if ("スープ".equals(menu)) {
						price = 250;
						hasSoup = true;
					} else if ("デザート".equals(menu)) {
						price = 400;
					} else if ("ドリンク".equals(menu)) {
						price = 200;
					}
					total += price;
					out.println("・" + menu + " (" + price + "円)<br>");
				}
				out.println("<br>");

				if (hasSalad && hasSoup) {
					total -= 50;
					out.println("★サラダ＆スープセット割引が適用されました！(-50円)<br><br>");
				}
				out.println("------------------------------------<br>");
				out.println("サイドメニュー合計金額: <strong>" + total + "円</strong><br>");
			}
		}
	}

}
