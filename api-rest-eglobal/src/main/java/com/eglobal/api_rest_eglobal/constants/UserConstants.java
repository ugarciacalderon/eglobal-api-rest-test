package com.eglobal.api_rest_eglobal.constants;

public class UserConstants {
    public static final String VALID_USERNAME_REGEX = "(^$|[aA-zZ._-]+[aA-zZ._-]{5})";
    public static final String VALID_EMAIL_REGEX = "^[aA-zZ0-9._%+-]+@[aA-zZ.-]+\\.[aA-zZ]{2,6}$";
    public static final String VALID_PHONE_REGEX = "^((\\(\\d{2}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$";
    public static final String VALID_PASSWORD_REGEX = "^((?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9]).{6,})\\S$";
}
