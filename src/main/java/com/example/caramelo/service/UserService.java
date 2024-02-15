package com.example.caramelo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.caramelo.dto.response.user.UsuarioResponse;

public interface UserService {
	UserDetailsService userDetailsService();

	List<UsuarioResponse> getAllUsers();
}
