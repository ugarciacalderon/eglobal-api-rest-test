package com.eglobal.api_rest_eglobal.dto;

import com.eglobal.api_rest_eglobal.constants.MessaggesConstants;
import com.eglobal.api_rest_eglobal.constants.UserConstants;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Pattern;

@Getter
@Setter
public class UserDto {
    @Pattern(regexp = UserConstants.VALID_USERNAME_REGEX, message = MessaggesConstants.MESSAGGE_USERNAME)
    private String username;
    @Pattern(regexp = UserConstants.VALID_PASSWORD_REGEX, message = MessaggesConstants.MESSAGGE_PASSWORD)
    private String password;
    @Pattern(regexp = UserConstants.VALID_EMAIL_REGEX, message = MessaggesConstants.MESSAGGE_EMAIL)
    private String email;
    @Pattern(regexp = UserConstants.VALID_PHONE_REGEX, message = MessaggesConstants.MESSAGGE_PHONE)
    private String mobileNumber;

}
