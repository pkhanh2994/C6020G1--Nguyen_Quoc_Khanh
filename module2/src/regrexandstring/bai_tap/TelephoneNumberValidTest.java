package regrexandstring.bai_tap;

import java.util.Scanner;

public class TelephoneNumberValidTest {
    public static void main(String[] args) {
        TelephoneNumberValid telephoneNumberValid = new TelephoneNumberValid();
        boolean isValid;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your number to check");
        String numsPhone=scanner.nextLine();
        isValid=telephoneNumberValid.validate(numsPhone);
        if(!isValid){
            System.out.println("Your phone number is wrong");
        }else System.out.println("Your phone number is wright");

    }


}
