package board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import board.dto.BoardDTO;
import board.dto.PageDTO;

public class BoardDaoImp implements BoardDAO{
	private SqlSessionTemplate sqlSession;
	
	public BoardDaoImp() {
		
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public int count() {
		return sqlSession.selectOne("board.count");
	}

	@Override
	public List<BoardDTO> list(PageDTO pv) {
		
		return sqlSession.selectList("board.list", pv);
	}

	@Override
	public void readCount(int num) {
		sqlSession.update("board.readCount",num); //조회수 업데이트
		
	}

	@Override
	public BoardDTO content(int num) {
		return sqlSession.selectOne("board.content", num); //조회수 업데이트 이후 실행
	}

	@Override
	public void reStepCount(BoardDTO dto) {
		sqlSession.update("board.reStepCount", dto);
		
	}

	@Override
	public void save(BoardDTO dto) { //save를 serviceImp에서 호출
		sqlSession.insert("board.save", dto);
		
	}

	@Override
	public void update(BoardDTO dto) {
		sqlSession.update("board.update", dto);
		
	}

	@Override
	public void delete(int num) {
		sqlSession.delete("board.delete", num);
		
	}

	@Override
	public String getFile(int num) {
		
		return sqlSession.selectOne("board.getFile", num);
	}
}

