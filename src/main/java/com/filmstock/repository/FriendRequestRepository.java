package com.filmstock.repository;

import com.filmstock.entity.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {
    FriendRequest findBySender_LoginAndReceiver_Login(String senderLogin, String receiverLogin);
}
