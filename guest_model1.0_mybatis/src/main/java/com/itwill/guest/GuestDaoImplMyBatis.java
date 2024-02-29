package com.itwill.guest;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.guest.mapper.GuestMapper;

public class GuestDaoImplMyBatis implements GuestDao {
	private SqlSessionFactory sqlSessionFactory;

	public GuestDaoImplMyBatis() {
		try {
			InputStream mybatisConfigInputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			this.sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfigInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Guest guest) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int insertRowCount = sqlSession.getMapper(GuestMapper.class).insert(guest);
		return guest.getGuestNo();
	}

	@Override
	public int update(Guest guest) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int updateRowCount = sqlSession.getMapper(GuestMapper.class).update(guest);
		return updateRowCount;
	}

	@Override
	public int delete(int guestNo) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int deleteRowCount = sqlSession.getMapper(GuestMapper.class).delete(guestNo);
		return deleteRowCount;
	}

	@Override
	public Guest findByGuestNo(int guestNo) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		Guest findGuest = sqlSession.getMapper(GuestMapper.class).findByGuestNo(guestNo);

		return findGuest;
	}

	@Override
	public List<Guest> findByAll() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		List<Guest> guestList = sqlSession.getMapper(GuestMapper.class).findByAll();
		sqlSession.close();
		return guestList;
	}

}
