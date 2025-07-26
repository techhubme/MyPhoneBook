package com.phonebook.config;

/**
 * LogMessage Class - Contains all the log messages at single place.
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
public final class LogMessage {

    /**
     * Private Constructor avoid object creation
     */
    private LogMessage() {
    }

    /* LINE - A line constant */
    public static final String LINE = "---------------------------------------------------------------------";

    /* WELCOME_MESSAGE - Info log when application started successfully */
    public static final String WELCOME_MESSAGE = "Welcome to MyPhoneBook Application";

    /* PHONE_BOOK_CNTLR_MSG_1 - Debug log when addContact method is called */
    public static final String PHONE_BOOK_CNTLR_MSG_1 = "Adding New PhoneBook Contact";

    /* APP_UTILS_MSG_1 For Pre-initialization */
    public static final String APP_UTILS_MSG_1 = "Performing Pre-initialization tasks";

    /* APP_UTILS_MSG_2 For Post-initialization */
    public static final String APP_UTILS_MSG_2 = "Performing Post-initialization tasks";

    /* APP_UTILS_MSG_3 - Debug log when setting the application environment variables */
    public static final String APP_UTILS_MSG_3 = "Setting application environment variables";

    /* VALUES_MSG_1 - Debug log when application getting hostname and hostIp */
    public static final String VALUES_MSG_1 = "Getting application Hostname and HostIp";

    /* VALUES_MSG_3 - Error logs while reading hostname and hostIpe */
    public static final String VALUES_MSG_2 = "Unable to read the Hostname and IP";

    /* CTRLR_ADV_ERROR_MSG_1 - Error logs when server got exception or error while processing request */
    public static final String CTRLR_ADV_ERROR_MSG_1 = "Exception/Error ID# {}";
}
