package com.example.polls.service;

import com.example.polls.dto.CardOwnerDTO;
import com.example.polls.model.Operation;
import com.example.polls.model.Product;
import com.example.polls.model.User;

public interface OperationService {

    Operation doBuy(Product product, int count, User user, CardOwnerDTO card);
}
