package edu.ssafy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.ssafy.dto.BoardDto;
import edu.ssafy.etc.DBUtil;

public class BoardRepositoryImpl implements BoardRepository {

	@Override
	public int BoardInsert(BoardDto b) throws SQLException {
		try (Connection connection = DBUtil.getConnection();
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
		try (Connection connection = DBUtil.getConnection();
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
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement pstmt = connection.prepareStatement("DELETE FROM board WHERE id = ?")) {
			pstmt.setInt(1, Integer.parseInt(id));
			return pstmt.executeUpdate();
		} catch (NumberFormatException e) {
			throw new SQLException("Invalid board ID: " + id, e);
		}
	}

	@Override
	public List<BoardDto> BoardSelectAll() throws SQLException {
		try (Connection connection = DBUtil.getConnection();
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
		try (Connection connection = DBUtil.getConnection();
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
