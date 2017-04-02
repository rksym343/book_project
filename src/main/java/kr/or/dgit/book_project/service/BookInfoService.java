package kr.or.dgit.book_project.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.book_project.dao.BookInfoMapper;
import kr.or.dgit.book_project.dao.BookInfoMapperImpl;
import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.util.MybatisSqlSessionFactory;

public class BookInfoService {

	public int insertBookInfo(BookInfo bookInfo) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
			int res = bookInfoMapper.insertBookInfo(bookInfo);
			sqlSession.commit();
			return res;
		}
	}

	public BookInfo selectBookInfo(Map<String, Object> param) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
			return bookInfoMapper.selectBookInfo(param);
		}

	}

	public List<BookInfo> selectBookInfoByAll() {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
			return bookInfoMapper.selectBookInfoByAll();
		}
	}

	public int selectBookInfoCountBy(Map<String, Object> param) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
			return bookInfoMapper.selectBookInfoCountBy(param);
		}
	}

}
