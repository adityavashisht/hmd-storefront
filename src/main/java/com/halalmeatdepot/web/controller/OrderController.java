package com.halalmeatdepot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vashishta on 9/13/16.
 */
@Controller
@RequestMapping("/order")
public class OrderController {


    @RequestMapping(method = RequestMethod.GET)
    public String show() {
        return "order/new";
    }


}
