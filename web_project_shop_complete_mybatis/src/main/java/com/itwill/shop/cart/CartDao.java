package com.itwill.shop.cart;

import java.util.List;

public interface CartDao {

	/*
	 * cart제품 존재여부
	 */
	int countByProductNo(String sUserId, int p_no) throws Exception;

	/*
	 * cart insert(cart)
	 */

	int insert(String sUserId, int p_no, int cart_qty) throws Exception;
	//int insert(Cart cart) throws Exception;

	/*
	 * cart add update(상품에서카트추가시update)
	 */
	int updateByProductNo(String sUserId, int p_no, int cart_qty) throws Exception;

	//int updateByProductNo(Cart cart) throws Exception;

	/*
	 * cart update(카트리스트에서 수정)
	 */
	int updateByCartNo(int cart_no, int cart_qty) throws Exception;

	//int updateByCartNo(Cart cart) throws Exception;

	/*
	 * cart list
	 */
	List<Cart> findByUserId(String userId) throws Exception;

	/*
	 * cart pk delete
	 */
	int deleteByCartNo(int cart_no) throws Exception;
	/*
	 * cart  delete
	 */
	int deleteByUserId(String sUserId) throws Exception;

	Cart findByCartNo(int cart_no) throws Exception;

}