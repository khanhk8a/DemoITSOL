package com.example.qlvp.dao;

public interface UserDAO {
    boolean checkRegistry(String email);
    boolean loginUser(String email, String passWord);
}
