package com.mdrdevapi.api.dto.helper;
import java.sql.Timestamp;

import lombok.Data;
@Data
public class AccountVerificationDto {
	private Long id;
	private String client_email;
	private String verification_code;
	private String verified;
	private String user_type;
	private int sent_count;
	private Timestamp created_at;
	private Timestamp updated_at;
}
