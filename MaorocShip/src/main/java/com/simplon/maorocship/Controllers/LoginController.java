package com.simplon.maorocship.Controllers;

import com.simplon.maorocship.Beans.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class LoginController {

    @Inject
    User user;

    public void login(){
        System.out.println("username : " + user.getUsername() + " | password : " + user.getPassword());
    }
}
