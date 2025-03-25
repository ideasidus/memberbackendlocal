package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.BoardDto;
import edu.ssafy.repository.BoardRepository;
import edu.ssafy.repository.BoardRepositoryImpl;

public class BoardServiceImpl implements BoardService {
	BoardRepository repo;

	public BoardServiceImpl() {
		repo = BoardRepositoryImpl.getDao();
	}

	@Override
	public int BoardInsert(BoardDto b) throws Exception {
		return repo.BoardInsert(b);
	}

	@Override
	public int BoardUpdate(BoardDto b) throws Exception {
		return repo.BoardUpdate(b);
	}

	@Override
	public int BoardDelete(String id) throws Exception {
		return repo.BoardDelete(id);
	}

	@Override
	public List<BoardDto> BoardSelectAll() throws Exception {
		return repo.BoardSelectAll();
	}

	@Override
	public BoardDto BoardSelect(String id) throws Exception {
		return repo.BoardSelect(id);
	}

}
