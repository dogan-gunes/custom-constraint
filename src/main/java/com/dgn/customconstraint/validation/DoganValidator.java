package com.dgn.customconstraint.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoganValidator implements ConstraintValidator<Dogan,String> {

    @Override
    public void initialize(Dogan constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        String regex = "^(?:\\+?90|0)([5-9]\\d{2})[-.\\s]?(\\d{3})[-.\\s]?(\\d{2})[-.\\s]?(\\d{2})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
