package com.eglobal.api_rest_eglobal.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
public class ErrorResponseDTO {

    private String apiPath;
    private String errorCode;
    private String errorMsg;
    private LocalDateTime errorTime;
}
