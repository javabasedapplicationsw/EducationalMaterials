package shop.interhouse.orm.service;

import java.util.List;

import shop.interhouse.orm.domain.CommentDto;

public interface CommentService {

	public List<CommentDto> getList(Integer bno) throws Exception;
	public int remove(Integer cno, Integer bno, String commenter) throws Exception;
	public int write(CommentDto dto) throws Exception;
	public int modify(CommentDto dto) throws Exception;
}
