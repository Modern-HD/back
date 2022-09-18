package com.myweb.www.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myweb.www.domain.PagingVO;
import com.myweb.www.domain.ProductVO;

public interface ProductDAO {
	public int insert(ProductVO pvo);
	public List<ProductVO> selectList(PagingVO pgvo);
	public ProductVO selectOne(long pno);
	public int update(ProductVO pvo);
	public int delete(long pno);
	public int selectTotalCount(PagingVO pgvo);
	public long selectLastPno();
	public int updateReadCount(@Param("pno") long pno, @Param("i") int i);
}
