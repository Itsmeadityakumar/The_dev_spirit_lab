package com.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.website.entity.NewsletterSubscriber;

public interface NewsletterRepository extends JpaRepository<NewsletterSubscriber, Long> {
	
	boolean existsByEmail(String email);

}
