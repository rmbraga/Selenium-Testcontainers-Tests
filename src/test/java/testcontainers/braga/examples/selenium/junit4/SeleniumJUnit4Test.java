package testcontainers.braga.examples.selenium.junit4;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

import static org.testcontainers.containers.BrowserWebDriverContainer.*;

public class SeleniumJUnit4Test {

    @Rule
    public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
            .withCapabilities(new ChromeOptions())
            .withRecordingMode(VncRecordingMode.RECORD_FAILING, new File("./target"));

    @Test
    public void googlePageTitleTest(){
        RemoteWebDriver driver = chrome.getWebDriver();

        driver.get("http://www.google.com");
        Assert.assertEquals("Googlee", driver.getTitle());
    }

    @Test
    public void googlePageTitleTest2(){
        RemoteWebDriver driver = chrome.getWebDriver();

        driver.get("http://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());
    }
}