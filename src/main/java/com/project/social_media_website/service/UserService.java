package com.project.social_media_website.service;

import com.project.social_media_website.dto.BaseResponse;
import com.project.social_media_website.dto.LoginDetails;
import com.project.social_media_website.dto.UserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface UserService {
    String userDetail(UserDetails userDetails) throws IOException;

    ResponseEntity<BaseResponse> login(LoginDetails loginDetails);

    ResponseEntity<BaseResponse> getUserImage();
}
