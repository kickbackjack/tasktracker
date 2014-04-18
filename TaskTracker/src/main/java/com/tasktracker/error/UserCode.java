/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tasktracker.error;

import java.util.HashMap;

/**
 *
 * @author Jack
 */
public enum UserCode implements ErrorCode {

    DATA_REQUIRED(200),
    DUPLICATE_EMAIL(201),
    USER_DOES_NOT_EXIST(301);
    
    private final static HashMap<Integer, String> messageMap;
    static {
        messageMap = new HashMap<Integer, String>();
        messageMap.put(200, "Missing full User details");
        messageMap.put(201, "User with given email address already exists");
        messageMap.put(301, "User does not exist");
    };
    
    private final int number;

    private UserCode(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }
    
    @Override
    public String getSimpleMessage() {
        return messageMap.get(number);
    }
}
