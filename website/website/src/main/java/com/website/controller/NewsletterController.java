package com.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.website.dto.NewsletterRequest;
import com.website.dto.NewsletterResponse;
import com.website.service.NewsletterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/newsletter")
@CrossOrigin(origins = "*")
public class NewsletterController {
	@Autowired
    private NewsletterService newsletterService;

    @PostMapping("/subscribe")
    public ResponseEntity<NewsletterResponse> subscribe(@Valid @RequestBody NewsletterRequest request) {
        NewsletterResponse response = newsletterService.subscribe(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
