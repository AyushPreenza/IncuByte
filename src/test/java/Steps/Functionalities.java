package Steps;

import PageObjects.FunctionalitiesObject;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_scouse.An;

public class Functionalities extends FunctionalitiesObject {
    String TitleName;

    @Then("click on fullscreen")
    public void click_on_fullscreen() {
        clickFullscreen();
    }

    @Then("click on next episode")
    public void click_on_next_episode() {
        nextEpisode();
    }

    @And("verify ott play brand logo")
    public void verify_ott_play_brand_logo() {
        verifyottbrandLogo();
    }

    @And("verify user is on next page")
    public void verify_user_is_on_next_page() {
        verifyUserOnNextEpisode(TitleName);
    }

    @And("verify seek bar")
    public void verify_seek_bar() {
        verifySeekBar();
    }

    @And("verify back button")
    public void verify_back_button() {
        verifyBackButton();
    }

    @And("Get the title of show")
    public void Get_the_title_of_show() {
        String TitleName = getTitleName();
    }

    @And("verify show is in full screen")
    public void verify_show_is_in_full_screen() {
        verifyFullScreen();
    }

    @And("click on Language Option")
    public void click_on_Language_Option() {
        clickLanguage();
    }

    @And("verify Audio options are present")
    public void verify_Audio_options_are_present() {
        verifyAudioOptions();
    }

    @And("verify subtitles options are present")
    public void verify_subtitles_options_are_present() {
        verifysubtitleOptions();
    }

    @And("click on show back button")
    public void click_on_show_back_button() {
        clickShowBackButton();
    }

    @Then("^Play the show \"([^\"]*)\"")
    public void Play_the_show(String show) throws InterruptedException {
        System.out.println(show);
        selectShow(show);
        Thread.sleep(5000);
    }

    @Then("click on first See all")
    public void click_on_first_See_all(){
        clickSeeAllFirst();
    }
}