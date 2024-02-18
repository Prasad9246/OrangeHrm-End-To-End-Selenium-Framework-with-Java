package logMassage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {

    private Logs() {
    }

    public static void logMessage(Class<?> clazz, String message) {
        getLogger(clazz).info(message);
        //ExcelLogger.logToExcel(clazz, message);
    }

    public static void logClickInfo(Class<?> clazz, String elementName) {
        String logMessage = "Clicked on " + elementName;
        getLogger(clazz).info(logMessage);
       // ExcelLogger.logToExcel(clazz, logMessage);
    }

    public static void logSendKeysInfo(Class<?> clazz, String elementName) {
        String logMessage = "Sent keys to " + elementName;
        getLogger(clazz).info(logMessage);
       // ExcelLogger.logToExcel(clazz, logMessage);
    }

    private static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }
}
