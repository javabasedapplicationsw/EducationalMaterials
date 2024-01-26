package shop.interhouse.orm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.interhouse.orm.domain.BoardDto;
import shop.interhouse.orm.repository.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<BoardDto> getPage(Map map) throws Exception {
		return boardDao.selectPage(map);
	}

	@Override
	public int getCount() throws Exception {
		return boardDao.count();
	}

	@Override
	public BoardDto read(Integer bno) throws Exception {
		
		BoardDto boardDto = boardDao.select(bno);
		//비즈니스 로직추가 (조회수 1증가)
		boardDao.increaseViewCnt(bno);
		
		return boardDto;
	}

	@Override
	public int remove(Integer bno, String writer) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.delete(bno, writer);
	}

	@Override
	public int write(BoardDto boardDto) throws Exception {
		return boardDao.insert(boardDto);
		//throw new Exception();
	}

	@Override
	public int modify(BoardDto boardDto) throws Exception {
		return boardDao.update(boardDto);
	}

}









