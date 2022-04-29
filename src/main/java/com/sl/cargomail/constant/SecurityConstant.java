package com.sl.cargomail.constant;

public class SecurityConstant {
    public static final long EXPIRATION_TIME = 432_000_000;// 5 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String TOKEN_CANNOT_BE_VERIFED = "Token cannot by verified";
    public static final String GET_ARRAYS_LIC = "A&SUnit, LLC";
    public static final String GET_ARRAYS_ADMINISTRATION = "Cargo-Mail Portal";
    public static final String AUTHORITIES = "Authorities";
    public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page";
    public static final String ACCESS_DENIDE_MESSAGE = "You do not have permision to access this page";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
    public static final String[] PUBLIC_URLS = {"/user/login", "/user/image/**", "/user/register"};
}
