package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.MemberDto;
import edu.ssafy.dto.Page;
import edu.ssafy.dto.SearchCondition;
import edu.ssafy.repository.MemberRepository;
import edu.ssafy.repository.MemberRepositoryImpl;

public class MemberServiceImpl implements MemberService {
	MemberRepository repo;

	public MemberServiceImpl() {
		repo = MemberRepositoryImpl.getDao();
	}

	@Override
	public int MemberInsert(MemberDto m) throws Exception {
		// TODO Auto-generated method stub
		return repo.MemberInsert(m);
	}

	@Override
	public int MemberUpdate(MemberDto m) throws Exception {
		// TODO Auto-generated method stub
		return repo.MemberUpdate(m);
	}

	@Override
	public int MemberDelete(String id) throws Exception {
		// TODO Auto-generated method stub
		return repo.MemberDelete(id);
	}

	@Override
	public List<MemberDto> MemberSelectAll() throws Exception {
		// TODO Auto-generated method stub
		return repo.MemberSelectAll();
	}

	@Override
	public MemberDto MemberSelect(String id) throws Exception {
		// TODO Auto-generated method stub
		return repo.MemberSelect(id);
	}

	@Override
	public int MemberDeletes(String[] ids) throws Exception {
		int cnt = 0;
		for (String id : ids) {
			cnt += repo.MemberDelete(id);
		}
		return cnt;
	}

	@Override
	public MemberDto login(String id, String pw) throws Exception {
		MemberDto dto = this.MemberSelect(id);
		if (dto != null && dto.getPw().equals(pw)) {
			return dto;
		}
		return null;
	}

	@Override
	public Page<MemberDto> search(SearchCondition condition) throws Exception {
		int totalItems = repo.getTotalCount(condition);
		System.out.println("totalItems:" + totalItems);
		List<MemberDto> members = repo.search(condition);
		System.out.println("membersSize:" + members.size());
		return new Page<>(condition, totalItems, members);
	}

}
