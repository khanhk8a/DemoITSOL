package com.example.qlvp.dao.impl;

import com.example.qlvp.dao.UserDAO;
import com.example.qlvp.modal.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean checkRegistry(String email) {
        Session session = sessionFactory.getCurrentSession();
        try{
            String sql = "FROM user where email = '" + email + "' ";
            User userid = (User) session.createQuery(sql.toString()).getSingleResult();
            if(userid != null){
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    @Override
    @Transactional
    public boolean loginUser(String email, String passWord) {
        Session session = sessionFactory.getCurrentSession();
        try{
            String sql = "FROM user where email='" + email + "' AND passWord='"+ passWord +"'";
            User userid = (User) session.createQuery(sql.toString()).getSingleResult();
            if(userid != null){
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
}
