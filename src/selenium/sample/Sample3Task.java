package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;

public class Sample3Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void assertEqualsTask() throws Exception {
//         TODO:
        int actualNumberOfElements = driver.findElements(By.className("test")).size();
        int expectedNumberOfElements = 5;
        assertEquals(actualNumberOfElements, expectedNumberOfElements);
//         check how many element with class "test" there are on page (5)

        String actualButtonValue = driver.findElement(By.name("randomButton2")).getAttribute("value");
        String expectedButtonValue = "This is also a button";
        assertEquals(actualButtonValue, expectedButtonValue);
//         check that value of second button is "This is also a button"
    }

    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
        try {
            String actualButtonValue = driver.findElement(By.name("randomButton2")).getAttribute("value");
            String expectedButtonValue = "this is Also a Button";
            assertTrue(actualButtonValue.equalsIgnoreCase(expectedButtonValue));
        } catch (AssertionError e) {
            fail("fail with custom error message");
        }
//         check that it is True that value of second button is
//         "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:

    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
        String actualButtonValue = driver.findElement(By.name("randomButton2")).getAttribute("value");
        String expectedButtonValue = "This is a button";
        assertFalse(actualButtonValue.equals(expectedButtonValue));
//        check that it is False that value of second button is "This is a button"
    }

    @Test
    public void failTask() throws Exception {
//        TODO:
        int numberOfTests = driver.findElements(By.className("test")).size();
        String unwantedNumber = "190";

        for (int i = 0; i < numberOfTests; i ++) {
            String testText = driver.findElements(By.className("test")).get(i).getText();
            assertFalse(testText.contains(unwantedNumber));
        }

//        check that none of items with class "test"
//        contain number 190
    }
}
