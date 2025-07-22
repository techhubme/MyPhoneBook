package com.phonebook.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Constants defined for reusability.
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Component
public class Values {

    /**
     * Private constructor to avoid the object creation.
     */
    private Values(){}

    @Value("${server.port}")
    public String applicationPort;

    /* LINE Constant */
    public static final String LINE = "---------------------------------------------------------------------";

    /* WELCOME_MSG Constant */
    public static final String WELCOME_MESSAGE = "Welcome to MyPhoneBook Application";

    /* NEW_LINE Constant */
    public static final String NEW_LINE = "\n";

    /* HOST Constant */
    public static final String HTTP = "http://";

    /* COLON Constant */
    public static final String COLON = ":";

    /* COMMA Constant */
    public static final String COMMA = ",";

    /* SWAGGER_UI_ENDPOINT Constant */
    public static final String SWAGGER_UI_ENDPOINT = "/swagger-ui/index.html";
}
