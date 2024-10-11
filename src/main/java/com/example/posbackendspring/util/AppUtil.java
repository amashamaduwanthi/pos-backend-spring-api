package com.example.posbackendspring.util;

import java.util.UUID;

public class AppUtil {
    public static String generateCustomerId(){
        return "CUSTOMER-"+ UUID.randomUUID();
    }


}
