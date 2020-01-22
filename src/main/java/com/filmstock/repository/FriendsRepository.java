package com.filmstock.repository;

import com.filmstock.entity.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendsRepository extends JpaRepository<Friends, Long> {
    Friends findByUserFirst_LoginAndUserSecond_Login(String userFirstLogin, String userSecondLogin);
}
