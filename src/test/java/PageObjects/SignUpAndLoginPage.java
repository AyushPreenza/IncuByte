package PageObjects;

import Utils.DriverUtil;
import org.openqa.selenium.*;

public class SignUpAndLoginPage extends DriverUtil {

    public By createAccount = By.xpath("(//a[contains(text(),'Create an Account')])[1]");
    public By firstNameField = By.xpath("//input[@id='firstname']");
    public By lastNameField = By.xpath("//input[@id='lastname']");
    public By emailField = By.xpath("//input[@id='email_address']");
    public By passwordField = By.xpath("//input[@id='password']");
    public By confirmPasswordField = By.xpath("//input[@id='password-confirmation']");
    public By createAccountConfirm = By.xpath("//button[@title='Create an Account']");
    public By successMsg = By.xpath("//div[contains(text(),'Thank you')]");
    public By myAccount = By.xpath("//span[contains(text(),'My Account')]");
    public By welcome = By.xpath("(//span[contains(text(),'Welcome,')])[1]");
    public By signIn = By.xpath("(//a[contains(text(),'Sign In')])[1]");
    public By loginEmail = By.xpath("//input[@name='login[username]']");
    public By loginPassword = By.xpath("//input[@name='login[password]']");
    public By signInSubmit = By.xpath("(//button[@id='send2'])[1]");
    public By dropdown = By.xpath("(//button[@class='action switch'])[1]");
    public By signOut = By.xpath("(//a[contains(text(),'Sign Out')])[1]");



    public void createAccountButton(){
       clickElement(createAccount);
    }

    public void enterFirstName(String firstName){
        sendKeys(firstNameField,firstName);
    }

    public void enterLastName(String lastName){
        sendKeys(lastNameField,lastName);
    }

    public void enterEmail(String text){
        sendKeys(emailField,text);
    }

    public void enterNewPassword(String pass){
        sendKeys(passwordField,pass);
    }

    public void enterConfirmPassword(String pass){
        sendKeys(confirmPasswordField,pass);
    }

    public void clickConfirmAccount(){
        clickElement(createAccountConfirm);
    }

    public void verifySuccessMsg(){
        waitForElement(successMsg);
    }

    public void confirmLogin(){
        waitForElement(myAccount);
        waitForElement(welcome);
    }

    public void clickSignInForLogin(){
        clickElement(signIn);
    }

    public void enterEmailLogin(String email1){
        sendKeys(loginEmail, email1);
    }

    public void enterPasswordLogin(String pass1){
        sendKeys(loginPassword, pass1);
    }

    public void clickSignInSubmit(){
        clickElement(signInSubmit);
    }

    public void signOut(){
        clickElement(dropdown);
        clickElement(signOut);
    }

}
