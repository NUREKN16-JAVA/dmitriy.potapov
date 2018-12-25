package ua.nure.kn.potapov.usermanagement.db;

import java.util.Collection;

import ua.nure.kn.potapov.usermanagement.User;

import java.util.Collection;

public interface UserDao {
    User create(User user) throws DatabaseException;

    User find(Long id) throws DatabaseException;

    Collection<User> findAll() throws DatabaseException;


    void update(User user) throws DatabaseException;

    void delete(User user) throws DatabaseException;


    void setConnectionFactory(ConnectionFactory connectionFactory) throws DatabaseException;
}

