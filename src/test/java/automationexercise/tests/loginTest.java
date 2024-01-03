package automationexercise.tests;
import automationexercise.pages.loginPage;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.*;

@Epic("User Managment")
@Story("Login")
public class loginTest extends testBase{
    private JSONFileManager testDataForRegister;
    private JSONFileManager testDataForLogin;

    @Test(description="Validate that the user can  login Succesfully")
    public void validateValidLogin(){
        new loginPage(driver).urlNavigate().clickOnLoginTabButton().
                fillValidLoginData(testDataForRegister.getTestData("email"),testDataForRegister.getTestData("password"))
                .cliclOnLoginButton().validateValidLogin(testDataForLogin.getTestData("expectedUrl"));
    }
    @Test(description = "Validate that the user can't login succesfully ")
    public void validateInValidLogin(){
        new loginPage(driver).urlNavigate().clickOnLoginTabButton().
                fillInValidLoginData(testDataForLogin.getTestData("wrongEmail"),
                        testDataForRegister.getTestData("password")).cliclOnLoginButton().
                validateInValidLogin(testDataForLogin.getTestData("expectedErrorMesssege"),
                        testDataForLogin.getTestData("colorOfErrorMessege"));
    }
    @BeforeClass
    @Description("Setting JSON file  ")
    public void beforeCLass(){
        testDataForRegister =new JSONFileManager("C:\\Users\\Mtech\\IdeaProjects\\demonopcommerce\\src\\test\\resources\\automationexercise\\TestData\\registerTestData.json");
        testDataForLogin =new JSONFileManager("C:\\Users\\Mtech\\IdeaProjects\\demonopcommerce\\src\\test\\resources\\automationexercise\\TestData\\loginTestData.json");
    }
}

