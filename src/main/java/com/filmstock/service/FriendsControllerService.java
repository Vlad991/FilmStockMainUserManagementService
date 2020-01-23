package com.filmstock.service;

import com.filmstock.converter.FriendRequestConverter;
import com.filmstock.converter.FriendsConverter;
import com.filmstock.dto.FriendRequestDTO;
import com.filmstock.dto.FriendsDTO;
import com.filmstock.entity.FriendRequest;
import com.filmstock.entity.Friends;
import com.filmstock.service.data.FriendRequestService;
import com.filmstock.service.data.FriendsService;
import com.filmstock.service.data.UserService;
import org.springframework.stereotype.Service;

@Service
public class FriendsControllerService {
    private FriendsConverter friendsConverter;
    private FriendRequestConverter friendRequestConverter;
    private FriendsService friendsService;
    private FriendRequestService friendRequestService;
    private UserService userService;

    public FriendsControllerService(FriendsConverter friendsConverter, FriendRequestConverter friendRequestConverter, FriendsService friendsService, FriendRequestService friendRequestService, UserService userService) {
        this.friendsConverter = friendsConverter;
        this.friendRequestConverter = friendRequestConverter;
        this.friendsService = friendsService;
        this.friendRequestService = friendRequestService;
        this.userService = userService;
    }

    public FriendRequestDTO sendFriendRequest(String senderLogin, String receiverLogin, String message) {
        if (!areFriends(senderLogin, receiverLogin)) {
            FriendRequest newFriendRequest = new FriendRequest();
            newFriendRequest.setSender(userService.findUserByLogin(senderLogin));
            newFriendRequest.setReceiver(userService.findUserByLogin(receiverLogin));
            newFriendRequest.setMessage(message);
            return friendRequestConverter.convertToDto(friendRequestService.saveFriendRequest(newFriendRequest));
        } else {
            return null;
        }
    }

    public FriendsDTO makeFriends(String firstLogin, String secondLogin) {
        if (areFriends(firstLogin, secondLogin)) {
            return friendsConverter.convertToDto(friendsService.getFriendsByLogins(firstLogin, secondLogin));
        } else {
            Friends newFriends = new Friends();
            newFriends.setUserFirst(userService.findUserByLogin(firstLogin));
            newFriends.setUserSecond(userService.findUserByLogin(secondLogin));
            return friendsConverter.convertToDto(friendsService.saveFriends(newFriends));
        }
    }

    public boolean areFriends(String firstLogin, String secondLogin) {
        Friends firstFriendsCombination = friendsService.getFriendsByLogins(firstLogin, secondLogin);
        Friends secondFriendsCombination = friendsService.getFriendsByLogins(secondLogin, firstLogin);
        if (firstFriendsCombination == null && secondFriendsCombination == null) {
            return true;
        } else {
            return false;
        }
    }
}
