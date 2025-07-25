package com.phonebook.util;

import com.phonebook.config.LogMessage;
import com.phonebook.config.Values;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Application utility class
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Slf4j
public final class AppUtils {

    @Setter
    private static Values values;

    /**
     * Private constructor to avoid the object creation.
     */
    private AppUtils() {
    }

    /**
     * Perform pre application Initialization tasks.
     */
    public static void performPreInitialize() {
        log.debug(LogMessage.APP_UTILS_MSG_1);
        setEnv();
    }

    /**
     *  Set the Application environment variables.
     */
    private static void setEnv(){
        log.debug(LogMessage.APP_UTILS_MSG_3);
        System.setProperty(Values.SYS_ENV_APP_HOSTNAME, Values.APP_HOST_NAME);
        System.setProperty(Values.SYS_ENV_APP_HOST_IP, Values.APP_HOST_IP);
    }

    /**
     * Perform post application Initialization tasks.
     */
    public static void performPostInitialize() {
        log.debug(LogMessage.APP_UTILS_MSG_2);
        showServerEndpoints();
    }

    /**
     * Logs the Server URL (IP and Port number) for reference.
     */
    private static void showServerEndpoints() {
        StringBuilder endPointInfo = new StringBuilder(LogMessage.LINE)
                .append(Values.NEW_LINE)
                .append(LogMessage.WELCOME_MESSAGE)
                .append(Values.NEW_LINE)
                .append(LogMessage.LINE);
        String[] ips = Values.APP_HOST_IP.split(Values.COMMA);
        for (String ip : ips) {
            ip = ip.trim();
            endPointInfo
                    .append(Values.NEW_LINE)
                    .append(Values.HTTP_PROTOCOL_PART)
                    .append(ip)
                    .append(Values.COLON)
                    .append(values.applicationPort)
                    .append(Values.NEW_LINE)
                    .append(Values.HTTP_PROTOCOL_PART)
                    .append(ip)
                    .append(Values.COLON)
                    .append(values.applicationPort)
                    .append(Values.SWAGGER_UI_ENDPOINT)
                    .append(Values.NEW_LINE);
        }
        endPointInfo.append(LogMessage.LINE);
        log.info(endPointInfo.toString());
    }
}
