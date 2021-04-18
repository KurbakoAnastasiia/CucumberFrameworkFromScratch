package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

    static Properties prop;

    /** This method read any given properties file
     *
     * @param filepath
     * @return Properties
     */

    public static Properties readProperties (String filepath) {
        try {
            FileInputStream fis = new FileInputStream(filepath);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    /**This method retrieves value based on specific key
     *
     * @param key
     * @return
     */
    public static String getPropertyValue(String key) {
      return prop.getProperty(key);
    }

}
