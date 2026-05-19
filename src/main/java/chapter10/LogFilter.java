package chapter10;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Servlet implementation class LogFilter
 */
@WebFilter("/*")
public class LogFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String uri = httpRequest.getRequestURI();
		System.out.println("[LOG]アクセスURL:" + uri);

		chain.doFilter(request, response);

	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}
}

