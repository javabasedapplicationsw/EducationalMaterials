package shop.interhouse.orm.repository;

import java.util.List;
import java.util.Map;

import shop.interhouse.orm.domain.BoardDto;
import shop.interhouse.orm.domain.SearchItem;

public interface BoardDao {

	public BoardDto select(Integer bno) throws Exception;
	public int deleteAll() throws Exception;
	public int insert(BoardDto dto) throws Exception;
	public List<BoardDto> selectPage(Map map) throws Exception;
	public int count() throws Exception;
	public int increaseViewCnt(Integer bno) throws Exception;
	public int delete(Integer bno, String writer) throws Exception;
	public int update(BoardDto boardDto) throws Exception;
	public int searchResultCnt(SearchItem sc) throws Exception;
	public List<BoardDto> searchSelectPage(SearchItem sc) throws Exception;
}
