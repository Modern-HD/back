package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.MemberVO;

public interface MemberService {
	int register(MemberVO mvo);
	MemberVO login(MemberVO mvo);
	List<MemberVO> getList();
	MemberVO detail(String email);
	int modify(MemberVO mvo);
	int remove(String email);
	int dupleChrck(String string);
}
