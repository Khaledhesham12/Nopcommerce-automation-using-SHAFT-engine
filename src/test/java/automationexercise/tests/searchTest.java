package automationexercise.tests;
import automationexercise.pages.searchPage;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.*;

@Epic("User activity")
@Story("Sesrch ")
public class searchTest extends testBase{
    private JSONFileManager testData;

    @Test(description = "Validite  when the user Search by productName ")
    public void searchBYProductName(){
        new searchPage(driver).urlNavigate().searchWithProductName(testData.getTestData("productName")).
                clickOnSearchButton().
                validateSearchWithProductName(testData.getTestData("expectedUrl")
                        ,testData.getTestData("searchWord"));
    }
    @Test(description = "Validate  when the user search by SKU")
    public void searchBySKU(){
        new searchPage(driver).urlNavigate().searchWithSku(testData.getTestData("sku"))
                .clickOnSearchButton().validateSearchWithSku(testData.getTestData("sku"));
    }
    @BeforeClass
    @Description("Sitting json file ")
    public void beforeMethod (){
        testData = new JSONFileManager("C:\\Users\\Mtech\\IdeaProjects\\demonopcommerce\\src\\test\\resources\\automationexercise\\TestData\\searchTestData.json");
    }
}

