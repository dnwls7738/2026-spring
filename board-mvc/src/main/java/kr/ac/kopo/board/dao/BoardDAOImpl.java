package kr.ac.kopo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;



/**
 * Oracle DB에서 게시판 테이블(tbl_board)에서 CRUD 기능 클래스
 */
@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private DataSource ds;

	@Override
	public List<BoardVO> selectAll() {

		List<BoardVO> boardList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as regDate";
			   sql += " from tbl_board";
			   sql += " order by no desc";
		
				try {
					// conn 객체 얻어오기
					conn = ds.getConnection();
					// sql를 sql 실행 객체 넣어주기
					pstmt = conn.prepareStatement(sql);
					// sql실행 후 결과를 얻어오기
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						int no = rs.getInt("no");
						String title = rs.getString("title");
						String writer = rs.getString("writer");
						String regDate = rs.getString("regDate");
						
						BoardVO board = new BoardVO();
						board.setNo(no);
						board.setTitle(title);
						board.setWriter(writer);
						board.setRegDate(regDate);
						
						boardList.add(board);
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
				
		return boardList;
	}

}
