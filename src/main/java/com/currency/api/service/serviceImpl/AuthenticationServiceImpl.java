package com.currency.api.service.serviceImpl;

import com.currency.api.conf.aop.request.SignUpRequest;
import com.currency.api.conf.aop.request.SigninRequest;
import com.currency.api.domain.response.SingleResponse;
import com.currency.api.entity.*;
import com.currency.api.repository.UserRepository;
import com.currency.api.service.AuthenticationService;
import com.currency.api.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public SingleResponse signup(SignUpRequest request) {

        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)

                .build();

        userRepository.save(user);

        log.info("user created in AuthenticationServiceImpl: "+ user);

        var jwt = jwtService.generateToken(user);

        return SingleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("user created")
                .build();
    }

    @Override
    public SingleResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return SingleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("token")
                .data(jwt)
                .build();
    }
}

