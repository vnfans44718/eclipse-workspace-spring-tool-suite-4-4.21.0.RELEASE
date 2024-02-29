package com.itwill.shop.order;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.shop.mapper.OrderMapper;

public class OrderDaoImplMyBatis implements OrderDao {
	private SqlSessionFactory sqlSessionFactory;

	public OrderDaoImplMyBatis() throws Exception {
		this.sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsStream("mybatis-config.xml"));
	}
	@Override
	public int deleteByUserId(String sUserId) throws Exception {
		SqlSession sqlSession= sqlSessionFactory.openSession(true);
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		int rowCount=orderMapper.deleteByUserId(sUserId);
		sqlSession.close();
		return rowCount;
	}

	@Override
	public int deleteByOrderNo(int o_no) throws Exception {
		SqlSession sqlSession= sqlSessionFactory.openSession(true);
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		int rowCount=orderMapper.deleteByOrderNo(o_no);
		sqlSession.close();
		return rowCount;
	}

	@Override
	public int insert(Order order) throws Exception {
		SqlSession sqlSession= sqlSessionFactory.openSession(false);
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		orderMapper.insert(order);
		List<OrderItem> orderItemList= order.getOrderItemList();
		for(OrderItem orderItem:orderItemList) {
			orderItem.setO_no(order.getO_no());
			orderMapper.insertOrderItem(orderItem);
		}
		sqlSession.commit();
		sqlSession.close();
		return 0;
	}

	@Override
	public List<Order> findOrderByUserId(String sUserId) throws Exception {
		SqlSession sqlSession= sqlSessionFactory.openSession(true);
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		List<Order> orderList=orderMapper.findOrderByUserId(sUserId);
		sqlSession.close();
		return orderList;
	}

	@Override
	public List<Order> findOrderWithOrderItemByUserId(String sUserId) throws Exception {
		SqlSession sqlSession= sqlSessionFactory.openSession(true);
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		List<Order> orderList=orderMapper.findOrderWithOrderItemByUserId(sUserId);
		sqlSession.close();
		return orderList;
	}

	@Override
	public Order findByOrderNo(int o_no) throws Exception {
		SqlSession sqlSession= sqlSessionFactory.openSession(true);
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		Order order=orderMapper.findByOrderNo(o_no);
		sqlSession.close();
		return order;
	}

	
}
