package automationexercise.pages;
import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.By;
import io.qameta.allure.Step;
public class homeSlidersPage {
    private SHAFT.GUI.WebDriver driver;
    private String pageUrl="https://demo.nopcommerce.com/";
    public homeSlidersPage(SHAFT.GUI.WebDriver driver){this.driver=driver;}
    public homeSlidersPage urlNavigate(){
        driver.browser().navigateToURL(pageUrl);
        return this;
    }
    private By iphoneSLider = By.xpath("//a[@class='nivo-imageLink'][1]");
            //By.xpath("//div[@id='nivo-slider']//img[contains(@data-thumb, '0000088_banner_01')]");
            //By.xpath("//div[@id=\"nivo-slider\"]//img[@src=\"https://demo.nopcommerce.com/images/thumbs/0000088_banner_01\"]");
    private By galaxySlider = By.xpath("//a[@class='nivo-imageLink'][2]");
            //"//div[@id=\"nivo-slider\"]//img[@src=\"https://demo.nopcommerce.com/images/thumbs/0000089_banner_02\"]");


    public homeSlidersPage validateIphoneSlider(String expectedIphoneUrl){
        //driver.element().waitToBeReady(iphoneSLider);
        driver.waitUntil(ExpectedConditions.elementToBeSelected(iphoneSLider));
        driver.element().click(iphoneSLider);
        String currentUrl= driver.browser().getCurrentURL();
        Assert.assertEquals(currentUrl,expectedIphoneUrl,"The url after click on slider doesn't match the expected URL");
       return this;
    }
    public homeSlidersPage validateGalaxySLider(String expectedGalaxyUrl){
        driver.waitUntil(ExpectedConditions.elementToBeClickable(galaxySlider));
        driver.element().click(galaxySlider);
        String currentUrl = driver.browser().getCurrentURL();
        Assert.assertEquals(currentUrl,expectedGalaxyUrl,"doesn't match ");
        return this;
    }
}
