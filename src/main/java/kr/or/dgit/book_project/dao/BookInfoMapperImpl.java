package kr.or.dgit.book_project.dao;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.Coden;

public class BookInfoMapperImpl implements BookInfoMapper {
	private String namespace="kr.or.dgit.book_project.dao.BookInfoMapper.";
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
	public BookInfo selectBookInfo(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int selectBookInfoByCoden(Coden coden) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int selectBookInfoByBCode(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

}
