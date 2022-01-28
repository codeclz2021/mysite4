package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;

	// 리스트(리스트만 출력할때)
	public List<BoardVo> getBoardList() {
		System.out.println("boardService/list");

		return boardDao.selectList();
	}

	// 글쓰기
	public int addBoard(BoardVo boardVo) {
		System.out.println("boardService/addBoard");

		return boardDao.insert(boardVo);
	}

	// 글가져오기
	@Transactional
	public BoardVo getBoard(int no, String type) throws Exception {
		System.out.println("boardService/getBoard");

		if ("read".equals(type)) {// 읽기 일때는 조회수 올림
			boardDao.updateHit(no);
			BoardVo boardVo = boardDao.select(no);
			return boardVo;

		} else { // 수정 일때는 조회수 올리지 않음
			BoardVo boardVo = boardDao.select(no);
			return boardVo;
		}

	}

	// 글수정
	public int modifyBoard(BoardVo boardVo) {
		System.out.println("boardService/modifyBoard");

		return boardDao.update(boardVo);
	}

	// 글삭제
	public int removeBoard(BoardVo boardVo) {
		System.out.println("boardService/removeBoard");

		return boardDao.delete(boardVo);
	}

}
