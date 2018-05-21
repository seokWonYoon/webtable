package board.service;

import java.util.List;

import board.dao.BoardDao;
import board.dao.BoardDaoInf;
import board.model.BoardVO;

public class BoardService implements BoardServiceInf{

	private BoardDaoInf dao;
	
	public BoardService(){
		dao = BoardDao.getInstance();
	}

	@Override
	public List<BoardVO> getBoardList() {
		return dao.getBoardList();
	}

	@Override
	public BoardVO getBoard(int board_num) {
		return dao.getBoard(board_num);
	}

	@Override
	public int setBoard_yn(BoardVO boardVO) {
		return dao.setBoard_yn(boardVO);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		return dao.insertBoard(boardVO);
	}
	

}
