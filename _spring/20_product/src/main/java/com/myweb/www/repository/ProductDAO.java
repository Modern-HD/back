package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.ProductVO;

public interface ProductDAO {
	public int insert(ProductVO pvo);
	public List<ProductVO> selectList();
	public ProductVO selectOne(long pno);
	public int update(ProductVO pvo);
	public int delete(long pno);
}
