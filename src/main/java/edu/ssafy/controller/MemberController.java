package edu.ssafy.controller;

import java.io.IOException;
import java.util.List;

import edu.ssafy.dto.MemberDto;
import edu.ssafy.service.MemberService;
import edu.ssafy.service.MemberServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private MemberService service;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		service = new MemberServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String action = req.getParameter("action");
		String url = new String();
		try {
			if (action == null && action.isBlank()) {
				url = "index.html";
			} else {
				if (action.equals("/")) {

				} else if (action.equals("memberinsert")) {
					url = memberInsert(req, resp);
				} else if (action.equals("memberupdate")) {
					url = memberUpdate(req, resp);
				} else if (action.equals("memberdelete")) {
					url = memberDelete(req, resp);
				} else if (action.equals("memberselectall")) {
					url = memberSelectAll(req, resp);
				} else if (action.equals("memberselect")) {
					url = memberSelect(req, resp);
				} else if (action.equals("delids")) {
					url = memberDeleteS(req, resp);
				} else if (action.equals("login")) {
					url = login(req, resp);
				} else if (action.equals("logout")) {
					url = logout(req, resp);
				}
			}

		} catch (Exception e) {
//			StringBuilder sb = new StringBuilder();
//			sb.append("문제가 발생했습니다");
//			sb.append(e.toString());
//			resp.getWriter().write(sb.toString());;
			req.setAttribute("errMsg", e.getMessage());
			url = "/error/error.jsp";
		}

		if (url.startsWith("redirect")) {
			url = url.substring(url.indexOf(":") + 1);
			resp.sendRedirect(req.getContextPath() + url);
		} else {
			req.getRequestDispatcher(url).forward(req, resp);
		}

	}

	private String logout(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().invalidate();
		return "redirect:/index.jsp";
	}

	private String login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String idsave = req.getParameter("idsave");
		System.out.println(idsave);
		if (idsave != null) {
			Cookie cookie = new Cookie("idsave", id);
			cookie.setMaxAge(60 * 60 * 10);
			cookie.setPath("/");
			resp.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("idsave", "");
			cookie.setMaxAge(0);
			cookie.setPath("/");
			resp.addCookie(cookie);
		}

		MemberDto loginedMember = service.login(id, pw);
		HttpSession session = req.getSession();
		session.setAttribute("loginedMember", loginedMember);
		if (loginedMember != null) {
			return "redirect:/index.jsp";
		}
		req.setAttribute("resMsg", "로그인 실패");
		return "/member/result.jsp";
	}

	private String memberDeleteS(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String[] delids = req.getParameterValues("delids");
		service.MemberDeletes(delids);
		return "redirect:/member?action=memberselectall";
	}

	private String memberSelectAll(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("select All");
		// 1. 파라미터 처리

		// 2. 로직처리
		List<MemberDto> list = service.MemberSelectAll();

		// 3. 화면처리
//		StringBuilder html = new StringBuilder();
//		for (MemberDto m : list) {
//			html.append("id : "+m.getId() + " , " + "pw : "+m.getPw() + " , " + "name : "+m.getName()+"<br/>");
//		}
//		
//		resp.setContentType("text/html; charset=utf-8");
//		resp.getWriter().write(html.toString());

		req.setAttribute("list", list);
		// req.getRequestDispatcher("/member/selectmember.jsp").forward(req, resp);
		return "/member/selectmember.jsp";
	}

	private String memberInsert(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		// 1. 파라미터 처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		// 2. 로직처리
		int res = service.MemberInsert(new MemberDto(id, pw, name));
		// 3. 화면처리
//		String html = """
//				회원이 잘 입력되었습니다
//				""";
//		resp.setContentType("text/html; charset=utf-8");
//		resp.getWriter().write(html);
//		req.setAttribute("resMsg", "회원입력이 성공했습니다");
//		req.getRequestDispatcher("/member/result.jsp").forward(req, resp);

		// String contextpath = req.getContextPath();
		// resp.sendRedirect(contextpath+"/member?action=memberselectall");

		return "redirect:/member?action=memberselectall";
	}

	private String memberSelect(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 1. 파라미터 처리
		System.out.println("id :" + req.getParameter("id"));
		String id = req.getParameter("id");
		// 2. 로직처리
		MemberDto mem = service.MemberSelect(id);

		// 3. 화면처리
		req.setAttribute("mem", mem);

		return "/member/detailmember.jsp";
	}

	private String memberDelete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 1. 파라미터 처리
		String id = req.getParameter("id");
		// 2. 로직처리
		int res = service.MemberDelete(id);
		// 3. 화면처리

		return "redirect:/member?action=memberselectall";
	}

	private String memberUpdate(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 1. 파라미터 처리
		MemberDto m = new MemberDto(req.getParameter("id"), req.getParameter("pw"), req.getParameter("name"));
		// 2. 로직처리
		service.MemberUpdate(m);
		// 3. 화면처리

		return "redirect:/member?action=memberselectall";
	}

}
