package com.example.polls.controller;

import com.example.polls.dto.ProductByOkvdRequestDTO;
import com.example.polls.dto.ProductCreateRequestDTO;
import com.example.polls.dto.ProductResponseDTO;
import com.example.polls.model.Tag;
import com.example.polls.repository.TagRepository;
import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;
import com.example.polls.service.ProductService;
import com.example.polls.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public List<ProductResponseDTO> getProducts(@RequestParam(value = "tag") String  tag) {
        return productService.findByTag(tag)
                .stream()
                .map(ProductResponseDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/okvdandmain")
    public List<ProductResponseDTO> getProductsByOkvdAndMainCategory(@Valid @RequestBody ProductByOkvdRequestDTO dto) {

        Set<Tag>  tags = new HashSet<>();
        if(dto.getMainCategory() != null){
            Optional<Tag> optionalTag = tagRepository.findByTitle(dto.getMainCategory());
            if(optionalTag.isPresent()){
                List<Tag> tagsFromRelevante = tagRepository.findByOkved(optionalTag.get().getOkved());
                if(!tagsFromRelevante.isEmpty()) {
                    tagsFromRelevante
                            .stream()
                            .forEach(tag -> tags.add(tag));
                }
            }
        }
        if(dto.getOkvds() != null){
                dto.getOkvds()
                    .stream()
                    .forEach(okvd -> {
                                List<Tag> optionalTag = tagRepository.findByOkved(okvd);
                                if(!optionalTag.isEmpty()) {
                                    optionalTag
                                            .stream()
                                            .forEach(tag -> tags.add(tag));
                                }
                    });
        }
        return productService.findByTags(tags)
                .stream()
                .map(ProductResponseDTO::new)
                .collect(Collectors.toList());
    }


    @GetMapping("/partner")
    public List<ProductResponseDTO> getProductsByPartnerId(@RequestParam(value = "partnerId") String  partnerId) {
        return productService.findByPartnerId(partnerId)
                .stream()
                .map(ProductResponseDTO::new)
                .collect(Collectors.toList());
    }

   /* @PostMapping("/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductCreateRequestDTO dto) {


        return productService.createProduct(tags)
                .stream()
                .map(ProductResponseDTO::new)
                .collect(Collectors.toList());
    }*/

}
