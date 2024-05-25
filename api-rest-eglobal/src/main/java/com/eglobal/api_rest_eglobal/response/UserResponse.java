package com.eglobal.api_rest_eglobal.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private String username;
    private String email;
    private String mobileNumber;
    private String fechaConsulta;
}
