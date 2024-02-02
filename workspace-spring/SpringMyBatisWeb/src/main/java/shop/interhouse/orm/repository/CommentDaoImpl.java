package shop.interhouse.orm.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.interhouse.orm.domain.CommentDto;

@Repository
public class CommentDaoImpl implements CommentDao {
	
	@Autowired
	private SqlSession session;
	private static String namespace = "shop.interhouse.orm.repository.CommentMapper.";

	@Override
	public int delete(Integer cno) throws Exception {
		return session.delete(namespace + "deleteAll", cno);
	}

	@Override
	public int delete(Integer cno, String commenter) throws Exception {
		Map map = new HashMap(); 
		map.put("cno", cno);
		map.put("commenter", commenter);
		return session.delete(namespace + "delete", map);
	}

	@Override
	public List<CommentDto> selectAll(Integer bno) throws Exception {
		return session.selectList(namespace + "selectAll", bno);
	}

	@Override
	public int insert(CommentDto commentDto) throws Exception {
		return session.insert(namespace + "insert", commentDto);
	}

	@Override
	public int update(CommentDto commentDto) throws Exception {
		return session.update(namespace + "update", commentDto);
	}

}











