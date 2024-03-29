package com.myweb.www.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myweb.www.domain.CommentVO;

@Repository
public class CommentDAOImpl implements CommentDAO {
	private final String NS = "CommentMapper.";
	
	@Inject
	private SqlSession sql;
	
	@Override
	public int insert(CommentVO cvo) {
		return sql.insert(NS + "reg", cvo);
	}

	@Override
	public List<CommentVO> selectList(long pno) {
		return sql.selectList(NS + "list", pno);
	}

	@Override
	public CommentVO selectOne(long cno) {
		return sql.selectOne(NS + "detail", cno);
	}

	@Override
	public int update(CommentVO cvo) {
		return sql.update(NS + "mod", cvo);
	}

	@Override
	public int delete(long cno) {
		return sql.delete(NS + "del", cno);
	}

	@Override
	public int deleteAll(long pno) {
		return sql.delete(NS + "del_all", pno);
	}

}
