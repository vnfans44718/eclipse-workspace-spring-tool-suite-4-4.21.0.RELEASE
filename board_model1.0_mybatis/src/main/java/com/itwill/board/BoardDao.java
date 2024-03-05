package com.itwill.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface BoardDao {

	/**
	 * 새로운 게시물을 추가하는 메써드.
	 * @throws Exception 
	 */
	int create(Board board) throws Exception;

	/**
	 * 답글 게시물을 추가하는 메써드
	 */
	int createReply(Board board) throws Exception;
	
	/**
	 * 게시물 리스트를 반환(게시물시작번호,게시물끝번호)
	 */
	List<Board> findBoardList(int start, int last) throws Exception;

	/*
	 * 
	 * 
	 */
	/**
	 * 답변게시물 존재여부확인메쏘드
	 */
	boolean countReplay(Board board) throws SQLException;

	/**
	 * 게시물을 삭제하는 메써드.
	 */
	int remove(int boardNo) throws Exception;

	/**
	 * 게시물내용을 수정하는 메써드.
	 */
	int update(Board board) throws Exception;

	/**
	 * 게시물 번호에 해당하는 게시물 정보를 반환하는 메써드.
	 */
	Board findBoard(int boardNo) throws Exception;

	/**
	 * 게시물 조회수를 1 증가.
	 */
	void increaseReadCount(int number) throws Exception;

	/**
	 * 게시물 총 건수를 조회, 반환
	 */
	@Select("select count(*) from board")
	int getBoardCount() throws Exception;

}