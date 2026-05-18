package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Practice05
 */
@WebServlet("/chapter6/Practice05")
public class Practice05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Practice05() {
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
		String days = request.getParameter("days");
		String transport = request.getParameter("transport");
		String campaign = request.getParameter("campaign");

		if (destination == null)
			destination = "";
		if (days == null)
			days = "0";
		if (transport == null)
			transport = "";

		String campaignMessage = "";
		if (campaign != null && campaign.equals("spring2025")) {
			campaignMessage = "春のキャンペーンを適用しました。";
		} else {
			campaignMessage = "キャンペーンは適用されません。";
		}

		try (PrintWriter out = response.getWriter()) {
			out.println("「" + destination + "」への旅行を" + days + "日間、交通手段は「" + transport + "」で予約しました。<br>");
			out.println(campaignMessage);
		}

	}

}
