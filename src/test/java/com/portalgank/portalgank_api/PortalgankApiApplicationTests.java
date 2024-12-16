package com.portalgank.portalgank_api;

import com.portalgank.portalgank_api.service.CustomUserDetailsService;
import com.portalgank.portalgank_api.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PortalgankApiApplicationTests {
	@Autowired
	private CustomUserDetailsService userDetailsService;
	private final JwtUtil jwtUtil = new JwtUtil();
	@Test
	void contextLoads() {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTczMzI4NTM4OSwiZXhwIjoxNzMzMjg4OTg5fQ.ojEXkqdnBnAQb60r2myXuY79MnMc6d2MdMqQEDbaQWw";
		String email = this.jwtUtil.extractEmail(token);
		System.out.println(email);
	}

}
