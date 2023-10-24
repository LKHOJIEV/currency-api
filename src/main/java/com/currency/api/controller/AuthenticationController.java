package com.currency.api.controller;

import com.currency.api.conf.aop.request.SignUpRequest;
import com.currency.api.conf.aop.request.SigninRequest;
import com.currency.api.domain.response.SingleResponse;
import com.currency.api.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest request) {

        SingleResponse signup = authenticationService.signup(request);

        return ResponseEntity.status(signup.getHttpStatus()).body(signup);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SigninRequest request) {
        SingleResponse signin = authenticationService.signin(request);
        return ResponseEntity.status(signin.getHttpStatus()).body(signin);
    }
}
