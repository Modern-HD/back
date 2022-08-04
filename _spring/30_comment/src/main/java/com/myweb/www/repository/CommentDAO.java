package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.CommentVO;

public interface CommentDAO {
	public int insert(CommentVO cvo);
	public List<CommentVO> selectList(long pno);
	public CommentVO selectOne(long cno);
	public int update(CommentVO cvo);
	public int delete(long cno);
	public int deleteAll(long pno);
}
