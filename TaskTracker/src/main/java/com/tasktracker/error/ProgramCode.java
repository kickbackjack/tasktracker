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
public enum ProgramCode implements ErrorCode {

    HIBERNATE_EXCEPTION(200);
    
    private final static HashMap<Integer, String> messageMap;
    static {
        messageMap = new HashMap<Integer, String>();
        messageMap.put(200, "There was an error in the database");
    };
    
    private final int number;

    private ProgramCode(int number) {
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