package base;

import loginPage.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilis.UtilityConf;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    WebDriver driver; 
    protected LoginPage log;
    protected String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";



   @BeforeMethod
   public void testSetUp1(){
       driver = new ChromeDriver();
       driver.get(url);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
       log = new LoginPage(driver);
   }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }




//    @AfterMethod
//    public void tearDown(ITestResult result) throws IOException {
//        if(ITestResult.FAILURE==result.getStatus()) {
//            UtilityConf.takingScreenShot(driver, result.getName());
//        }
//        //driver.quit();
//    }


//    @AfterMethod
//    public void takingScreenShotAndTearDown(ITestResult result){
//
//       if (ITestResult.FAILURE==result.getStatus()) {
//           TakesScreenshot screenshot = (TakesScreenshot) driver;
//           File source = screenshot.getScreenshotAs(OutputType.FILE);
//           File destination = new File("src/test/resources/ScreenShots/"+result.getName()+".png");
//
//           try {
//               FileHandler.copy(source, destination);
//           } catch (IOException ioException) {
//               ioException.printStackTrace();
//           }
//       }
//
//    }

}
