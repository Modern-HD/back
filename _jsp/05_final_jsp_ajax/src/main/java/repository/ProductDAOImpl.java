package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ProductVO;
import orm.DataBaseBuilder;

public class ProductDAOImpl implements ProductDAO {
	private static Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);
	private SqlSession sql;
	private final String NS = "ProductMapper.";
	
	public ProductDAOImpl() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}
	
	@Override
	public int insert(ProductVO pvo) {
		int isUp = sql.insert(NS + "register", pvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<ProductVO> selectList() {
		return sql.selectList(NS + "list");
	}

	@Override
	public ProductVO selectOne(int pno) {
		return sql.selectOne(NS + "detail", pno);
	}

	@Override
	public int update(ProductVO pvo) {
		int isUp = sql.update(NS + "modify", pvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int delete(int pno) {
		int isUp = sql.delete(NS + "remove", pno);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}
}
