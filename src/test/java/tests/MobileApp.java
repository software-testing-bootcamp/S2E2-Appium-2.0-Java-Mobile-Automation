package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.DriverManager;

import java.net.MalformedURLException;

public class MobileApp extends DriverManager {

    By loginButtonBy = By.id("com.bilgikolik.app:id/loginButton");
    By emailBy = By.id("com.bilgikolik.app:id/epostaadresi");
    By passwordBy = By.id("com.bilgikolik.app:id/sifrekutu");
    By doLoginBy = By.id("com.bilgikolik.app:id/girisyapbuton");
    By welcomeMessageBy = By.id("com.bilgikolik.app:id/usernametext");

    @Parameters("platform")
    @BeforeClass(groups = {"hook"})
    void beforeClass(@Optional("platform") String platform) throws MalformedURLException {
        setDriver(platform);
    }

    @AfterClass(groups = {"hook"})
    void teardown() {
        driver.quit();
    }

    @Test(groups = {"android"})
    public void mobileAppTest() throws Exception {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonBy)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailBy)).click();
        //driver.findElement(loginButtonBy).click();
        //driver.findElement(emailBy).click();
        driver.findElement(emailBy).sendKeys("xokeni2792@host1s.com");
        driver.findElement(passwordBy).sendKeys("123qwe");
        //driver.hideKeyboard();
        driver.findElement(doLoginBy).click();
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessageBy)).getText();
        Assert.assertEquals(actualText, "bootcamp");
        Thread.sleep(2000);
    }

}
