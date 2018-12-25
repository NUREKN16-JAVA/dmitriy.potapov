package ua.nure.kn.potapov.usermanagement.db;
public class DaoFactoryImpl extends DaoFactory {

private static final String USER_DAO = "dao.ua.nure.kn.potapov.usermanagement.db.UserDao";
    @Override

    public UserDao getUserDao() {

        UserDao result = null;
        try {
            Class<?> myclass = Class.forName(properties.getProperty(USER_DAO));
            result = (UserDao) myclass.newInstance();
            result.setConnectionFactory(getConnectionFactory());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (DatabaseException e) {
            e.printStackTrace();

        }

        return result;
    }
}