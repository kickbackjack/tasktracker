/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tasktracker.controller;

import com.tasktracker.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jack
 */
@Controller("home")
@RequestMapping(value={"/", "/home"})
public class HomeController {
    
    private static final Logger logger = Logger.getLogger(HomeController.class);
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String get(ModelMap model) {
        logger.info("Loading home page");
        return "home";
    }
}
