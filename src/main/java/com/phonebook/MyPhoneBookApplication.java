package com.phonebook;

import com.phonebook.config.Values;
import com.phonebook.util.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Application main class
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Slf4j
@SpringBootApplication
public class MyPhoneBookApplication {

	/**
	 * The Starting point of application
	 *
	 * @param args Array of String - The command line arguments
	 */
	public static void main(String[] args) {
		log.debug("Starting Application");
		AppUtils.performPreInitialize();
		ConfigurableApplicationContext ctx = SpringApplication.run(MyPhoneBookApplication.class, args);
		Values values = ctx.getBean(Values.class);
		AppUtils.initializeValues(values);
		AppUtils.performPostInitialize();
	}
}
