package com.filmstock.service.data;

import com.filmstock.entity.Friends;
import com.filmstock.exception.FriendsAlreadyExistException;
import com.filmstock.exception.FriendsNotFoundException;
import com.filmstock.repository.FriendsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FriendsService {
    private FriendsRepository friendsRepository;

    public FriendsService(FriendsRepository friendsRepository) {
        this.friendsRepository = friendsRepository;
    }

    @Transactional
    public void saveFriends(Friends newFriends) {
        Friends existingFriends = friendsRepository
                .findByUserFirst_LoginAndUserSecond_Login(
                        newFriends.getUserFirst().getLogin(),
                        newFriends.getUserSecond().getLogin());
        if (existingFriends != null) {
            throw new FriendsAlreadyExistException("Friends already exist");
        }
        friendsRepository.save(newFriends);
    }

    @Transactional
    public void deleteFriends(Friends friends) {
        Friends existingFriends = friendsRepository
                .findByUserFirst_LoginAndUserSecond_Login(
                        friends.getUserFirst().getLogin(),
                        friends.getUserSecond().getLogin());
        if (existingFriends == null) {
            throw new FriendsNotFoundException("Friends not found");
        }
        friendsRepository.delete(existingFriends);
    }
}
