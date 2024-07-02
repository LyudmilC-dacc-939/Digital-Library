package mainframe;

import model.User;
import repository.UserDatabase;

import java.util.ArrayList;

public class MainDataProvider {
    private ArrayList<User> users = UserDatabase.fetchUsers();

    public MainDataProvider() {
    }

    public boolean loginUser(String username, String password){
        for(User user: this.users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){

                return true;
            }
        }
        return false;
    }
}
