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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CommentReposTest {
	private static Logger log = LoggerFactory.getLogger(CommentReposTest.class);
	
	@Inject
	private CommentDAO cdao;
	
	@Test
	public void commentInsertTest() {
		int isUp = cdao.insert(new CommentVO(1L, "admin@admin.com", "테스트 댓글 1"));
		log.info(">>> Comment Insert Test > {}", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void commentDummyTest() {
		for (int i = 0; i < 40; i++) {
			int isUp = cdao.insert(new CommentVO(1L, "admin@admin.com", "Test Comment " + i));
			log.info(">>> Comment Insert Dummy{} Test > {}", i, isUp > 0 ? "OK" : "FAIL");
		}
	}
	
	@Test
	public void commentListTest() {
		List<CommentVO> list = cdao.selectList(1L);
		for (CommentVO cvo : list) {
			log.info("{}", cvo);
		}
	}
	
	@Test
	public void commentUpdateTest() {
		int isUp = cdao.update(new CommentVO(1L, "is Update?"));
		log.info(">>> Comment Update Test > {}", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void commentDeleteTest() {
		int isUp = cdao.delete(1L);
		log.info(">>> Comment Delete Test > {}", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void commentDeleteAllTest() {
		int isUp = cdao.deleteAll(1L);
		log.info(">>> Comment Delete All Test > {}", isUp > 0 ? "OK" : "FAIL");
	}
}
