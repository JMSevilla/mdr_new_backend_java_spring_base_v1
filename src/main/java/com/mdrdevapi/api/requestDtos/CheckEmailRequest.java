package com.mdrdevapi.api.requestDtos;
import lombok.Data;
import com.mdrdevapi.api.constants.CheckEmailConstant;

@Data
public class CheckEmailRequest {
	private String email;
	private String type;
}
