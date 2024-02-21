package com.example.caramelo.service.user;

import com.example.caramelo.dto.request.SignUpRequest;
import com.example.caramelo.dto.request.SigninRequest;
import com.example.caramelo.dto.response.user.JwtAuthenticationResponse;

public interface AuthenticationService {
	
	/** REGISTRO */
    JwtAuthenticationResponse signup(SignUpRequest request);
    /** ACCESO a Token JWT */
    JwtAuthenticationResponse signin(SigninRequest request);
}
