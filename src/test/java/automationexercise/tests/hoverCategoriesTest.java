package automationexercise.tests;
import automationexercise.pages.hoverCategoriesPage;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.*;

@Epic("User activity")
@Story("Choose Category")
public class hoverCategoriesTest extends testBase {
    private JSONFileManager testData;

    @Test(description = "Validate that the user hover on one of main categories then click on sub category")
    public void validateHover(){
        new hoverCategoriesPage(driver).urlNavigate().hoverOnMainCategory().validateTheChossenSubCategory();

    }
}
