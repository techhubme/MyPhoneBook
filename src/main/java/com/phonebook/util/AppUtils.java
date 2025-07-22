package com.phonebook.util;

import com.phonebook.config.Values;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Application utility class
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Component
@Slf4j
public final class AppUtils {

    private static Values values;

    /**
     * Private constructor to avoid the object creation.
     */
    private AppUtils() {
    }

    public static void initializeValues(Values v) {
        values = v;
    }

    /**
     * Perform pre application Initialization tasks.
     */
    public static void performPreInitialize() {
        log.debug("Performing Pre-initialization tasks");
        LogUtils.setLogThreadContext();
    }

    /**
     * Perform post application Initialization tasks.
     */
    public static void performPostInitialize() {
        log.debug("Performing Post-initialization tasks");
        showServerEndpoints();
    }

    /**
     * Logs the Server URL (IP and Port number) for reference.
     */
    private static void showServerEndpoints() {
        StringBuilder endPointInfo = new StringBuilder(Values.LINE)
                .append(Values.NEW_LINE)
                .append(Values.WELCOME_MESSAGE)
                .append(Values.NEW_LINE)
                .append(Values.LINE);
        String[] ips = LogUtils.HOST_IP.split(Values.COMMA);
        for (String ip : ips) {
            ip = ip.trim();
            endPointInfo
                    .append(Values.NEW_LINE)
                    .append(Values.HTTP).append(ip).append(Values.COLON).append(values.applicationPort)
                    .append(Values.NEW_LINE)
                    .append(Values.HTTP).append(ip).append(Values.COLON).append(values.applicationPort)
                    .append(Values.SWAGGER_UI_ENDPOINT)
                    .append(Values.NEW_LINE);
        }
        endPointInfo.append(Values.LINE);
        log.info(endPointInfo.toString());
    }
}
