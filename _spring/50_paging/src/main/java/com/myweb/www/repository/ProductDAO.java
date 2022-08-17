package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.PagingVO;
import com.myweb.www.domain.ProductVO;

public interface ProductDAO {
	public int insert(ProductVO pvo);
	public List<ProductVO> selectList(PagingVO pgvo);
	public ProductVO selectOne(long pno);
	public int update(ProductVO pvo);
	public int delete(long pno);
	public int selectTotalCount(PagingVO pgvo);
}
