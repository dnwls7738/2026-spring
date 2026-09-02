package kr.ac.kopo.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.member.vo.MemberVO;



// @Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private DataSource ds;

	// 회원 목록
	@Override
	public List<MemberVO> selectAll() {
		
		List<MemberVO> memberList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select id, name, password, email_id, email_domain, tel1, tel2, tel3, post, basic_addr, detail_addr, type, to_char(reg_date, 'yyyy-mm-dd') as regDate";
			   sql += " from tbl_member";
			   sql += " order by reg_date desc";
			   
		
				try {
					// conn 객체 얻어오기
					conn = ds.getConnection();
					// sql를 sql 실행 객체 넣어주기
					pstmt = conn.prepareStatement(sql);
					// sql실행 후 결과를 얻어오기
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						String id = rs.getString("id");
						String name = rs.getString("name");
						String password = rs.getString("password");
						String emailId = rs.getString("email_id");
						String emailDomain = rs.getString("email_domain");
						String tel1 = rs.getString("tel1");
						String tel2 = rs.getString("tel2");
						String tel3 = rs.getString("tel3");
						String post = rs.getString("post");
						String basicAddr = rs.getString("basic_addr");
						String detailAddr = rs.getString("detail_addr");
						String type = rs.getString("type");
						String regDate = rs.getString("regDate");
						
						MemberVO member = new MemberVO();
						member.setId(id);
						member.setName(name);
						member.setPassword(password);
						member.setEmailId(emailId);
						member.setEmailDomain(emailDomain);
						member.setTel1(tel1);
						member.setTel2(tel2);
						member.setTel3(tel3);
						member.setPost(post);
						member.setBasicAddr(basicAddr);
						member.setDetailAddr(detailAddr);
						member.setType(type);
						member.setRegDate(regDate);

						
						memberList.add(member);
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					if(rs != null) {
						try {
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
						}	
					}
					
					if(pstmt != null){
						try {
							pstmt.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
				{
						
					}
				}
				
		return memberList;
	}

	//회원가입
	@Override
	public void insert(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into tbl_member(id, name, password, email_id, email_domain, tel1, tel2, tel3, post, basic_addr, detail_addr) ";
		sql += " values(?,?,?,?,?,?,?,?,?,?,?) ";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getEmailId());
			pstmt.setString(5, member.getEmailDomain());
			pstmt.setString(6, member.getTel1());
			pstmt.setString(7, member.getTel2());
			pstmt.setString(8, member.getTel3());
			pstmt.setString(9, member.getPost());
			pstmt.setString(10, member.getBasicAddr());
			pstmt.setString(11, member.getDetailAddr());

			
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public MemberVO selectById(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

}
