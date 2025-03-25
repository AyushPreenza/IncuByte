package PageObjects;

import Utils.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ProdObjects extends BaseTest {

    public By UserIcon = By.xpath("//IMG[@src='https://images.ottplay.com/static/profile2.svg?format=webp']");

    public By ParentalControl = By.xpath("//div/a[text()='Parental Control']");

    public By OttRailList = By.xpath("//div[@class='slick-list']");
    public By liveHindiNewsHeading = By.xpath("//h3[contains(text(),'Live Hindi News')]");
    public By liveSportsHeading = By.xpath("//h3[contains(text(),'Live Sports')]");
    public By regionalNewsHeading = By.xpath("//h3[contains(text(),'Regional News')]");

    public By SearchBar = By.xpath("(//input[@id='searchFeild'])[1]");
    public By TamilShow = By.xpath("//div[contains(text(),'Zee Tamil HD')]");
    public By profileIcon = By.xpath("(//div[@class='ottplay-84'])[1]");
    public By settingOptions = By.xpath("//div[contains(text(),'Settings')]");


    public void clickUserIcon() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.visibilityOfElementLocated(UserIcon));
            driver.findElement(UserIcon).click();
        } catch (Throwable e) {
            Assert.fail("User Icon not clicked");
        }
    }

        public void verifyParentalControl () {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 25);
                wait.until(ExpectedConditions.visibilityOfElementLocated(ParentalControl));
                WebElement element = driver.findElement(ParentalControl);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Assert.fail("Parental control not present");
            }
        }

        public void OttRail () {
            boolean flag = false;
            WebDriverWait wait = new WebDriverWait(driver, 25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(OttRailList));

            try {
                for (int i = 0; i <= 5; i++) {
                    flag = driver.findElement(By.xpath("//div[@data-index='" + i + "']")).isDisplayed();
                    System.out.println(flag);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Assert.fail("channels are not present on rail");
            }
            if (!flag) {
                Assert.fail("Channels are missing from rail");
            }
        }

        public void verifyLiveShows () {
            try {
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                WebDriverWait wait = new WebDriverWait(BaseTest.driver, 25);
                wait.until(ExpectedConditions.visibilityOfElementLocated(liveHindiNewsHeading));
                driver.findElement(liveHindiNewsHeading).isDisplayed();
                driver.findElement(liveSportsHeading).isDisplayed();
//            driver.findElement(regionalNewsHeading).isDisplayed();
            } catch (Throwable e) {
                Assert.fail("Live Shows not displayed");
            }
        }

        public void clickSearchAndEnter (String platform){
            try {
                Thread.sleep(4000);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                WebDriverWait wait = new WebDriverWait(BaseTest.driver, 25);
                wait.until(ExpectedConditions.visibilityOfElementLocated(SearchBar));
                driver.findElement(SearchBar).sendKeys(platform);
                Actions action = new Actions(driver);
                action.sendKeys(Keys.ENTER).build().perform();
                Thread.sleep(5000);
            } catch (Throwable e) {
                Assert.fail("Search not working");
            }
        }

        public void clickPlatform (String platform){
            try {
                String element = "//span[contains(text(),'" + platform + "')]";
                WebDriverWait wait = new WebDriverWait(driver, 30);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
                driver.findElement(By.xpath(element)).click();
            } catch (Throwable e) {
                Assert.fail("Platform not clicked");
            }
        }

        public void verifyTamilAndTeluguShows () {
            try {
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.findElement(TamilShow).isDisplayed();
            } catch (Throwable e) {
                Assert.fail("Telugu and Tamil shows not verified");
            }
        }

        public void clickProfileIcon () {
            try {
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                WebDriverWait wait = new WebDriverWait(BaseTest.driver, 25);
                wait.until(ExpectedConditions.visibilityOfElementLocated(profileIcon));
                boolean displayed = driver.findElement(profileIcon).isDisplayed();
                if (displayed) {
                    driver.findElement(profileIcon).click();
                }
            } catch (Throwable e) {
                Assert.fail("Profile Icon not displayed");
            }
        }

        public void verifySettings () {
            try {
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.findElement(settingOptions).isDisplayed();
            } catch (Throwable e) {
                Assert.fail("Setting options not available");
            }
        }
    }
