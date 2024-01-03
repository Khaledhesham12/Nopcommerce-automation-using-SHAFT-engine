package automationexercise.tests;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import org.testng.annotations.*;
public class testBase {
    protected static SHAFT.GUI.WebDriver driver;

    @BeforeMethod
    @Description("Navigate to  Base Url")
    public void brforeMethod(){
        driver = new SHAFT.GUI.WebDriver();
    }

    @AfterMethod
    @Description("Close the browser after test")
    public void tearDown(){
        driver.browser().closeCurrentWindow();
    }
}
