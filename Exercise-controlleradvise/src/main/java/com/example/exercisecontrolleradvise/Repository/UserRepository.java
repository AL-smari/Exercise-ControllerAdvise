package com.example.exercisecontrolleradvise.Repository;

import com.example.exercisecontrolleradvise.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserById(Integer id);
    User findUserByUsernameAndPassword(String username , String password);

    List<User> findUserBySubscriptionTrue();



}