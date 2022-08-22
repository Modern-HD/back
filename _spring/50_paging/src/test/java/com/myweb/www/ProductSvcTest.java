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
import com.myweb.www.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.myweb.www.config.RootConfig.class})
public class ProductSvcTest {
	private static Logger log = LoggerFactory.getLogger(ProductSvcTest.class);
	
	@Inject
	private ProductService psv;
	
//	@Test
//	public void productRegisterTest() {
//		int isUp = psv.register(new ProductVO("SvcTest", 7777, "SvcUser", "This is Svc Test", "Testers", "TEST"));
//		log.info(">>> Register Test {}", isUp > 0 ? "OK" : "FAIL");
//	}
//	
	@Test
	public void productListTest() {
		List<ProductVO> list = psv.getList(new PagingVO());
		for (ProductVO pvo : list) {
			log.info(">>> get List Test > {}, {}, {}, {}, {}, {}", pvo.getPno(), pvo.getPname(), pvo.getPrice(), pvo.getWriter(), pvo.getMadeBy(), pvo.getRegAt());
		}
	}
	
	@Test
	public void insertProductDummyTest() throws Exception {
		for (int i = 1; i <= 256; i++) {
			psv.register(
					new ProductVO(
							"cate"+(i%10), "S-A", (int)(Math.random()*5001)+5000,
							"tester"+(int)(Math.random()*100)+"@tester.com",
							"DESC-SA", "STAKEHOLDERS"));
		}
	}
	
	@Test
	public void productDetailTest() {
		ProductVO pvo = psv.detail(53L);
		log.info(">>> Detail Test > {}, {}, {}, {}, {}, {}", pvo.getPno(), pvo.getPname(), pvo.getPrice(), pvo.getWriter(), pvo.getMadeBy(), pvo.getRegAt());
	}
	
	@Test
	public void productModifyTest() {
		ProductVO pvo = psv.detail(53L);
		pvo.setPrice(10000);
		pvo.setMadeBy("SvcUsers");
		int isUp = psv.modify(pvo);
		log.info(">>> Modify Test {}", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void productRemoveTest() {
		int isUp = psv.remove(53L);
		log.info(">>> Remove Test {}", isUp > 0 ? "OK" : "FAIL");
	}
	
}
