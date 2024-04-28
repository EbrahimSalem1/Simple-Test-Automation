package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleTest {

    WebDriver driver;
    String url = "https://the-internet.herokuapp.com/login";


    @BeforeMethod
    public void Config(){

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }



    @Test(priority = 1)
    public void enterInvalidUserNameLoginData(){

        //FindElements and sendKeys (userName - Password)
        driver.findElement(By.cssSelector("#username")).sendKeys("tomsm");
        driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");

        //Click On Element Button
        driver.findElement(By.cssSelector(".radius")).click();

        //Assertion between ExpectedResult - ActualResult
        String ActualValidationError = driver.findElement(By.cssSelector("#flash")).getText();
        String ExpectedSuccessMessage = "Your username is invalid!\n" + "×";
        Assert.assertEquals(ActualValidationError , ExpectedSuccessMessage);

        //Print an ErrorMessage
        System.out.println(ActualValidationError);




    }



    @Test(priority = 2)
    public void enterInvalidPasswordLoginData(){

        //FindElements and sendKeys (userName - Password)
        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecret");

        //Click On Element Button
        driver.findElement(By.cssSelector(".radius")).click();


        ////Assertion between ExpectedResult - ActualResult
        String ActualValidationErrorPassMessage = driver.findElement(By.cssSelector("#flash")).getText();
        String ExpValidationErrorPassMessage = "Your password is invalid!\n" + "×";
        Assert.assertTrue(ActualValidationErrorPassMessage.contains(ExpValidationErrorPassMessage));

        //Print an ErrorMessage
        System.out.println(ActualValidationErrorPassMessage);



    }


    @Test(priority = 3)
    public void enterValidData(){

        //FindElements and sendKeys (userName - Password)
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");

        //Click On Element Button
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        //Assertion between ExpectedResult - ActualResult
        String ActualSuccessMessage = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        String ExpectedSuccessMessage = "You logged into a secure area!";
        Assert.assertTrue(ActualSuccessMessage.contains(ExpectedSuccessMessage));

        //Print a SuccessMessage
        System.out.println(ActualSuccessMessage);



    }

}
