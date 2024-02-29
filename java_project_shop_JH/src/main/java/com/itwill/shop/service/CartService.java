package com.itwill.shop.service;

import java.util.List;

import com.itwill.shop.dao.CartDao;
import com.itwill.shop.vo.Cart;
public class CartService {
	private CartDao cartDao;
	public CartService() throws Exception {
		cartDao=new CartDao();
	}
	
	/*
	 * 카트추가 or 수정
	 */
	public int addCart(String sUserId,int p_no,int cart_qty)throws Exception {
		if(cartDao.countByProductNo(sUserId, p_no) > 0) {
			//수정
			cartDao.updateByProductNo(sUserId, p_no, cart_qty);
		}else {
			//추가
			cartDao.insert(sUserId,p_no,cart_qty);
		}
		return 0;
	}
	public int addCart(Cart cart)throws Exception {
		if(cartDao.countByProductNo(cart.getUser().getUserid(), cart.getProduct().getPNo()) > 0) {
			//수정
			cartDao.updateByProductNo(cart);
		}else {
			//추가
			cartDao.insert(cart);
		}
		return 0;
	}
	/*
	 * 카트수량변경수정
	 */
	public int updateCart(int cart_no,int cart_qty)throws Exception {
		return 0;
	}
	public int updateCart(Cart cart)throws Exception {
		return 0;
	}
	/*
	 * 카트보기
	 */
	public List<Cart> getCartItemByUserId(String sUserId) throws Exception{
		return null;
	}
	/*
	 * 카트아이템1개보기
	 */
	public Cart getCartItemByCartNo(int cart_no) throws Exception{
		return cartDao.findByCartNo(cart_no);
	}
	
	/*
	 * 카트아이템1개삭제
	 */
	public int deleteCartItemByCartNo(int cart_no) throws Exception{
		return 0;
	}
	/*
	 * 카트삭제
	 */
	public int deleteCartItemByUserId(String sUserId)throws Exception {
		return 0;
	}
}
