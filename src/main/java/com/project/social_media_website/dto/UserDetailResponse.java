package com.project.social_media_website.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserDetailResponse {

    private List<UserDetails> userDetails;
}
