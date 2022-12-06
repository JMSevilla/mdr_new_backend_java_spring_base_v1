package com.mdrdevapi.api.requestDtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
// Annotations
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetailsRequestDto {
	private String client_email;
	private String code;
}
