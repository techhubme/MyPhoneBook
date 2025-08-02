package com.phonebook.config;

/**
 * EndPont class contains constants for all the endpoint URIs
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
public final class EndPont {

    /**
     * Private constructor prevent object instantiation
     */
    private EndPont(){}

    /* CONTACT - Home URI */
    public static final String CONTACT = "/contact" ;

    /* CONTACT - Add new Contact URI */
    public static final String ADD = "/add";

    /* CONTACT - Get Contact by Id URI */
    public static final String GET_BY_ID = "/get/{id}" ;
}
