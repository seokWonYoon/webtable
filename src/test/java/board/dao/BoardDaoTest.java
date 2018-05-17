package board.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import board.dao.BoardDao;
import board.dao.BoardDaoInf;
import board.model.BoardVO;

public class BoardDaoTest {

	BoardDaoInf dao;
	BoardVO boardVO;
	
	@Before
	public void setup(){
		dao = BoardDao.getInstance();
		boardVO = new BoardVO();
	}
	
	@Test
	public void getBoardTest() {

		/*** Given ***/
		
		int board_num = 1;

		/*** When ***/
		boardVO = dao.getBoard(board_num);

		/*** Then ***/
		assertNotNull(boardVO);
		assertEquals("notice", boardVO.getBoard_name());
	}

	
	@Test
	public void setBoard_ynTest() {

		/*** Given ***/
		boardVO.setBoard_num(1);
		boardVO.setBoard_vital_yn("n");

		/*** When ***/
		int result = dao.setBoard_yn(boardVO);

		/*** Then ***/
		assertEquals(1, result);

	}

	
	@Test
	public void insertBoardTest() {

		/*** Given ***/
		BoardVO boardVO = new BoardVO();
		int result = 0;
		boardVO.setBoard_name("Q&A");
		boardVO.setMem_id("test");

		/*** When ***/
		result = dao.insertBoard(boardVO);

		/*** Then ***/
		assertEquals(1, result);

	}

}
