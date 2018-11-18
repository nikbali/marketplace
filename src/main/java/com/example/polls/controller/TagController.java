package com.example.polls.controller;

import com.example.polls.model.*;
import com.example.polls.dto.*;
import com.example.polls.repository.TagRepository;
import com.example.polls.repository.UserRepository;

import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;
import com.example.polls.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;
    private static final Logger logger = LoggerFactory.getLogger(TagController.class);

    @GetMapping
    public List<Tag> getTagsByOKVD(@RequestParam(value = "okvd") String okvd) {
        List<Tag> tags = tagRepository.findByOkved(okvd);
        return tags;
    }


}
