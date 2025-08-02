package com.phonebook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class SuccessResponse implements PhoneBookResponse{

    private String successMessage;
    private String contactId;
}
