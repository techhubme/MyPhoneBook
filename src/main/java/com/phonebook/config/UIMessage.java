package com.phonebook.config;

/**
 * UIMessage class
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
public class UIMessage {

    /**
     * Private object to avoid object creation
     */
    private UIMessage(){}

    /* PHONE_BOOK_CTRLR_MSG_1 - Message when contact added successfully */
    public static final String PHONE_BOOK_CTRLR_MSG_1 = "Phonebook contact added successfully";

    /* FIRST_NAME_ERR_MSG_1 - Message for first name if empty */
    public static final String PHONE_BOOK_CTRLR_MSG_2 = "Phonebook contact is invalid";

    /* FIRST_NAME_ERR_MSG_1 - Message for first name if empty */
    public static final String FIRST_NAME_ERR_MSG_1 = "First name must not be empty";

    /* FIRST_NAME_ERR_MSG_2 - Message for invalid name */
    public static final String FIRST_NAME_ERR_MSG_2 = "First name is invalid, name should contains alphabets only";

    /* MIDDLE_NAME_ERR_MSG_1 - Message for invalid middle name */
    public static final String MIDDLE_NAME_ERR_MSG_1 = "Middle name is invalid, name should contains alphabets only";

    /* LAST_NAME_ERR_MSG_1 - Message - Name should not be null */
    public static final String LAST_NAME_ERR_MSG_1 = "Last name must not empty";

    /* LAST_NAME_ERR_MSG_2 - Message for invalid name */
    public static final String LAST_NAME_ERR_MSG_2 = "Last name is invalid, name should contains alphabets only";

    /* COUNTRY_CODE_ERR_MSG_1 - Message for country code if empty */
    public static final String COUNTRY_CODE_ERR_MSG_1 = "Country code must not be empty";

    /* COUNTRY_CODE_ERR_MSG_2 - Message for country code if invalid */
    public static final String COUNTRY_CODE_ERR_MSG_2 = "Country code should be start with '+' and followed by digits";

    /* COUNTRY_CODE_ERR_MSG_2 - Message for contact number if null or empty */
    public static final String CONTACT_NUMBER_ERR_MSG_1 = "Contact number should not be empty";

    /* COUNTRY_CODE_ERR_MSG_2 - Message for contact number if invalid */
    public static final String CONTACT_NUMBER_ERR_MSG_2 = "Contact number should contains digits only";

    /* CONTACT_NUMBER_ERR_MSG_3 - Message for contact number if not provided */
    public static final String CONTACT_NUMBER_ERR_MSG_3 = "Please provide at least one contact number";

    /* LANDMARK_ERR_MSG_1 - Message for invalid address landmark */
    public static final String LANDMARK_ERR_MSG_1 = "Invalid Landmark";

    /* VILLAGE_CITY_ERR_MSG_1 - Message for invalid village or city landmark */
    public static final String VILLAGE_CITY_ERR_MSG_1 = "Village or city should not empty";

    /* VILLAGE_CITY_ERR_MSG_2 - Message for invalid village or city landmark */
    public static final String VILLAGE_CITY_ERR_MSG_2 = "Invalid village or city";

    /* VILLAGE_CITY_ERR_MSG_1 - Message for invalid village or city landmark */
    public static final String DISTRICT_ERR_MSG_1 = "District should not empty";

    /* VILLAGE_CITY_ERR_MSG_1 - Message for invalid village or city landmark */
    public static final String DISTRICT_ERR_MSG_2 = "District is invalid";

    /* STATE_ERR_MSG_1 - Message for invalid address State */
    public static final String STATE_ERR_MSG_1 = "State should not empty";

    /* STATE_ERR_MSG_2 - Message for invalid address State */
    public static final String STATE_ERR_MSG_2 = "State is invalid";

    /* COUNTRY_ERR_MSG_1 - Message for invalid address country */
    public static final String COUNTRY_ERR_MSG_1 = "Country should not empty";

    /* STATE_ERR_MSG_2 - Message for invalid address country */
    public static final String COUNTRY_ERR_MSG_2 = "Country is invalid";

    /* PIN_CODE_ERR_MSG_1 - Message for invalid address Pin code or Zip code */
    public static final String PIN_CODE_ERR_MSG_1 = "PinCode or ZipCode should not empty";

    /* PIN_CODE_ERR_MSG_2 - Message for invalid address Pin code or Zip code */
    public static final String PIN_CODE_ERR_MSG_2 = "PinCode or ZipCode is invalid";

    /* CTRLR_ADV_ERR_MSG_1 - Message when server got exception or error while processing request */
    public static final String CTRLR_ADV_ERR_MSG_1 = "Internal Error: Id# %s";

}
