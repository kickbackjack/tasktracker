/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tasktracker.service;

import com.tasktracker.bean.UserAccount;
import com.tasktracker.dao.UserDao;
import com.tasktracker.error.TaskTrackerException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jack
 */
@Service
public class UserService implements UserDetailsService {
    
    private static final Logger logger = Logger.getLogger(UserService.class);
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private UserAssembler userAssembler;
    
    public void addUser(UserAccount user) throws TaskTrackerException {
        userDao.addUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        logger.info("Loading user " + string);
        UserAccount user = userDao.getUser(string);
        
        if (user == null) {
            logger.warn("Failed to find user in database");
            throw new UsernameNotFoundException("User not found");
        }
 
        logger.info("Found user " + user.toString());
        return userAssembler.buildUserFromUserEntity(user);
    }
}
