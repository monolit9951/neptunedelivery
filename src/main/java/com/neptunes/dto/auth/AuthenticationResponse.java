package com.neptunes.dto.auth;

import com.neptunes.dto.user.UserResponse;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private UserResponse user;
    private String token;
}
