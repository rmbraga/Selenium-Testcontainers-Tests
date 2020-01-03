package testcontainers.braga.examples.selenium.junit4;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class GenericContainerTest {

    @ClassRule
    public GenericContainer redis =
            new GenericContainer("redis:3.0.2")
                    .withExposedPorts(6379);
}
