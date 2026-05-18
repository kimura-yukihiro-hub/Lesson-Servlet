package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PracticeA02
 */
@WebServlet("/chapter5/PracticeA02")
public class PracticeA02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PracticeA02() {
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

		// 2. HTMLのラジオボタン（name="color"）から値を取得
		String color = request.getParameter("color");
		if (color == null) {
			color = ""; // 未選択時のエラー防止
		}

		// 3. 画像の条件表に合わせた変数（背景色とメッセージ）の準備
		String bgColor = "white";
		String message = "選択された色は未対応です。";

		// 4. 送信された色に応じた条件分岐
		switch (color) {
		case "red":
			bgColor = "red";
			message = "赤は情熱の色です。";
			break;
		case "blue":
			bgColor = "blue";
			message = "青は冷静さと信頼を表します。";
			break;
		case "yellow":
			bgColor = "yellow";
			message = "黄色は元気と希望の色です。";
			break;
		case "green":
			bgColor = "green";
			message = "緑は自然や安心感を連想させます。";
			break;
		}

		// 5. 画面（HTML）の出力
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>背景色を変更するサーブレット</title>");
			out.println("</head>");
			// 決定した背景色を反映
			out.println("<body style='background-color: " + bgColor + ";'>");

			// 見本画面に合わせた文字表示
			out.println("<h2>色が選択されました</h2>");
			out.println("<p>" + message + "</p>");

			out.println("</body>");
			out.println("</html>");
		}
	}
}
