package reply.dao;

import java.util.List;

import reply.dto.ReplyDTO;

public interface ReplyDAO {

	// 댓글조회
	public List<ReplyDTO> readReply(int rnum) throws Exception;
	//throws Exception => 예외가 발생하면 자신을 호출한 상위메서드로 예외던짐
}
