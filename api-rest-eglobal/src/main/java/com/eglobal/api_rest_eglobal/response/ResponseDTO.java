package com.eglobal.api_rest_eglobal.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ResponseDTO {
    private String statusCode;
    private String statusMsg;
}
