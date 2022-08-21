package com.myweb.www;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.MemberVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.myweb.www.config.RootConfig.class})
public class MemberSvcTest {
	private static Logger log = LoggerFactory.getLogger(MemberSvcTest.class);
	
	@Inject
	private MemberService msv;
	
	@Test
	public void MemberListTest() throws Exception {
		List<MemberVO> list = msv.getList(new PagingVO());
		for (MemberVO mvo : list) {
			log.info(">>> {}, {}, {}, {}, {}", mvo.getEmail(), mvo.getNickName(), mvo.getRegAt(),
					mvo.getLastLogin(), mvo.getGrade());
		}
	}
	
	@Test
	public void MemberLoginTest() throws Exception {
		MemberVO mvo = msv.login(new MemberVO("msvtester@tester.com", "1111"));
		log.info(">>> {}, {}, {}, {}, {}", mvo.getEmail(), mvo.getNickName(), mvo.getRegAt(),
				mvo.getLastLogin(), mvo.getGrade());
	}
	
	@Test
	public void MemberDetailTest() throws Exception {
		MemberVO mvo = msv.detail("msvtester@tester.com");
		log.info(">>> {}, {}, {}, {}, {}", mvo.getEmail(), mvo.getNickName(), mvo.getRegAt(),
				mvo.getLastLogin(), mvo.getGrade());
	}
	
	@Test
	public void MemberUpdateTest() throws Exception {
		MemberVO mvo = msv.detail("msvtester@tester.com");
		mvo.setGrade(20);
		int isUp = msv.modify(mvo);
		log.info(">>> Test of modify Member: {}", isUp > 0 ? "OK" : "Fail");
		if (isUp > 0) {
			mvo = msv.detail("msvtester@tester.com");
			log.info(">>> {}, {}, {}, {}, {}", mvo.getEmail(), mvo.getNickName(), mvo.getRegAt(),
					mvo.getLastLogin(), mvo.getGrade());
		}
	}
	
	@Test
	public void MemberRemoveTest() throws Exception {
		int isUp = msv.remove("msvtester@tester.com");
		log.info(">>> Test of remove Member: {}", isUp > 0 ? "OK" : "Fail");
	}
	
	@Test
	public void MemberRegDummy() throws Exception {
		int isUp = msv.register(new MemberVO("msvtester@tester.com", "1111", "MSVTester"));
		log.info(">>> Test of insert Member: {}", isUp > 0 ? "OK" : "Fail");
	}
	
	
}
