package ua.nure.kn.potapov.usermanagement.web;


import ua.nure.kn.potapov.usermanagement.User;
import ua.nure.kn.potapov.usermanagement.web.EditServlet;
import ua.nure.kn.potapov.usermanagement.web.MockServletTestCase;

import java.text.DateFormat;
import java.util.Date;

public class EditServletTest extends MockServletTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();

        createServlet(EditServlet.class);    }

    public void testEdit() {
        Date date = new Date();
        User user = new User(new Long(1000), "Dmitriy", "Potapov", date);
        getMockUserDao().expect("update", user);

        addRequestParameter("id", "1000");
        addRequestParameter("firstName", "Dmitriy");
        addRequestParameter("lastName", "Potapov");
        addRequestParameter("date", DateFormat.getDateInstance().format(date));
        addRequestParameter("okButton", "Ok");
        doPost();
    }

    public void testEditEmptyFirstName() {
        Date date = new Date();
        addRequestParameter("id", "1000");
        addRequestParameter("lastName", "Potapov");
        addRequestParameter("date", DateFormat.getDateInstance().format(date));
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

    public void testEditEmptyLastName() {
        Date date = new Date();
        addRequestParameter("id", "1000");
        addRequestParameter("firstName", "Dmitriy");
        addRequestParameter("date", DateFormat.getDateInstance().format(date));
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

    public void testEditEmptyDate() {
        Date date = new Date();
        addRequestParameter("id", "1000");
        addRequestParameter("firstName", "Dmitriy");
        addRequestParameter("lastName", "Potapov");
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

    public void testEditInvalidDate() {
        Date date = new Date();
        addRequestParameter("id", "1000");
        addRequestParameter("firstName", "Dmitriy");
        addRequestParameter("lastName", "Potapov");
        addRequestParameter("date", "testtestInnatest1");
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

}