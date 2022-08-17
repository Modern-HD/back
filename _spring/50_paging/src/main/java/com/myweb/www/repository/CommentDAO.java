package com.myweb.www.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.domain.PagingVO;

public interface CommentDAO {
	public int insert(CommentVO cvo);
	public List<CommentVO> selectList(@Param("pno") long pno, @Param("pgvo") PagingVO pgvo);
	public CommentVO selectOne(long cno);
	public int update(CommentVO cvo);
	public int delete(long cno);
	public int deleteAll(long pno);
	public int selectTotalCount(long pno);
}
