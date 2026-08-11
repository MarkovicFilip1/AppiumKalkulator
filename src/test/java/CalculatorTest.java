import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");

        options.setAppPackage("org.fossify.math.debug");
        options.setAppActivity("org.fossify.math.activities.MainActivity");

        options.setNoReset(true);

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );


    }
    @Test
    public void enterNumberTwo() throws InterruptedException {

        driver.findElement(
                AppiumBy.id("org.fossify.math.debug:id/btn_9")
        ).click();
        Thread.sleep(5000);

        String pageSource = driver.getPageSource();

        assertTrue(pageSource.contains("2"));
    }

    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}

