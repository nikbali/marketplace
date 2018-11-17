package com.example.polls.service;

import com.example.polls.model.Product;
import com.example.polls.model.Tag;
import com.example.polls.repository.ProductRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;


public interface ProductService {

     List<Product> findByTag(final String tag);

     List<Product> findByTags(final Set<Tag> tags);

}
