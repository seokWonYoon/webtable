package board.service;

import java.util.List;

import board.model.BoardVO;

public interface BoardServiceInf {

	/**
	 * 	
	* Method : getBoardList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @return
	* Method 설명 :전체 게시판리스트 가져오기
	 */
	public List<BoardVO> getBoardList();
	
	/**
	 * 
	* Method : getBoard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param board_num
	* @return
	* Method 설명 :게시판 1개의 정보 가져오기
	 */
	public BoardVO getBoard(int board_num);
	
	/**
	 * 
	* Method : setBoard_yn
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param boardVO
	* @return
	* Method 설명 :사용여부 변경
	 */
	public int setBoard_yn(BoardVO boardVO);
	
	/**
	 * 
	* Method : insertBoard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param boardVO
	* @return
	* Method 설명 :게시판 신규등록
	 */
	public int insertBoard(BoardVO boardVO);
	
}
