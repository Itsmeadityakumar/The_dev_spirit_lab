package com.website.service;

import com.website.dto.ContactRequest;
import com.website.dto.ContactResponse;

public interface ContactService {
	ContactResponse saveMessage(ContactRequest request);

}
