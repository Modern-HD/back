package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.CommentVO;

public interface CommentService {
	public int post(CommentVO cvo);
	public List<CommentVO> spread(long pno);
	public CommentVO detail(long cno);
	public int modify(CommentVO cvo);
	public int remove(long cno);
	public int removeAll(long pno);
	
}
