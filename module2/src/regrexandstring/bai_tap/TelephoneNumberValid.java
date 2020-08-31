package regrexandstring.bai_tap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelephoneNumberValid {
    private static Pattern pattern;
    private static Matcher matcher;

    private static final String TELEPHONE_REGEX="^\\d{2}-0\\d{9}$";
    public TelephoneNumberValid(){
        pattern=Pattern.compile(TELEPHONE_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
