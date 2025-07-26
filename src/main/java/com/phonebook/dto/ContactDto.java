package com.phonebook.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.phonebook.config.UIMessage;
import com.phonebook.config.Values;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Contact class represent the contact number.
 * it holds country code, contact number, contact type.
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Builder
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactDto {

    /* Country code of contact number */
    @NotNull(message = UIMessage.COUNTRY_CODE_ERR_MSG_1)
    @NotBlank(message = UIMessage.COUNTRY_CODE_ERR_MSG_1)
    @Pattern(message = UIMessage.COUNTRY_CODE_ERR_MSG_2, regexp = Values.CALLING_COUNTRY_CODE_REGEX)
    private String countryCode;

    /* Contact number */
    @NotNull(message = UIMessage.CONTACT_NUMBER_ERR_MSG_1)
    @NotBlank(message = UIMessage.CONTACT_NUMBER_ERR_MSG_1)
    @Pattern(message = UIMessage.CONTACT_NUMBER_ERR_MSG_2, regexp = Values.CONTACT_NUMBER_REGEX)
    private String contactNumber;

    /* Type of contact */
    private ContactType contactType;

    /**
     * ContactType enum
     */
    public enum ContactType {
        MOBILE, LANDLINE, OFFICE,
    }
}
