package shop.interhouse.orm;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import shop.interhouse.orm.domain.BoardDto;
import shop.interhouse.orm.domain.SearchItem;
import shop.interhouse.orm.repository.BoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDaoImplTest02 {

	@Autowired
	private BoardDao boardDao;
	
	//@Test
	public void searchSelectPageTest() throws Exception {
		SearchItem si = new SearchItem(1, 10, "T", "Pioneering2");
		List<BoardDto> list = boardDao.searchSelectPage(si);
		System.out.println("list = " + list);
		System.out.println();
	}
	
	//@Test
	public void searchSelectPageTest2() throws Exception {
		boardDao.deleteAll();
		for (int i=1; i<=20; i++) {
			BoardDto boardDto = new BoardDto("Pioneering"+i, "취업 준비", "user3");
			boardDao.insert(boardDto);
		}	
		
		// %Pioneering2%
		SearchItem si = new SearchItem(1, 10, "T", "Pioneering2");		//Pioneering2, Pioneering20
		List<BoardDto> list = boardDao.searchSelectPage(si);
		System.out.println("list = " + list);
		assertTrue(list.size() == 2);
		System.out.println();
		
	}
	
	@Test
	public void searchSelectPageTest3() throws Exception {
		boardDao.deleteAll();
		for (int i=1; i<=20; i++) {
			BoardDto boardDto = new BoardDto("Pioneering"+i, "취업 준비", "user3");
			boardDao.insert(boardDto);
		}	
		
		// %Pioneering2%
		SearchItem si = new SearchItem(1, 10, "T", "Pioneering2");		//Pioneering2, Pioneering20
		int cnt = boardDao.searchResultCnt(si);
		System.out.println("cnt = " + cnt);
		assertTrue(cnt == 2);
		
	}	
}



































