package com.eglobal.api_rest_eglobal.controller;

import com.eglobal.api_rest_eglobal.constants.MessaggesConstants;
import com.eglobal.api_rest_eglobal.constants.UserConstants;
import com.eglobal.api_rest_eglobal.dto.UserDto;
import com.eglobal.api_rest_eglobal.response.UserResponse;
import com.eglobal.api_rest_eglobal.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity addUser(@Valid @RequestBody UserDto user) {
        ResponseEntity response = null;
        try {
            Boolean succes = userService.save(user);
            if (succes) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Usuario Creado Correctamente");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("A ocurrido una excepción " + ex.getMessage());
        }
        return response;
    }

    @GetMapping("/consultaUsuario")
    public ResponseEntity consultaUsuario(@RequestParam(name = "username", required = true)
                                            @Pattern(regexp=UserConstants.VALID_USERNAME_REGEX, message = MessaggesConstants.MESSAGGE_USERNAME)
                                            String username,
                                        @RequestParam(name = "email", required = false) @Pattern(regexp = UserConstants.VALID_EMAIL_REGEX, message = MessaggesConstants.MESSAGGE_EMAIL)
                                        String email,
                                        @RequestParam(name = "mobileNumber", required = false)
                                            @Pattern(regexp = UserConstants.VALID_PHONE_REGEX, message = MessaggesConstants.MESSAGGE_PHONE)
                                        String mobileNumber) {
        ResponseEntity response = null;
        UserResponse userResponse;
        UserResponse savedUser;
        try {

            savedUser = userService.findByUsername(username, email, mobileNumber);
            if (null != savedUser) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(savedUser);
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("A ocurrido una ecepción " + ex.getMessage());
        }
        return response;
    }
}
