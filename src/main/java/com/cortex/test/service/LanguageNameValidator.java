package com.cortex.test.service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LanguageNameValidator implements ConstraintValidator<LanguageNameValidation, String> {
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return (name.equals("Java") ||
                name.equals("JavaScript") ||
                name.equals("C#") ||
                name.equals("C++") ||
                name.equals("Python"));
    }
}
