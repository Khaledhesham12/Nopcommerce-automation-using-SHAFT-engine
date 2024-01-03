package automationexercise.pages;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.Assert;
public class wishlistPage {
    private SHAFT.GUI.WebDriver driver;
    private String pageUrl="https://demo.nopcommerce.com/";
    public wishlistPage (SHAFT.GUI.WebDriver driver){this.driver=driver;}
    public  wishlistPage urlNavigate(){driver.browser().navigateToURL(pageUrl);return this;}
    private By addToWishlistButton = By.xpath("//div[@data-productid=\"18\"]//button[@title=\"Add to wishlist\"]");
    private By succesMessege =By.xpath("//div[@id=\"bar-notification\"]//p[contains(text(),'The product has been added to your ')]");
    private By wishlistTab = By.className("wishlist-label");
    private By qtyValue = By.className("qty-input");
    public wishlistPage validateSuccesMessege(String backgroundColor){
        driver.element().click(addToWishlistButton);
        driver.verifyThat().element(succesMessege).isVisible();
        driver.verifyThat().element(succesMessege).cssProperty("background-color").isEqualTo(backgroundColor);
        return this;
    }
    public wishlistPage validateAddToWishList(){
        driver.element().click(addToWishlistButton);
        driver.element().waitToBeInvisible(succesMessege);
        driver.element().click(wishlistTab);
        String quantityValue = driver.element().getText(qtyValue);
        int qty = Integer.parseInt(quantityValue);
        Assert.assertTrue(qty>0,"Quantity is not greater than zero ");
        return this;
    }
}
