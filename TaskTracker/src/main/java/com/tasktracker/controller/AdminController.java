/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tasktracker.controller;

import com.tasktracker.bean.UserAccount;
import com.tasktracker.dao.UserDao;
import com.tasktracker.error.TaskTrackerException;
import com.tasktracker.service.UserService;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jack
 */
@Controller("admin")
@RequestMapping("/admin")
public class AdminController {
    
    private static final Logger logger = Logger.getLogger(AdminController.class);
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String get(ModelMap model) {
        logger.info("Loading administration");
        model.addAttribute("user_account", new UserAccount());
        return "admin";
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser(ModelMap model)  {
        logger.info("Loading administration");
        model.addAttribute("user_account", new UserAccount());
        return "admin";
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user_account") @Valid UserAccount user, BindingResult result)  {
        if (result.hasErrors()) {
            logger.debug("Error validating new user - " + user);
        }
        
        try {
            userService.addUser(user);
        } catch (TaskTrackerException e) {
            // Send simplified error message back to the user
            // TODO: ...
        }
        
        return "admin";
    }
}
