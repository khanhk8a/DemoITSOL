package com.example.qlvp.service;

import com.example.qlvp.dao.UserDAO;
import com.example.qlvp.modal.User;
import com.example.qlvp.repo.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRespository userRespository;



    @Override
    public User save(User user) {
        return userRespository.save(user);
    }

    @Override
    public boolean checkRegistry(String email) {
        return userDAO.checkRegistry(email);
    }

    @Override
    public boolean loginUser(String email, String passWord) {
        return userDAO.loginUser(email,passWord);
    }
}
