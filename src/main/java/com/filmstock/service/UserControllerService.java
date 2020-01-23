package com.filmstock.service;

import com.filmstock.converter.UserConverter;
import com.filmstock.dto.UserDTO;
import com.filmstock.entity.BlockingReason;
import com.filmstock.entity.User;
import com.filmstock.exception.NullUserLoginException;
import com.filmstock.service.data.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserControllerService {
    private UserConverter userConverter;
    private UserService userService;
    private ApplicationEventPublisher applicationEventPublisher;

    public UserControllerService(UserConverter userConverter, UserService userService, ApplicationEventPublisher applicationEventPublisher) {
        this.userConverter = userConverter;
        this.userService = userService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public UserDTO registerNewUser(UserDTO newUserDTO) {
        User newUser = userConverter.convertToEntity(newUserDTO);
        UserDTO savedNewUserDTO = userConverter.convertToDto(userService.registerNewUser(newUser));
        savedNewUserDTO.setPassword(newUserDTO.getPassword());
        applicationEventPublisher.publishEvent(savedNewUserDTO);
        return savedNewUserDTO;
    }

    public List<UserDTO> findAll() {
        return userConverter.convertToListDto(userService.findAll());
    }

    public UserDTO findUserByLogin(String login) {
        if (login == null) {
            throw new NullUserLoginException("User login is required");
        }
        User user = userService.findUserByLogin(login);
        UserDTO userDTO = userConverter.convertToDto(user);
        return userDTO;
    }

    public UserDTO blockUser(String login, BlockingReason reason) {
        if (login == null) {
            throw new NullUserLoginException("User login is required");
        }
        return userConverter.convertToDto(userService.blockUser(login, reason)); // todo reason not null
    }

    public UserDTO unblockUser(String login) {
        if (login == null) {
            throw new NullUserLoginException("User login is required");
        }
        return userConverter.convertToDto(userService.unblockUser(login));
    }
}
