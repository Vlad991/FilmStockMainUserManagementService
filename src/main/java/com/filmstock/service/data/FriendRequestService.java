package com.filmstock.service.data;

import com.filmstock.entity.FriendRequest;
import com.filmstock.repository.FriendRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class FriendRequestService {
    private FriendRequestRepository friendRequestRepository;

    public FriendRequestService(FriendRequestRepository friendRequestRepository) {
        this.friendRequestRepository = friendRequestRepository;
    }

    public void saveFriendRequest(FriendRequest friendRequest) {
        FriendRequest existingRequest = friendRequestRepository
                .findBySender_LoginAndReceiver_Login(
                        friendRequest.getSender().getLogin(),
                        friendRequest.getReceiver().getLogin());
        if (existingRequest != null) {
            throw new FriendRequestAlreadyExistsException("Friend request already exists");
        }
        friendRequestRepository.save(friendRequest);
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
