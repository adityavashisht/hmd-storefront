package com.halalmeatdepot.web.controller;

import com.halalmeatdepot.domain.Order;
import com.halalmeatdepot.service.OrderService;
import com.halalmeatdepot.web.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

/**
 * Created by vashishta on 9/13/16.
 */
@Controller
@RequestMapping("/order")
@Secured(value = {"ROLE_ADMIN", "ROLE_USER"})
public class OrderController {


    @Autowired
    private OrderService orderService;


    @RequestMapping(method = RequestMethod.GET)
    public String show(@RequestParam(name = "id", required = false) Long id,
                       Model model,
                       Principal principal,
                        @CurrentUser User systemUser
    ) {

        Object user =  systemUser;

        // This code below is possible, but not recommended

        Object myUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Order order = null;
        String view = "order/new";

        if (id != null) {
            order = orderService.getById(id);
            model.addAttribute("order", order);
            view = "order/view";
        } else {

        }
        return view;
    }


}
