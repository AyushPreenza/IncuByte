package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public static ChromeDriver driver;
    public static AppiumDriver<MobileElement> androidDriver = null;
    public static void setUp() {
        ChromeOptions options=new ChromeOptions();
        Map<String, Object> prefs=new HashMap<String,Object>();
        prefs.put("profile.default_content_setting_values.notifications", 1);
        //1-Allow, 2-Block, 0-default
        options.setExperimentalOption("prefs",prefs);

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        WebDriverManager.chromedriver().setup();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
    }

    public byte[] TakeScreenShot(String path) throws IOException {
        System.out.println("Screenshot Path: " + path);
        try {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(screenshot);
            fileOutputStream.close();
            return screenshot;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void launchApplicationInMobileBrowser(String content) {

        try {
            // Set the desired capabilities for the Android emulator
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
            caps.setCapability(MobileCapabilityType.UDID, "emulator-5554"); // Replace with your emulator UDID
//            caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");
            caps.setCapability("autoAcceptAlerts", true);
            caps.setCapability("autoDismissAlerts", true);


            // Initialize the Appium driver
            androidDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), caps);

            // Navigate to the desired URL in the Chrome browser
            String url = content;
            androidDriver.get(url);

            // Optional: Add additional test steps or assertions here
            WebDriverWait wait = new WebDriverWait(androidDriver,60);
            wait.until(ExpectedConditions.alertIsPresent());
            androidDriver.findElement(By.id("com.android.chrome:id/negative_button")).click();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
            e.printStackTrace();
        }
    }

    public byte[] TakeScreenShotMobile(String path) throws IOException {
        System.out.println("Screenshot Path: " + path);
        try {
            byte[] screenshot = ((TakesScreenshot)androidDriver).getScreenshotAs(OutputType.BYTES);
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(screenshot);
            fileOutputStream.close();
            return screenshot;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void tapByAdb(String command){
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("ADB command executed successfully.");
            } else {
                System.out.println("ADB command failed with exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}