package com.itwill.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.common.DataSource;
import com.itwill.shop.dao.sql.CartSQL;
import com.itwill.shop.vo.Cart;
import com.itwill.shop.vo.Product;
import com.itwill.shop.vo.User;


public class CartDao {
	private DataSource dataSource;
	
	
	public CartDao() throws Exception{
		dataSource=new DataSource();
	}
	
	/*
	 * cart제품 존재여부
	 */
	public int  countByProductNo(String sUserId,int p_no) throws Exception{
		int count=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_COUNT_BY_USERID_PRODUCT_NO);
			pstmt.setString(1, sUserId);
			pstmt.setInt(2, p_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
			
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return count;
	}
	
	
	/*
	 * cart insert(cart)
	 */
	public int insert(Cart cart) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		int insertRowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_INSERT);
			pstmt.setInt(1, cart.getCartQty());
			pstmt.setInt(2, cart.getProduct().getPNo());
			pstmt.setString(3,cart.getUser().getUserid());
			insertRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return insertRowCount;
		
	}
	
	public int insert(String sUserId,int p_no,int cart_qty) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		int insertRowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_INSERT);
			pstmt.setInt(1, cart_qty);
			pstmt.setInt(2, p_no);
			pstmt.setString(3, sUserId);
			insertRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return insertRowCount;
		
	}
	/*
	 * cart add update(상품에서카트추가시update)
	 */
	public int updateByProductNo(String sUserId,int p_no,int cart_qty) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_UPDATE_BY_PRODUCT_NO_USERID);
			pstmt.setInt(1, cart_qty);
			pstmt.setString(2, sUserId);
			pstmt.setInt(3, p_no);
			rowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return rowCount;
	}
	public int updateByProductNo(Cart cart) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_UPDATE_BY_PRODUCT_NO_USERID);
			
			rowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return rowCount;
	}
	/*
	 * cart update(카트리스트에서 수정)
	 * cart PK로 업데이트 한다
	 */
	public int updateByCartNo(int cart_no,int cart_qty) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_UPDATE_BY_CART_NO);
			pstmt.setInt(1, cart_qty);
			pstmt.setInt(2, cart_no);
			rowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return rowCount;
	}
	
	
	//상품 리스트에서 추가 시
	public int updateByCartNo(Cart cart) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_UPDATE_BY_CART_NO);
			pstmt.setInt(1, cart.getCartQty());
			pstmt.setString(2, cart.getUser().getUserid());
			pstmt.setInt(3, cart.getProduct().getPNo());
			
		
			rowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return rowCount;
	}
	/*
	 * cart list
	 */
	public List<Cart> findByUserId(String userId) throws Exception{
		List<Cart> cartList=new ArrayList<Cart>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			/*
			select c.*,p.* from cart c join product p on c.p_no=p.p_no where userid='guard1'
			
			CART_NO   CART_QTY  USERID    	P_NO 	P_NAME      P_PRICE    	P_IMAGE          P_DESC                                                                                                P_DESC                                                                                                                                                                                                   P_CLICK_COUNT
			---------- ---------- --------------------------------------------------------------------------
			   	8			1	guard1		5		포메라니안	800000		pomeranian.jpg	 기타 상세 정보 등...	
				9			1	guard1		8		사모예드	800000		samoyed.jpg		 기타 상세 정보 등...	0
				7			1	guard1		6		샤페이		700000		shaipei.jpg	  	 기타 상세 정보 등...	0
			*/   
			pstmt=con.prepareStatement(CartSQL.CART_SELECT_BY_USERID);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Cart cart =Cart.builder()
						.cartNo(rs.getInt("cart_no"))
						.user(User.builder().userid(rs.getString("userid")).build())
						.cartQty(rs.getInt("cart_qty"))
						.product(Product.builder()
									.pNo(rs.getInt("p_no"))
									.pName(rs.getString("p_name"))
									.pPrice(rs.getInt("p_price"))
									.pImage(rs.getString("p_image"))
									.pDesc(rs.getString("p_desc"))
									.build())
						.build();
				cartList.add(cart);
				
			}
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		
		return cartList;
	}
	
	/*
	 * cart pk delete
	 */
	public int deleteByCartNo(int cart_no) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		int deleteRowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_DELETE_BY_CART_NO);
			pstmt.setInt(1, cart_no);
			deleteRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return deleteRowCount;
	}
	/*
	 * cart  delete
	 */
	public int deleteByUserId(String sUserId) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		int deleteRowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_DELETE_BY_USERID);
			pstmt.setString(1, sUserId);
			deleteRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return deleteRowCount;
	}
	public Cart findByCartNo(int cart_no)throws Exception {
		Cart cart=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_SELECT_BY_CART_NO);
			pstmt.setInt(1,cart_no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				cart=new Cart();
			}
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return cart;
	}
}
