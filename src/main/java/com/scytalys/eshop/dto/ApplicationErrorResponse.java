package com.scytalys.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationErrorResponse implements ErrorResponse {
    private int status;
    private String message;
    private long timestamp;


    @Override
    public HttpStatusCode getStatusCode() {
        return null;
    }

    @Override
    public ProblemDetail getBody() {
        return null;
    }
}
