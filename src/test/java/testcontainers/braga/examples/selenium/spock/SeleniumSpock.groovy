package testcontainers.braga.examples.selenium.spock

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.RemoteWebDriver
import org.testcontainers.containers.BrowserWebDriverContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode;

@Testcontainers
class SeleniumSpock extends Specification {

    @Shared
    BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
            .withCapabilities(new ChromeOptions())
            .withRecordingMode(VncRecordingMode.RECORD_FAILING, new File("./target"));

    def "Google page title test"() {
        given: "A WebDriver is instantiated"
        RemoteWebDriver driver = chrome.getWebDriver();
        String googleTitle = "Googles";

        when: "We do a get on http://www.google.com"
        driver.get("http://www.google.com");

        then: "The page title should be 'Google'"
        googleTitle == driver.getTitle();
    }

}
