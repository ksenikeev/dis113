package ru.itis.semestr2.model;

public class UserFactory {

    public static User getNewUser(UserRole role) {
        User user = null;
        if (role.getId() == 2) {
            user = new Driver();
        } else {
            user = new Client();
        }
        user.setRole(role);
        return user;
    }

}
