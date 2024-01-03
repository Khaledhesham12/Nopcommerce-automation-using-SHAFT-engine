package automationexercise.tests;
import automationexercise.pages.followUsPage;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.*;

@Epic("User acticty")
@Story("Follow Us")
public class followUsTest extends testBase {
    private JSONFileManager testData;
    @Test(description = "Validate that when the user click on FacebookLink Navigate to facebook page ")
    public void validateFacebook(){
        new followUsPage(driver).urlNavigate().
                validateFacebookLink(testData.getTestData("expectedFacebookUrl"));
    }

    @Test(description = "Validate that when the user click on Twitterink Navigate to Twitter page")
    public void validateTwitter(){
        new followUsPage(driver).urlNavigate()
                .validateTwitterink(testData.getTestData("expectedTwitterUrl"));
    }

    @Test(description = "Validate that when the user click on RssLink Navigate to Rss page")
    public void validateRss(){
        new followUsPage(driver).urlNavigate().
                validateRssLink(testData.getTestData("expectedRssUrl"));
    }

    @Test(description = "Validate that when the user click on YoutubeLink Navigate to Youtube page")
    public void validateYoutube(){
        new followUsPage(driver).urlNavigate()
                .validateYoutubeLink(testData.getTestData("expectedYoutubeUrl"));
    }
    @BeforeClass
    @Description("Sitting Json File ")
    public void beforeClass(){
        testData = new JSONFileManager("C:\\Users\\Mtech\\IdeaProjects\\demonopcommerce\\src\\test\\resources\\automationexercise\\TestData\\followUsTestData.json");
    }
}

