package Steps;

import PageObjects.ForwardRewindObject;
import Utils.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ForwardRewind extends ForwardRewindObject {

    @Given("^I navigate to application$")
    public void iNavigateToApplication() {
        try {
            driver.get("https://www.ottplay.com/");
            driver.manage().window().maximize();
        } catch (Throwable e) {

        }
    }

    @And("^I click on Sign In button$")
    public void iClickOnSignInButton() {
        ClickSignIn();
    }

    @And("^I enter username and password$")
    public void enterUserNamePassword(DataTable dataTable) {
        try {

            System.out.println(dataTable);
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

            System.out.println(data.get(0).get("username"));
            System.out.println(data.get(0).get("password"));

            enterUserName(data.get(0).get("username"));
            clickContinue();
            Thread.sleep(2000);
            enterPassword(data.get(0).get("password"));
            clickLogin();
            Thread.sleep(4000);
        } catch (Throwable e) {

        }
    }
}

