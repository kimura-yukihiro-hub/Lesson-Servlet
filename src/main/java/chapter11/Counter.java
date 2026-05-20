package chapter11;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Counter
 */
@WebServlet("/chapter11/Counter")
public class Counter extends HttpServlet {
	private AtomicInteger counter;

	public void init() throws ServletException {
		counter = new AtomicInteger(0);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int currentCount = counter.incrementAndGet();

		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<h1>現在のカウント:" + currentCount + "</h1>");

	}

	public void destroy() {
		getServletContext().log("サーブレット停止時の最終カウント値:" + counter.get());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
