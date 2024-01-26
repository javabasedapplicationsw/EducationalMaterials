package shop.interhouse.orm;

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
	
	@Test
	public void searchSelectPageTest() throws Exception {
		SearchItem si = new SearchItem(1, 10, "T", "Pioneering2");
		List<BoardDto> list = boardDao.searchSelectPage(si);
		System.out.println("list = " + list);
	}
}







