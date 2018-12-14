package ua.nure.kn16.potapov.usermanagement.db;

import com.mockobjects.dynamic.Mock;

import ua.nure.kn16.potapov.usermanagement.db.DaoFactory;
import ua.nure.kn16.potapov.usermanagement.db.UserDao;


public class MockDaoFactory extends DaoFactory {
	
	private Mock mockUserDao;
	
	public MockDaoFactory() {
		mockUserDao = new Mock(UserDao.class);
	}

	public Mock getMockUserDao() {
		return mockUserDao;
	}
	
	@Override
	public UserDao getUserDao() {
		
		return (UserDao) mockUserDao.proxy();
	}

}
