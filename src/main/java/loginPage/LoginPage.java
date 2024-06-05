package loginPage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }


    public final By userNameInput = By.cssSelector("input[placeholder='Username']");
    public final By passwordInput = By.cssSelector("input[placeholder='Password']");
    public final By loginBtn = By.cssSelector("button[type='submit']");
    public final By getErrorMessage = By.cssSelector("div[role='alert']");



    @Step
    public void enterUserName(String name){
        driver.findElement(userNameInput).sendKeys(name);
    }

    @Step
    public void enterPassword(String pass){
        driver.findElement(passwordInput).sendKeys(pass);
    }

    @Step
    public void clickOnLoginBtn(){
        driver.findElement(loginBtn).click();
    }

    @Step
    public String getErrorMs(){
        return driver.findElement(getErrorMessage).getText();
    }
}