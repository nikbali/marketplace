package com.example.polls.util;

import com.example.polls.dto.OperationsResponseDTO;
import com.example.polls.dto.UserProfileDTO;
import com.example.polls.model.Operation;
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

    public static OperationsResponseDTO fromOperationToOperationsResponseDTO(Operation operation) {
        return new OperationsResponseDTO(
                operation.getId(),
                operation.getDescription(),
                operation.getProduct().getName(),
                operation.getDate().toString(),
                operation.getAmount(),
                operation.getStatus().getName(),
                operation.getUser().getLogin(),
                 operation.getProduct().getImage1(),
                 operation.getCount());

    }

}
