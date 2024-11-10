package org.digitallibrary.repository;

import org.digitallibrary.model.OldUser;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    public static List<OldUser> fetchUsers() {
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
