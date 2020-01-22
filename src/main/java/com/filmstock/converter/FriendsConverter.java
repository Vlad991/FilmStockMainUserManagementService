package com.filmstock.converter;

import com.filmstock.dto.FriendsDTO;
import com.filmstock.entity.Friends;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FriendsConverter {
    @Autowired
    private UserConverter userConverter;

    public FriendsDTO convertToDto(Friends friends) {
        FriendsDTO friendsDTO = new FriendsDTO();
        friendsDTO.setUserFirst(userConverter.convertToDto(friends.getUserFirst()));
        friendsDTO.setUserSecond(userConverter.convertToDto(friends.getUserSecond()));
        return friendsDTO;
    }

    public Friends convertToEntity(FriendsDTO friendsDTO) {
        Friends friends = new Friends();
        friends.setUserFirst(userConverter.convertToEntity(friendsDTO.getUserFirst()));
        friends.setUserSecond(userConverter.convertToEntity(friendsDTO.getUserSecond()));
        return friends;
    }

    public List<FriendsDTO> convertToListDto(List<Friends> friendsList) {
        return friendsList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
