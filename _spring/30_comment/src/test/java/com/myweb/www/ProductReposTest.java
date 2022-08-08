package com.myweb.www;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.ProductVO;
import com.myweb.www.repository.ProductDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ProductReposTest {
	private static Logger log = LoggerFactory.getLogger(ProductReposTest.class);
	
	@Inject
	private ProductDAO pdao;
	
	@Test
	public void insertProductTest() throws Exception {
		int isUp = pdao.insert(new ProductVO("TestUsers", 1234, "testerUser", "This is Test Product", "testerUsers","test"));
		log.info(">>> insert Test > {}", isUp > 0 ? "Ok" : "Fail");
	}
	
	@Test
	public void insertDummyProduct() throws Exception {
		for (int i = 1; i <= 50; i++) {
			int isUp = pdao.insert(new ProductVO("testProduct" + i, i * 100, "testers" + i, "This is Test Product", "testers" + i, "test"));
			log.info(">>> insert Test" + i + "> {}", isUp > 0 ? "Ok" : "Fail");
		}
	}
	
	@Test
	public void productListTest() throws Exception {
		List<ProductVO> list = pdao.selectList();
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
