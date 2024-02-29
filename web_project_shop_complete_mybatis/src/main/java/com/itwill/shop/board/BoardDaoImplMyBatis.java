package com.itwill.shop.board;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.shop.mapper.BoardMapper;




/*
 * 자료실 게시판에서 데이터베이스의 접근을 전담하는 클래스. 
 * BOARD 테이블과의 접근을 담당한다.
 */
public class BoardDaoImplMyBatis implements BoardDao {
	private SqlSessionFactory sqlSessionFactory;

	public BoardDaoImplMyBatis() throws Exception {
		this.sqlSessionFactory = 
				new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsStream("mybatis-config.xml"));
	}

	/**
	 * 새로운 게시물을 추가하는 메써드.
	 * 
	 * @throws Exception
	 */
	@Override
	public int create(Board board) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		BoardMapper boardMapper=sqlSession.getMapper(BoardMapper.class);
		int rowCount=boardMapper.create(board);
		sqlSession.close();
		return rowCount;
	}
	
	/**
	 * 답글 게시물을 추가하는 메써드
	 */
	@Override
	public int createReply(Board board) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		BoardMapper boardMapper=sqlSession.getMapper(BoardMapper.class);
		Board temp=boardMapper.findBoard(board.getBoardNo());
		boardMapper.updateReply(temp);
		
		board.setGroupNo(temp.getGroupNo());
		board.setStep(temp.getStep()+1);
		board.setDepth(temp.getDepth()+1);
		
		boardMapper.createReply(board);
		sqlSession.commit();
		sqlSession.close();
		return 0;

	}

	/**
	 * 게시물 리스트를 반환(게시물시작번호,게시물끝번호)
	 */
	@Override
	public List<Board> findBoardList(int start, int last) throws Exception {
		System.out.println("" + start + " ~ " + last);
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		BoardMapper boardMapper=sqlSession.getMapper(BoardMapper.class);
		Map param=new HashMap();
		param.put("start", start);
		param.put("last", last);
		List<Board> boardList= boardMapper.findBoardList(param);
		sqlSession.close();
		return boardList;
	}

	/*
	 * 
	 * 
	 */
	/**
	 * 답변게시물 존재여부확인메쏘드
	 */
	@Override
	public boolean countReplay(Board board) throws SQLException {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		BoardMapper boardMapper=sqlSession.getMapper(BoardMapper.class);
		int rowCount=boardMapper.countReplay(board);
		System.out.println(rowCount);
		Boolean isExist=false;
		if(rowCount>1) {
			isExist=true;
		}
		sqlSession.close();
		return isExist;
	}

	/**
	 * 게시물을 삭제하는 메써드.
	 */
	@Override
	public int remove(int boardNo) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		BoardMapper boardMapper=sqlSession.getMapper(BoardMapper.class);
		int rowCount=boardMapper.remove(boardNo);
		sqlSession.close();
		return rowCount;

	}

	/**
	 * 게시물내용을 수정하는 메써드.
	 */
	@Override
	public int update(Board board) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		BoardMapper boardMapper=sqlSession.getMapper(BoardMapper.class);
		int rowCount=boardMapper.update(board);
		sqlSession.close();
		return rowCount;
	}

	/**
	 * 게시물 번호에 해당하는 게시물 정보를 반환하는 메써드.
	 */
	@Override
	public Board findBoard(int boardNo) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		BoardMapper boardMapper=sqlSession.getMapper(BoardMapper.class);
		Board board= boardMapper.findBoard(boardNo);
		System.out.println(board);
		sqlSession.close();
		return board;
	}

	/**
	 * 게시물 조회수를 1 증가.
	 */
	@Override
	public void increaseReadCount(int number) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		BoardMapper boardMapper=sqlSession.getMapper(BoardMapper.class);
		boardMapper.increaseReadCount(number);
		sqlSession.close();
		
	}

	/**
	 * 게시물 총 건수를 조회, 반환
	 */
	@Override
	public int getBoardCount() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		BoardMapper boardMapper=sqlSession.getMapper(BoardMapper.class);
		int totCount=boardMapper.getBoardCount();
		sqlSession.close();
		return totCount;
	}

	

}
