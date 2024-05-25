package com.eglobal.api_rest_eglobal.service;

import com.eglobal.api_rest_eglobal.dto.UserDto;
import com.eglobal.api_rest_eglobal.response.UserResponse;

public interface UserService {
    Boolean save(UserDto users);
    UserResponse findByUsername(String username, String email, String mobileNumber);
}
