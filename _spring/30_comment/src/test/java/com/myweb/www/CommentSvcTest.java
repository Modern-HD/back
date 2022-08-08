package com.myweb.www;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.repository.CommentDAO;
import com.myweb.www.service.CommentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CommentSvcTest {
	private static Logger log = LoggerFactory.getLogger(CommentSvcTest.class);
	
	@Inject
	private CommentService csv;
	
	@Test
	public void commentRegisterTest() {
		int isUp = csv.post(new CommentVO(1L, "admin@admin.com", "테스트 댓글 1"));
		log.info(">>> Comment Register Test > {}", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void commentDummyTest() {
		for (int i = 0; i < 40; i++) {
			int isUp = csv.post(new CommentVO(i, "admin@admin.com", "Test Comment " + i));
			log.info(">>> Comment Dummy{} Test > {}", i, isUp > 0 ? "OK" : "FAIL");
		}
	}
	
	@Test
	public void commentListTest() {
		List<CommentVO> list = csv.spread(1L);
		for (CommentVO cvo : list) {
			log.info("{}", cvo);
		}
	}
	
	@Test
	public void commentModifyTest() {
		int isUp = csv.modify(new CommentVO(42L, "is Update?"));
		log.info(">>> Comment Modify Test > {}", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void commentRemoveTest() {
		int isUp = csv.remove(2L);
		log.info(">>> Comment Remove Test > {}", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void commentRemoveAllTest() {
		int isUp = csv.removeAll(1L);
		log.info(">>> Comment Remove All Test > {}", isUp > 0 ? "OK" : "FAIL");
	}
}
