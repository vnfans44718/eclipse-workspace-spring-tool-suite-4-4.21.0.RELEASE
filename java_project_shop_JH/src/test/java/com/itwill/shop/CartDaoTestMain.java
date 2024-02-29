package com.itwill.shop;

import java.util.List;

import com.itwill.shop.dao.CartDao;
import com.itwill.shop.vo.Cart;
import com.itwill.shop.vo.Product;
import com.itwill.shop.vo.User;

public class CartDaoTestMain {

	public static void main(String[] args) throws Exception {
		CartDao cartDao=new CartDao();
		System.out.println("1.add(insert)");
		int insertRowcount=cartDao.insert(Cart.builder()
						.user(User.builder().userid("guard2").build())
						.product(Product.builder().pNo(7).build())
						.cartQty(7)	
					.build());
		System.out.println(">>> cart insert");
		System.out.println("2.updateByCartNo");
		System.out.println(cartDao.updateByCartNo(Cart.builder().cartNo(8).cartQty(4).build()));
		System.out.println("2.updateByProductNo");
		System.out.println(cartDao.updateByProductNo(Cart.builder()
					.user(User.builder().userid("guard1").build()) 
					.product(Product.builder().pNo(1).build())
					.cartQty(8)
					.build()));
		
		
		
		
		System.out.println("2.updateByProductNoAndUserId");
		
		
		System.out.println("3.delete");
		
		System.out.println("4.cartList[select]");
		List<Cart> cartList1=cartDao.findByUserId("guard1");
		System.out.println(cartList1);
		System.out.println("5.countByProductNo");
		System.out.println(cartDao.countByProductNo("guard1", 5));
		
	}
}
