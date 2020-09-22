package com.sda.auction.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ErrorResponseDto {

	private int code;
	private String message;

	public ErrorResponseDto(int code, String message) {
		this.code = code;
		this.message = message;
	}

	@JsonIgnore
	public byte[] getBytes() throws JsonProcessingException {
		String serialized = new ObjectMapper().writeValueAsString(this);
		return serialized.getBytes();
	}
}
