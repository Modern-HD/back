package com.myweb.www;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.PagingVO;
import com.myweb.www.domain.ProductVO;
import com.myweb.www.repository.ProductDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.myweb.www.config.RootConfig.class})
public class ProductReposTest {
	
	@Inject
	private ProductDAO pdao;
//	
//	@Test
//	public void insertProductTest() throws Exception {
//		int isUp = pdao.insert(new ProductVO("TestUsers", 1234, "testerUser", "This is Test Product", "testerUsers","test"));
//		log.info(">>> insert Test > {}", isUp > 0 ? "Ok" : "Fail");
//	}
//	
//	@Test
//	public void insertDummyProduct() throws Exception {
//		for (int i = 51; i <= 100; i++) {
//			int isUp = pdao.insert(new ProductVO("testProduct" + i, i *200, "tester" + i, "This is Test Product", "Testers", "test"));
//			log.info(">>> insert Test" + i + "> {}", isUp > 0 ? "Ok" : "Fail");
//		}
//	}
	
	@Test
	public void productListTest() throws Exception {
		List<ProductVO> list = pdao.selectList(new PagingVO());
		for (ProductVO pvo : list) {
			log.info(">>> get List Test > {}, {}, {}, {}, {}, {}", pvo.getPno(), pvo.getPname(), pvo.getPrice(), pvo.getWriter(), pvo.getMadeBy(), pvo.getRegAt());
		}
	}
	
	@Test
	public void productDetailTest() throws Exception {
		ProductVO pvo = pdao.selectOne(1L);
		log.info(">>> get Detail Test > {}, {}, {}, {}, {}, {}", pvo.getPno(), pvo.getPname(), pvo.getPrice(), pvo.getWriter(), pvo.getMadeBy(), pvo.getRegAt());
	}
	
	@Test
	public void updateProductTest() throws Exception {
		ProductVO pvo = pdao.selectOne(1L);
		pvo.setCategory("Test");
		pvo.setPrice(6666);
		pvo.setDescription("This is Test");
		int isUp = pdao.update(pvo);
		log.info(">>> update Test > {}", isUp > 0 ? "Ok" : "Fail");
	}
	
	@Test
	public void deleteProductTest() throws Exception {
		int isUp = pdao.delete(44L);
		log.info(">>> Delete Test > {}", isUp > 0 ? "Ok" : "Fail");
	}
}
