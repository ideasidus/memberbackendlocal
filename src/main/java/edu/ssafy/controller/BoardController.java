package edu.ssafy.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import edu.ssafy.dto.BoardDto;
import edu.ssafy.service.BoardService;
import edu.ssafy.service.BoardServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private BoardService service;

	@Override
	public void init() throws ServletException {
		super.init();
		service = new BoardServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String action = req.getParameter("action");
		String url = new String();
		try {
			if (action == null || action.isBlank()) {
				url = "index.html";
			} else {
				if (action.equals("/")) {

				} else if (action.equals("boardinsert")) {
					url = boardInsert(req, resp);
				} else if (action.equals("boardupdate")) {
					url = boardUpdate(req, resp);
				} else if (action.equals("boarddelete")) {
					url = boardDelete(req, resp);
				} else if (action.equals("boardselectall")) {
					url = boardSelectAll(req, resp);
				} else if (action.equals("boardselect")) {
					url = boardSelect(req, resp);
				}
			}

		} catch (Exception e) {
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

	private String boardSelectAll(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("select All");
		// 1. 파라미터 처리

		// 2. 로직처리
		List<BoardDto> list = service.BoardSelectAll();

		// 3. 화면처리

		req.setAttribute("list", list);
		return "/board/selectboard.jsp";
	}

	private String boardInsert(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 1. 파라미터 처리
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String registId = req.getParameter("registId");
		LocalDateTime registDate = LocalDateTime.now();
		// 2. 로직처리
		int res = service.BoardInsert(new BoardDto(0, title, content, registId, registDate));
		// 3. 화면처리
		return "redirect:/board?action=boardselectall";
	}

	private String boardSelect(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 1. 파라미터 처리
		System.out.println("id :" + req.getParameter("id"));
		String id = req.getParameter("id");
		// 2. 로직처리
		BoardDto write = service.BoardSelect(id);

		// 3. 화면처리
		req.setAttribute("write", write);

		return "/board/detailboard.jsp";
	}

	private String boardDelete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 1. 파라미터 처리
		String id = req.getParameter("id");
		// 2. 로직처리
		int res = service.BoardDelete(id);
		// 3. 화면처리

		return "redirect:/board?action=boardselectall";
	}

	private String boardUpdate(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 1. 파라미터 처리
		BoardDto m = new BoardDto(Integer.parseInt(req.getParameter("id")), req.getParameter("title"),
				req.getParameter("content"), req.getParameter("registId"), LocalDateTime.now());
		// 2. 로직처리
		service.BoardUpdate(m);
		// 3. 화면처리

		return "redirect:/board?action=boardselectall";
	}

}
