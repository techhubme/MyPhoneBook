package com.phonebook.util;

import lombok.extern.slf4j.Slf4j;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Logger utility class
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Slf4j
public final class LogUtils {

    /* Server's HOST_NAME */
    public static final String HOST_NAME;

    /* Server's HOST_IP */
    public static final String HOST_IP;

    /**
     * Private constructor to avoid the object creation.
     */
    private LogUtils() {
    }

    /* Initialize the static variables */
    static {
        String hostName = null;
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
            log.error("Unable to read the Hostname and IP", ex);
        }
        int hostLen = hostIp.length();
        hostIp.delete(hostLen - 2, hostLen);
        HOST_NAME = hostName;
        HOST_IP = hostIp.toString();
        setLogThreadContext();
    }

    /**
     * Sets the logger pattern's context placeholder values
     */
    public static void setLogThreadContext() {
        System.setProperty("my.phone.book.app.host.name", HOST_NAME);
        System.setProperty("my.phone.book.app.host.ip", HOST_IP);
    }
}
