package com.phonebook.response;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

/**
 * Error response class
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class ErrorResponse implements PhoneBookResponse{

    private Map<String,String> errors;
 }
