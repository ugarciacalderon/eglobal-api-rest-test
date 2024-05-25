package com.eglobal.api_rest_eglobal.service.impl;

import com.eglobal.api_rest_eglobal.dto.UserDto;
import com.eglobal.api_rest_eglobal.entity.User;
import com.eglobal.api_rest_eglobal.exceptionHandling.ResourceNotFoundException;
import com.eglobal.api_rest_eglobal.exceptionHandling.UserAlreadyExistsException;
import com.eglobal.api_rest_eglobal.mapper.UserMapper;
import com.eglobal.api_rest_eglobal.repository.UserRepository;
import com.eglobal.api_rest_eglobal.response.UserResponse;
import com.eglobal.api_rest_eglobal.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository usersRepository;

    @Override
    public Boolean save(UserDto user) {
            Optional<User> optionalUsername = usersRepository.findByUsername(user.getUsername());
            if (optionalUsername.isPresent()) {
                throw new UserAlreadyExistsException("El usuario con ese nombre de usuario ya existe: "+user.getUsername());
            }
            Optional<User> optionalEmail = usersRepository.findByEmail(user.getEmail());
            if (optionalEmail.isPresent()) {
                throw new UserAlreadyExistsException("El usuario con ese email ya existe: "+user.getEmail());
            }
            Optional<User> optionalMobilePhone = usersRepository.findByMobileNumber(user.getMobileNumber());
            if (optionalMobilePhone.isPresent()) {
                throw new UserAlreadyExistsException("El usuario con ese número de telèfono ya existe: "+user.getMobileNumber());
            }

            User userToSave;
            userToSave = UserMapper.userDtoToUser(user, new User());
            userToSave.setCreatedAt(new Date());
            userToSave.setUpdatedAt(new Date());
            userToSave.setEnabled(true);
            usersRepository.save(userToSave);
            return true;
    }

    @Override
    public UserResponse findByUsername(String username, String email, String mobileNumber) {
        User userfound = null;
        if (null != username) {
            userfound = usersRepository.findByUsername(username).orElseThrow(
                    () -> new ResourceNotFoundException("User", "username", username)
            );
        }
        if (null != email) {
            userfound = usersRepository.findByEmail(email).orElseThrow(
                    () -> new ResourceNotFoundException("User", "email", username)
            );
        }
        if (null != mobileNumber) {
            userfound = usersRepository.findByMobileNumber(mobileNumber).orElseThrow(
                    () -> new ResourceNotFoundException("User", "mobile number", username)
            );
        }

        return UserMapper.userToUserResponse(userfound, new UserResponse());
    }
}
