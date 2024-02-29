package com.itwill.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.shop.cart.Cart;

public interface CartMapper {

	/*
	 * cart제품 존재여부
	 */
	@Select("select count(*)  as p_count from cart  where userid=#{userid} and p_no=#{p_no}")
	int countByProductNo(@Param("userid") String sUserId, @Param("p_no") int p_no) throws Exception;
	/*
	 * cart insert(cart)
	 */
	//@Insert("insert into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_SEQ.nextval,#{cart_qty},#{p_no},#{userid})")
	//int insert(Cart cart) throws Exception;
	@Insert("insert into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_SEQ.nextval,#{cart_qty},#{p_no},#{userid})")
	int insert(@Param("userid") String sUserId, @Param("p_no")  int p_no,@Param("cart_qty")  int cart_qty) throws Exception;
	/*
	 * cart add update(상품에서카트추가시update)
	 */
	@Update("update cart set cart_qty=cart_qty+#{cart_qty} where userid=#{userid} and p_no=#{p_no}")
	int updateByProductNo(@Param("userid") String sUserId, @Param("p_no") int p_no, @Param("cart_qty") int cart_qty) throws Exception;
	//@Update("update cart set cart_qty=cart_qty+#{cart_qty} where userid=#{userid} and p_no=#{p_no}")
	//int updateByProductNo(Cart cart) throws Exception;

	/*
	 * cart update(카트리스트에서 수정)
	 */
	@Update("update cart set cart_qty=#{cart_qty} where cart_no=#{cart_no}")
	int updateByCartNo(@Param("cart_no") int cart_no, @Param("cart_qty") int cart_qty) throws Exception;
	//@Update("update cart set cart_qty=#{cart_qty} where cart_no=#{cart_no}")
	//int updateByCartNo(Cart cart) throws Exception;

	/*
	 * cart list
	 */
	@ResultMap("cartResultMap")
	@Select("select c.*,p.* from cart c join product p on c.p_no=p.p_no where userid=#{userid}")
	List<Cart> findByUserId(@Param("userid") String userId) throws Exception;
	/*
	 * cart pk delete
	 */
	@Delete("delete from cart where cart_no=#{cart_no}")
	int deleteByCartNo(@Param("cart_no") int cart_no) throws Exception;

	/*
	 * cart  delete
	 */
	@Delete("delete from cart where userid=#{userid}")
	int deleteByUserId(@Param("userid") String sUserId) throws Exception;
	
	@ResultMap("cartResultMap")
	@Select("select * from cart c join product p on c.p_no=p.p_no where cart_no=#{cart_no}")
	Cart findByCartNo(@Param("cart_no") int cart_no) throws Exception;

}