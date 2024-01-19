package shop.interhouse.orm.repository;

import java.util.List;
import java.util.Map;

import shop.interhouse.orm.domain.BoardDto;

public interface BoardDao {

	public BoardDto select(Integer bno) throws Exception;
	public int deleteAll() throws Exception;
	public int insert(BoardDto dto) throws Exception;
	public List<BoardDto> selectPage(Map map) throws Exception;
	public int count() throws Exception;
	public int increaseViewCnt(Integer bno) throws Exception;
	public int delete(Integer bno, String writer) throws Exception;
	
}
