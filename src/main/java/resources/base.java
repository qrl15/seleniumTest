package resources;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;


public class base {

    public  WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {
        //chrome
        prop = new Properties();
        FileInputStream f = new FileInputStream("//Users//jaxethhugomahiya//IdeaProjects//E2EProject//src//main//java//resources//data.properties");
        prop.load(f);
        String browserName = prop.getProperty("browser");


        if(browserName.equals("chrome")){

            System.setProperty("webdriver.chrome.driver","//Users//jaxethhugomahiya//Downloads//chromedriver");
            driver = new ChromeDriver();
        }else if(browserName.equals("firefox")){

        }else if(browserName.equals("IE")){

        }

        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    public void getScreenshotPath(String testCaseName, WebDriver driver) throws IOException{
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("home/user")+"/reports/"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
    }
}
