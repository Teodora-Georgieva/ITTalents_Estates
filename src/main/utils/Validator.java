package main.utils;

public abstract class Validator {
    public static boolean isValidString(String s){
        return s != null && s.length() > 0;
    }

    public static boolean isValidBudget(double budget){
        return budget >= 30000 && budget <= 150000;
    }
}