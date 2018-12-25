package ua.nure.kn.potapov.usermanagement.db;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ua.nure.kn.potapov.usermanagement.User;
import ua.nure.kn.potapov.usermanagement.db.ConnectionFactory;
import ua.nure.kn.potapov.usermanagement.db.DatabaseException;
import ua.nure.kn.potapov.usermanagement.db.UserDao;

public class MockUserDao implements UserDao {

    private long id = 0;
    private Map<Long, User> users = new HashMap<>();


    //создание нового
    @Override
    public User create(User user) throws DatabaseException {
        Long currentId = new Long(++id);
        user.setId(currentId);
        users.put(currentId, user);
        return user;
    }

    // обновление инфы
    @Override
    public void update(User user) throws DatabaseException {
        Long currentId = user.getId();
        users.remove(currentId);
        users.put(currentId, user);
    }

    // для удаления
    @Override
    public void delete(User user) throws DatabaseException {
        Long currentId = user.getId();
        users.remove(currentId);

    }

    // поиск
    @Override
    public User find(Long id) throws DatabaseException {
        return users.get(id);
    }

    // для поиска
    @Override
    public Collection<User> findAll() throws DatabaseException {
        return users.values();
    }

    @Override
    public void setConnectionFactory(ConnectionFactory connectionFactory) throws DatabaseException {
        // автогенерация

    }

}