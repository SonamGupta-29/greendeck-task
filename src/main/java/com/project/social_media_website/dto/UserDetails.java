package com.project.social_media_website.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserDetails {

    private String SocialLogoImage;
    private String name;
    private String mob_num;
    private String dob;
    private String email;
    private String password;
}
