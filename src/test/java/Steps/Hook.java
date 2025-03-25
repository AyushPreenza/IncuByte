package Steps;

import Utils.BaseTest;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileOutputStream;
import java.io.IOException;

import static Utils.BaseTest.androidDriver;
import static Utils.BaseTest.driver;

public class Hook {
    BaseTest baseTest = new BaseTest();

    @Before("@Reg or @Sanity or @prod or @Func or @sonyliv")
    public void testStart() {
        System.out.println("------Test Started---------");
    }

    @After("@Reg or @Sanity or @prod or @Func or @sonyliv")
    public void TearDownTest(Scenario scenario) throws IOException {
        String path = null;

        if (scenario.isFailed()) {
            System.out.println(scenario.getName());
            String scFileName = "ScreenShot_" + System.currentTimeMillis();
            path = System.getProperty("user.dir") + "\\report\\" + scFileName + ".png";
            byte[] screenshot = baseTest.TakeScreenShot(path);
            scenario.attach(screenshot, "image/png", "image");
            driver.close();
            driver.quit();
        }else{
            driver.close();
            driver.quit();
        }
    }

    @Before("@mobile")
    public void beforeAndroidDriver(){
        System.out.println("------Test Started For Mobile Browser---------");
    }

    @After("@mobile")
    public void tearDownAndroidDriver(Scenario scenario) throws IOException {
        String path = null;

        if (scenario.isFailed()) {
            System.out.println(scenario.getName());
            String scFileName = "MobileScreenShot_" + System.currentTimeMillis();
            path = System.getProperty("user.dir") + "\\report\\" + scFileName + ".png";
            byte[] screenshot = baseTest.TakeScreenShotMobile(path);
            scenario.attach(screenshot, "image/png", "image");
            androidDriver.quit();
        }else{
            androidDriver.quit();
        }
    }
}
