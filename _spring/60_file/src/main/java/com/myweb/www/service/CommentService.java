package com.myweb.www.service;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.handler.PagingHandler;

public interface CommentService {
	public int post(CommentVO cvo);
	public PagingHandler spread(long pno, PagingVO pgvo);
	public CommentVO detail(long cno);
	public int modify(CommentVO cvo);
	public int remove(long cno);
	public int removeAll(long pno);
	
}
