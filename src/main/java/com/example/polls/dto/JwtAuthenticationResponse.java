package com.example.polls.dto;


public class JwtAuthenticationResponse {
    private  String accessToken;
    private  UserProfileDTO userProfileDTO;

    public JwtAuthenticationResponse(final String accessToken, final UserProfileDTO userProfileDTO) {
        this.accessToken = accessToken;
        this.userProfileDTO = userProfileDTO;
    }


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }


    public UserProfileDTO getUserProfileDTO() {
        return userProfileDTO;
    }

    public void setUserProfileDTO(UserProfileDTO userProfileDTO) {
        this.userProfileDTO = userProfileDTO;
    }
}
