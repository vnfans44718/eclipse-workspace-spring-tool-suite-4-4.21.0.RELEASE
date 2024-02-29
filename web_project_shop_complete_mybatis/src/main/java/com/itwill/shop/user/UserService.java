package com.itwill.shop.user;

import com.itwill.shop.user.exception.ExistedUserException;
import com.itwill.shop.user.exception.PasswordMismatchException;
import com.itwill.shop.user.exception.UserNotFoundException;

/*
 * - 회원관리 업무(비즈니스로직,예외처리,트랜젝션,보안,로깅)을 수행하는 클래스
 * - 웹컴포넌트(서블릿,JSP)에서 직접접근(메쏘드호출)하는 클래스(객체)
 * - Dao를 이용해서 데이타베이스를 조작작업(CRUD)하는 클래스
 */
public class UserService {
	
	private UserDao userDao;
	public UserService() throws Exception{
		userDao=new UserDaoImplMyBatis();
	}
	/*
	 * 회원가입
	 */
	public int create(User user) throws Exception {
		// 1.아이디중복체크
		if (userDao.countByUserId(user.getUserId())>0) {
			throw new ExistedUserException(user.getUserId() + " 는 이미존재하는 아이디입니다.");
		}
		return userDao.insert(user);

	}
	
	public User login(String userId, String password) throws Exception {
		// 1.아이디존재여부
		User user = userDao.findUser(userId);
		if (user == null) {
			throw new UserNotFoundException(userId + " 는 존재하지않는 아이디 입니다.");
		}
		// 2.패쓰워드일치여부
		if (!user.isMatchPassword(password)) {
			throw new PasswordMismatchException("패쓰워드가 일치하지않습니다.");
		}
		return user;
	}
	/*
	 * 회원상세보기
	 */
	public User findUser(String userId)throws Exception{
		return userDao.findUser(userId);
	}
	/*
	 * 회원수정
	 */
	public int update(User user)throws Exception{
		return userDao.update(user);
	}
	
	/*
	 * 회원탈퇴
	 */
	public int remove(String userId)throws Exception{
		return userDao.delete(userId);
	}
	public boolean isDuplicateId(String userId) throws Exception {
		int count=userDao.countByUserId(userId);
		boolean isExist = false;
		if(count>0) {
			isExist=true;
		}
		return isExist;
	}
}


















