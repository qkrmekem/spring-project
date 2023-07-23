package com.qkrmekem.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        // equalsIgnoreCase 대소문자 구분 없이 문자열 비교
        boolean isValidUsername = username.equalsIgnoreCase("qkrmekem");
        boolean isValidPassword = password.equalsIgnoreCase("password");
        return isValidUsername && isValidPassword;
    }

}
