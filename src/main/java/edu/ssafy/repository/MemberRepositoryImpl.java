package edu.ssafy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.ssafy.dto.MemberDto;
import edu.ssafy.etc.DBUtil;

public class MemberRepositoryImpl implements MemberRepository {

	@Override
	public int MemberInsert(MemberDto m) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO member (id, pw, name) VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPw());
			pstmt.setString(3, m.getName());

			return pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}

	@Override
	public int MemberUpdate(MemberDto m) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int MemberUpdate(String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberDto> MemberSelectAll() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberDto> memberList = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT id, pw, name FROM member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberDto member = new MemberDto(rs.getString("id"), rs.getString("pw"), rs.getString("name"));
				memberList.add(member);
			}

			return memberList;
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
	}

	@Override
	public MemberDto MemberSelect(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
