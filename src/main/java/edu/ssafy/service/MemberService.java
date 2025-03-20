package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.MemberDto;

public interface MemberService {
	int MemberInsert(MemberDto m)  throws Exception;
	int MemberUpdate(MemberDto m)  throws Exception;
	int MemberDelete(String id)  throws Exception;
	List<MemberDto> MemberSelectAll()  throws Exception;
	MemberDto MemberSelect(String id)  throws Exception;
	int MemberDeletes(String[] ids)  throws Exception;
}
