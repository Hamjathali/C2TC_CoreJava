package com.tnsif.onlineshopping.entities;

public class Admin extends User {

    public Admin(int userId, String username, String email) {
        super(userId, username, email);
    }

    @Override
    public String toString() {
        return "Admin [UserId=" + getUserId() + ", Username=" + getUsername() + ", Email=" + getEmail() + "]";
    }
}
