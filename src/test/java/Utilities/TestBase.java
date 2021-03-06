package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

   public static WebDriver driver;
   public MyLibrary mylib;
   public static WebDriverWait wait;
   public static Actions act;

    @BeforeMethod
    public void setups(){
        driver=Driver.getDriver();
        mylib=new MyLibrary(driver);
        wait=new WebDriverWait(driver,50);
        act=new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void EndTest(){
        mylib.sleep(3);
       Driver.CloseDriver();
    }

}
