package com.project.social_media_website.controller;

import com.project.social_media_website.dto.BaseResponse;
import com.project.social_media_website.dto.LoginDetails;
import com.project.social_media_website.dto.UserDetails;
import com.project.social_media_website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("user")  //end point of registration
    public String userData(@RequestBody UserDetails userDetails) throws IOException {

        return userService.userDetail(userDetails);
    }

    @PostMapping("login")   //end point of login
    public ResponseEntity<BaseResponse> customerLogin(@RequestBody LoginDetails loginDetails) {


        if (loginDetails == null) {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("Credetials Should not be null");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return userService.login(loginDetails);
    }

    @GetMapping("user-img-fetch")
        public ResponseEntity<BaseResponse> userImage(){

        return userService.getUserImage();
    }
}
