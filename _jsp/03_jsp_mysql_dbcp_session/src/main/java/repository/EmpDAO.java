package repository;

import java.util.List;

import domain.EmpVO;

public interface EmpDAO {
	public int insert(EmpVO evo);
	public List<EmpVO> selectList();
	public EmpVO selectOne(int empno);
	public EmpVO selectOne(int empno, String pwd);
	public int update(EmpVO evo);
	public int delete(int empno);
}
