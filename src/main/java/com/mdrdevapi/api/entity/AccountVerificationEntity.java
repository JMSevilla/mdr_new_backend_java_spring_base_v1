package com.mdrdevapi.api.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "restful_api_accountverification_1")
@Data
public class AccountVerificationEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;
	
	@Column(name="client_email")
	private String client_email;
	
	@Column(name="verification_code")
	private String verification_code;
	
	@Column(name="verified")
	private String verified;
	
	@Column(name="user_type")
	private String user_type;
	
	@Column(name="sent_count")
	private int sent_count;
	
	@Column(name="created_at")
	private Timestamp created_at;
	
	@Column(name="updated_at")
	private Timestamp updated_at;
	
	public AccountVerificationEntity() {}
	
	public AccountVerificationEntity(String client_email, String verification_code, String verified, 
			String user_type, int sent_count, Timestamp created_at, Timestamp updated_at) {
		this.client_email = client_email;
		this.verification_code = verification_code;
		this.verified = verified;
		this.user_type = user_type;
		this.sent_count = sent_count;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
}
