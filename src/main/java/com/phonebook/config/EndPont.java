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
    private EndPont() {
    }

    /* CONTACT - Home URI */
    public static final String CONTACT = "/contact";

    /* CONTACT - Add new Contact URI */
    public static final String ADD = "/add";

    /* CONTACT - Update the Contact URI */
    public static final String UPDATE = "/update";

    /* CONTACT - Get Contact by Id URI */
    public static final String GET_BY_ID = "/get/{id}";

    /* CONTACT - Delete Contact by Id URI */
    public static final String DELETE_BY_ID = "/delete/{id}";

    /* LIST_CONTACTS - List Contacts using offset and limit */
    public static final String LIST_CONTACTS = "/list/{offset}/{limit}";
}
