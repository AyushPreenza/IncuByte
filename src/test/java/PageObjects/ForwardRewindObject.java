package PageObjects;

import Utils.BaseTest;
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

public class ForwardRewindObject extends BaseTest {

    public By SignInButton=By.xpath("//div[@class='ottplay-84'][text()='Login/Register']");
    public By UserNameButton=By.xpath("//INPUT[@id='phoneEmail']");
    public By Continue = By.xpath("//INPUT[@id='btSubmit']");
    public By PasswordButton=By.xpath("//INPUT[@id='upass']");
    public By Login = By.xpath("//INPUT[@id='btnLogin']");
    public By firstShow = By.xpath("(//DIV[@class='subscriptionBanner_landscapeCard__grid__actionDetails__EIps_'])[1]");
    public By liveShow = By.xpath("//li[contains(text(),'Live')]");
    public By secondShow = By.xpath("(//DIV[@class='subscriptionBanner_landscapeCard__grid__actionDetails__EIps_'])[2]");
    public By Resume = By.xpath("//SPAN[text()='Resume']");

    public By PlayShow = By.xpath("//SPAN[@class='movieDescription_playtext__U0wBf'][text()='Play']/self::SPAN");

    public By Pause = By.xpath("//SPAN[@class='pauseBtn']");

    public By Play = By.xpath("//SPAN[@class='playBtn']");

    public static By TimeDuration = By.xpath("//div[@class='playerDuration']");
    public By FastForward = By.xpath("//SPAN[@class='forwardBtn'][text()='10']");

    public By BackWard = By.xpath("//SPAN[@class='rewindBtn'][text()='10']");
    public By FullScreen = By.xpath("//SPAN[@class='controllBtns'][text()='Full Screen']");
    public By UserIcon = By.xpath("//IMG[@src='https://images.ottplay.com/static/profile2.svg?format=webp']");

    public By ParentalControl=By.xpath("//div/a[text()='Parental Control']");

    public By OttRailList = By.xpath("//div[@class='slick-list']");
    static Actions action;
    static Actions action1;
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

    public void clickPlatform(String asset) {
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(Premium));
//        driver.findElement(Premium).click();

        String xpath = "(//div[@class='ottplay-107']//span[contains(text(),'"+asset+"')])[1]";
        System.out.println(xpath);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//        jsx.executeScript("arguments[0].click();", xpath);
        driver.findElement(By.xpath(xpath)).click();

    }

    public void selectChannel(String asset) throws InterruptedException {
        String xpath = "//img[@alt='"+asset+"']";
        System.out.println(xpath);
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,450)", "");
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//        jsx.executeScript("arguments[0].click();", xpath);
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickFirstShow(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstShow));
        driver.findElement(firstShow).click();
    }

    public void playShow(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(Resume));
            driver.findElement(Resume).click();
        }catch(Exception e) {
            driver.findElement(PlayShow).click();
        }
    }

    public void pauseEpisode(){
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            boolean displayed = driver.findElement(Pause).isDisplayed();
            if(!displayed) {
                action = new Actions(driver);
                action.moveByOffset(200,300).build().perform();
                driver.findElement(Pause).click();
            }
        }catch(Exception e) {
            Assert.fail(e.getMessage());
        }

    }

    public void playEpisode(){
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            boolean displayed = driver.findElement(Play).isDisplayed();
            if(!displayed) {
                action1.sendKeys(Keys.CONTROL).build().perform();
                driver.findElement(Play).click();
            }
        }catch(Exception e) {
            Assert.fail(e.getMessage());
        }

    }

    public static boolean testImageComparison(int timeDelay) throws IOException, InterruptedException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshot1 = ts.getScreenshotAs(OutputType.FILE);
        Thread.sleep(timeDelay);
        File screenshot2 = ts.getScreenshotAs(OutputType.FILE);
        BufferedImage image1 = ImageIO.read(new File(screenshot1.toURI()));
        BufferedImage image2 = ImageIO.read(new File(screenshot2.toURI()));
        boolean isSame = true;

        if (image1.getWidth() == image2.getWidth() && image1.getHeight() == image2.getHeight()) {
            for (int x = 0; x < image1.getWidth(); x++) {
                for (int y = 0; y < image1.getHeight(); y++) {
                    int rgb1 = image1.getRGB(x, y);
                    int rgb2 = image2.getRGB(x, y);

                    if (rgb1 != rgb2) {
                        isSame = false;
                        break;
                    }
                }
            }
        } else {
            isSame = false;
        }

        // isSame is false -> then consecutive photos are not same
        // isSame is true -> then consecutive photos are  same

        return !isSame;
    }

    public static void episodeIsPausedOnPausingIt()
    {
        try {
            List<String> s = Arrays.asList(driver.findElement(TimeDuration).getText().split("/"));
            String playDuration1 = s.get(0).trim();
            System.out.println(playDuration1);
            List<String> a = Arrays.asList(playDuration1.split(":"));
            String minBeforeForward=a.get(0).trim();
            String secBeforeForward=a.get(1).trim();
            int minuteBeforeForward = Integer.parseInt(minBeforeForward);
            int secondsBeforeForward = Integer.parseInt(secBeforeForward);
            Thread.sleep(10000);
            action = new Actions(driver);
            action.sendKeys(Keys.CONTROL).build().perform();
            Thread.sleep(1000);
            List<String> s1 = Arrays.asList(driver.findElement(TimeDuration).getText().split("/"));
            String playDuration2 = s1.get(0).trim();
            System.out.println(playDuration2);
            List<String> a1 = Arrays.asList(playDuration2.split(":"));
            String minAfterForward=a1.get(0).trim();
            String secAfterForward=a1.get(1).trim();
            int minuteAfterForward = Integer.parseInt(minAfterForward);
            int secondsAfterForward = Integer.parseInt(secAfterForward);
            if(minuteAfterForward==minuteBeforeForward && secondsAfterForward == secondsBeforeForward)
            {
                System.out.println("Episode paused");
            }else {
                Assert.fail("not paused");
            }
        }
        catch(Throwable e)
        {
            Assert.fail(e.getMessage());
        }
    }

    public void verifyFastForwardIsWorking() throws InterruptedException {
        try {
        pauseEpisode();
        List<String> s = Arrays.asList(driver.findElement(TimeDuration).getText().split("/"));
        String playDuration1 = s.get(0).trim();
        System.out.println(playDuration1);
        List<String> a = Arrays.asList(playDuration1.split(":"));
        String minBeforeForward=a.get(0).trim();
        String secBeforeForward=a.get(1).trim();
        int minuteBeforeForward = Integer.parseInt(minBeforeForward);
        int secondsBeforeForward = Integer.parseInt(secBeforeForward);
        //==================
        action = new Actions(driver);
        action.moveByOffset(200,300).build().perform();
        driver.findElement(FastForward).click();
        driver.findElement(FastForward).click();
        driver.findElement(FastForward).click();
        Thread.sleep(10000);
        action1 = new Actions(driver);
        action1.sendKeys(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
//        action1.moveToElement(driver.findElement(By.xpath("//img[@alt='ottplay logo']"))).build().perform();

        List<String> s1 = Arrays.asList(driver.findElement(TimeDuration).getText().split("/"));
        String playDuration2 = s1.get(0).trim();
        System.out.println(playDuration2);
        List<String> a1 = Arrays.asList(playDuration2.split(":"));
        String minAfterForward=a1.get(0).trim();
        String secAfterForward=a1.get(1).trim();
        int minuteAfterForward = Integer.parseInt(minAfterForward);
        int secondsAfterForward = Integer.parseInt(secAfterForward);
        //secondsAfterForward represents seconds after forwarding video
        //waitForElementToAppearAndClick(playAndPauseButton,type_id);
        if(minuteAfterForward>minuteBeforeForward)
        {

        }
        else if(secondsAfterForward > secondsBeforeForward )
        {

        }else
            Assert.fail("fast forward not working");

        }
        catch(Throwable e)
        {
            Assert.fail(e.getMessage());
        }
        playEpisode();
    }

    public void fullScreen(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(FullScreen));
            driver.findElement(FullScreen).click();
        }catch(Exception e) {
            action = new Actions(driver);
            action.moveByOffset(200,300).build().perform();
            driver.findElement(FullScreen).click();
        }
    }


    public void verifyBackwardIsWorking() throws InterruptedException {
        try {
            List<String> s = Arrays.asList(driver.findElement(TimeDuration).getText().split("/"));
            String playDuration1 = s.get(0).trim();
            System.out.println(playDuration1);
            List<String> a = Arrays.asList(playDuration1.split(":"));
            String minBeforeRewind=a.get(0).trim();
            String secBeforeRewind=a.get(1).trim();
            int minuteBeforeRewind = Integer.parseInt(minBeforeRewind);
            int secondsBeforeRewind = Integer.parseInt(secBeforeRewind);
            //==================

            action1.sendKeys(Keys.CONTROL).build().perform();
            driver.findElement(BackWard).click();
            driver.findElement(BackWard).click();
            Thread.sleep(10000);
            action1.sendKeys(Keys.CONTROL).build().perform();
            Thread.sleep(1000);
            List<String> s1 = Arrays.asList(driver.findElement(TimeDuration).getText().split("/"));
            String playDuration2 = s1.get(0).trim();
            System.out.println(playDuration2);
            List<String> a1 = Arrays.asList(playDuration2.split(":"));
            String minAfterRewind = a1.get(0).trim();
            String secAfterRewind = a1.get(1).trim();
            int minuteAfterRewind = Integer.parseInt(minAfterRewind);
            int secondsAfterRewind = Integer.parseInt(secAfterRewind);;
            //secondsAfterForward represents seconds after forwarding video
            //waitForElementToAppearAndClick(playAndPauseButton,type_id);
            if (minuteAfterRewind < minuteBeforeRewind) {

            } else if (secondsAfterRewind < secondsBeforeRewind) {

            }else
                Assert.fail("fast forward not working");

        }
        catch(Throwable e) {
            Assert.fail(e.getMessage());
        }
    }
    public void clickSecondShow(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondShow));
        driver.findElement(secondShow).click();
    }
    public void clickLiveShow(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(liveShow));
        driver.findElement(liveShow).click();
    }
}
