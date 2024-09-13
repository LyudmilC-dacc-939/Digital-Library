package repository;

import model.User;

import java.util.ArrayList;

public class UserDatabase {
    public static ArrayList<User> fetchUsers() {
        ArrayList<User> users = new ArrayList<>();
        User user1 = new User(
                "Test.John.Doe24",
                "John",
                "Doe",
                "TestTest2222#",
                "John5Doe@gmail.com");
        users.add(user1);
        return users;
    }
}
