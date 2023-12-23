package com.jv6.dto;

import java.util.List;

public record AccountDTO(
		String username,
		String password,
		List<String> authorities
		) {

}
