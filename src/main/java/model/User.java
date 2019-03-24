package model;

import javax.persistence.*;

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
    private String UserName;
    private String PassWd;

    public User() {
    }

    public User(String name, String lastName) {
        this.UserName = name;
        this.PassWd = lastName;
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
}
