package regrexandstring.bai_tap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValid {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String NAME_REGEX="^[APC]\\d{4}[GHIKLM]$";
    public NameValid(){
        pattern=Pattern.compile(NAME_REGEX);
    }
    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
