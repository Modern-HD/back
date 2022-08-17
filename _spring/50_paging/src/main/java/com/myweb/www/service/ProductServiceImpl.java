package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.PagingVO;
import com.myweb.www.domain.ProductVO;
import com.myweb.www.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

	@Inject
	private ProductDAO pdao;
	
	@Override
	public int register(ProductVO pvo) {
		return pdao.insert(pvo);
	}

	@Override
	public List<ProductVO> getList(PagingVO pgvo) {
		return pdao.selectList(pgvo);
	}

	@Override
	public ProductVO detail(long pno) {
		return pdao.selectOne(pno);
	}

	@Override
	public int modify(ProductVO pvo) {
		return pdao.update(pvo);
	}

	@Override
	public int remove(long pno) {
		return pdao.delete(pno);
	}

	@Override
	public int getTotalCount(PagingVO pgvo) {
		return pdao.selectTotalCount(pgvo);
	}

}
