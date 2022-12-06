package com.mdrdevapi.api.responseDtos;
import java.util.List;

import com.mdrdevapi.api.dto.helper.AccountVerificationDto;

import lombok.Data;
@Data
public class AccountVerificationResponseDto {
	private List<AccountVerificationDto> accountVerificationDto;
}
