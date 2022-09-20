package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.FileVO;
import com.myweb.www.domain.MemberVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.repository.FileDAO;
import com.myweb.www.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO mdao;
	
	@Inject
	private FileDAO fdao;
	
	@Override
	public int register(MemberVO mvo, FileVO fvo) {
		int isUp = mdao.insert(mvo);
		if(fvo != null && isUp > 0) {
			FileVO pfvo = fvo;
			pfvo.setEmail(mvo.getEmail());
			isUp = fdao.insertProfile(pfvo);
		}
		return isUp;
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		return mdao.selectLogin(mvo);
	}

	@Override
	public List<MemberVO> getList(PagingVO pgvo) {
		return mdao.selectList(pgvo);
	}

	@Override
	public MemberVO detail(String email) {
		return mdao.selectDetail(email);
	}

	@Override
	public int modify(MemberVO mvo) {
		return mdao.update(mvo);
	}

	@Override
	public int remove(String email) {
		return mdao.delete(email);
	}

	@Override
	public int dupleChrck(String email) {
		return mdao.selectEmail(email);
	}

	@Override
	public int getTotalCount(PagingVO pgvo) {
		return mdao.selectTotalCount(pgvo);
	}

}
