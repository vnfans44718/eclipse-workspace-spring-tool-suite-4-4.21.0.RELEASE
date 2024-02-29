package com.itwill.shop.order;

import java.util.List;

public interface OrderDao {

	/*
	 * 주문전체삭제(ON DELETE CASCADE)
	 */
	int deleteByUserId(String sUserId) throws Exception;

	/*
	 * 주문1건삭제(ON DELETE CASCADE)
	 */
	int deleteByOrderNo(int o_no) throws Exception;

	/*
	 * 주문생성
	 */
	int insert(Order order) throws Exception;

	/*
	 * 주문전체(특정사용자)
	 */
	List<Order> findOrderByUserId(String sUserId) throws Exception;

	/*
	 * 주문+주문아이템 전체(특정사용자)
	 */
	List<Order> findOrderWithOrderItemByUserId(String sUserId) throws Exception;

	/*
	 * 주문1개보기(주문상세리스트)
	 */
	Order findByOrderNo(int o_no) throws Exception;

}