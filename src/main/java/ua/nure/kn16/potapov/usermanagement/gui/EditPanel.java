package ua.nure.kn16.potapov.usermanagement.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JOptionPane;

import ua.nure.kn16.potapov.usermanagement.User;
import ua.nure.kn16.potapov.usermanagement.db.DatabaseException;

public class EditPanel extends AddPanel {
	
	private User user;

    public EditPanel(MainFrame parent) {
        super(parent);
        setName("editPanel");
    }

    protected void doAction(ActionEvent e) throws ParseException {
        System.out.println(user);
        if ("ok".equalsIgnoreCase(e.getActionCommand())) {
            user.setFirstName(getFirstNameField().getText());
            user.setLastName(getLastNameField().getText());
            DateFormat format = DateFormat.getDateInstance();
            try {
                Date date = format.parse(getDateOfBirthField().getText());
                user.setBirthDate(date);
            } catch (ParseException e1) {
                getDateOfBirthField().setBackground(Color.RED);
                throw e1;
            }
            try {
                parent.getDao().update(user);
            } catch (DatabaseException e1) {
                JOptionPane.showMessageDialog(this, e1.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void setUser(User user) {
        DateFormat format = DateFormat.getDateInstance();
        this.user = user;
        getFirstNameField().setText(user.getFirstName());
        getLastNameField().setText(user.getLastName());
        getDateOfBirthField().setText(format.format(user.getBirthDate()));
    }
}
