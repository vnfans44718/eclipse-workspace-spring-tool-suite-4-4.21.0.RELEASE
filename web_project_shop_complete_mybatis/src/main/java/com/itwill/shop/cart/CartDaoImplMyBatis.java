package com.itwill.shop.cart;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.shop.mapper.CartMapper;

public class CartDaoImplMyBatis implements CartDao {
	private SqlSessionFactory sqlSessionFactory;
	public CartDaoImplMyBatis() throws Exception{
		this.sqlSessionFactory = 
				new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsStream("mybatis-config.xml"));
	}
	
	/*
	 * cart제품 존재여부
	 */
	@Override
	public int countByProductNo(String sUserId, int p_no) throws Exception {
		SqlSession sqlSession= 
				sqlSessionFactory.openSession(true);
		CartMapper cartMapper=sqlSession.getMapper(CartMapper.class);
		int count = cartMapper.countByProductNo(sUserId, p_no);
		return count;
	}
	/*
	 * cart insert(cart)
	 */
	/*
	@Override
	public int insert(Cart cart) throws Exception {
		SqlSession sqlSession= 
				sqlSessionFactory.openSession(true);
		CartMapper cartMapper=sqlSession.getMapper(CartMapper.class);
		int insertRowCount = cartMapper.insert(cart);
		sqlSession.close();
		return insertRowCount;

	}
	*/
	@Override
	public int insert(String sUserId, int p_no, int cart_qty) throws Exception {
		SqlSession sqlSession= 
				sqlSessionFactory.openSession(true);
		CartMapper cartMapper=sqlSession.getMapper(CartMapper.class);
		int insertRowCount = cartMapper.insert(sUserId, p_no, cart_qty);
		sqlSession.close();
		return insertRowCount;

	}

	/*
	 * cart add update(상품에서카트추가시update)
	 */
	@Override
	public int updateByProductNo(String sUserId, int p_no, int cart_qty) throws Exception {
		SqlSession sqlSession= 
				sqlSessionFactory.openSession(true);
		CartMapper cartMapper=sqlSession.getMapper(CartMapper.class);
		int rowCount = cartMapper.updateByProductNo(sUserId, p_no, cart_qty);
		sqlSession.close();
		return rowCount;
	}

	/*@Override
	public int updateByProductNo(Cart cart) throws Exception {
		SqlSession sqlSession= 
				sqlSessionFactory.openSession(true);
		CartMapper cartMapper=sqlSession.getMapper(CartMapper.class);
		int rowCount = cartMapper.updateByProductNo(cart);
		sqlSession.close();
		return rowCount;
	}
	*/
	/*
	 * cart update(카트리스트에서 수정)
	 */
	@Override
	public int updateByCartNo(int cart_no, int cart_qty) throws Exception {
		SqlSession sqlSession= 
				sqlSessionFactory.openSession(true);
		CartMapper cartMapper=sqlSession.getMapper(CartMapper.class);
		int rowCount = cartMapper.updateByCartNo(cart_no, cart_qty);
		sqlSession.close();
		return rowCount;
	}

	/*
	@Override
	public int updateByCartNo(Cart cart) throws Exception {
		SqlSession sqlSession= 
				sqlSessionFactory.openSession(true);
		CartMapper cartMapper=sqlSession.getMapper(CartMapper.class);
		int rowCount =cartMapper.updateByProductNo(cart);
		sqlSession.close();
		return rowCount;
	}
	*/

	/*
	 * cart list
	 */
	@Override
	public List<Cart> findByUserId(String userId) throws Exception {
		/*
		select c.*,p.* from cart c join product p on c.p_no=p.p_no where userid='guard1'
		
		CART_NO   CART_QTY  USERID    	P_NO 	P_NAME      P_PRICE    	P_IMAGE          P_DESC                                                                                                P_DESC                                                                                                                                                                                                   P_CLICK_COUNT
		---------- ---------- --------------------------------------------------------------------------
		   	8			1	guard1		5		포메라니안	800000		pomeranian.jpg	 기타 상세 정보 등...	
			9			1	guard1		8		사모예드	800000		samoyed.jpg		 기타 상세 정보 등...	0
			7			1	guard1		6		샤페이		700000		shaipei.jpg	  	 기타 상세 정보 등...	0
		*/
		List<Cart> cartList = new ArrayList<Cart>();
		SqlSession sqlSession= 
				sqlSessionFactory.openSession(true);
		CartMapper cartMapper=sqlSession.getMapper(CartMapper.class);
		cartList=cartMapper.findByUserId(userId);
		sqlSession.close();
		return cartList;
	}

	/*
	 * cart pk delete
	 */
	@Override
	public int deleteByCartNo(int cart_no) throws Exception {
		SqlSession sqlSession= 
				sqlSessionFactory.openSession(true);
		CartMapper cartMapper=sqlSession.getMapper(CartMapper.class);
		int deleteRowCount = cartMapper.deleteByCartNo(cart_no);
		sqlSession.close();
		return deleteRowCount;
	}

	/*
	 * cart  delete
	 */
	@Override
	public int deleteByUserId(String sUserId) throws Exception {
		SqlSession sqlSession= 
				sqlSessionFactory.openSession(true);
		CartMapper cartMapper=sqlSession.getMapper(CartMapper.class);
		int deleteRowCount = cartMapper.deleteByUserId(sUserId);
		sqlSession.close();
		return deleteRowCount;
	}
	
	@Override
	public Cart findByCartNo(int cart_no) throws Exception {
		SqlSession sqlSession= 
				sqlSessionFactory.openSession(true);
		CartMapper cartMapper=sqlSession.getMapper(CartMapper.class);
		Cart cart = cartMapper.findByCartNo(cart_no);
		sqlSession.close();
		return cart;
	}
}
