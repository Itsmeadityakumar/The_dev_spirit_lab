package com.website.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContactRequest(
		@NotBlank(message = "Name cannot be empty")
		@Size(max = 100, message = "Name must be under 100 characters")
		String name,

		@NotBlank(message = "Email cannot be empty")
		@Email(message = "Must be a valid email address")
		String email,

		@NotBlank(message = "Message cannot be empty")
		@Size(max = 2000, message = "Message must be under 2000 characters")
		String message) {}
