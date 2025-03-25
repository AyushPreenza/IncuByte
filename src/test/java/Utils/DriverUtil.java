package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverUtil {

    public static WebDriver driver = null;

    public static WebDriver createBrowser(String browser) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("autoGrantPermissions", "true");


        switch (browser) {
            case "Chrome":
                //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver2");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
//            	 WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "Headless":

                WebDriverManager.chromedriver().setup();
                //System.setProperty("webdriver.chrome.silentOutput","true");
                //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                final ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                options.setAcceptInsecureCerts(true);
                options.addArguments("--proxy-server='direct://'");
                options.addArguments("--proxy-bypass-list=*");
                //options.addArguments("--headless");
                options.addArguments("--blink-settings=imagesEnabled=false");
                options.addArguments("--user-agent='Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36'");
                options.addArguments("--start-maximized");
                options.addArguments("--disable-infobars"); // disabling infobars

                options.addArguments("--disable-extensions"); // disabling extensions

                options.addArguments("--disable-gpu"); // applicable to windows os only

                options.addArguments("--no-sandbox"); // Bypass OS security model

                options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems


                options.addArguments("--disable-web-security");
                options.addArguments("--use-fake-ui-for-media-stream");
                options.addArguments("--user-data-dir'");
                options.addArguments("--disable-user-media-security=true");
                options.addArguments("--allow-running-insecure-content");
                options.addArguments("--window-size=2000,1450");


                driver = new ChromeDriver(options);
                break;
        }

        return driver;
    }
}
