package ua.nure.kn.potapov.usermanagement.db;
import java.sql.Connection;

public interface ConnectionFactory {
    /* Connection to databaseConnection to database, DatabaseException */

    Connection createConnection() throws DatabaseException;
}
