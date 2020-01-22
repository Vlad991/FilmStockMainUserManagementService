package com.filmstock.converter;

import com.filmstock.dto.FriendRequestDTO;
import com.filmstock.entity.FriendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FriendRequestConverter {
    @Autowired
    private UserConverter userConverter;

    public FriendRequestDTO convertToDto(FriendRequest friendRequest) {
        FriendRequestDTO friendRequestDTO = new FriendRequestDTO();
        friendRequestDTO.setSender(userConverter.convertToDto(friendRequest.getSender()));
        friendRequestDTO.setReceiver(userConverter.convertToDto(friendRequest.getReceiver()));
        friendRequestDTO.setMessage(friendRequest.getMessage());
        return friendRequestDTO;
    }

    public FriendRequest convertToEntity(FriendRequestDTO friendRequestDTO) {
        FriendRequest friendRequest = new FriendRequest();
        friendRequest.setSender(userConverter.convertToEntity(friendRequestDTO.getSender()));
        friendRequest.setReceiver(userConverter.convertToEntity(friendRequestDTO.getReceiver()));
        friendRequest.setMessage(friendRequestDTO.getMessage());
        return friendRequest;
    }

    public List<FriendRequestDTO> convertToListDto(List<FriendRequest> friendRequests) {
        return friendRequests.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
