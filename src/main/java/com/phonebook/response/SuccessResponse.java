package com.phonebook.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.phonebook.dto.PhoneBookContactDto;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * SuccessResponse class
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Builder
@Getter
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuccessResponse implements PhoneBookResponse{

    private String successMessage;
    private String contactId;
    private PhoneBookContactDto contact;
}
