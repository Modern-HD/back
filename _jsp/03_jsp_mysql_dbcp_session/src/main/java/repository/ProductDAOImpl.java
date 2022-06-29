package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ProductVO;

public class ProductDAOImpl implements ProductDAO {
	private static Logger log = LoggerFactory.getLogger(EmpDAOImpl.class);
	private Connection cn;
	private PreparedStatement pst;
	private ResultSet rs;
	private String query;
	
	public ProductDAOImpl() {
		cn = DBConnector.getConnection();
	}
	
	@Override
	public int insert(ProductVO pvo) {
		query = "insert into product(pname, price, regdate, madeby) values(?, ?, now(), ?)";
		try {
			pst = cn.prepareStatement(query);
			pst.setString(1, pvo.getPname());
			pst.setDouble(2, pvo.getPrice());
			pst.setString(3, pvo.getMadeby());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("productDAOImpl > insert > error");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<ProductVO> selectList() {
		List<ProductVO> list = new ArrayList<>();
		query = "select * from product order by pno";
		try {
			pst = cn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new ProductVO(rs.getInt("pno"), rs.getString("pname"), rs.getDouble("price"), rs.getString("regdate"), rs.getString("madeby")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("productDAOImpl > selectList > error");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ProductVO selectOne(int pno) {
		query = "select * from product where pno = ?";
		ProductVO pvo = null;
		try {
			pst = cn.prepareStatement(query);
			pst.setInt(1, pno);
			rs = pst.executeQuery();
			if(rs.next()) {
				pvo = new ProductVO(rs.getInt("pno"), rs.getString("pname"), rs.getDouble("price"), rs.getString("regdate"), rs.getString("madeby"));
			}
			return pvo;
		} catch (SQLException e) {
			System.out.println("productDAOImpl > selectOne > error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(ProductVO pvo) {
		query = "update product set pname=?, price=?, madeby=? where pno=?";
		try {
			pst = cn.prepareStatement(query);
			pst.setString(1, pvo.getPname());
			pst.setDouble(2, pvo.getPrice());
			pst.setString(3, pvo.getMadeby());
			pst.setInt(4, pvo.getPno());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("productDAOImpl > update > error");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int pno) {
		query = "delete from product where pno = ?";
		try {
			pst = cn.prepareStatement(query);
			pst.setInt(1, pno);
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("productDAOImpl > delete > error");
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
