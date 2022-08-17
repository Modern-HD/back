package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.PagingVO;
import com.myweb.www.domain.ProductVO;

public interface ProductService {
	public int register(ProductVO pvo);
	public List<ProductVO> getList(PagingVO gpvo);
	public ProductVO detail(long pno);
	public int modify(ProductVO pvo);
	public int remove(long pno);
	public int getTotalCount(PagingVO pgvo);
}
