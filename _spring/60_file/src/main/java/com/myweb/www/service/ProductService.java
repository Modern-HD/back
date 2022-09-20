package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.PagingVO;
import com.myweb.www.domain.ProductDTO;
import com.myweb.www.domain.ProductVO;

public interface ProductService {
	public int register(ProductDTO pdto);
	public List<ProductVO> getList(PagingVO gpvo);
	public ProductDTO detail(long pno);
	public int modify(ProductDTO pdto);
	public int remove(long pno);
	public int getTotalCount(PagingVO pgvo);
	public int removeFile(String uuid);
}
