package automationexercise.pages;
import com.shaft.driver.SHAFT;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.openqa.selenium.By;
import io.qameta.allure.Step;
import java.util.Set;
public class followUsPage {
    private SHAFT.GUI.WebDriver driver;
    private String pageUrl="https://demo.nopcommerce.com/";
    public followUsPage(SHAFT.GUI.WebDriver driver){this.driver=driver;}
    public followUsPage urlNavigate(){driver.browser().navigateToURL(pageUrl);return this;}
    private By facebookLink = By.className("facebook");
    private By twitterink = By.className("twitter");
    private By rssLink = By.className("rss");
    private By youtubeLink = By.className("youtube");

    @SneakyThrows
    @Step("Validate that when the user click on FacebookLink Navigate to facebook page ")
    public followUsPage validateFacebookLink(String expectedFacebookUrl){
        String minWindowsHande= driver.getDriver().getWindowHandle();
         driver.element().click(facebookLink);
        //Thread.sleep(12000);
        Set<String> windowsHandles=driver.getDriver().getWindowHandles();
        for (String handle:windowsHandles){
            if (!handle.equals(minWindowsHande)){
                driver.getDriver().switchTo().window(handle);
                break;
            }}
        String actualFacebookUrl = driver.browser().getCurrentURL();
        Assert.assertEquals(actualFacebookUrl,expectedFacebookUrl,"Doesn't match url");
       // driver.getDriver().switchTo().window(minWindowsHande);

        return this;
    }
    @SneakyThrows
    @Step("Validate that when the user click on Twitterink Navigate to Twitter page ")
    public followUsPage validateTwitterink(String expectedTwitterUrl){
        String minWindowsHandle = driver.getDriver().getWindowHandle();
        driver.element().click(twitterink);
        //Thread.sleep(12000);
        Set<String> windowsHandles= driver.getDriver().getWindowHandles();
        for (String handle:windowsHandles){
            if (!handle.equals(minWindowsHandle)){
                driver.getDriver().switchTo().window(handle);
                break;
            }}
        String actualTwitterUrl = driver.browser().getCurrentURL();
        Assert.assertEquals(actualTwitterUrl,expectedTwitterUrl,"Doesn't match url");
        return this;
    }
    @SneakyThrows
    @Step("Validate that when the user click on RssLink Navigate to Rss page ")
    public followUsPage validateRssLink(String expectedRssUrl){
        String minWindowsHandle = driver.getDriver().getWindowHandle();
        driver.element().click(rssLink);
       // Thread.sleep(7000);
        Set<String> windowsHandles= driver.getDriver().getWindowHandles();
        for (String handle:windowsHandles){
            if (!handle.equals(minWindowsHandle)){
                driver.getDriver().switchTo().window(handle);
                break;
            }}
        String actualRssUrl = driver.browser().getCurrentURL();
        Assert.assertEquals(actualRssUrl,expectedRssUrl,"Doesn't match url");
        return this;
    }
    @SneakyThrows
    @Step("Validate that when the user click on YoutubeLink Navigate to Youtube page ")
    public followUsPage validateYoutubeLink(String expectedYoutubeUrl){
        String minWindowsHandle = driver.getDriver().getWindowHandle();
        driver.element().click(youtubeLink);
        //Thread.sleep(12000);
        Set<String> windowsHandles= driver.getDriver().getWindowHandles();
        for (String handle:windowsHandles){
            if (!handle.equals(minWindowsHandle)){
                driver.getDriver().switchTo().window(handle);
                break;
            }}
        String actualYoutubeUrl = driver.browser().getCurrentURL();
        Assert.assertEquals(actualYoutubeUrl,expectedYoutubeUrl,"Doesn't match url");
        return this;
    }
}
