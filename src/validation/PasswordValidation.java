package validation;

import java.util.regex.*;

public class PasswordValidation {
    private Pattern pattern;
    private Matcher matcher;
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{5}$";

    public PasswordValidation() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    public boolean validatePassword(final String password) {
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}

