package com.world.selfstarter.controller;

import com.world.selfstarter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginFormController {

    @Autowired
    private UserRepository userRepository;

    // constructor injection also works
    // code here to use the injected userRepository

}