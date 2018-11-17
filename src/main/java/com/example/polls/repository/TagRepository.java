package com.example.polls.repository;

import com.example.polls.model.Tag;
import com.example.polls.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByTitle(String title);
    List<Tag> findByOkved(String okved);
}
