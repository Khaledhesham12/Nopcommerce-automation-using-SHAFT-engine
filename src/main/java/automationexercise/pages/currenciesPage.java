package automationexercise.pages;
import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.openqa.selenium.By;
import io.qameta.allure.Step;

public class currenciesPage {
    private SHAFT.GUI.WebDriver driver;
    private String pageUrl ="https://demo.nopcommerce.com/";
    public  currenciesPage(SHAFT.GUI.WebDriver driver){
    this.driver=driver;
}
    public currenciesPage urlNavigate(){driver.browser().navigateToURL(pageUrl);return this;}
    private By currenceDropDownList = By.id("customerCurrency");
    private By priceOfTheFirstProduct=By.xpath("//div[@data-productid=\"1\"]//span[@class=\"price actual-price\"]");
    private By priceOfTheSecondProduct=By.xpath("//div[@data-productid=\"4\"]//span[@class=\"price actual-price\"]");
    private By priceOfTheThirdProduct=By.xpath("//div[@data-productid=\"18\"]//span[@class=\"price actual-price\"]");
    private By priceOfTheForthProduct=By.xpath("//div[@data-productid=\"43\"]//span[@class=\"price actual-price\"]");

    @Step("Validate that the User Can choose Current from DropDown List ")
    public currenciesPage clickOnCurrenceDropDownList(String currensy){
        driver.element().select(currenceDropDownList,(currensy));
        return this;
    }
    @Step("Validate thet The currensy changed in All products prices")
    public currenciesPage getAndAssertText(String currentSymbol){
    {
        String[] xPaths = {
            "//div[@data-productid=\"1\"]//span[@class=\"price actual-price\"]",
            "//div[@data-productid=\"4\"]//span[@class=\"price actual-price\"]",
            "//div[@data-productid=\"18\"]//span[@class=\"price actual-price\"]",
            "//div[@data-productid=\"43\"]//span[@class=\"price actual-price\"]",
        };
        String[] getText =new String[4];
        for (int i=0 ; i<4 ;i++){
            getText[i]=driver.element().getText(By.xpath(xPaths[i]));
            Assert.assertTrue(getText[i].contains(currentSymbol),"Currency symbol not found in element"+(i+1));
        }
        return this;

    }}
}

