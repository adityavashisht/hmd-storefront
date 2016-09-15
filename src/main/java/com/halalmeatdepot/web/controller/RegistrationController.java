package com.halalmeatdepot.web.controller;

import com.halalmeatdepot.domain.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vashishta on 9/15/16.
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {

    @RequestMapping(method = RequestMethod.GET)
    public String register(Model model) {
        RegisterForm registerForm = new RegisterForm();
        model.addAttribute(registerForm);
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute ("registerForm") RegisterForm registerForm) {

        Customer customer = registerForm.getCustomer();

        return "register";
    }

}
