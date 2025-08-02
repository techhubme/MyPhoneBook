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

    /* CTRLR_ADV_MSG_1 - Log message when controller advice handling global exception. */
    public static final String CTRLR_ADV_MSG_1 = "Handling controller's thrown exception";

    /* CTRLR_ADV_MSG_2 - Log message when controller advice handling enum related validation exception. */
    public static final String CTRLR_ADV_MSG_2 = "Handling controller's enum value exception";

    /* CTRLR_ADV_MSG_3 - Log message when controller advice handling method validation exception. */
    public static final String CTRLR_ADV_MSG_3 = "Handling controller's method validation exception";

    /* CTRLR_ADV_MSG_4 - Log message when controller advice handling method validation exception. */
    public static final String CTRLR_ADV_MSG_4 = "Handling controller exception";

    /* LOC_BOOK_SERVICE_MSG_1 - Log message when contact unable to save. */
    public static final String LOC_BOOK_SERVICE_MSG_1 = "Unable to save phone book contact";

    /* LOC_BOOK_SERVICE_MSG_2 - Log message when contact not foud for given id. */
    public static final String LOC_BOOK_SERVICE_MSG_2 = "Contact not found for id {0}";

    /* LOC_BOOK_SERVICE_MSG_3 - Log message when contact not foud for given id. */
    public static final String LOC_BOOK_SERVICE_MSG_3 = "Contact not deleted for id {0}";

    /* LOC_BOOK_SERVICE_MSG_4 - Log message when getting contacts list. */
    public static final String LOC_BOOK_SERVICE_MSG_4 = "Couldn't get the list of contacts";

    /* LOC_BOOK_SERVICE_MSG_5 - Log message when update the contact list. */
    public static final String LOC_BOOK_SERVICE_MSG_5 = "Contact id should not be empty";

    /* LOC_BOOK_SERVICE_MSG_6 - Log message when contact unable to update. */
    public static final String LOC_BOOK_SERVICE_MSG_6 = "Unable to update phone book contact";
}
