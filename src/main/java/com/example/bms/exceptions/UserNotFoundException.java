package com.example.bms.exceptions;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(){
        super("User Not Found");
    }
}
