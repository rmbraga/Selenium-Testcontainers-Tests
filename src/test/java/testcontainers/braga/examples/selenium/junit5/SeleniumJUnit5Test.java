package testcontainers.braga.examples.selenium.junit5;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode;

@Testcontainers
public class SeleniumJUnit5Test {

    @Container
    public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
            .withCapabilities(new ChromeOptions())
            .withRecordingMode(VncRecordingMode.RECORD_FAILING, new File("./target"));

    @Test
    public void googlePageTitleTest(){
        RemoteWebDriver driver = chrome.getWebDriver();

        driver.get("http://www.google.com");
        Assertions.assertEquals("Google", driver.getTitle());
    }

    @Test
    public void googlePageTitleTest2(){
        RemoteWebDriver driver = chrome.getWebDriver();

        driver.get("http://www.google.com");
        Assertions.assertEquals("Googlee", driver.getTitle());
    }
}
