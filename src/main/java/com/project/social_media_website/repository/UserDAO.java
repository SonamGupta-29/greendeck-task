package com.project.social_media_website.repository;

import com.project.social_media_website.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User,Integer> {

    @Query(value = "select * from user where email=?1 and password=?2", nativeQuery = true)
    User findBy(String email , String password);

    @Query(value = "SELECT * FROM user" , nativeQuery = true)
    List<User> userList();
}
