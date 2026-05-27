package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.dao.TweetDAO;

@WebServlet("/new_tweet")
public class NewTweetServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String content = request.getParameter("content");
		String author = request.getParameter("author");

		HttpSession session = request.getSession();
		
		if (author == null || author.length() >255) {
			session.setAttribute("message", "投稿に失敗しました。投稿者名は255文字以内で入力してください。");
			session.setAttribute("messageType", "error");
			
			response.sendRedirect("tweet_list");
			return;
		}

		TweetDAO tweetDAO = new TweetDAO();
		try {
			tweetDAO.addTweet(content, author);
			session.setAttribute("message", "ツイートを投稿しました。");
			session.setAttribute("messageType", "success");
			
		} catch (Exception e) {
			session.setAttribute("message", "エラーにより投稿に失敗しました。");
			session.setAttribute("messageType", "error");
			e.printStackTrace();
		}

		response.sendRedirect("tweet_list");
	}
}
