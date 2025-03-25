package PageObjects;

import Utils.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SanityPageObject extends BaseTest {
    public By logoutBtn = By.xpath("//span[contains(text(),'Logout')]");
    public By FacingIssuePlayHere = By.xpath("//A[@class='movieDescription_issuePlayHere__RMs5a'][text()='Play Here']");
    public By searchBar = By.xpath("//INPUT[@id='searchFeild']");
    public By seeAllResult = By.xpath("//SPAN[@class='searchDropdown_seeAllTitle__niBOx']");
    public By storiesPageFilters = By.xpath("//span[@class='MuiButton-label'][contains(text(),'All Type')]");
    public By filterOptions = By.xpath("//span[@class='MuiButton-label'][contains(text(),'All Languages')]");
    public By settingBtn = By.xpath("(//img[@alt='settings icon'])[1]");
    public By MyLanguagesFilter = By.xpath("//span[contains(text(),'My Languages')]");
    public By MyProvidersFilter = By.xpath("//span[contains(text(),'My Providers')]");
    public By MyGenresFilter = By.xpath("//span[contains(text(),'My Genres')]");
    public By MyActorsFilter = By.xpath("//span[contains(text(),'My Actors')]");
    public By MyFilmmakersFilter = By.xpath("//span[contains(text(),'My Filmmakers')]");
    public By listingPageLanguageFilter = By.xpath("//p[contains(text(),'Languages')]");
    public By listingPageGenresFilter = By.xpath("//p[contains(text(),'Genres')]");
    public By listingPageProvidersFilter = By.xpath("//p[contains(text(),'Providers')]");
    public By listingPageFreePaidFilter = By.xpath("//p[contains(text(),'Free')]");
    public By listingPageRuntimeMinutesFilter = By.xpath("//p[contains(text(),'Runtime')]");
    public By listingPageQualityFilter = By.xpath("//p[contains(text(),'Quality')]");
    public By listingPageContentRatingFilter = By.xpath("//p[contains(text(),'Content')]");
    public By profileMyLanguagesFilter = By.xpath("//span[contains(text(),'My Languages')]");
    public By profileMyProvidersFilter = By.xpath("//span[contains(text(),'My Providers')]");
    public By profileMyGenresFilter = By.xpath("//span[contains(text(),'My Genres')]");
    public By profileMyActorsFilter = By.xpath("//span[contains(text(),'My Actors')]");
    public By profileMyFilmmakersFilter = By.xpath("//span[contains(text(),'My Filmmakers')]");
    public By SignInButton = By.xpath("//div[@class='ottplay-84'][text()='Login/Register']");
    public By movieReleasesBtn = By.xpath("(//a[contains(text(),'Movie Releases')])[1]");
    public By languageBtn = By.xpath("//span[contains(text(),'Languages')]");
    public By hindiLanguageBtn = By.xpath("//h5[contains(text(),'Hindi')]");

    public By GoToTop = By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root ottplay-237']");
    public By ContentCarousel = By.xpath("(//DIV[@class='undefined homeBannerSlider__imgwrap'])[9]");
    public By firstCarousel = By.xpath("//BUTTON[@data-glide-dir='=3']");
    public By firstCarouselPremium = By.xpath("(//DIV[@class='imageWrapper'])[9]");
    public By firstCarouselPremium2 = By. xpath("//div[@class='undefined homeBannerSlider__imgwrap']/img[contains(@src, 'jpeg')]");

    public By SubscribeToWatch = By.xpath("//STRONG[text()='Subscribe to Watch']");
    public By verifyHindiFilter = By.xpath("//li[contains(text(),'Hindi')]");
    public By firstShowAfterSearch = By.xpath("(//div[@class='searchResult_listCards__imagePoster__dfmGJ'])[1]");
    public void clickLogoutBtn() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn));
            driver.findElement(logoutBtn).click();
        } catch (Throwable e) {
            Assert.fail("User Icon not clicked");
        }
    }

    public void selectVendor(String asset) throws InterruptedException {
        try {
            WebDriverWait wait1 = new WebDriverWait(driver, 50);
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'My Profile')]")));
            String xpath = "//img[contains(@src, '" + asset + "')]";
            System.out.println(xpath);
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            WebElement element = driver.findElement(By.xpath(xpath));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(5000);
            driver.findElement(By.xpath(xpath)).click();
        } catch (Throwable e) {
            Assert.fail("Vendor not selected");
        }
    }

    public void facingIssuesLink() throws InterruptedException {
        String parent = driver.getWindowHandle();
        System.out.println(parent);
        System.out.println(driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(FacingIssuePlayHere));
        driver.findElement(FacingIssuePlayHere).click();
        Thread.sleep(10000);

        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        System.out.println(newTab.size());
        for (int i = 0; i <= newTab.size() - 1; i++) {
            System.out.println("windows - " + " " + i + " " + newTab.get(i));
        }
        // change focus to new tab
        driver.switchTo().window(newTab.get(1));
        Thread.sleep(5000);
        System.out.println("second tab - " + driver.getCurrentUrl());
        String newUrl = driver.getCurrentUrl();
        if (!newUrl.contains("sony")) {
            Assert.fail("Not redirected to sony liv page");
        }
        driver.close();
        // change focus back to old tab
        driver.switchTo().window(parent);
    }

    public void searchContent(String search) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));

        driver.findElement(searchBar).sendKeys(search);
    }

    public void clickSeeAllResult() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(seeAllResult));
        driver.findElement(seeAllResult).click();
        Thread.sleep(5000);
    }

    public void clickMoviesShows() throws InterruptedException {
        String[] arr = {"Movie", "Show", "Live TV", "Sport", "Cast & Crew", "Stories"};

        String buttons = "//SPAN[@class='MuiButton-label']";
        List<WebElement> rows = driver.findElements(By.xpath(buttons));
        System.out.println(rows.size());
        for (WebElement row : rows) {
            for (int i = 0; i <= arr.length - 1; i++) {
                if (row.getText().equals(arr[i])) {
                    row.click();
                    Thread.sleep(2000);
                }
            }
        }
    }

    public void verifyFilters() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(filterOptions));
            driver.findElement(filterOptions).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("Filters not displayed");
        }
    }

    public void verifyFilterOnStoriesPage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(storiesPageFilters));
            driver.findElement(storiesPageFilters).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("Filters not displayed");
        }
    }

    public void scrollBottom() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
    }

    public void clickSettingsBtn() {
        try {
            refreshPage();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, 25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(SignInButton));
            WebDriverWait wait2 = new WebDriverWait(driver, 50);
            wait2.until(ExpectedConditions.visibilityOfElementLocated(settingBtn));
            driver.findElement(settingBtn).click();
        } catch (Throwable e) {
            Assert.fail("Setting button not clicked");
        }
    }

    private void refreshPage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(SignInButton));
            boolean displayed = driver.findElement(SignInButton).isDisplayed();
            if (!displayed)
                driver.navigate().refresh();
        } catch (Exception e) {

        }
    }

    public void myLanguagesFilter() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MyLanguagesFilter));
            driver.findElement(MyLanguagesFilter).click();
        } catch (Throwable e) {
            Assert.fail("My Languages Filter not clicked");
        }
    }

    public void myProvidersFilter() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MyProvidersFilter));
            driver.findElement(MyProvidersFilter).click();
        } catch (Throwable e) {
            Assert.fail("My Providers Filter not clicked");
        }
    }

    public void myGenresFilter() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MyGenresFilter));
            driver.findElement(MyGenresFilter).click();
        } catch (Throwable e) {
            Assert.fail("My Genres Filter not clicked");
        }
    }

    public void myActorsFilter() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MyActorsFilter));
            driver.findElement(MyActorsFilter).click();
        } catch (Throwable e) {
            Assert.fail("My Actors Filter not clicked");
        }
    }

    public void myFilmmakersFilter() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MyFilmmakersFilter));
            driver.findElement(MyFilmmakersFilter).click();
        } catch (Throwable e) {
            Assert.fail("Filmmakers Filter not clicked");
        }
    }

    public void selectListing(String asset) throws InterruptedException {
        try {
            String xpath = "(//ul[@id='menu-list-grow']//a[contains(text(),'" + asset + "')])[1]";
            System.out.println(xpath);
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            driver.findElement(By.xpath(xpath)).click();
        } catch (Throwable e) {
            Assert.fail("Listing not selected");
        }
    }

    public void verifyListingPageFilters() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(listingPageLanguageFilter));
            driver.findElement(listingPageLanguageFilter).click();
            Thread.sleep(2000);
            driver.findElement(listingPageContentRatingFilter).click();
            Thread.sleep(2000);
            driver.findElement(listingPageQualityFilter).click();
            Thread.sleep(2000);
            driver.findElement(listingPageRuntimeMinutesFilter).click();
            Thread.sleep(2000);
            driver.findElement(listingPageFreePaidFilter).click();
            Thread.sleep(2000);
            driver.findElement(listingPageProvidersFilter).click();
            Thread.sleep(2000);
            driver.findElement(listingPageGenresFilter).click();
        } catch (Throwable e) {
            Assert.fail("ListingPage filters are not veified");
        }
    }

    public void verifyProfileFilters() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(profileMyActorsFilter));
            driver.findElement(profileMyLanguagesFilter).isDisplayed();
            driver.findElement(profileMyActorsFilter).isDisplayed();
            driver.findElement(profileMyGenresFilter).isDisplayed();
            driver.findElement(profileMyProvidersFilter).isDisplayed();
            driver.findElement(profileMyFilmmakersFilter).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("Profile filters not verified");
        }
    }

    public void clickMovieReleases() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(movieReleasesBtn));
            driver.findElement(movieReleasesBtn).click();
        } catch (Throwable e) {
            Assert.fail("Movie releases not clicked");
        }
    }

    public void changeLanguageFilterToHindi() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(languageBtn));
        Thread.sleep(2000);
        driver.findElement(languageBtn).click();
        Thread.sleep(3000);
        driver.findElement(hindiLanguageBtn).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'Apply Filter')]")).click();
    }

    public void verifyHindiFilter() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(verifyHindiFilter));
        } catch (Throwable e) {
            Assert.fail("filter not applied");
        }

    }

    public void clickGoToTop() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(GoToTop));
            WebElement button = driver.findElement(By.xpath("//button[@id='toptopbtn']"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", button);
        } catch (Throwable e) {
            Assert.fail("Go to top button not clicked");
        }
    }

    public void verifyBottomOfPage() {
        try {
            driver.findElement(By.xpath("//span[contains(text(),'Google Play')]")).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("Button not clicked");
        }
    }

    public void clickContentFromCarousel() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SignInButton));

        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(firstCarousel));
        driver.findElement(firstCarousel).click();

        driver.findElement(ContentCarousel).click();
    }

    public void clickSubscribeToWatch() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SubscribeToWatch));
        driver.findElement(SubscribeToWatch).click();
    }

    public void verifyPlanPage() throws InterruptedException {
        Thread.sleep(5000);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        if (!url.contains("plan")) {
            Assert.fail("not redirected to plans page");
        }
    }

    public void clickContentFromCarouselPremium() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(firstCarouselPremium));
        driver.findElement(firstCarouselPremium).click();
    }

    public void clickFirstShowAfterSearch() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.visibilityOfElementLocated(firstShowAfterSearch));
//            Thread.sleep(5000);
            boolean displayed = driver.findElement(firstShowAfterSearch).isDisplayed();
            if (displayed) {
                driver.findElement(firstShowAfterSearch).click();
            }
        } catch (Throwable e) {
            Assert.fail("Button not clicked");
        }
    }
}

