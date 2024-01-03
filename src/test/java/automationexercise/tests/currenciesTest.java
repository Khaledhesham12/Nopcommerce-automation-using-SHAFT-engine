package automationexercise.tests;
import automationexercise.pages.currenciesPage;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.*;

@Epic("User activity")
@Story("Change Currence")
public class currenciesTest extends testBase {
    private JSONFileManager testData;

    @Test(description = "Validate that when  the user changes currence then the currence will be changed Automaticlly in the products ")
    public void validateCurrence(){
        new currenciesPage(driver).urlNavigate().clickOnCurrenceDropDownList(testData.getTestData("currensy"))
                .getAndAssertText(testData.getTestData("currensySymbol"));

    }
    @BeforeClass
    @Description("Setting json file   ")
    public void beforeClass(){
        testData=new JSONFileManager("C:\\Users\\Mtech\\IdeaProjects\\demonopcommerce\\src\\test\\resources\\automationexercise\\TestData\\currenciesTestData.json");
    }
}
