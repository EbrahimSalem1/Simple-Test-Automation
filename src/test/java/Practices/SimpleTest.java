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
    public void setConfig(){

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){

        //PostConditions
        driver.quit();
    }



    @Test(priority = 1)
    public void enterInvalidUserNameLoginData(){

        
        driver.findElement(By.cssSelector("#username")).sendKeys("tomsm");
        driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");        
        driver.findElement(By.cssSelector(".radius")).click();

        
        String ectualValidationError = driver.findElement(By.cssSelector("#flash")).getText();
        String expectedSuccessMessage = "Your username is invalid!\n" + "×";
        Assert.assertEquals(ActualValidationError , ExpectedSuccessMessage);

    }



    @Test(priority = 2)
    public void enterInvalidPasswordLoginData(){

        
        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecret");
        driver.findElement(By.cssSelector(".radius")).click();

        
        String actualValidationErrorPassMessage = driver.findElement(By.cssSelector("#flash")).getText();
        String expValidationErrorPassMessage = "Your password is invalid!\n" + "×";
        Assert.assertTrue(ActualValidationErrorPassMessage.contains(ExpValidationErrorPassMessage));

    }


    @Test(priority = 3)
    public void enterValidLoginData(){

        
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");        
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        
        String actualSuccessMessage = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        String expectedSuccessMessage = "You logged into a secure area!";
        Assert.assertTrue(ActualSuccessMessage.contains(ExpectedSuccessMessage));

<<<<<<< HEAD
        //Print a SuccessMessage
        System.out.println(ActualSuccessMessage);
=======
>>>>>>> fb363e7a6b4e2d529ba9a08d6fc3af84ac9cb980
    }

}
