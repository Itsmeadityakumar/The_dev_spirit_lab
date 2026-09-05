package com.website.dto;

import java.time.LocalDateTime;


public record ContactResponse(
		long id,
	    String name,
	    String email,
	    String message,
	    LocalDateTime submittedAt,
	    String status) {


	public static ContactResponse of(long id, String name, String email, String message, LocalDateTime submittedAt) {
        return new ContactResponse(id, name, email, message, submittedAt, "SUCCESS");
    }

}
