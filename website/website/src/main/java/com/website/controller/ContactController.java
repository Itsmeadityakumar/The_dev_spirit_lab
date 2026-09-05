package com.website.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.website.dto.ContactRequest;
import com.website.dto.ContactResponse;
import com.website.service.ContactService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")  // Replace with specific frontend origin in production
public class ContactController {
	@Autowired
	private ContactService contactService;
	@PostMapping
    public ResponseEntity<ContactResponse> submitMessage(@Valid @org.springframework.web.bind.annotation.RequestBody ContactRequest request) {
        ContactResponse response = contactService.saveMessage(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
	

}
