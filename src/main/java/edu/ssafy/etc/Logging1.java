package edu.ssafy.etc;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class Logging1
 */
@WebFilter("/*")
public class Logging1 extends HttpFilter implements Filter {

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public Logging1() {
		super();
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		System.out.println("logging1 req");
		System.out.println("호출 된 Application : " + request.getServletContext().getContextPath());
		String actionStr = request.getParameter("action");
		System.out.println("Action : " + (actionStr == null ? "No Action" : actionStr));

		Map<String, String[]> paramMap = request.getParameterMap();
		String params = paramMap.entrySet().stream()
				.map(entry -> entry.getKey() + ": " + Arrays.toString(entry.getValue()))
				.collect(Collectors.joining(",", "{", "}"));
		System.out.println("params : " + params);
		System.out.println("================================");

		chain.doFilter(request, response);
//		System.out.println("logging1 resp");

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
