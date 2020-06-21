package com.APIProject.apiProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.PAYMENT_REQUIRED)
public class NonSufficientFunds extends RuntimeException {

    public NonSufficientFunds(String property) {
        super(property);
    }

}
