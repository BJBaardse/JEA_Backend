package model;

import jwt.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.findOne", query = "select u from User u where u.id = :id"),
        @NamedQuery(name = "User.getAll", query = "select u from User u"),
        @NamedQuery(name = "User.checkcreds", query = "select u from User u where u.UserName = :username and u.PassWd = :password")
}
)
public class User implements Serializable{

    public long getGebruikersiD() {
        return GebruikersiD;
    }

    public void setGebruikersiD(long gebruikersiD) {
        GebruikersiD = gebruikersiD;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWd() {
        return PassWd;
    }

    public void setPassWd(String passWd) {
        PassWd = passWd;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long GebruikersiD;

    @NotNull(message = "Username cannot be null")
    @Column(unique = true)
    private String UserName;

    @NotNull(message = "Password cannot be null")
    private String PassWd;

    @Email(message = "Email should be valid")
    private String Email;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    private int Age;

    private Role role;

    @OneToMany(mappedBy = "user")
//    @JoinColumn(name = "advertentie_id", referencedColumnName = "advertentie_id")
    private List<Advertentie> advertenties;

    public List<Advertentie> getAdvertenties() {
        return advertenties;
    }

    public User setAdvertentie(List<Advertentie> advertenties) {
        this.advertenties = advertenties;
        return this;
    }
    public User() {
    }

    public User(String name, String lastName) {
        this.UserName = name;
        this.PassWd = lastName;
    }

    public User(String name, String lastName, String email, int age, Role role) {
        this.UserName = name;
        this.PassWd = lastName;
        this.Email = email;
        this.Age = age;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "GebruikersiD=" + GebruikersiD +
                ", UserName='" + UserName + '\'' +
                ", PassWd='" + PassWd + '\'' +
                ", Email='" + Email + '\'' +
                ", Age=" + Age +
                ", role=" + role +
                '}';
    }
}
