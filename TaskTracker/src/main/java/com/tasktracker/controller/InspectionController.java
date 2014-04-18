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
@Controller("inspection")
@RequestMapping("/inspection")
public class InspectionController {
    
    private static final Logger logger = Logger.getLogger(InspectionController.class);
    
    @RequestMapping(method = RequestMethod.GET)
    public String get(ModelMap model) {
        logger.info("Loading inspection");
        return "inspection";
    }
}
