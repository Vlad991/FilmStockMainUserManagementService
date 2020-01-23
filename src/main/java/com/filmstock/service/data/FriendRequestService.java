package com.filmstock.service.data;

import com.filmstock.entity.FriendRequest;
import com.filmstock.exception.FriendRequestAlreadyExistsException;
import com.filmstock.exception.FriendRequestNotFoundException;
import com.filmstock.repository.FriendRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class FriendRequestService {
    private FriendRequestRepository friendRequestRepository;

    public FriendRequestService(FriendRequestRepository friendRequestRepository) {
        this.friendRequestRepository = friendRequestRepository;
    }

    public FriendRequest saveFriendRequest(FriendRequest friendRequest) {
        FriendRequest existingRequest = friendRequestRepository
                .findBySender_LoginAndReceiver_Login(
                        friendRequest.getSender().getLogin(),
                        friendRequest.getReceiver().getLogin());
        if (existingRequest != null) {
            existingRequest.setMessage(friendRequest.getMessage());
            return friendRequestRepository.save(existingRequest);
        } else {
            return friendRequestRepository.save(friendRequest);
        }
    }

    public void deleteFriendRequest(FriendRequest friendRequest) {
        FriendRequest existingRequest = friendRequestRepository
                .findBySender_LoginAndReceiver_Login(
                        friendRequest.getSender().getLogin(),
                        friendRequest.getReceiver().getLogin());
        if (existingRequest == null) {
            throw new FriendRequestNotFoundException("Friend request not found");
        }
        friendRequestRepository.delete(existingRequest);
    }
}
