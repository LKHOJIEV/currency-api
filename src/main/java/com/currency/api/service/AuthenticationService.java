package com.currency.api.service;


import com.currency.api.conf.aop.request.SignUpRequest;
import com.currency.api.conf.aop.request.SigninRequest;
import com.currency.api.domain.response.SingleResponse;

public interface AuthenticationService {
    SingleResponse signup(SignUpRequest request);

    SingleResponse signin(SigninRequest request);
}