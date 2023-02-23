package reply.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import reply.dto.ReplyDTO;

public class ReplyDAOImp implements ReplyDAO{
	private SqlSessionTemplate sql;

	
	//댓글 조회
	@Override
	public List<ReplyDTO> readReply(int rnum) throws Exception {
		return sql.selectList("replyMapper.reaReply", rnum);
	}
	

}
