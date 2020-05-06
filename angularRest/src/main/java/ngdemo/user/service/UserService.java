package ngdemo.user.service;

import ngdemo.user.domain.User;

public class UserService {

    public User getDefaultUser() {
        User user = new User();
        user.setFirstName("JonFromREST");
        user.setLastName("DoeFromREST");
        user.setBmp("rest.png");
        return user;
    }
}
