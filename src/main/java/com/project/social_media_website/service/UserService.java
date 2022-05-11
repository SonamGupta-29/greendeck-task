package com.project.social_media_website.service;

import com.project.social_media_website.dto.BaseResponse;
import com.project.social_media_website.dto.LoginDetails;
import com.project.social_media_website.dto.UserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    String userDetail(UserDetails userDetails);

    ResponseEntity<BaseResponse> login(LoginDetails loginDetails);
}
