package shop.interhouse.orm.repository;

import shop.interhouse.orm.domain.BoardDto;

public interface BoardDao {

	public BoardDto select(Integer bno) throws Exception;
	public int deleteAll() throws Exception;
	public int insert(BoardDto dto) throws Exception;
}
