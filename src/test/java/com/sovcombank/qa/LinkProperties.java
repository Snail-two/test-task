package com.sovcombank.qa;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LinkProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;

    public static Logger logger = Logger.getLogger(ConfProperties.class.getName());

    static {
        try {
            //указание пути до файла с настройками
            fileInputStream = new FileInputStream("src/test/resources/link.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Файл не найден");
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * метод для возврата строки со значением из файла с настройками
     */
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
