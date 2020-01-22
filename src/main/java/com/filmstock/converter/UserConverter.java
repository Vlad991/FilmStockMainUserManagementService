package com.filmstock.converter;

import com.filmstock.dto.UserDTO;
import com.filmstock.entity.BlockedUser;
import com.filmstock.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    public UserDTO convertToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(user.getLogin());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setBirthday(user.getBirthday());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setPhoto(user.getPhoto());
        if (user.getBlocked() != null) {
            userDTO.setBlocked(true);
            userDTO.setBlockingReason(user.getBlocked().getBlockingReason());
        } else {
            userDTO.setBlocked(false);
        }
        return userDTO;
    }

    public User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setLogin(userDTO.getLogin());
        user.setSurname(userDTO.getSurname());
        user.setBirthday(userDTO.getBirthday());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setPhoto(userDTO.getPhoto());
        if(userDTO.isBlocked()) {
            BlockedUser blockedUser = new BlockedUser();
            blockedUser.setUser(user);
            blockedUser.setBlockingReason(userDTO.getBlockingReason());
            user.setBlocked(blockedUser);
        }
        return user;
    }

    public List<UserDTO> convertToListDto(List<User> users) {
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
