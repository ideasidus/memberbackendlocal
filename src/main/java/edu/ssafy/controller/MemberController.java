package edu.ssafy.controller;

import java.io.IOException;
import java.util.List;

import edu.ssafy.dto.MemberDto;
import edu.ssafy.service.MemberService;
import edu.ssafy.service.MemberServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private MemberService service;

	@Override
	public void init() throws ServletException {
		super.init();
		service = new MemberServiceImpl();
		System.out.println("init");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");
		proccess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");
		proccess(req, resp);
	}

	private void proccess(HttpServletRequest req, HttpServletResponse resp) {
//		req.getRequestURL(); // 전체경로 http://ip:port/contextpath/servlet/servlet/servlet...
//		req.getRequestURI(); // contextpath 부터 나온다 contextpath/servlet/servlet/servlet...
//		req.getServletContext(); // servlet/servlet/servlet...
//		req.getContextPath(); // contextpath

		String action = req.getParameter("action");
		String url = new String();
		if (action == null || action.isBlank()) {
			url = "index.html";
		} else {
			if (action.equals("memberinsert")) {
				url = memberInsert(req, resp);
			} else if (action.equals("memberupdate")) {
				url = memberUpdate(req, resp);
			} else if (action.equals("memberdelete")) {
				url = memberDelete(req, resp);
			} else if (action.equals("memberselectall")) {
				url = memberSelectAll(req, resp);
			} else if (action.equals("memberselect")) {
				url = memberSelect(req, resp);
			}
		}
	}

	private String memberSelect(HttpServletRequest req, HttpServletResponse resp) {
		// 1. 파라미터 처리
		// 2. 로직처리
		// 3. 화면 처리
		return null;
	}

	private String memberSelectAll(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// 1. 파라미터 처리 - 필요 없음

			// 2. 로직처리
			List<MemberDto> memberList = service.MemberSelectAll();
			req.setAttribute("memberList", memberList);

			// 3. 화면 처리
			String html = """
					<h2>회원 목록</h2>
					<table>
					<tr><th>ID</th><th>PW</th><th>이름</th></tr>
					""";

			for (MemberDto member : memberList) {
				html = html.concat("<tr>");
				html = html.concat("<td>" + member.getId() + "</td>");
				html = html.concat("<td>" + member.getPw() + "</td>");
				html = html.concat("<td>" + member.getName() + "</td>");
				html = html.concat("</tr>");
			}

			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().append(html);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String memberDelete(HttpServletRequest req, HttpServletResponse resp) {
		// 1. 파라미터 처리
		// 2. 로직처리
		// 3. 화면 처리
		return null;
	}

	private String memberUpdate(HttpServletRequest req, HttpServletResponse resp) {
		// 1. 파라미터 처리
		// 2. 로직처리
		// 3. 화면 처리
		return null;
	}

	private String memberInsert(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// 1. 파라미터 처리
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String name = req.getParameter("name");

			// 2. 로직처리
			MemberDto memberDto = new MemberDto(id, pw, name);
			service.MemberInsert(memberDto);

			// 3. 화면 처리
			String html = """
					<h2>회원 추가가 완료 되었습니다</h2>
					""";
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().append(html);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}