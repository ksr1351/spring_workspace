package reply.service;

import java.util.List;

import reply.dto.ReplyDTO;

public interface ReplyService {
	
	// 댓글조회
		public List<ReplyDTO> readReply(int rnum) throws Exception;
}
