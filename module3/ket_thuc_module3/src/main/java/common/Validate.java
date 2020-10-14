package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static boolean isValidName(String name){
        Pattern pattern=Pattern.compile("^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$");
        Matcher matcher=pattern.matcher(name);
        return matcher.matches();
    }
    public static boolean isValidNumber(String number){
        Pattern pattern=Pattern.compile("^[1-9][\\d]*");
        Matcher matcher=pattern.matcher(number);
        return matcher.matches();
    }
    public static boolean isPrice(String price){
        Pattern pattern=Pattern.compile("^[1-9][1-9]{8,}");
        Matcher matcher=pattern.matcher(price);
        return matcher.matches();
    }
}
