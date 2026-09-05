package com.website.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "contact_messages")
public class ContactMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="Name", nullable=false,length = 100)
	@Size(max = 100, message = "Name must be under 100 characters")
	@NotBlank(message = "Name cannot be blank")
	private String name;
	@NotBlank(message = "Email cannot be blank")
    @Email(message = "Please provide a valid email address")
    @Column(nullable = false)
	private String email;
	@NotBlank(message = "Message cannot be blank")
    @Size(max = 2000, message = "Message must be under 2000 characters")
    @Column(nullable = false, columnDefinition = "TEXT")
	private String message;
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt; 
	@PrePersist
	protected void onCreate() {
	    this.createdAt = LocalDateTime.now();
	}
	

}
