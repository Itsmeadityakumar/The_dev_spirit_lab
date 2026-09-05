package com.website.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record NewsletterRequest(
		@NotBlank(message = "Email cannot be blank")
		@Email(message = "Please enter a valid email address")
		String email
		) {

}
