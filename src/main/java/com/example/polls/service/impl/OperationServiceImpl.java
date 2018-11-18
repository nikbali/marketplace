package com.example.polls.service.impl;

import com.example.polls.dto.CardOwnerDTO;
import com.example.polls.exception.AppException;
import com.example.polls.model.Operation;
import com.example.polls.model.Product;
import com.example.polls.model.StatusOperation;
import com.example.polls.model.User;
import com.example.polls.repository.OperationRepository;
import com.example.polls.repository.ProductRepository;
import com.example.polls.repository.UserRepository;
import com.example.polls.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;


    @Override
    public Operation doBuy(final Product product,
                      final int count,
                      final User user,
                      final CardOwnerDTO card) {
        if(product.getCount() < count){
            throw  new AppException("Выбранного количества нет в наличии!");
        }
        BigDecimal summ = product.getAmount().multiply(BigDecimal.valueOf(count));
        if(summ.compareTo(user.getBalance()) > 0){
            throw  new AppException("Недостаточно средств!");
        }

        /* Создаем операцию о покупке*/
        Operation operation = new Operation();
        operation.setAmount(summ);
        operation.setDescription(String.format("Покупка: %s, Стоимость: %s, Дата: %s", product.getName(), summ.toString(), LocalDateTime.now()));
        operation.setDate(Instant.now());
        operation.setStatus(StatusOperation.DONE);
        operation.setUser(user);
        operation.setProduct(product);
        Operation oper = operationRepository.save(operation);

        /* Изменем баланс у пользователя после покупки*/
        BigDecimal userCurrentBalance = user.getBalance();
        user.setBalance(userCurrentBalance.subtract(summ));
        userRepository.save(user);

        /* Меняем количество товаров в нашем магазине*/
        product.setCount(product.getCount() - count);
        productRepository.save(product);

        return oper;
    }
}
