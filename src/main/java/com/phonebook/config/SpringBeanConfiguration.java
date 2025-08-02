package com.phonebook.config;

import com.phonebook.model.PhoneBookContact;
import com.svsoft.datarepo.exception.ObjectRepositoryException;
import com.svsoft.datarepo.repository.LocalObjectRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring bean configuration file
 */
@Configuration
public class SpringBeanConfiguration {

    @Bean
    public LocalObjectRepository<PhoneBookContact> localObjectRepository() throws ObjectRepositoryException {
        return new LocalObjectRepository<>();
    }
}
