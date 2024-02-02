package shop.interhouse.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.interhouse.orm.domain.CommentDto;
import shop.interhouse.orm.repository.BoardDao;
import shop.interhouse.orm.repository.CommentDao;

@Service
public class CommentServiceImpl implements CommentService {
	
	BoardDao boardDao;
	CommentDao commentDao;
	
	//@Autowired
	public CommentServiceImpl(BoardDao boardDao, CommentDao commentDao) {
		//super();
		this.boardDao = boardDao;
		this.commentDao = commentDao;
	}



	@Override
	public List<CommentDto> getList(Integer bno) throws Exception {
		return commentDao.selectAll(bno);
		//throw new Exception("test");
	}



	@Override
	@Transactional(rollbackFor = Exception.class)
	public int remove(Integer cno, Integer bno, String commenter) throws Exception {
		int rowCnt = boardDao.updateCommentCnt(bno, -1);
		System.out.println("댓글 수 업데이트 (-1) = " +  rowCnt);
		
		rowCnt = commentDao.delete(cno, commenter);
		System.out.println("삭제된 댓글 수 = " + rowCnt);
		
		return rowCnt;
	}


	@Override
	@Transactional(rollbackFor = Exception.class)
	public int write(CommentDto commentDto) throws Exception {
		boardDao.updateCommentCnt(commentDto.getBno(), 1);
		return commentDao.insert(commentDto);
	}



	@Override
	public int modify(CommentDto dto) throws Exception {
		return commentDao.update(dto);
	}

}








