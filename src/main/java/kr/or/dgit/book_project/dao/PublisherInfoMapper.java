package kr.or.dgit.book_project.dao;

import kr.or.dgit.book_project.dto.PublisherInfo;

public interface PublisherInfoMapper {
	int insertPubliherShort(PublisherInfo publisherInfo);
	int selectCountAll();
}
