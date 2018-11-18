package com.example.polls.service.impl;

import com.example.polls.model.Product;
import com.example.polls.model.Tag;
import com.example.polls.repository.ProductRepository;
import com.example.polls.repository.TagRepository;
import com.example.polls.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TagRepository tagRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public List<Product> findByTag(final String tag) {
        return productRepository.findByTag(tag);
    }


    @Override
    public List<Product> findByTags(final Set<Tag> tags){
        List<String> stringsTag = tags.stream().map(tag -> tag.getTitle()).collect(Collectors.toList());
        List<Product> products =  productRepository.findByTags(stringsTag);
        return products;
    }
}
