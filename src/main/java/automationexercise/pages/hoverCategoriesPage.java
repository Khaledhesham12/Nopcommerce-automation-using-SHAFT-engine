package automationexercise.pages;
import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.openqa.selenium.By;
import io.qameta.allure.Step;
public class hoverCategoriesPage {
    private SHAFT.GUI.WebDriver driver;
    private String pageUrl = "https://demo.nopcommerce.com/";
    public hoverCategoriesPage(SHAFT.GUI.WebDriver driver) {this.driver = driver;}
    public hoverCategoriesPage urlNavigate(){driver.browser().navigateToURL(pageUrl);return this;}
    private By mainCategory = By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/computers\"]");
    private By subCategory = By.xpath("//ul[@class=\"top-menu notmobile\"]//ul[@class=\"sublist first-level\"]//a[@href=\"/notebooks\"]");
    private By pageTitle = By.xpath("//div[@class=\"page-title\"]//h1");
  @Step("Validate that the user hover in main category and apper the list of sub category ")
    public hoverCategoriesPage hoverOnMainCategory(){
        driver.element().hover(mainCategory);
        return this;
    }
    @Step("Validate that the name of sub category that the user had choosen is the page tittle")
    public hoverCategoriesPage validateTheChossenSubCategory(){
        String textOfSubCategory = driver.element().getText(subCategory).toLowerCase();
        driver.element().click(subCategory);
        String textOfTitlePage = driver.element().getText(pageTitle).toLowerCase();
        Assert.assertEquals(textOfTitlePage,textOfSubCategory," tittle doesn't match text of sub category ");
        return this;
    }
}

