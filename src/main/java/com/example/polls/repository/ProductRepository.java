package com.example.polls.repository;

import com.example.polls.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT v FROM Product v where v.tag.title = :tag")
    List<Product> findByTag(@Param("tag") String tag);

    @Query("SELECT v FROM Product v where v.tag.title in :tags")
    List<Product> findByTags(@Param("tags") List<String> tags);

    @Query("SELECT v FROM Product v where v.partner.id = :partnerId")
    List<Product> findByPartnerId(@Param("partnerId") String partnerId);


}

