package Academy;

//import org.junit.Test;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class HomePage extends base {

    //public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();

    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String Username, String Password) throws IOException {

        driver.get(prop.getProperty("url"));
       LandingPage l = new LandingPage(driver);
       LoginPage logIn = new LoginPage(driver);

        Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
        Assert.assertTrue(l.getNav().isDisplayed());


        l.getLogin().click();
        logIn.getEmail().sendKeys(Username);
        logIn.getPass().sendKeys(Password);
        logIn.getLogin().click();
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }


    @DataProvider
     public Object[][] getData(){
        //Row stands for how many different data types test should run
        //column - how many values per each test
        //rows
        Object[][] data = new Object[2][2];
        data[0][0] = "test@gmail.com";
        data[0][1] = "ads12349990";

        data[1][0] = "Restrictedasd@gmail.com";
        data[1][1] = "RestrictedPassword";

        return data;
    }


}
