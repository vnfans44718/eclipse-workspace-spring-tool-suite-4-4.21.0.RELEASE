package com.itwill.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.common.DataSource;
import com.itwill.shop.dao.sql.OrderSQL;
import com.itwill.shop.vo.Order;
import com.itwill.shop.vo.OrderItem;
import com.itwill.shop.vo.Product;

public class OrderDao {

	private DataSource dataSource;
	
	
	public OrderDao() throws Exception{
		dataSource=new DataSource();
	}
	
	/*
	 * 주문전체삭제(ON DELETE CASCADE)
	 */
	public int deleteByUserId(String sUserId) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_USERID);
			pstmt.setString(1, sUserId);
			rowCount = pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				con.close();
		}
		return rowCount;
	}

	/*
	 * 주문1건삭제(ON DELETE CASCADE)
	 */
	public int deleteByOrderNo(int o_no) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_O_NO);
			pstmt.setInt(1, o_no);
			rowCount = pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				con.close();
		}
		return rowCount;
	}

	/*
	 * 주문생성
	 */
	public int insert(Order order) throws Exception {
		/*
		  insert into orders(o_no,o_desc,o_date,o_price,userid) 
		  values(orders_o_no_SEQ.nextval,'비글외1종',sysdate-2,1050000,'guard1'); 
		  
		  insert into  order_item(oi_no,oi_qty,o_no,p_no)
		  values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,1);
		 */

		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		return 0;
	}

	/*
	 * 주문전체(특정사용자)
	 */
	public List<Order> findOrderByUserId(String sUserId) throws Exception {
		ArrayList<Order> orderList = new ArrayList<Order>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			/*
			 * select * from orders where userid='guard1'
			 */
			pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT_BY_USERID);
			pstmt.setString(1, sUserId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				orderList.add(new Order());
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return orderList;
	}

	/*
	 * 주문+주문아이템 전체(특정사용자)
	 */
	public List<Order> findOrderWithOrderItemByUserId(String sUserId) throws Exception {
		
		List<Order> orderList = new ArrayList<Order>();
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			con = dataSource.getConnection();
			/*
			 * select * from orders where userid='guard1'
			 */
			pstmt1 = con.prepareStatement(OrderSQL.ORDER_SELECT_BY_USERID);
			pstmt1.setString(1, sUserId);
			rs1 = pstmt1.executeQuery();
			while (rs1.next()) {
				orderList.add(new Order());
			}
				
			pstmt2 = con.prepareStatement(OrderSQL.ORDER_SELECT_WITH_ORDERITEM_BY_O_NO);
			for (int i = 0; i < orderList.size(); i++) {
				Order tempOrder = orderList.get(i);
				/*
				 * select * from orders o join order_item oi on o.o_no=oi.o_no join product p on
				 * oi.p_no=p.p_no where o.userid=? and o.o_no = ?
				 */
				
				rs2 = pstmt2.executeQuery();
				/*
				 * O_NO O_DESC O_DATE O_PRICE      USERID OI_NO OI_QTY O_NO P_NO P_NAME 	P_PRICE P_IMAGE P_DESC 
				 * ---------- ----------------------------------------------------------------------------- 
				 * 2 비글외2마리 2023/01/06 1550000 guard2   1    1     1    1   비글 		550000 bigle.png 기타 상세 정보 등... 0 
				 * 2 비글외2마리 2023/01/06 1550000 guard2   2    3     1    2   달마시안 	500000 dalma.jpg 기타 상세 정보 등... 0
				 * 2 비글외2마리 2023/01/06 1550000 guard2   2    2     1    2   달마시안 	500000 dalma.jpg 기타 상세 정보 등... 0
				 */
				Order orderWithOrderItem=null;
				if (rs2.next()) {
					orderWithOrderItem = new Order();
					do {
					
					} while (rs2.next());
				}
				orderList.set(i, orderWithOrderItem);
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return orderList;
	}

	/*
	 * 주문+주문아이템 한개
	 */
	public Order findByOrderNo(int o_no) throws Exception {

		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		con = dataSource.getConnection();
		/*
		 * select * from orders o join order_item oi on o.o_no=oi.o_no join product p on
		 * oi.p_no=p.p_no where o.userid=? and o.o_no = ?
		 */
		pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT_WITH_ORDERITEM_BY_O_NO);
		pstmt.setInt(1, o_no);
		rs = pstmt.executeQuery();
		/*
		  O_NO   O_DESC 	  O_DATE 	O_PRICE  USERID  OI_NO  OI_QTY O_NO P_NO P_NAME 	  P_PRICE   P_IMAGE 	P_DESC 
		  ---------- ------------------------------------------------------------------------------------------------------------ 
		  1   비글외1마리 	2023/01/06 	1550000  guard1 	1 	 1 		 1   1 	 비글 	      550000 	bigle.png 	기타 상세 정보 등... 0 
		  1   비글외1마리 	2023/01/06 	1550000  guard1 	2 	 2 		 1   2 	 달마시안     500000 	dalma.jpg 	기타 상세 정보 등... 0
		 */
		if (rs.next()) {
			
		}
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return order;
	}

}
