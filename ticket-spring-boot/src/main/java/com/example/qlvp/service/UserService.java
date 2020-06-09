package com.example.qlvp.service;

import com.example.qlvp.modal.User;

public interface UserService {
    User save(User user);
    boolean checkRegistry(String email);
    boolean loginUser(String email, String passWord);
}
