package com.phonebook.response;

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
public class SuccessResponse implements PhoneBookResponse{

    private String successMessage;
}
