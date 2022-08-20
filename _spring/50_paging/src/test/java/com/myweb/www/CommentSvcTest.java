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
@ContextConfiguration(classes = {com.myweb.www.config.RootConfig.class})
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
	public void insertCommentDummiesTest() throws Exception {
		for (int j = 1; j <= 256; j++) {
			int x = (int) (Math.random() * 256);
			for (int i = 0; i < x; i++) {
				csv.post(new CommentVO(j,
						"tester" + ((int) (Math.random() * 256)) + "@tester.com",
						"Comment Dummy Content for" + j + ": " + (int)(Math.random() * 256)));
			}
		}
	}
	
//	@Test
//	public void commentListTest() {
//		List<CommentVO> list = csv.spread(1L);
//		for (CommentVO cvo : list) {
//			log.info("{}", cvo);
//		}
//	}
	
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
