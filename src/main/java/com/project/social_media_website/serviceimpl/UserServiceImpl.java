package com.project.social_media_website.serviceimpl;

import com.project.social_media_website.dto.BaseResponse;
import com.project.social_media_website.dto.LoginDetails;
import com.project.social_media_website.dto.UserDetailResponse;
import com.project.social_media_website.dto.UserDetails;
import com.project.social_media_website.entity.User;
import com.project.social_media_website.repository.UserDAO;
import com.project.social_media_website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDAO userDAO;


    @Override
    public String userDetail(UserDetails userDetails) throws IOException {

        BaseResponse baseResponse = new BaseResponse();
        User user = new User();

        user.setName(userDetails.getName());
        user.setMobNum(userDetails.getMob_num());
        user.setDob(userDetails.getDob());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        userDAO.save(user);
        return "Account Created Successfully";
    }

    @Override
    public ResponseEntity<BaseResponse> login(LoginDetails loginDetails) {

        Optional<User> user = Optional.ofNullable(userDAO.findBy(loginDetails.getEmail(), loginDetails.getPassword()));
        BaseResponse baseResponse = new BaseResponse();

        if (!user.isPresent()) {
            baseResponse.setMessage("User Not Found");
            baseResponse.setHttpStatus(HttpStatus.NOT_FOUND);
            baseResponse.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.NOT_FOUND);
        }
        baseResponse.setMessage("Successfully Login");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        baseResponse.setResponse(user);
        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<BaseResponse> getUserImage() {

        BaseResponse baseResponse = new BaseResponse();
        UserDetailResponse userDetailResponse = new UserDetailResponse();
        List<User> userList = userDAO.userList();
        List<UserDetails> userDetails = new ArrayList<>();
        for (User user : userList) {
            UserDetails userDetail = new UserDetails();
            userDetail.setSocialLogoImage(user.getSocialLogoImage());


            userDetails.add(userDetail);
        }
        userDetailResponse.setUserDetails(userDetails);
        baseResponse.setMessage("image successfully fetched");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
//        baseResponse.setResponse(UserDetailResponse);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
