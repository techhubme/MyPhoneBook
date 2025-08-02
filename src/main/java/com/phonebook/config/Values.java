package com.phonebook.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Constants defined for reusability.
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Slf4j
@Component
public class Values {

    /**
     * Private constructor to avoid the object creation.
     */
    private Values() {
    }

    /* APP_HOST_NAME - Application Server's hostname */
    @Value("${server.port}")
    public String applicationPort;

    @Value("${springdoc.swagger-ui.path}")
    public String swaggerUIPath;

    /* APP_HOST_NAME - Application Server's hostname */
    public static final String APP_HOST_NAME;

    /* APP_HOST_IP - Application Server's hostIp */
    public static final String APP_HOST_IP;

    /* NEW_LINE - New line character */
    public static final String NEW_LINE = "\n";

    /* HOST Constant */
    public static final String HTTP_PROTOCOL_PART = "http://";

    /* COLON Constant */
    public static final String COLON = ":";

    /* COMMA Constant */
    public static final String COMMA = ",";

    /* ID Constant */
    public static final String ID = "id";

    /* OFFSET Constant */
    public static final String OFFSET = "offset";

    /* LIMIT Constant */
    public static final String LIMIT = "limit";

    /* SYS_ENV_APP_HOSTNAME for application Hostname environment variable */
    public static final String SYS_ENV_APP_HOSTNAME = "MyPhoneBook.app.hostname";

    /* SYS_ENV_APP_HOST_IP for application HostIp environment variable */
    public static final String SYS_ENV_APP_HOST_IP = "MyPhoneBook.app.hostIp";

    /* NAME_REGEX - Regular expression for name */
    public static final String NAME_REGEX = "[a-zA-Z ]{0,15}";

    /* LANDMARK_REGEX - Regular expression for village or city landmark */
    public static final String LANDMARK_REGEX = "[a-zA-Z0-9#. ]{0,40}";

    /* VILLAGE_CITY_REGEX - Regular expression for address landmark */
    public static final String VILLAGE_CITY_REGEX = "[a-zA-Z0-9# ]{1,30}";

    /* CALLING_COUNTRY_CODE_REGEX - Regular expression for Phone call country code */
    public static final String CALLING_COUNTRY_CODE_REGEX = "^\\+\\d{1,4}$";

    /* CALLING_COUNTRY_CODE_REGEX - Regular expression for Phone call country code */
    public static final String CONTACT_NUMBER_REGEX = "\\d{6,14}$";

    /* DISTRICT_REGEX - Regular expression for address district */
    public static final String DISTRICT_REGEX = "[a-zA-Z0-9# ]{1,25}";

    /* DISTRICT_REGEX - Regular expression for address district */
    public static final String PIN_CODE_REGEX = "[a-zA-Z0-9 ]{1,10}";

    /* NUMBER_REGEX - Regular expression for number only */
    public static final String NUMBER_REGEX = "\\d+";

    /* Initialize the static variables */
    static {
        log.debug(LogMessage.VALUES_MSG_1);
        String hostName = "";
        StringBuilder hostIp = new StringBuilder();
        try {
            hostName = InetAddress.getLocalHost().getHostName();
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface netInf = interfaces.nextElement();
                Enumeration<InetAddress> addresses = netInf.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress inetAddress = addresses.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        hostIp.append(inetAddress.getHostAddress()).append(", ");
                    }
                }
            }
        } catch (Exception ex) {
            log.error(LogMessage.VALUES_MSG_2, ex);
        }
        int hostLen = hostIp.length();
        hostIp.delete(hostLen - 2, hostLen);
        APP_HOST_NAME = hostName;
        APP_HOST_IP = hostIp.toString();
    }
}
