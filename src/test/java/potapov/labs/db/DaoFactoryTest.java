package potapov.labs.db;

import junit.framework.TestCase;
import potapov.labs.db.DaoFactory;
import potapov.labs.db.UserDao;

public class DaoFactoryTest extends TestCase {

	public void testGetUserDao() {
		try {
			DaoFactory daoFactory = DaoFactory.getInstance();
			assertNotNull("DaoFactory instance is null", daoFactory);
			UserDao userDao = daoFactory.getUserDao();
			assertNotNull("UserDao intance is null", userDao);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

}
