package members.service;

import common.exception.WrongEmailPasswordException;
import members.dao.MembersDAO;
import members.dto.AuthInfo;
import members.dto.ChangePwdCommand;
import members.dto.MembersDTO;

public class MembersServiceImp implements MembersService{
	private MembersDAO membersDao;
	
	public MembersServiceImp() {
		
	}
	
	public void setMembersDao(MembersDAO membersDao) {
		this.membersDao = membersDao;
	}

	@Override
	public AuthInfo addmemberProcess(MembersDTO dto) {//회원가입후 바로 로그인처리
		membersDao.insertMember(dto);
		return new AuthInfo(dto.getMemberEmail(), dto.getMemberName(), dto.getMemberPass());
	}

	@Override
	public AuthInfo loginProcess(MembersDTO dto) {
		
		MembersDTO member = membersDao.selectByEmail(dto.getMemberEmail());
		if(member == null){//회원이 아니면
			//System.out.println("회원이 아닙니다.");
			throw new WrongEmailPasswordException();//사용자 예외가 예상될 때 throw 사용
		}
		
		if(!member.matchPassword(dto.getMemberPass())) {//비밀번호가 다를 경우
			//System.out.println("비밀번호가 다릅니다.");
			throw new WrongEmailPasswordException();
		}
			
		return new AuthInfo(member.getMemberEmail(), member.getMemberName(), member.getMemberPass());
	}

	@Override
	public MembersDTO updateMemberProcess(String memberEmail) {
		
		return membersDao.selectByEmail(memberEmail); //멤버에 해당되는 이메일 값 가져오기
		
	}

	@Override
	public AuthInfo updateMemberProcess(MembersDTO dto) {
		membersDao.updateMember(dto);
		MembersDTO member = membersDao.selectByEmail(dto.getMemberEmail());
		return new AuthInfo(member.getMemberEmail(), member.getMemberName(), member.getMemberPass());
		
	}

	@Override
	public void updatePassProcess(String memberEmail, ChangePwdCommand changePwd) {
		MembersDTO member = membersDao.selectByEmail(memberEmail); //이메일에 대한 정보 가져오고 MembersDTO member 가 받음
		if(member == null)
			throw new WrongEmailPasswordException();
		
		member.changePassword(changePwd.getCurrentPassword(), changePwd.getNewPassword());
		membersDao.updateByPass(member);
		
	}
}











