package Steps;

import Utils.DriverUtil;
import io.cucumber.java.*;
import java.io.IOException;

import static Utils.DriverUtil.createBrowser;
import static Utils.DriverUtil.driver;

public class Hook {

    @Before
    public void testStart() {
        createBrowser("Chrome");
        System.out.println("------Test Started---------");
    }

    @After
    public void TearDownTest(Scenario scenario) throws IOException {
        String path = null;

        if (scenario.isFailed()) {
            System.out.println(scenario.getName());
            path = System.getProperty("user.dir") + "/Screenshot/" + "embedded1" + ".png";
            byte[] screenshot = DriverUtil.TakeScreenShot(path);
            scenario.attach(screenshot, "image/png", "image");
            driver.close();
            driver.quit();
        }else{
            driver.close();
            driver.quit();
        }
    }

}
