package edu.ssafy.repository;

import java.util.List;

import edu.ssafy.dto.BoardDto;

public interface BoardRepository {
	int BoardInsert(BoardDto b) throws Exception;

	int BoardUpdate(BoardDto b) throws Exception;

	int BoardDelete(String id) throws Exception;

	List<BoardDto> BoardSelectAll() throws Exception;

	BoardDto BoardSelect(String id) throws Exception;
}
