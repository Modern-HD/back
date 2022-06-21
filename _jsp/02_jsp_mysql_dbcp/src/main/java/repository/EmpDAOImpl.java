package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.EmpVO;

public class EmpDAOImpl implements EmpDAO {
	private static Logger log = LoggerFactory.getLogger(EmpDAOImpl.class);
	private Connection cn;
	private PreparedStatement pst;
	private ResultSet rs;
	private String query;
	
	public EmpDAOImpl() {
		cn = DBConnector.getConnection();
	}

	@Override
	public int insert(EmpVO evo) {
		query = "insert into emp(empno, pwd, ename, hiredate) values(?, ?, ?, now())";
		try {
			pst = cn.prepareStatement(query);
			pst.setInt(1, evo.getEmpno());
			pst.setString(2, evo.getPwd());
			pst.setString(3, evo.getEname());
			return pst.executeUpdate();
		} catch (SQLException e) {
			log.info(">>> EmpDAO > insert > Error");
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public List<EmpVO> selectList() {
		List<EmpVO> list = new ArrayList<>();
		query = "select empno, ename, hiredate, deptno from emp order by empno";
		try {
			pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new EmpVO(rs.getInt("empno"), rs.getString("ename"), rs.getString("hiredate"), rs.getInt("deptno")));
			}
			return list;
		} catch (SQLException e) {
			log.info(">>> EmpDAO > selectList > Error");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public EmpVO selectOne(int empno) {
		EmpVO empVO = null;
		query = "select * from emp where empno = ?";
		try {
			pst = cn.prepareStatement(query);
			pst.setInt(1, empno);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				empVO = new EmpVO(rs.getInt("empno"), rs.getString("pwd"), rs.getString("ename"), rs.getString("job"),
						rs.getInt("mgr"), rs.getString("hiredate"), rs.getDouble("sal"), rs.getDouble("comm"), rs.getInt("deptno"));
			}
			return empVO;
		} catch (SQLException e) {
			log.info(">>> EmpDAO > selectOne > Error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(EmpVO evo) {
		query = "update emp set ename=?, job=?, mgr=?, sal=?, comm=?, deptno=? where empno=?";
		try {
			pst = cn.prepareStatement(query);
			pst.setString(1, evo.getEname());
			pst.setString(2, evo.getJob());
			pst.setInt(3, evo.getMgr());
			pst.setDouble(4, evo.getSal());
			pst.setDouble(5, evo.getComm());
			pst.setInt(6, evo.getDeptno());
			pst.setInt(7, evo.getEmpno());
			return pst.executeUpdate();
		} catch (SQLException e) {
			log.info(">>> EmpDAO > update > Error");
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(int empno) {
		query = "delete from emp where empno = ?";
		try {
			pst = cn.prepareStatement(query);
			pst.setInt(1, empno);
			pst.executeUpdate();
		} catch (SQLException e) {
			log.info(">>> EmpDAO > delete > Error");
			e.printStackTrace();
		}
		return 0;
	}
}
