package Steps;

import PageObjects.SanityPageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class SanitySteps extends SanityPageObject {

    @And("verify user able to logout")
    public void verify_user_able_to_logout() {
        clickLogoutBtn();
    }

    @Then("^click on \"([^\"]*)\" vendor")
    public void click_on_vendor(String platform) throws InterruptedException {
        System.out.println(platform);
        selectVendor(platform);
    }

    @Then("verify facing issues play here link")
    public void verify_facingIssues() throws IOException, InterruptedException {
        Thread.sleep(10000);
        facingIssuesLink();
    }

    @Then("^Search content \"([^\"]*)\"")
    public void click_on_search(String content) throws IOException, InterruptedException {
        searchContent(content);
    }

    @Then("click on see all result")
    public void click_on_seeAll() throws IOException, InterruptedException {
        clickSeeAllResult();
    }

    @Then("click on movies,shows,stories,live tv etc")
    public void click_on_moviesShowsEtc() throws IOException, InterruptedException {
        clickMoviesShows();
    }

    @Then("verify filters present")
    public void verify_filters_present() {
        verifyFilters();
    }

    @Then("verify filters present on stories page")
    public void verify_filters_present_on_stories_page() {
        verifyFilterOnStoriesPage();
    }

    @Then("scroll to bottom of page")
    public void scroll_bottom() throws IOException, InterruptedException {
        scrollBottom();
    }

    @And("click on settings button")
    public void click_on_settings_button() throws InterruptedException {
        Thread.sleep(20000);
        clickSettingsBtn();
    }

    @And("click and verify setting filters for unsubscribed user")
    public void click_and_verify_setting_filters_for_unsubscribed_user() throws InterruptedException {
        myFilmmakersFilter();
        Thread.sleep(2000);
        myActorsFilter();
        Thread.sleep(2000);
        myGenresFilter();
        Thread.sleep(2000);
        myProvidersFilter();
        Thread.sleep(2000);
        myLanguagesFilter();
    }

    @And("^click on \"([^\"]*)\" listing")
    public void click_on_listing(String platform) throws InterruptedException {
        System.out.println(platform);
        selectListing(platform);
    }

    @And("verify filters on listing page")
    public void verify_filters_on_listing_page() {
        verifyListingPageFilters();
    }

    @And("verify filters on profile")
    public void verify_filters_on_profile() {
        verifyProfileFilters();
    }

    @And("click on Movie releases")
    public void click_on_Movie_releases() {
        clickMovieReleases();
    }

    @And("change the language filter to hindi")
    public void change_the_language_filter_to_hindi() throws InterruptedException {
        changeLanguageFilterToHindi();
    }

    @And("verify filter applied for hindi language")
    public void verify_filter_applied_for_hindi_language() {
        verifyHindiFilter();
    }

    @And("click go to top button")
    public void click_go_to_top_button() {
        clickGoToTop();
    }

    @And("verify user on bottom of page")
    public void verify_user_on_bottom_of_page() {
        verifyBottomOfPage();
    }

    @And("click content from carousel")
    public void click_content_from_carousel() throws InterruptedException {
        clickContentFromCarousel();
    }

    @And("click subscribe to watch")
    public void click_subscribe() {
        clickSubscribeToWatch();
    }

    @And("verify redirected to plans page")
    public void Verify_redirected_to_plansPage() throws InterruptedException {
        verifyPlanPage();
    }

    @And("click content from carousel in premium page")
    public void click_content_from_carouselPremium() throws InterruptedException {
        clickContentFromCarouselPremium();
    }
    @And("select first show after search")
    public void select_first_show_after_search() {
        clickFirstShowAfterSearch();
    }

}
