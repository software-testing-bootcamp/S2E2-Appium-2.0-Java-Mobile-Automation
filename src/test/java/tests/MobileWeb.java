package tests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.DriverManager;

import java.net.MalformedURLException;

public class MobileWeb extends DriverManager {
    By videosTabBy = By.xpath("//a[contains(text(),'Videos')]");
    By playlistsTabBy = By.xpath("//a[contains(text(),'Playlists')]");
    By moreOptionsBy = By.xpath("//button[contains(@aria-label,'More options')]");
    By aboutItemBy = By.xpath("//a[contains(text(),'About')]");
    AppiumBy aboutBy = (AppiumBy) AppiumBy.className("user-text");

    @Parameters("platform")
    @BeforeClass(groups = {"hook"})
    void beforeClass(@Optional("platform") String platform) throws MalformedURLException {
        setDriver(platform);
    }

    @AfterClass(groups = {"hook"})
    void teardown() {
        driver.quit();
    }

    @Test(groups = {"safari", "chrome"})
    public void youtubeMobileWebTest() throws Exception {
        driver.get(baseURL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(videosTabBy)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(playlistsTabBy)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(moreOptionsBy)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutItemBy)).click();
        Thread.sleep(2000);
        String aboutText = wait.until(ExpectedConditions.visibilityOfElementLocated(aboutBy)).getText();
        if (!aboutText.contains("software testing")) {
            Assert.fail("Failed to find text");
        }
        Thread.sleep(2000);
    }

}
