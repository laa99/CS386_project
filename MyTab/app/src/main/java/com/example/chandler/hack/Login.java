package com.example.chandler.hack;

/**
 * Created by adampaquette on 3/15/17.
 */

public class Login{

    public boolean validateUser(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }
}
