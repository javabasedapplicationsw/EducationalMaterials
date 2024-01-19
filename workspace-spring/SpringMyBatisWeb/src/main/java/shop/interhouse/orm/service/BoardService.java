package shop.interhouse.orm.service;

import java.util.List;
import java.util.Map;

import shop.interhouse.orm.domain.BoardDto;

public interface BoardService {

	public List<BoardDto> getPage(Map map) throws Exception;
	public int getCount() throws Exception;
	public BoardDto read(Integer bno) throws Exception;
	public int remove(Integer bno, String writer) throws Exception;
}
