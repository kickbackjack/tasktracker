/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tasktracker.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jack
 */
@Controller("footer")
@RequestMapping("/footer")
public class FooterController {
    
    private static final Logger logger = Logger.getLogger(FooterController.class);
    
    @RequestMapping(method = RequestMethod.GET)
    public String get(ModelMap model) {
        logger.info("Loading footer");
        return "modules/footer";
    }
}
