package com.example.qlvp.repo;

import com.example.qlvp.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRespository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);
}
