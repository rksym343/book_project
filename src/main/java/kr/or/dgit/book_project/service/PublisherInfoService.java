package kr.or.dgit.book_project.service;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.book_project.dao.PublisherInfoMapper;
import kr.or.dgit.book_project.dao.PublisherInfoMapperImpl;
import kr.or.dgit.book_project.dto.PublisherInfo;
import kr.or.dgit.book_project.util.MybatisSqlSessionFactory;
public class PublisherInfoService {

	
	
	public int insertPubliherShort(PublisherInfo publisherInfo){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			PublisherInfoMapper publisherInfoMapper = new PublisherInfoMapperImpl(sqlSession);
			int res = publisherInfoMapper.insertPubliherShort(publisherInfo);
			sqlSession.commit();
			return res;
		}
	}
	
	public int selectCountAll(){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			PublisherInfoMapper publisherInfoMapper = new PublisherInfoMapperImpl(sqlSession);
			int res = publisherInfoMapper.selectCountAll();
			return res;
		}
	}
	
	
	
}
