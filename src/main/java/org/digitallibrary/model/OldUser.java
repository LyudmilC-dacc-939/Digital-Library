package org.digitallibrary.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class OldUser {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String uid;
    private String eMail;
    private LocalDate date;

    public OldUser(String username,
                   String firstName,
                   String lastName,
                   String password,
                   String eMail) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.uid = generateString();
        this.eMail = eMail;
        this.date = LocalDate.now();
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
