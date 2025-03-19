package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.MemberDto;
import edu.ssafy.repository.MemberRepository;
import edu.ssafy.repository.MemberRepositoryImpl;

public class MemberServiceImpl implements MemberService {
	private MemberRepository repository;

	public MemberServiceImpl() {
		repository = new MemberRepositoryImpl();
	}

	@Override
	public int MemberInsert(MemberDto m) throws Exception {
		return repository.MemberInsert(m);
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
		return repository.MemberSelectAll();
	}

	@Override
	public MemberDto MemberSelect(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
