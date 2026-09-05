package com.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.dto.ContactRequest;
import com.website.dto.ContactResponse;
import com.website.entity.ContactMessage;
import com.website.repository.ContactRepository;

import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Service

public class ContactServiceImpl implements ContactService {
	@Autowired
    private ContactRepository contactRepository;

	@Override
	@Transactional
	public ContactResponse saveMessage(ContactRequest request) {
	    ContactMessage contactMessage = new ContactMessage();
	    contactMessage.setName(request.name());
	    contactMessage.setEmail(request.email());
	    contactMessage.setMessage(request.message());

	    ContactMessage saved = contactRepository.save(contactMessage);

	    return ContactResponse.of(
	        saved.getId(),
	        saved.getName(),
	        saved.getEmail(),
	        saved.getMessage(),
	        saved.getCreatedAt()
	    );

}
}
