package model;

import java.time.LocalDate;
import java.util.UUID;

public class User {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String uid;
    private String eMail;
    private LocalDate date;

    public User(String username, String firstName, String lastName, String password, String eMail) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.uid = generateString();
        this.eMail = eMail;
        this.date = LocalDate.now();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUid() {
        return uid;
    }

    public String geteMail() {
        return eMail;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User seteMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    private String generateString() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", uid='" + uid + '\'' +
                ", eMail='" + eMail + '\'' +
                ", date=" + date +
                '}';
    }
}
