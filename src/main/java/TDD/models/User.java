package TDD.models;

import java.io.Serializable;

public class User implements Serializable {
    public String Username;
    public String Password;

    public User(String username, String passwd) {
        Username = username;
        Password = passwd;
    }
}
