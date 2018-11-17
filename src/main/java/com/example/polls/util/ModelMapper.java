package com.example.polls.util;

import com.example.polls.dto.UserProfileDTO;
import com.example.polls.model.User;

public  class ModelMapper {

    public static User fromUserDtoToUser(UserProfileDTO userProfileDTO) {
        return new User();
    }

    public static UserProfileDTO fromUserToUserProfileDTO(User user) {
        return new UserProfileDTO(user.getId(),
                user.getLogin(),
                user.getFio(),
                user.getCardNumber(),
                user.getBalance());
    }

}
