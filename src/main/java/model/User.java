package model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.findOne", query = "select u from User u where u.id = :id"),
        @NamedQuery(name = "User.getAll", query = "select u from User u")
}
)
public class User {

    @Id
    @GeneratedValue
    private long GebruikersiD;

    @NotNull(message = "Username cannot be null")
    private String UserName;

    @NotNull(message = "Username cannot be null")
    private String PassWd;

    @Email(message = "Email should be valid")
    private String Email;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    private int Age;

    public User() {
    }

    public User(String name, String lastName) {
        this.UserName = name;
        this.PassWd = lastName;
    }

    public User(String name, String lastName, String email, int age) {
        this.UserName = name;
        this.PassWd = lastName;
        this.Email = email;
        this.Age = age;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getPassWd() {
        return PassWd;
    }

    public void setPassWd(String passWd) {
        this.PassWd = passWd;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }
}
