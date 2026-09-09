package com.xworkz.library.util;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidationUtil {
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    private static final Validator validator = factory.getValidator();

    public static Validator getValidator()
    {
        return validator;
    }
}
