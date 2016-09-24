package com.halalmeatdepot.web.controller;

import com.halalmeatdepot.domain.Customer;
import com.halalmeatdepot.web.data.ErrorMessage;
import com.halalmeatdepot.web.data.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vashishta on 9/15/16.
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private RegisterValidator registerValidator;

    @RequestMapping(method = RequestMethod.GET)
    public String register(Model model) {
        RegisterForm registerForm = new RegisterForm();
        model.addAttribute(registerForm);
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("registerForm") RegisterForm registerForm, BindingResult result) {

        registerValidator.validate(registerForm, result);
        if (!result.hasErrors()) {
            Customer customer = registerForm.getCustomer();

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String encoded = bCryptPasswordEncoder.encode(customer.getPassword());
            customer.setPassword(encoded);

        }

        return "register";
    }


    @RequestMapping(value="ajax", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<JsonResponse> submitAjax(@ModelAttribute RegisterForm registerForm,
                                                   HttpServletRequest request,
                                                   BindingResult result) {


        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setPayload(new String("S"));

        List<ErrorMessage> errorMessageList = new ArrayList<>();

        if(registerForm.getCustomer().getBirthDate() == null) {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setField("birthDate");
            errorMessage.setMessage("Invalid Birth Date");

            errorMessageList.add(errorMessage);

        }

        jsonResponse.setErrorMessages(errorMessageList);

        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);

    }

}
