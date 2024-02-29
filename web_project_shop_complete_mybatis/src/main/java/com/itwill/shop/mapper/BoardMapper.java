package com.itwill.shop.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.shop.board.Board;

public interface BoardMapper {
	/**
	 * 새로운 게시물을 추가하는 메써드.
	 * 
	 * @throws Exception
	 */
	@Insert("insert into board (boardno, title, writer, content, groupno, step) values(board_sequence.nextval, #{title}, #{writer}, #{content},board_sequence.currval, 1)")
	int create(Board board) throws Exception;

	/**
	 * 답글 게시물추가전 step update 하는 메써드
	 */
	@Update("update board set step = step + 1 where step > #{step} and groupno = #{groupNo}")
	int updateReply(Board temp) throws Exception;

	/**
	 * 답글 게시물을 추가하는 메써드
	 */
	@Insert("insert into board(boardno, title, writer, content,groupno, step, depth) values(board_sequence.nextval, #{title}, #{writer}, #{content},#{groupNo}, #{step}, #{depth})")
	int createReply(Board board) throws Exception;

	/**
	 * 게시물 리스트를 반환(게시물시작번호,게시물끝번호)
	 */
	@Select("SELECT * FROM ( SELECT rownum idx, s.* FROM( "
			+ "                            SELECT boardno, title,content, writer,regdate,readcount,groupno, step, depth "
			+ "                            FROM board ORDER BY groupno DESC, step ASC"
			+ "                            ) s" + "               )" + "WHERE idx >= #{start} AND idx <= #{last}")
	List<Board> findBoardList(Map param) throws Exception;

	/**
	 * 답변게시물 존재여부확인메쏘드
	 */
	@Select("select count(*) cnt from board where groupno = #{groupNo} and depth >= #{depth} and step >=#{step} order by step,depth asc")
	int countReplay(Board board) throws SQLException;

	/**
	 * 게시물을 삭제하는 메써드.
	 */
	@Delete("delete board where boardno = #{boardNo}")
	int remove(int boardNo) throws Exception;

	/**
	 * 게시물내용을 수정하는 메써드.
	 */
	@Update("update board  set title = #{title}, content =  #{content},writer =  #{writer} where boardno = #{boardNo}")
	int update(Board board) throws Exception;

	/**
	 * 게시물 번호에 해당하는 게시물 정보를 반환하는 메써드.
	 */
	@Select("select boardno, title, writer, content,regdate, readcount,groupno, step, depth from board where boardno = #{boardNo}")
	Board findBoard(int boardNo) throws Exception;

	/**
	 * 게시물 조회수를 1 증가.
	 */
	@Update("update board set readcount = readcount + 1 where boardno = #{number}")
	void increaseReadCount(int number) throws Exception;

	/**
	 * 게시물 총 건수를 조회, 반환
	 */
	@Select("select count(*) from board")
	int getBoardCount() throws Exception;

}
