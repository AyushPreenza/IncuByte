package Steps;

import Utils.BaseTest;
import io.cucumber.java.*;

import java.io.IOException;

import static Utils.BaseTest.androidDriver;
import static Utils.BaseTest.driver;
import static Utils.DriverUtil.createBrowser;

public class Hook {
    BaseTest baseTest = new BaseTest();

    @Before("@Func")
    public void testStart() {
        createBrowser("Chrome");
        System.out.println("------Test Started---------");
    }

    @After("@Func")
    public void TearDownTest(Scenario scenario) throws IOException {
        String path = null;

        if (scenario.isFailed()) {
            System.out.println(scenario.getName());
            String scFileName = "ScreenShot_" + System.currentTimeMillis();
            path = System.getProperty("user.dir") + "\\report\\" + scFileName + ".png";
            byte[] screenshot = baseTest.TakeScreenShot(path);
            scenario.attach(screenshot, "image/png", "image");
//            driver.close();
//            driver.quit();
        }else{
            driver.close();
            driver.quit();
        }
    }

}
