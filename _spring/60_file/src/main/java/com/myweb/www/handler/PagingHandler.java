package com.myweb.www.handler;

import java.util.List;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.domain.PagingVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingHandler {
	private int startPage; // 현재 화면에서 보여줄 페이지네이션의 시작 인덱스 번호
	private int endPage; // 현재 화면에서 보여줄 페이지네이션의 끝 인덱스 번호
	private boolean prev, next; // 이전, 다음 버튼 존재 유무
	
	private int totalCount; // 총 게시글의 수
	private PagingVO pgvo; // 사용자가 입력하거나 전달되는 페이징 정보값을 갖고 있는 객체
	private List<CommentVO> cmtList;
	
	public PagingHandler(PagingVO pgvo, int totalCount) {
		this.pgvo = pgvo;
		this.totalCount = totalCount;
		
		this.endPage = (int)(Math.ceil(pgvo.getPageNo() / (pgvo.getQty()*1.0))) * pgvo.getQty();
		this.startPage = endPage - (pgvo.getQty() - 1);
		
		int realEndPage = (int)(Math.ceil((totalCount * 1.0) / pgvo.getQty()));
		
		if(realEndPage < this.endPage) {
			this.endPage = realEndPage;
		}
		this.next = endPage < realEndPage;
		this.prev = startPage > 1;

	}

	public PagingHandler(List<CommentVO> selectList,
			PagingVO pgvo, int totalCount) {
		this(pgvo, totalCount);
		this.cmtList = selectList;
	}
}
