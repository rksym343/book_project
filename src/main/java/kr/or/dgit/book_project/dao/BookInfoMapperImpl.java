package kr.or.dgit.book_project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.Coden;

public class BookInfoMapperImpl implements BookInfoMapper {
	private String namespace = "kr.or.dgit.book_project.dao.BookInfoMapper.";
	private static final Log log = LogFactory.getLog(BookInfoMapper.class);
	private SqlSession sqlSession;

	public BookInfoMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insertBookInfo(BookInfo bookInfo) {
		log.debug("insertBookInfo()");
		return sqlSession.insert(namespace + "insertBookInfo", bookInfo);
	}

	@Override
	public List<BookInfo> selectBookInfo(Map<String, Object> param) {
		log.debug("selectBookInfo()");
		return sqlSession.selectList(namespace + "selectBookInfo");
	}

	@Override
	public List<BookInfo> selectBookInfoByAll() {
		log.debug("selectBookInfoByAll()");
		return sqlSession.selectList(namespace + "selectBookInfoByAll");
	}

	@Override
	public int selectBookInfoCountBy(Map<String, Object> param) {
		log.debug("selectBookInfoCountBy()");
		return sqlSession.selectOne(namespace + "selectBookInfoCountBy");
	}
}