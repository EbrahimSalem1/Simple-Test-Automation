package login;
import base.BaseTest;
import base.TestListeners;
import loginPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static utilities.DataDriven.JsonClass.readJson;
//import static utilities.DataFile.JsonClass.readJson;

@Listeners(TestListeners.class)
public class LoginTest extends BaseTest {


    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\jsonData\\login.json";


    @Test
    public void testEnterInvalidLoginPasswordAndClickLoginBtn1(){

        LoginPage log1 = log;
        log1.enterUserName(readJson(filePath , "name1"));
        log1.enterPassword(readJson(filePath , "password1"));
        log1.clickOnLoginBtn();
        String actualGetMessage = log1.getErrorMs();
        String expectedMs = "Error"; //Invalid credentials
        Assert.assertEquals(actualGetMessage , expectedMs);

    }

    @Test
    public void testEnterValidLoginPasswordAndClickLoginBtn2(){

        LoginPage logValid = log;
        logValid.enterUserName(readJson(filePath , "name2"));
        logValid.enterPassword(readJson(filePath , "password2"));
        logValid.clickOnLoginBtn();
        Assert.assertEquals(logValid.getErrorMs() , "Invalid credentials");

    }
    @Test
    public void testEnterValidLoginPasswordAndClickLoginBtn3(){

        LoginPage logValid = log;
        logValid.enterUserName(readJson(filePath , "name3"));
        logValid.enterPassword(readJson(filePath , "password3"));
        logValid.clickOnLoginBtn();
    }
}