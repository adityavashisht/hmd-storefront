package com.halalmeatdepot.web.controller;

import com.halalmeatdepot.domain.Customer;
import com.halalmeatdepot.web.EmailUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * Created by vashishta on 9/15/16.
 */
@Component
public class RegisterValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RegisterForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterForm form = (RegisterForm) target;


        ValidationUtils.rejectIfEmpty(errors, "customer.firstName", "required", "Required");
        ValidationUtils.rejectIfEmpty(errors, "customer.lastName", "required", "Required");
        ValidationUtils.rejectIfEmpty(errors, "customer.email", "required", "Required");
        ValidationUtils.rejectIfEmpty(errors, "customer.birthDate", "required", "Required");

        Customer customer = form.getCustomer();


        if (customer.getBirthDate() == null && !errors.hasFieldErrors("customer.birthDate")) {
            errors.rejectValue("customer.birthDate", "invalid");
        }

        if (StringUtils.hasText(customer.getEmail()) && !errors.hasFieldErrors("customer.email")) {
            boolean isValid = EmailUtils.isEmail(customer.getEmail());
            if (!isValid) {
                errors.rejectValue("customer.email", "invalid.email");
            }
        }


    }
}
