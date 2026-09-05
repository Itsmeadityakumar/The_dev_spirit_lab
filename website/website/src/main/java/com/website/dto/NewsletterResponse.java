package com.website.dto;

import java.time.LocalDateTime;

public record NewsletterResponse(
		Long id,
	    String email,
	    LocalDateTime subscribedAt,
	    String status
		) {
	public static NewsletterResponse of(Long id, String email, LocalDateTime subscribedAt) {
        return new NewsletterResponse(id, email, subscribedAt, "SUCCESS");
    }

}
