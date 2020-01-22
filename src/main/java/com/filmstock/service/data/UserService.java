package com.filmstock.service.data;

import com.filmstock.entity.BlockedUser;
import com.filmstock.entity.BlockingReason;
import com.filmstock.entity.User;
import com.filmstock.exception.UserAlreadyBlockedException;
import com.filmstock.exception.UserAlreadyExistsException;
import com.filmstock.exception.UserNotBlockedException;
import com.filmstock.exception.UserNotFoundException;
import com.filmstock.repository.BlockedUserRepository;
import com.filmstock.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private BlockedUserRepository blockedUserRepository;

    public UserService(UserRepository userRepository, BlockedUserRepository blockedUserRepository) {
        this.userRepository = userRepository;
        this.blockedUserRepository = blockedUserRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Transactional
    public User registerNewUser(User newUser) {
        User existingUser = userRepository.findByLogin(newUser.getLogin());
        if (existingUser != null) {
            throw new UserAlreadyExistsException("User is already registered");
        }
        return userRepository.save(newUser);
    }

    @Transactional
    public User blockUser(String login, BlockingReason reason) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UserNotFoundException();
        }
        if (user.getBlocked() != null) {
            throw new UserAlreadyBlockedException();
        }
        BlockedUser blockedUser = new BlockedUser();
        blockedUser.setBlockingReason(reason);
        blockedUser.setUser(user);
        user.setBlocked(blockedUser);
        blockedUserRepository.save(blockedUser);
        return userRepository.save(user);  // todo save(ban)???
    }

    @Transactional
    public User unblockUser(String login) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UserNotFoundException();
        }
        BlockedUser blockedUser = user.getBlocked();
        if (blockedUser == null) {
            throw new UserNotBlockedException();
        }
        user.setBlocked(null);
        blockedUserRepository.delete(blockedUser);
        User checkUser = userRepository.findByLogin(user.getLogin());
        if (checkUser == null) {
            throw new UserNotFoundException();
        }
        return checkUser;
    }
}
