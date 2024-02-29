package com.itwill.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.itwill.shop.product.Product;

public interface ProductMapper {

	/*
	 * selelctByPK : 상품번호로 검색
	 */
	@Select("select * from product where p_no=#{p_no}")
	Product findByPrimaryKey(@Param("p_no") int p_no) throws Exception;

	/*
	 * selectAll : 상품전체검색
	 */
	@Select("select * from product")
	List<Product> findAll() throws Exception;

}