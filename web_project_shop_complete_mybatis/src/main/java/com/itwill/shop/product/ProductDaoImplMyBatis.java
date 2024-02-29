package com.itwill.shop.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.shop.common.DataSourceFactory;
import com.itwill.shop.mapper.ProductMapper;
import com.itwill.shop.mapper.UserMapper;

/*
쇼핑몰에서 상품테이블과의 데이타베이스와의 작업을 전담하는 클래스
PRODUCT 테이블에 제품 검색 등의 작업을한다.
*/
public class ProductDaoImplMyBatis implements ProductDao {
	private SqlSessionFactory sqlSessionFactory;

	public ProductDaoImplMyBatis() throws Exception {
		this.sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsStream("mybatis-config.xml"));
	}

	
	
	
	/*
	 * selelctByPK : 상품번호로 검색
	 */
	@Override
	public Product findByPrimaryKey(int p_no) throws Exception {
		SqlSession sqlSession= sqlSessionFactory.openSession(true);
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		Product product=productMapper.findByPrimaryKey(p_no);
		sqlSession.close();
		return product;
	}

	/*
	 * selectAll : 상품전체검색
	 */
	@Override
	public List<Product> findAll() throws Exception {
		SqlSession sqlSession= sqlSessionFactory.openSession(true);
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		List<Product> productList=productMapper.findAll();
		return productList;
	}
}
