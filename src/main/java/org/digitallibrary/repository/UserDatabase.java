package org.digitallibrary.repository;

import org.digitallibrary.model.OldUser;

import java.util.ArrayList;

public class UserDatabase {
    public static ArrayList<OldUser> fetchUsers() {
        ArrayList<OldUser> oldUsers = new ArrayList<>();
        OldUser oldUser1 = new OldUser(
                "Test.John.Doe24",
                "John",
                "Doe",
                "TestTest2222#",
                "John5Doe@gmail.com");
        oldUsers.add(oldUser1);
        return oldUsers;
    }
}
