package com.ideas2it.ems.util.validationutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
     
    static String namePattern = ("^[a-zA-Z]{2,20}$");
    static String designationPattern = ("^[a-zA-Z]{2,30}$");
    static String phoneNumberPattern = ("^[0|91]*[7-9]{1}[0-9]{9}$");
    static String emailIdPattern = "^[a-zA-Z]{2,20}[.\\-_]"
                                   .concat("?[a-zA-Z0-9]{1,20}[@]")
                                   .concat("[a-z]{1,20}[a-z0-9]{0,10}")
                                   .concat("[.][a-z]{2,3}[.]")
                                   .concat("?[a-z]{1,2}$");
    static String experiencePattern = ("^[0-9]");
    
    public static boolean isValidPattern(String pattern, String fieldValue) {
        return Pattern.matches(pattern,fieldValue);   
    }
}