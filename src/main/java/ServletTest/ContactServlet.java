package ServletTest;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String user = request.getParameter("user");
		String company = request.getParameter("company");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		String[] news = request.getParameterValues("news");
		String req = request.getParameter("req");

		request.setAttribute("user", user);
		request.setAttribute("company", company);
		request.setAttribute("email", email);
		request.setAttribute("message", message);
		request.setAttribute("news", news);
		request.setAttribute("req", req);

		if (user == null || user.trim().isEmpty() ||
				email == null || email.trim().isEmpty() ||
				message == null || message.trim().isEmpty()) {

			request.setAttribute("error", "氏名、メールアドレス、お問合せ内容は必須項目です。");
			request.getRequestDispatcher("form.jsp").forward(request, response);
			return;
		}

		if ("Yes".equals(req)) {
			request.getRequestDispatcher("download.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("contact-out.jsp").forward(request, response);
		}
	}
}
