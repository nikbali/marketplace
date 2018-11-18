package com.example.polls.repository;

import com.example.polls.model.Operation;
import com.example.polls.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
}
