package com.itwill.shop.product;

import java.util.List;

public interface ProductDao {

	/*
	 * selelctByPK : 상품번호로 검색
	 */
	Product findByPrimaryKey(int p_no) throws Exception;

	/*
	 * selectAll : 상품전체검색
	 */
	List<Product> findAll() throws Exception;

}