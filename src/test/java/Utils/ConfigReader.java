package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    public static Properties loadPropertyFile(String filePath) {
        // Read from properties file
        File file = new File(filePath);
        Properties prop = new Properties();

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
            prop.load(fileInput);
        } catch (Exception e) {

        }
        return prop;

    }

    public static String getValue(String key) {

        Properties prop = loadPropertyFile("src/main/resources/config.properties");
        // Open the URL in firefox browser
        return prop.getProperty(key);
    }

    public String getReportConfigPath(){

        String reportConfigPath = getValue("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }
}
