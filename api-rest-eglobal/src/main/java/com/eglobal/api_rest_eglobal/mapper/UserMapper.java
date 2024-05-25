package com.eglobal.api_rest_eglobal.mapper;

import com.eglobal.api_rest_eglobal.dto.UserDto;
import com.eglobal.api_rest_eglobal.entity.User;
import com.eglobal.api_rest_eglobal.response.UserResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserMapper {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static User userDtoToUser(UserDto userDto, User users) {
        users.setUsername(userDto.getUsername());
        users.setPassword(userDto.getPassword());
        users.setEmail(userDto.getEmail());
        users.setMobileNumber(userDto.getMobileNumber());
        return users;
    }

    public static UserResponse userToUserResponse(User users, UserResponse userResponse) {
        userResponse.setUsername(users.getUsername());
        userResponse.setEmail(users.getEmail());
        userResponse.setMobileNumber(users.getMobileNumber());
        userResponse.setFechaConsulta(dateFormat.format(new Date()));
        return userResponse;
    }
}
