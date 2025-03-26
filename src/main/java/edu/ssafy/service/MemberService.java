package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.MemberDto;
import edu.ssafy.dto.Page;
import edu.ssafy.dto.SearchCondition;

public interface MemberService {
	int MemberInsert(MemberDto m) throws Exception;

	int MemberUpdate(MemberDto m) throws Exception;

	int MemberDelete(String id) throws Exception;

	List<MemberDto> MemberSelectAll() throws Exception;

	MemberDto MemberSelect(String id) throws Exception;

	int MemberDeletes(String[] ids) throws Exception;

	MemberDto login(String id, String pw) throws Exception;

	Page<MemberDto> search(SearchCondition condition) throws Exception;
}
