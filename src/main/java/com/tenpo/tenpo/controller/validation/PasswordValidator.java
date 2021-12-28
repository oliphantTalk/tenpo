package com.tenpo.tenpo.controller.validation;

import com.tenpo.tenpo.api.session.SignUpRq;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<IsPasswordMatching, SignUpRq> {

    @Override
    public void initialize(IsPasswordMatching constraintAnnotation) {
    }
    @Override
    public boolean isValid(SignUpRq signUpRq, ConstraintValidatorContext context){
        return signUpRq.getPassword().equals(signUpRq.getPasswordConfirmation());
    }
}
