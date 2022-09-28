package com.ideas2it.employeemanagement.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
     
    public static String namePattern = "^[A-Za-z]{2,20}([ ]?[a-zA-Z]+)*$";
    public static String designationPattern = "^[a-zA-Z]{2,30}$";
    public static String phoneNumberPattern = "^[0|91]*[7-9]{1}[0-9]{9}$";
    public static String emailIdPattern = "^[a-zA-Z]{1,20}[.\\-_]"
                                   .concat("?[a-zA-Z0-9]{1,20}[@]")
                                   .concat("[a-z0-9]{1,20}[a-z0-9]{0,10}")
                                   .concat("[.][a-z]{2,3}[.]")
                                   .concat("?[a-z]{1,3}$");
    public static String experiencePattern = "^[0-9][.]?[0-9]";
    
    public static boolean isValidPattern(String pattern, String fieldValue) {
        return Pattern.matches(pattern,fieldValue);   
    }
}