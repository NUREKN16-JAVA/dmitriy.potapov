package ua.nure.kn16.potapov.usermanagement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.nure.kn16.potapov.usermanagement.User;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class UserTest {
    public static final long ID = 1L;
    public static final String FIRST_NAME = "Ivan";
    public static final String LAST_NAME = "Ivanov";

    private static final int YEAR_OF_BIRTH = 1990;

    private static int today;

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User(ID, FIRST_NAME, LAST_NAME, new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        today = calendar.get(Calendar.DATE);
    }


    @Test
    public void testGetFullName() {
        User user = new User(ID, FIRST_NAME, LAST_NAME, null);
        assertEquals("Ivan, Ivanov", user.getFullName());
    }


    //����� ���� �������� ��� ����� � ���� ����
    @Test
    public void testAgeAfter() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH, Calendar.SEPTEMBER, 15);
        User user = new User(ID, FIRST_NAME, LAST_NAME, calendar.getTime());
        assertEquals(28, user.getAge());
    }

    //����� ���� �������� ����� ����� � ���� ����
    @Test
    public void testAgeBefore() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH, Calendar.NOVEMBER, 15);
        User user = new User(ID, FIRST_NAME, LAST_NAME, calendar.getTime());
        assertEquals(27, user.getAge());
    }

       //����� ���� �������� �������
    @Test
    public void testAgeTheSameDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH, Calendar.OCTOBER, today);
        User user = new User(ID, FIRST_NAME, LAST_NAME, calendar.getTime());
        assertEquals(28, user.getAge());
    }
}