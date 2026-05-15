package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Practice03
 */
@WebServlet("/chapter5/Practice03")
public class Practice03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Practice03() {
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
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String ageStr = request.getParameter("age");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='UTF-8'><title>Practice03</title></head>");
		out.println("<body>");

		try {
			int age = Integer.parseInt(ageStr);

			if (age < 18) {
				out.println("<p>こんにちは、" + user + "さん。未成年ですね。</p>");

			} else {
				out.println("<p>こんにちは、" + user + "さん。大人ですね。</p>");
			}
		} catch (NumberFormatException e) {
			out.println("<p>年齢は数値で入力してください。</p>");
		}

		out.println("</body>");
		out.println("</html>");
	}

}
