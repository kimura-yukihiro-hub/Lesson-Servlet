package chapter5;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// URLは大文字・小文字を区別するため、画像の設定（Practice04）に合わせます
@WebServlet("/chapter5/Practice04")
public class Practice04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Practice04() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 文末の記号をすべて半角の「;」に修正
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");

		LocalDateTime now = LocalDateTime.now();
		int hour = now.getHour();

		// 挨拶の判定とクォーテーションの修正
		String greeting = "";
		if (hour >= 5 && hour < 12) {
			greeting = "おはようございます。";
		} else if (hour >= 12 && hour < 18) {
			greeting = "こんにちは。";
		} else {
			greeting = "こんばんは。";
		}

		// お題の見本「15時4分」に合わせて「H時m分」に修正（曜日も削除）
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月d日 H時m分 ", Locale.JAPANESE);
		String formattedDateTime = now.format(formatter);

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='UTF-8'><title>Practice04</title></head>");
		out.println("<body>");
		out.println("<p>" + formattedDateTime + greeting + "</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
