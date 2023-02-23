package reply.service;

import java.util.List;

import reply.dao.ReplyDAO;
import reply.dto.ReplyDTO;

public class ReplyServiceImp implements ReplyService{
	private ReplyDAO replyDao;
	
	public ReplyServiceImp() {
		
	}

	@Override
	public List<ReplyDTO> readReply(int rnum) throws Exception {
		return replyDao.readReply(rnum);
	}

}
