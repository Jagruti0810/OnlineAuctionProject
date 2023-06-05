package common;

public class Utility {
    public static String generateVerificationCode() {
        int code = (int) (Math.random() * 900000 + 100000);
        return String.valueOf(code);
    }
}
