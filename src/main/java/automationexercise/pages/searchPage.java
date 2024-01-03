package automationexercise.pages;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.By;
import io.qameta.allure.Step;
import java.util.List;
public class searchPage {
    private SHAFT.GUI.WebDriver driver;
    private String pageUrl="https://demo.nopcommerce.com/";
    public searchPage (SHAFT.GUI.WebDriver driver){this.driver=driver;}
    public searchPage urlNavigate(){driver.browser().navigateToURL(pageUrl);return this;}
    private By searchTextBox = By.id("small-searchterms");
    private By searchButton = By.xpath("//div[@class=\"header-lower\"]//button[@type=\"submit\"]");
    private By searchResult =By.xpath("//div[@class=\"search-results\"]");
    private By searchItem=By.xpath("//div[@class=\"item-box\"]//div[@class=\"picture\"]");
    private By skuValue = By.xpath("//div[@class=\"sku\"]//span[@class=\"value\"]");

    public searchPage searchWithProductName(String productName){
        driver.element().type(searchTextBox,(productName));
        return this;
    }
    public  searchPage validateSearchWithProductName(String expectedUrl,String searchWord){
        driver.verifyThat().browser().url().contains(expectedUrl);
        List<WebElement> searchResults = driver.getDriver().findElements(searchResult);
        int sizeOfSerachResult = searchResults.size();
        System.out.println("the number of itemsResult is : "+sizeOfSerachResult);
        for (WebElement result : searchResults){
            String resultText=result.getText().toLowerCase();
            Assert.assertTrue(resultText.contains(searchWord.toLowerCase()));
        }
        return this;
    }
    public searchPage searchWithSku(String sku){
        driver.element().type(searchTextBox,(sku));
        return this;
    }
    public searchPage validateSearchWithSku(String sku){
        driver.element().click(searchItem);
        String skuOfProduct = driver.element().getText(skuValue);
        Assert.assertTrue(skuOfProduct.contains(sku));
        return this;
    }
    public searchPage clickOnSearchButton(){
        driver.element().click(searchButton);
        return this;
    }
}
