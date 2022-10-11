package com.myweb.board.service;

import java.util.List;

import com.myweb.board.domain.BoardVO;

public interface BoardService {
	public int register(BoardVO bvo);
	public List<BoardVO> getList();
	public BoardVO getDetail(int bno);
	public int modify(BoardVO bvo);
	public int remove(int bno);
}
