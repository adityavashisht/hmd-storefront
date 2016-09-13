package com.halalmeatdepot.web.controller;

import com.halalmeatdepot.domain.Order;
import com.halalmeatdepot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by vashishta on 9/13/16.
 */
@Controller
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public String show(@RequestParam(name = "id", required = false) Long id, Model model) {

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
