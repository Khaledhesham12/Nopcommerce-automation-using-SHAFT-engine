package automationexercise.pages;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import io.qameta.allure.Step;
public class registerationPage {
    private SHAFT.GUI.WebDriver driver;
    private String pageUr="https://demo.nopcommerce.com/";
    public registerationPage(SHAFT.GUI.WebDriver driver){this.driver=driver;}
    public registerationPage urlNavigate(){driver.browser().navigateToURL(pageUr);return this;}
    private By registerTabButton = By.xpath("//a[@class=\"ico-register\"]");
    private By maleInput= By.id("gender-male");
    private By femaleInput=By.id("gender-female");
    private By firstNameTextBox=By.id("FirstName");
    private By lastNameTextBox=By.id("LastName");
    private By dateOfBithDay=By.name("DateOfBirthDay");
    private By dateOfBithMonth=By.name("DateOfBirthMonth");
    private By dateOfBithYear=By.name("DateOfBirthYear");
    private By emailTextBox=By.xpath("//div[@class=\"form-fields\"]//input[@id=\"Email\"]");
    private By companyNameTextBox= By.id("Company");
    private By passwordTextBox=By.xpath("//div[@class=\"form-fields\"]//input[@id=\"Password\"]");
    private By confirmPasswordTextBox=By.id("ConfirmPassword");
    private By registerButton=By.id("register-button");
    private By statusAlert=By.className("result");

    @Step("Validate that the User registered succsesfully")
    public registerationPage validateRegister(String alertText,String color){
        driver.verifyThat().element(statusAlert).text().isEqualTo(alertText).perform();
        driver.verifyThat().element(statusAlert).cssProperty("color").isEqualTo(color).perform();
        return this;
    }
    public registerationPage chooseGender(){
      driver.element().click(maleInput);
        return this;
    }
    public registerationPage clickOnRegisterTabButton(){
        driver.element().click(registerTabButton);
        return this;
    }
    public registerationPage fillRegisterData(String firstName,String lastName,String email,
                                              String companyName,String password,String confirmPassword){
        driver.element().type(firstNameTextBox,firstName);
        driver.element().type(lastNameTextBox,lastName);
        driver.element().type(emailTextBox,email);
        driver.element().type(companyNameTextBox,companyName);
        driver.element().type(passwordTextBox,password);
        driver.element().type(confirmPasswordTextBox,confirmPassword);
        return this;
    }
    public registerationPage chooseDateOfBirth(String Day,String Month,String Year){
        driver.element().select(dateOfBithDay,(Day));
        driver.element().select(dateOfBithMonth,(Month));
        driver.element().select(dateOfBithYear,(Year));
        return this;
    }
    public registerationPage clickOnRegisterButton(){
        driver.element().click(registerButton);
        return this;
    }
}
