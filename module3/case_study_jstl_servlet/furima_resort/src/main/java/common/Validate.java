package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static boolean isValidCustomerID(String customerID) {
        Pattern pattern = Pattern.compile("^KH" + "-" + "\\d{4}$");
        Matcher matcher = pattern.matcher(customerID);
        return matcher.matches();
    }
  public static boolean isValidServiceID(String serviceID){
        Pattern pattern=Pattern.compile("^DV"+"-"+"\\d{4}$");
        Matcher matcher=pattern.matcher(serviceID);
        return matcher.matches();
  }
  public static boolean isValidPhoneNumber(String phoneNumber){
        Pattern pattern=Pattern.compile("^(09[0|1]|849[0|1])+\\d{7}$");
        Matcher matcher=pattern.matcher(phoneNumber);
        return matcher.matches();
  }
  public static boolean isValidIdentifyCard(String identifyCard){
        Pattern pattern=Pattern.compile("\\d{9}|\\d{12}");
        Matcher matcher=pattern.matcher(identifyCard);
        return matcher.matches();
  }
  public static boolean isValidEmail(String email){
        Pattern pattern=Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
        Matcher matcher=pattern.matcher(email);
        return matcher.matches();
  }
  public static boolean isNumber(String number){
        Pattern pattern=Pattern.compile("^[1-9][\\d]*");
        Matcher matcher=pattern.matcher(number);
        return matcher.matches();

  }
}
