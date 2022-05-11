package com.project.social_media_website.dto;

import com.project.social_media_website.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Getter
@Setter
@ToString
public class BaseResponse {

    private String message;
    private HttpStatus httpStatus;
    private int httpStatusCode;

    public void setResponse(Optional<User> user) {
    }
}
