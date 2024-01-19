package shop.interhouse.orm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import shop.interhouse.orm.domain.BoardDto;
import shop.interhouse.orm.repository.BoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDaoImplTest {

	@Autowired
	private BoardDao boardDao;
	
	//@Test
	public void selectTest() throws Exception {
		assertTrue(boardDao != null);
		System.out.println("boardDao = " + boardDao);
		
		boardDao.deleteAll();
		BoardDto boardDto = new BoardDto("Pioneering", "Ready for Action", "cheonho");
		boardDao.insert(boardDto);
		
		boardDto = boardDao.select(1);
		System.out.println("boardDto = " + boardDto);
		assertTrue(boardDto.getBno().equals(1));
		
		boardDao.deleteAll();
		boardDto = new BoardDto("Pioneering", "Ready for Action", "cheonho");
		boardDao.insert(boardDto);
		
		boardDto = boardDao.select(2);
		System.out.println("boardDto = " + boardDto);
		assertTrue(boardDto.getBno().equals(2));
	}
	
	@Test
	public void insertDummyDataTest() throws Exception {
		boardDao.deleteAll();
		
		for(int i=1; i <= 250; i++ ) {
			BoardDto boardDto = new BoardDto("Pioneering" + i, "Ready for Action"+i, "cheonho");
			boardDao.insert(boardDto);
		}
	}
}























