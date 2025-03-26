package edu.ssafy.repository;

import java.util.List;

import edu.ssafy.dto.MemberDto;
import edu.ssafy.dto.SearchCondition;

public interface MemberRepository {
	int MemberInsert(MemberDto m) throws Exception;

	int MemberUpdate(MemberDto m) throws Exception;

	int MemberDelete(String id) throws Exception;

	List<MemberDto> MemberSelectAll() throws Exception;

	MemberDto MemberSelect(String id) throws Exception;

	int getTotalCount(SearchCondition condition) throws Exception;

	List<MemberDto> search(SearchCondition condition) throws Exception;
}
