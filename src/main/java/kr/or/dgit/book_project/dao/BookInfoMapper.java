package kr.or.dgit.book_project.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.book_project.dto.BookInfo;

public interface BookInfoMapper {
	int insertBookInfo(BookInfo bookInfo);

	List<BookInfo> selectBookInfo(Map<String, Object> param);

	List<BookInfo> selectBookInfoByAll();

	// 분야/특정 코드의 책 갯수 가져오기
	int selectBookInfoCountBy(Map<String, Object> param);
}
