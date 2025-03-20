package edu.ssafy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ssafy.dto.MemberDto;
import edu.ssafy.etc.DBUtil;

public class MemberRepositoryImpl implements MemberRepository{

	@Override
	public int MemberInsert(MemberDto m) throws SQLException {
		Connection connection = DBUtil.getConnection();
		String sql = "insert into member(id, pw, name) values(?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, m.getId());
		pstmt.setString(2, m.getPw());
		pstmt.setString(3, m.getName());
		
		int res = pstmt.executeUpdate();
		DBUtil.close(pstmt);
		DBUtil.close(connection);
		return res;
	}

	@Override
	public int MemberUpdate(MemberDto m) throws SQLException{
		Connection connection = DBUtil.getConnection();
		String sql = "update member set  pw = ? , name = ? where  id = ? ";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		pstmt.setString(1, m.getPw());
		pstmt.setString(2, m.getName());
		pstmt.setString(3, m.getId());
		
		int res = pstmt.executeUpdate();
		DBUtil.close(pstmt);
		DBUtil.close(connection);
		return res;
	}

	@Override
	public int MemberDelete(String id) throws SQLException{
		Connection connection = DBUtil.getConnection();
		String sql = "delete from member where id = ? ";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, id);
		
		int res = pstmt.executeUpdate();
		DBUtil.close(pstmt);
		DBUtil.close(connection);
		
		return res;
	}

	@Override
	public List<MemberDto> MemberSelectAll() throws SQLException {
		Connection connection = DBUtil.getConnection();
		String sql = "select id, pw, name from member ";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<MemberDto> list = new ArrayList<>();
		while(rs.next()) {
			MemberDto dto = new MemberDto(rs.getString("id"),rs.getString("pw"),rs.getString("name") );
			list.add(dto);
		}
		DBUtil.close(connection);
		return list;
	}

	@Override
	public MemberDto MemberSelect(String id) throws SQLException{
		Connection connection = DBUtil.getConnection();
		String sql = "select id, pw, name from member where id = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		MemberDto dto = null;
		if(rs.next()) {
			dto = new MemberDto(rs.getString("id"),rs.getString("pw"),rs.getString("name") );
		}
		DBUtil.close(connection);
		return dto;
	}

}
