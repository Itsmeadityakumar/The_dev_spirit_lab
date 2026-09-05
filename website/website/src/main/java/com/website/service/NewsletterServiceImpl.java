package com.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.dto.NewsletterRequest;
import com.website.dto.NewsletterResponse;
import com.website.entity.NewsletterSubscriber;
import com.website.repository.NewsletterRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
public class NewsletterServiceImpl  implements NewsletterService{
	@Autowired
    private NewsletterRepository newsletterRepository;
	
	@Override
	@Transactional
	public NewsletterResponse subscribe(NewsletterRequest request) {
        String cleanEmail = request.email().trim().toLowerCase();

        if (newsletterRepository.existsByEmail(cleanEmail)) {
            throw new IllegalArgumentException("Email is already subscribed!");
        }

        NewsletterSubscriber subscriber = new NewsletterSubscriber(cleanEmail);
        NewsletterSubscriber saved = newsletterRepository.save(subscriber);
 
        return NewsletterResponse.of(
            saved.getId(),
            saved.getEmail(),
            saved.getSubscribedAt()
        );
    }

}
