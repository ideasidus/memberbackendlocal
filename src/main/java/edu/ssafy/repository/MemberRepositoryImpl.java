package edu.ssafy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ssafy.dto.MemberDto;
import edu.ssafy.etc.DBUtil;

/*
 * 여기에선 connection을 열고 닫아야 하지만, BoardRepo에서는 그렇지 않다.
 * BoardRepo 에서는 try-with-resource 구문을 사용하기 때문!!
 * 그렇다면 try-with-resource 구문은 close()를 오버라이딩 하는 등의 제약이 있을까?
 * 찾아보니 AutoClosable을 구현해야 하는 것 같다. close를 무조건 구현해야 하는 인터페이스~!
 */
public class MemberRepositoryImpl implements MemberRepository {
	private static MemberRepositoryImpl dao = new MemberRepositoryImpl();
	private static DBUtil dbUtil = DBUtil.getUtil();

	private MemberRepositoryImpl() {

	}

	public static MemberRepositoryImpl getDao() {
		return dao;
	}

	@Override
	public int MemberInsert(MemberDto m) throws SQLException {
		Connection connection = dbUtil.getConnection();
		String sql = "insert into member(id, pw, name) values(?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, m.getId());
		pstmt.setString(2, m.getPw());
		pstmt.setString(3, m.getName());

		int res = pstmt.executeUpdate();
		dbUtil.close(pstmt);
		dbUtil.close(connection);
		return res;
	}

	@Override
	public int MemberUpdate(MemberDto m) throws SQLException {
		Connection connection = dbUtil.getConnection();
		String sql = "update member set  pw = ? , name = ? where  id = ? ";
		PreparedStatement pstmt = connection.prepareStatement(sql);

		pstmt.setString(1, m.getPw());
		pstmt.setString(2, m.getName());
		pstmt.setString(3, m.getId());

		int res = pstmt.executeUpdate();
		dbUtil.close(pstmt);
		dbUtil.close(connection);
		return res;
	}

	@Override
	public int MemberDelete(String id) throws SQLException {
		Connection connection = dbUtil.getConnection();
		String sql = "delete from member where id = ? ";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, id);

		int res = pstmt.executeUpdate();
		dbUtil.close(pstmt);
		dbUtil.close(connection);

		return res;
	}

	@Override
	public List<MemberDto> MemberSelectAll() throws SQLException {
		Connection connection = dbUtil.getConnection();
		String sql = "select id, pw, name from member ";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<MemberDto> list = new ArrayList<>();
		while (rs.next()) {
			MemberDto dto = new MemberDto(rs.getString("id"), rs.getString("pw"), rs.getString("name"));
			list.add(dto);
		}
		dbUtil.close(connection);
		return list;
	}

	@Override
	public MemberDto MemberSelect(String id) throws SQLException {
		Connection connection = dbUtil.getConnection();
		String sql = "select id, pw, name from member where id = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		MemberDto dto = null;
		if (rs.next()) {
			dto = new MemberDto(rs.getString("id"), rs.getString("pw"), rs.getString("name"));
		}
		dbUtil.close(connection);
		return dto;
	}

}
