package ru.arkhipov.MySecondTestAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonValue;
//import com.sun.net.httpserver.Authenticator;

public enum Codes {

//    SUCCESS, FAILED

    SUCCESS("success"),
    FAILED("failed");

    private final String name;

    Codes(String name){
        this.name = name;
    }

    @JsonValue
    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}
