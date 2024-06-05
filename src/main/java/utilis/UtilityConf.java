package utilis;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class UtilityConf {


    public static void takingScreenShot(WebDriver driver , String screenShotName) throws IOException {
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot,new File("src/test/resources/ScreenShots/"+screenShotName+".png"));
    }
}