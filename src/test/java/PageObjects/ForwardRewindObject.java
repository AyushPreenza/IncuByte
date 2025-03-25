package PageObjects;

import Utils.BaseTest;
import Utils.DriverUtil;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ForwardRewindObject extends DriverUtil {

    public By SignInButton=By.xpath("//div[@class='ottplay-84'][text()='Login/Register']");
    public By UserNameButton=By.xpath("//INPUT[@id='phoneEmail']");
    public By Continue = By.xpath("//INPUT[@id='btSubmit']");
    public By PasswordButton=By.xpath("//INPUT[@id='upass']");
    public By Login = By.xpath("//INPUT[@id='btnLogin']");
    
    public void ClickSignIn()
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.visibilityOfElementLocated(SignInButton));
            boolean displayed = driver.findElement(SignInButton).isDisplayed();
            if(displayed)
                driver.findElement(SignInButton).click();
        }catch(Exception e) {
            refreshPage();
            driver.findElement(SignInButton).click();
        }
    }

    public void refreshPage(){
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            boolean displayed = driver.findElement(SignInButton).isDisplayed();
            if(!displayed)
                driver.navigate().refresh();
        }catch(Exception e) {

        }
    }

    public void enterUserName(String userName){
        driver.findElement(UserNameButton).sendKeys(userName);
    }

    public void clickContinue(){
        driver.findElement(Continue).click();
    }

    public void enterPassword(String password){
        driver.findElement(PasswordButton).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(Login).click();
    }
}
