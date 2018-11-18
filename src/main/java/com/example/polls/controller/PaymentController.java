package com.example.polls.controller;


import com.example.polls.dto.ApiResponse;
import com.example.polls.dto.PaymentRequestDTO;
import com.example.polls.dto.ProductByOkvdRequestDTO;
import com.example.polls.dto.ProductResponseDTO;
import com.example.polls.exception.AppException;
import com.example.polls.model.Operation;
import com.example.polls.model.Product;
import com.example.polls.model.Tag;
import com.example.polls.model.User;
import com.example.polls.repository.ProductRepository;
import com.example.polls.repository.UserRepository;
import com.example.polls.service.OperationService;
import com.example.polls.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/order")
public class PaymentController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OperationService operationService;

    @PostMapping("/payment")
    public ResponseEntity<?> doPayment(@Valid @RequestBody PaymentRequestDTO dto) {

        Optional<User> userOptional = userRepository.findByLogin(dto.getLogin());
        if(!userOptional.isPresent()){
            throw  new AppException("Клиент не найден!");
        }
        if( dto.getCardInfo() == null ||
            !StringUtils.hasText(dto.getCardInfo().getMmyy()) ||
            !StringUtils.hasText(dto.getCardInfo().getOwnerName()) ||
            !StringUtils.hasText(dto.getCardInfo().getPhoneNumber()) ||
            dto.getCardInfo().getCardNumber() == null
                ){
            throw  new AppException("Некорректно заполнены данные о кредитной карте!!");
        }
        if(     dto.getProduct() == null ||
                dto.getProduct().getId() == null ||
                dto.getProduct().getCount() == null ||
                dto.getProduct().getCount() <= 0
                ){
            throw  new AppException("Некорректно заполнены поля! Проверьте информацию о продукте!");
        }
        Optional<Product> productOptional = productRepository.findById(dto.getProduct().getId());
        if(!productOptional.isPresent()){
            throw  new AppException("Продукт не найден!");
        }
        Operation operation = operationService.doBuy(productOptional.get(),dto.getProduct().getCount(), userOptional.get(), dto.getCardInfo());
        if(operation == null){
            return new ResponseEntity(new ApiResponse(false, "Что то пошло не так...!"),
                    HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(new ApiResponse(true, "Покупка успешно совершена!"));
    }


}
