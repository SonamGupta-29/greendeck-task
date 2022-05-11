package com.project.social_media_website.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UserDetails {

    private String name;
    private String mob_num;
    private String dob;
    private String email;
    private String password;

}
