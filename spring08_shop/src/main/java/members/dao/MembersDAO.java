package members.dao;

import members.dto.MembersDTO;

public interface MembersDAO {

	public int insertMember(MembersDTO dto);
	public MembersDTO selectByEmail(String memberEmail);
	
	public void updateMember(MembersDTO dto); //회원정보 위해 사용
	public void updateByPass(MembersDTO dto); //비밀번호 위해 사용
}
