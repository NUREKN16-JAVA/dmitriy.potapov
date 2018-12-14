package ua.nure.kn16.potapov.usermanagement;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class User implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;

    public User() {
        super();
    }

    public User(Long id, String firstName, String lastName, Date date) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = date;
    }

    public User(String firstName, String lastName, Date date) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = date;
	}

	public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(id, user.id) &&
//                Objects.equals(firstName, user.firstName) &&
//                Objects.equals(lastName, user.lastName) &&
//                Objects.equals(birthDate, user.birthDate);
//    }

//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, firstName, lastName, birthDate);
//    }

    public String getFullName() {
        return (new StringBuilder(getFirstName()).append(", ").append(getLastName())).toString();
    }

    public int getAge() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDate = calendar.get(Calendar.DATE);

        calendar.setTime(birthDate);
        final int birthYear = calendar.get(Calendar.YEAR);
        final int birthMonth = calendar.get(Calendar.MONTH);
        final int birthDate = calendar.get(Calendar.DATE);

        int age = currentYear - birthYear;
        if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDate < birthDate)) {
            --age;
        }

        return age;
    }

	@Override
	public int hashCode() {
		if(this.getId() == null) {
			return 0;
		}
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(this == obj) {
			return true;
		}
		if(this.getId() == null && ((User) obj).getId() == null) {
			return true;
		}
		
		return this.getId().equals(((User) obj).getId());
	}
    
    
    
}
