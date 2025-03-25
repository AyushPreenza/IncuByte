package Steps;

import PageObjects.MobilePageObjects;
import Utils.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import Utils.BaseTest;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class MobileSteps extends MobilePageObjects {

    @And("launch in mobile browser")
    public void launch_in_mobileBrowser() {
        BaseTest.launchApplicationInMobileBrowser("https://www.ottplay.com/");
    }

    @And("click on user button")
    public void click_on_user() {
        clickUser();
    }

    @And("click login")
    public void click_on_login() {
        clickLogin();
    }

    @And("^I enter username and password in mobile$")
    public void enterUserNamePassword(DataTable dataTable) {
        try {

            System.out.println(dataTable);
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

            enterUserName(data.get(0).get("username"));
            clickContinue();
            Thread.sleep(2000);
            enterPassword(data.get(0).get("password"));
            clickLoginContinue();
            Thread.sleep(4000);
        } catch (Throwable e) {
            Assert.fail(e.getMessage());
        }
    }

    @Then("click on sidebar")
    public void click_on_sidebar() {
        clickSidebar();
    }

    @Then("click user profile")
    public void click_user_profile() {
        clickUserProfile();
    }

    @Then("logout the user")
    public void logout_the_user() {
        clickLogout();
    }

    @Then("click Sign in with Google")
    public void click_Sign_in_with_Google() {
        clickGoogleLogin();
    }

    @And("click Sign in with Facebook")
    public void click_Sign_in_with_Facebook() {
        clickFacebookLogin();
    }

    @And("click Sign in with Apple")
    public void click_Sign_in_with_Apple() {
        clickAppleLogin();
    }

    @And("verify google login page")
    public void verify_google_login_page() {
        verifyGooglePage();
    }

    @And("verify facebook login page")
    public void verify_facebook_login_page() {
        verifyFacebookPage();
    }

    @And("verify apple login page")
    public void verify_apple_login_page() {
        verifyApplePage();
    }

    @Then("navigate back")
    public void navigate_back() throws InterruptedException {
        navigateBack();
    }

    @Then("click on mShows")
    public void click_on_mShows() {
        clickMshows();
    }

    @Then("click on mMovies")
    public void click_on_mMovies() {
        clickMmovies();
    }

    @Then("click on mNews")
    public void click_on_mNews() {
        clickMnews();
    }
    @Then("close sidebar")
    public void click_sidebar() throws InterruptedException {
        closeSidebar();
    }

    @Then("^wait \"([^\"]*)\"")
    public void waitTime(String time) throws InterruptedException {
        int delay = Integer.parseInt(time)*1000;
        Thread.sleep(delay);
    }

}
