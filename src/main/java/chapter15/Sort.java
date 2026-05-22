package chapter15;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;

@WebServlet("/chapter15/Sort")
public class Sort extends HttpServlet {
	private static final long serialVersionUID = 10L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String sortOrder = request.getParameter("sort");

			ProductDAO dao = new ProductDAO();
			List<Product> list = dao.searchAndSort(sortOrder);

			request.setAttribute("list", list);

			request.getRequestDispatcher("sort-output.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
