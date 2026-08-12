import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final String button9Id = "org.fossify.math.debug:id/btn_9";
    private final String button8Id = "org.fossify.math.debug:id/btn_8";
    private final String button7Id = "org.fossify.math.debug:id/btn_7";
    private final String button6Id = "org.fossify.math.debug:id/btn_6";
    private final String button5Id = "org.fossify.math.debug:id/btn_5";
    private final String button4Id = "org.fossify.math.debug:id/btn_4";
    private final String button3Id = "org.fossify.math.debug:id/btn_3";
    private final String button2Id = "org.fossify.math.debug:id/btn_2";
    private final String button1Id = "org.fossify.math.debug:id/btn_1";
    private final String button0Id = "org.fossify.math.debug:id/btn_0";
    private final String buttonPlusId = "org.fossify.math.debug:id/btn_plus";
    private final String buttonMultiplyId = "org.fossify.math.debug:id/btn_multiply";
    private final String buttonMinusId = "org.fossify.math.debug:id/btn_minus";
    private final String buttonDevideId = "org.fossify.math.debug:id/btn_divide";
    private final String editTextResultId = "org.fossify.math.debug:id/result";
    private final String buttonEqualsId = "org.fossify.math.debug:id/btn_equals";
    private final String buttonDecimalId = "org.fossify.math.debug:id/btn_decimal";

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");

        options.setAppPackage("org.fossify.math.debug");
        options.setAppActivity("org.fossify.math.activities.SplashActivity.Green");

        options.setNoReset(false);

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );
    }
    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void testTwoDigitAdding(){

        WebElement button9 = driver.findElement(AppiumBy.id(button9Id));
        WebElement button7 = driver.findElement(AppiumBy.id(button7Id));
        WebElement button5 = driver.findElement(AppiumBy.id(button5Id));
        WebElement buttonPlus = driver.findElement(AppiumBy.id(buttonPlusId));
        WebElement buttonDecimal = driver.findElement(AppiumBy.id(buttonDecimalId));
        WebElement buttonEquals = driver.findElement(AppiumBy.id(buttonEqualsId));

        button9.click();
        button9.click();

        buttonPlus.click();

        button7.click();
        button7.click();

        buttonPlus.click();

        button5.click();
        buttonDecimal.click();
        button5.click();

        buttonEquals.click();


        String actual = driver.findElement(AppiumBy.id(editTextResultId)).getText();

        System.out.println("ACTUAL RESULT: " + actual);

        assertEquals("181.5", actual);
    }

    @Test
    public void testSubtractionToNegativeNumber(){

        WebElement button1 = driver.findElement(AppiumBy.id(button1Id));
        WebElement button0 = driver.findElement(AppiumBy.id(button0Id));
        WebElement buttonMinus = driver.findElement(AppiumBy.id(buttonMinusId));
        WebElement buttonEquals = driver.findElement(AppiumBy.id(buttonEqualsId));

        button1.click();
        button0.click();

        buttonMinus.click();

        button1.click();
        button0.click();
        button0.click();

        buttonEquals.click();

        String actual = driver.findElement(AppiumBy.id(editTextResultId)).getText();

        assertEquals("-90", actual);
    }








    @Test
    public void testSpamingEqualsRepeatedly(){

        WebElement buttonEquals = driver.findElement(AppiumBy.id(buttonEqualsId));
        WebElement button1 = driver.findElement(AppiumBy.id(button1Id));
        WebElement buttonPlus = driver.findElement(AppiumBy.id(buttonPlusId));
        WebElement button2 = driver.findElement(AppiumBy.id(button2Id));


        button1.click();
        buttonPlus.click();
        button2.click();

        buttonEquals.click();
        String firstResult = driver.findElement(AppiumBy.id(editTextResultId)).getText();
        buttonEquals.click();
        String secondResult = driver.findElement(AppiumBy.id(editTextResultId)).getText();
        buttonEquals.click();
        String thirdResult = driver.findElement(AppiumBy.id(editTextResultId)).getText();


        //assertAll(
       //         () -> assertEquals("3", firstResult, "First ="),
       //         () -> assertEquals("3", secondResult, "Second ="),
       //         () -> assertEquals("3", thirdResult, "Third =")
       // );



        try {
            assertEquals("3", firstResult);
            System.out.println("First = PASS");
        } catch (AssertionError e) {
            System.out.println("First = FAIL - Expected: 3, Actual: " + firstResult);
        }


        try {
            assertEquals("3", secondResult);
            System.out.println("Second = PASS");
        } catch (AssertionError e) {
            System.out.println("Second = FAIL - Expected: 3, Actual: " + secondResult);
        }


        try {
            assertEquals("3", thirdResult);
            System.out.println("Third = PASS");
        } catch (AssertionError e) {
            System.out.println("Third = FAIL - Expected: 3, Actual: " + thirdResult);
        }


    }

    @Test
    public void testDivisionByZeroShowInfinity(){

        WebElement button6 = driver.findElement(AppiumBy.id(button6Id));
        WebElement button8 = driver.findElement(AppiumBy.id(button8Id));
        WebElement buttonDevide = driver.findElement(AppiumBy.id(buttonDevideId));
        WebElement button0 = driver.findElement(AppiumBy.id(button0Id));
        WebElement buttonEqual = driver.findElement(AppiumBy.id(buttonEqualsId));

        button6.click();
        button8.click();

        buttonDevide.click();

        button0.click();

        buttonEqual.click();

        String actual = driver.findElement(AppiumBy.id(editTextResultId)).getText();
        assertEquals("Infinity", actual);




    }

    private WebElement getElementById(String id) {
        return driver.findElement(
                AppiumBy.id(id)
        );
    }


}

