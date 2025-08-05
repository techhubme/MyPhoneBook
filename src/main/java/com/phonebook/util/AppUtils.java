package com.phonebook.util;

import com.phonebook.config.LogMessage;
import com.phonebook.config.Values;
import com.svsoft.commons.utility.constant.LoggerEmoji;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

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
     * Set the Application environment variables.
     */
    private static void setEnv() {
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
        StringBuilder endPointInfo = new StringBuilder("{} ")
                .append(LogMessage.LINE)
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
                    .append(values.swaggerUIPath)
                    .append(Values.NEW_LINE);
        }
        endPointInfo.append(LogMessage.LINE);
        log.info(endPointInfo.toString(), LoggerEmoji.INFO);
    }

    /**
     * Generate and return a unique error id to analysis the log efficiently
     *
     * @return String - A unique error id for log analysis
     */
    public static String getErrorId() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return new StringBuilder()
                .append(currentDateTime.getHour())
                .append(Math.random())
                .append(currentDateTime.getMinute())
                .append(currentDateTime.getSecond())
                .append(currentDateTime.getNano())
                .append(currentDateTime.getDayOfMonth())
                .append(currentDateTime.getMonthValue())
                .append(currentDateTime.getYear())
                .append(Math.random()).toString();
    }
}
