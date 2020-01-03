package testcontainers.braga.examples.selenium.junit4;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.containers.wait.strategy.WaitStrategy;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class DockerComposeTest {

    @ClassRule
    public static DockerComposeContainer environment =
            new DockerComposeContainer(new File("src/test/resources/compose-test.yml"))
                    .withExposedService("redis_1", 6379);

    @Test
    public void getContainerUrl() throws IOException {
        String address = "http://" + environment.getServiceHost("redis_1", 6379) +
                ":" + environment.getServicePort("redis_1", 88);
        int statusResponse = getRequestStatusCode(address);
        Assert.assertEquals(200, statusResponse);
    }

    public int getRequestStatusCode(String address) throws IOException {
        URL url = new URL(address);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        return con.getResponseCode();
    }
}






