package automationexercise.pages;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import io.qameta.allure.Step;

public class loginPage {
    private SHAFT.GUI.WebDriver driver;
    private String pageUrl="https://demo.nopcommerce.com/";
    public loginPage (SHAFT.GUI.WebDriver driver){this.driver=driver;}
    public loginPage urlNavigate(){driver.browser().navigateToURL(pageUrl);return this;}
    private By loginTabButton = By.xpath("//a[@class=\"ico-login\"]");
    private By emailTextBox =By.xpath("//div[@class=\"returning-wrapper fieldset\"]//input[@id=\"Email\"]");
    private By passwordTextBox=By.xpath("//div[@class=\"returning-wrapper fieldset\"]//input[@id=\"Password\"]");
    private By loginButton =By.xpath("//div[@class=\"returning-wrapper fieldset\"]//div[@class=\"buttons\"]//button[@type=\"submit\"]");
    private By myAcountTabButton =By.className("ico-account");
    private By errorMessegeOfInvalidLogin = By.xpath("//div[contains(text(),'Login was unsuccessful')]");
    @Step("Validate that the user logged in Succesfully ")
    public loginPage validateValidLogin(String expectedUrl){
      driver.verifyThat().browser().url().isEqualTo(expectedUrl).perform();
      driver.verifyThat().element(myAcountTabButton).isVisible().perform();
      return this;
    }
    @Step("Validate that the user Couldn't logIn Succesfully")
    public loginPage validateInValidLogin(String expectedErrorMesssege,String colorOfErrorMessege){
       driver.verifyThat().element(errorMessegeOfInvalidLogin).text().isEqualTo(expectedErrorMesssege).perform();
       driver.verifyThat().element(errorMessegeOfInvalidLogin).cssProperty("color").
               isEqualTo(colorOfErrorMessege);
       return this;
    }
    public loginPage clickOnLoginTabButton(){
        driver.element().click(loginTabButton);
        return this;
    }
    public loginPage fillValidLoginData(String email,String password){
        driver.element().type(emailTextBox,email);
        driver.element().type(passwordTextBox,password);
        return this;
    }
    public loginPage fillInValidLoginData(String wrongEmail,String password){
        driver.element().type(emailTextBox,wrongEmail);
        driver.element().type(passwordTextBox,password);
        return this;
    }
    public loginPage cliclOnLoginButton(){
        driver.element().click(loginButton);
        return this;
    }
}
