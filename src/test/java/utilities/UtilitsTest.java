package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class UtilitsTest {
    WebDriver driver;

    public UtilitsTest(WebDriver driver){
        this.driver = driver;
    }



    public void takeScreenshot(Method method) throws IOException {

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file , new File("report/"+method.getName()+".png"));

    }
}
