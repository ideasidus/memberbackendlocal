package edu.ssafy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import edu.ssafy.dto.BoardDto;
import edu.ssafy.etc.DBUtil;

/*
 * 
 * 그냥 Connection을 사용하는 코드에서 DataSource를 사용하는 Connection Pool 코드로 바꾸자 에러 발생 -> 잘 찾아 봅시다 어떻게 해야하나
 * 실습 코드를 확인하니 repoImpl도 Singleton으로 구현 돼 있네용~ 바꿔 봅시다.
 * 현재 코드는 connection을 지금 그냥 Repository에서 할당하는데, 실습 코드는 Service에서 하는 것 같습니다.
 * 베스트 프렉티스를 찾아보니 Service에서 관리하는게 맞는 것 같습니다.
 * 그래야지 여러개의 Dao 메서드를 한 트랜젝션으로 만들어 관리 할 수 있습니다.
 * 일단은 그냥 생성자에서 가지고 있는걸로...? ㅎㅎ
 */
public class BoardRepositoryImpl implements BoardRepository {
	private static BoardRepositoryImpl dao = new BoardRepositoryImpl();
	private static DBUtil dbUtil = DBUtil.getUtil();

	private BoardRepositoryImpl() {

	}

	public static BoardRepositoryImpl getDao() {
		return dao;
	}

	@Override
	public int BoardInsert(BoardDto b) throws SQLException {
		try (Connection connection = dbUtil.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(
						"INSERT INTO board (title, content, registid, registdate) VALUES (?, ?, ?, ?)")) {
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setString(3, b.getRegistId());
			pstmt.setTimestamp(4, Timestamp.valueOf(b.getRegistDate()));
			return pstmt.executeUpdate();
		}
	}

	@Override
	public int BoardUpdate(BoardDto b) throws SQLException {
		try (Connection connection = dbUtil.getConnection();
				PreparedStatement pstmt = connection
						.prepareStatement("UPDATE board SET title = ?, content = ?, registdate = ? WHERE id = ?")) {
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setTimestamp(3, Timestamp.valueOf(b.getRegistDate()));
			pstmt.setInt(4, b.getId());
			return pstmt.executeUpdate();
		}
	}

	@Override
	public int BoardDelete(String id) throws SQLException {
		try (Connection connection = dbUtil.getConnection();
				PreparedStatement pstmt = connection.prepareStatement("DELETE FROM board WHERE id = ?")) {
			pstmt.setInt(1, Integer.parseInt(id));
			return pstmt.executeUpdate();
		} catch (NumberFormatException e) {
			throw new SQLException("Invalid board ID: " + id, e);
		}
	}

	@Override
	public List<BoardDto> BoardSelectAll() throws SQLException {
		try (Connection connection = dbUtil.getConnection();
				PreparedStatement pstmt = connection
						.prepareStatement("SELECT id, title, content, registid, registdate FROM board");
				ResultSet rs = pstmt.executeQuery()) {
			List<BoardDto> list = new ArrayList<>();
			while (rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegistId(rs.getString("registid"));
				dto.setRegistDate(rs.getTimestamp("registdate").toLocalDateTime());
				list.add(dto);
			}
			return list;
		}
	}

	@Override
	public BoardDto BoardSelect(String id) throws SQLException {
		try (Connection connection = dbUtil.getConnection();
				PreparedStatement pstmt = connection
						.prepareStatement("SELECT id, title, content, registid, registdate FROM board WHERE id = ?");) {
			pstmt.setInt(1, Integer.parseInt(id));
			try (ResultSet rs = pstmt.executeQuery()) {
				BoardDto dto = null;
				if (rs.next()) {
					dto = new BoardDto();
					dto.setId(rs.getInt("id"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setRegistId(rs.getString("registid"));
					dto.setRegistDate(rs.getTimestamp("registdate").toLocalDateTime());
				}
				return dto;
			}
		} catch (NumberFormatException e) {
			throw new SQLException("Invalid board ID: " + id, e);
		}
	}
}
