package kr.ac.kopo.member.dao;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.ac.kopo.config.DBConfig;
import kr.ac.kopo.member.vo.MemberVO;

@SpringJUnitConfig(classes = {DBConfig.class})
public class MemberDBTest {
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private MemberDAO memberDao;
	
	
	@Disabled
	@Test
	public void DB접속Test() throws Exception{
		Connection conn = ds.getConnection();
		assertNotNull(conn);
	}
	
	@Disabled
	@Test
	public void 전체멤버조회() throws Exception{
		List<MemberVO> list = memberDao.selectAll();
		for(MemberVO member : list) {
			System.out.println(member);
		}
	}
	
	@Test
	public void 로그인() throws Exception{
		MemberVO member = new MemberVO();
		member.setId("dnwls7738");
		member.setPassword("1234");
		
		assertNotNull(memberDao.login(member));
		
	}
}
