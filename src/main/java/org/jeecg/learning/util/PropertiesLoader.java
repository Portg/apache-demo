package org.jeecg.learning.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private static final Properties properties = new Properties();

    public static Properties loadProperties() {

        InputStream is = null;
        try {
            is = PropertiesLoader.class.getClassLoader().getResourceAsStream(
                    "application.properties");
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
	}


}
