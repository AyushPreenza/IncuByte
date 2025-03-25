package Steps;

import PageObjects.SignUpAndLoginPage;
import Utils.RandomPasswordGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SignUpAndLoginSteps extends SignUpAndLoginPage {

    String firstName = "";
    String lastName =  "";
    String email;
    String password;

    @Given("^I navigate to application$")
    public void iNavigateToApplication() {
            driver.get("https://magento.softwaretestingboard.com/");
            driver.manage().window().maximize();
    }

    @And("^I click on Sign In button$")
    public void iClickOnSignInButton() {
        clickSignInForLogin();
    }

    @Then("I click on create account")
    public void iClickOnCreateAccount() {
        createAccountButton();
    }

    @And("Enter first name {string} and last name {string}")
    public void enterFirstNameAndLastName(String arg0, String arg1) {
        firstName = arg0;
        lastName = arg1;
        enterFirstName(firstName);
        enterLastName(lastName);
    }

    @Then("I Enter email")
    public void iEnterEmail() {
        email = randomEmail();
        enterEmail(email);
        System.out.println("Email - "+email);
    }

    @And("I Enter password")
    public void iEnterPassword() {
        password = RandomPasswordGenerator.generatePassword(9);
        enterNewPassword(password);
        enterConfirmPassword(password);
        System.out.println("password - "+password);
    }

    @Then("click Create and Account confirm button")
    public void clickCreateAndAccountConfirmButton() {
        clickConfirmAccount();
        verifySuccessMsg();
    }

    @And("I confirm Log in")
    public void iConfirmLogIn() {
        confirmLogin();
    }

    @And("I enter email and password")
    public void iEnterEmailAndPassword() {
        System.out.println("Logging in with Email - "+ email + ", Password - "+ password);
        enterEmailLogin(email);
        enterPasswordLogin(password);
    }

    @Then("click Sign in")
    public void clickSignIn() {
        clickSignInSubmit();
    }

    @Then("I sign out from account")
    public void iSignOutFromAccount() {
        signOut();
    }
}

