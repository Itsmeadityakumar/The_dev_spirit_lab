package com.website.service;

import com.website.dto.NewsletterRequest;
import com.website.dto.NewsletterResponse;

public interface NewsletterService {
	
	public NewsletterResponse subscribe(NewsletterRequest request);

}
