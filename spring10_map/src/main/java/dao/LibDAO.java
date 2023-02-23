package dao;

import java.util.HashMap;
import java.util.List;

import dto.LibmapDTO;

public interface LibDAO {
	//메소드 명을 mapper.xml에 설정되어있는 id와 동일하게 한다.
	//mapMapper.xml
	public List<LibmapDTO> lib_list(HashMap<String, Object> map); //검색에 해당하는 데이터 가져오는 메소드
	
	public int lib_countAll(String data); //검색에 해당하는 데이터 갯수 메소드
	
}
