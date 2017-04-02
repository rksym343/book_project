package kr.or.dgit.book_project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.book_project.dao.BookInfoMapper;
import kr.or.dgit.book_project.dao.BookInfoMapperImpl;
import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.Coden;
import kr.or.dgit.book_project.dto.PublisherInfo;
import kr.or.dgit.book_project.service.BookInfoService;
import kr.or.dgit.book_project.util.MybatisSqlSessionFactory;

public class BookInfoServiceTest {
	private static BookInfoService bookInfoService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookInfoService = new BookInfoService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bookInfoService = null;
	}

/*@Test
	public void atestselectBookInfoCountBy() { /// 왜 안되냐!!!!
		Map<String, Object> param = new HashMap<>();
		param.put("searchBy", "Coden");
		param.put("cName", "IT");
		int res = bookInfoService.selectBookInfoCountBy(param);
		System.out.println("검색 조건 : " + param);
		System.out.println(res);
		Assert.assertNotNull(res);
	}*/

	/*@Test
	public void btestinsertBookInfo() { // 된댜!!!!!!!!!!!!!!!!
		PublisherInfo pCode = new PublisherInfo();
		pCode.setpCode("P022"); // 외래키관계는 있는 데이터 선택해야함
		pCode.setPublisher("다산지식하우스");
		
		Coden cName = new Coden("자기계발","D"); // 있는 데이터 선택해야함
		BookInfo bookInfo = new BookInfo("D005", "00", "필드명 테스트 중 책제목", "저자", 20000, "2017-04-02", false, cName, pCode);
		

		int res = bookInfoService.insertBookInfo(bookInfo);
		Assert.assertSame(1, res);
	}*/

@Test
	public void ctestselectBookInfo() { // 왜 안돼 한개 선택 왜왜왜왜왜왜 왜 왜 조건절 안먹어
		/*BookInfo bookInfo = new BookInfo();
		bookInfo.setbCode("T001");
		bookInfo.setbSubCode(0);
		*/
		Map<String, Object> param = new HashMap<>();
		param.put("isDel", false);
		param.put("bCode", "T001");
		param.put("bSubCode", "00");
		List<BookInfo> bookInfoRes = bookInfoService.selectBookInfo(param);
		Assert.assertNotNull(bookInfoRes);

	}

	/*@Test
	public void dtestselectBookInfoByAll() {
		List<BookInfo> list = bookInfoService.selectBookInfoByAll();
		Assert.assertNotNull(list);
	}*/

}
