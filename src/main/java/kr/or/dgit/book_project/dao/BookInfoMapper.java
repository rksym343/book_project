package kr.or.dgit.book_project.dao;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.Coden;

public interface BookInfoMapper {
	int insertBookInfo(BookInfo bookInfo);
	BookInfo selectBookInfo(BookInfo bookInfo);
	
	//해당분야의 책 갯수 가져오기
	int selectBookInfoByCoden(Coden coden);
	
	//특정 코드의 책 갯수 가져오기
	int selectBookInfoByBCode(BookInfo bookInfo);
}
