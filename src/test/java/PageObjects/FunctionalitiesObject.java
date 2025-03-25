package PageObjects;

import Utils.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class FunctionalitiesObject extends BaseTest {

    public By resumeButton = By.xpath("//span[contains(text(),'Resume')]");
    public By fullScreenButton = By.xpath("//i[@class='fullScreen']");
    public By firstSeeAll = By.xpath("(//div[contains(text(),'See All')])[1]");
    public By nextEpisodeButton = By.xpath("//span[contains(text(),'Next Episode ')]");
    public By OttPlayBrandLogo = By.xpath("//img[@alt='ottplay logo']");
    public By playButton = By.xpath("//span[@class='movieDescription_playtext__U0wBf']");
    public By seekBar = By.xpath("//div[@class='playerslider']");
    public By backButton = By.xpath("//span[@class='videoBackBtn']");
    public By showTitle = By.xpath("//div[@class='topBarPlayer topbarplayerA']//h2");
    public By exitFullScreenBtn = By.xpath("//i[@class='exitFullScreen']");
    public By languageBtn = By.xpath("//span[contains(text(),'Language')]");
    public By audioOptionsTitle = By.xpath("//li[contains(text(),'Audio')]");
    public By languageList = By.xpath("//li[contains(text(),'Audio')]//parent::ul[@class='titlesAudioHead']//li");
    public By subtitleOptionsTitle = By.xpath("//ul[@class='titlesAudioHead']//li[contains(text(),'Subtitles')]");

    public void clickFullscreen() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(BaseTest.driver, 25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(fullScreenButton));
            boolean displayed = driver.findElement(fullScreenButton).isDisplayed();
            if (displayed)
                driver.findElement(fullScreenButton).click();
        } catch (Throwable e) {
            Assert.fail("full screen button not displayed");
        }
    }

    public void nextEpisode() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(BaseTest.driver, 25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(nextEpisodeButton));
            boolean displayed = driver.findElement(nextEpisodeButton).isDisplayed();
            if (displayed)
                driver.findElement(nextEpisodeButton).click();
        } catch (Throwable e) {
            Assert.fail("next episode button not displayed/working");
        }
    }

    public void verifyottbrandLogo() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(OttPlayBrandLogo).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("OTT Play brand logo not displayed");
        }
    }

    public void verifyUserOnNextEpisode(String titleName) {
        String TitleName1 = driver.findElement(showTitle).getText();
        System.out.println("Title Name - " + TitleName1);
        if ((Objects.equals(titleName, TitleName1))) {
            Assert.fail("User is not directed to next episode");
        }
    }

    public void verifySeekBar() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(seekBar).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("fSeek bar not displayed");
        }
    }

    public void verifyBackButton() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            boolean displayed = driver.findElement(backButton).isDisplayed();
            if (displayed)
                driver.findElement(backButton).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//span[contains(text(),'Home')])[1]")).isDisplayed();

        } catch (Throwable e) {
            Assert.fail("Back button not displayed/working");
        }
    }

    public String getTitleName() {
        String TitleName = driver.findElement(showTitle).getText();
        System.out.println("Title Name - " + TitleName);
        return TitleName;
    }

    public void verifyFullScreen() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(exitFullScreenBtn).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("Video is not in Full screen mode");
        }
    }

    public void clickLanguage() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(BaseTest.driver, 25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(languageBtn));
            boolean displayed = driver.findElement(languageBtn).isDisplayed();
            if (displayed)
                driver.findElement(languageBtn).click();
        } catch (Throwable e) {
            Assert.fail("Language button not displaying/working");
        }
    }

    public void verifyAudioOptions() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(BaseTest.driver, 25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(audioOptionsTitle));
            driver.findElement(audioOptionsTitle).isDisplayed();
            driver.findElement(languageList).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("Audio Options are not present");
        }
    }

    public void verifysubtitleOptions() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(BaseTest.driver, 25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(subtitleOptionsTitle));
            driver.findElement(subtitleOptionsTitle).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("Subtitle Options are not present");
        }
    }

    public void clickShowBackButton() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            boolean displayed = driver.findElement(backButton).isDisplayed();
            if (displayed)
                driver.findElement(backButton).click();
        } catch (Throwable e) {
            Assert.fail("Back button not displayed/working");
        }
    }

    public void selectShow(String asset) throws InterruptedException {
        String xpath = "//h6[contains(text(),'" + asset + "')]";
        System.out.println(xpath);
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,450)", "");
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//        jsx.executeScript("arguments[0].click();", xpath);
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickSeeAllFirst(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstSeeAll));
        driver.findElement(firstSeeAll).click();
    }
}