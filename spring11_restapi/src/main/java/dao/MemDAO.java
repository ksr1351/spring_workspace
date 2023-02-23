package dao;

import java.util.List;

import model.MemDTO;

public interface MemDAO {
	public List<MemDTO> list();
	
	public MemDTO list(MemDTO dto);
	
	public void insertMethod(MemDTO dto);
	
	public MemDTO updateMethod(int num);
	
	public void updateMethod(MemDTO dto);
	
	public void deletMethod(int num);
	
	public MemDTO one(int num);
	
	public int countMethod();
	
}
