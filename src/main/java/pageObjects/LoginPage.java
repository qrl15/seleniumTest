package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LoginPage {

    public WebDriver driver;

    By email = By.xpath("//input[@id='user_email']");
    By pass = By.xpath("//input[@id='user_password']");
    By butClick = By.cssSelector("[value='Log In']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmail(){
        return driver.findElement(email);
    }

    public WebElement getPass(){
        return driver.findElement(pass);
    }

    public WebElement getLogin(){
        return driver.findElement(butClick);
    }
}
