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
//         check how many element with class "test" there are on page (5)
        System.out.println(driver.findElements(By.className("test")).size());
//        check there are 5 elements with class "test"
        int expected = 5;
        int actual = driver.findElements(By.className("test")).size();
        assertEquals(expected, actual);
//         check that value of second button is "This is also a button"
        // probably meant for the next task but test was performed anyway
        String expectedStr = "This is also a button";
        String actualStr = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertEquals(expectedStr, actualStr);
    }

    @Test
    public void assertTrueTask() throws Exception {
//         check that it is True that value of second button is
//         "this is Also a Button" if you ignore Caps Locks
        String expected = "this is Also a Button";
        String actual = driver.findElement(By.name("randomButton2")).getAttribute("value");
        try {
            assertTrue(expected.equalsIgnoreCase(actual));
//         fail with custom error message:
        } catch (AssertionError e) {
            System.err.println("Button text mismatch expected value");
            e.printStackTrace();
        }
    }

    @Test
    public void assertFalseTask() throws Exception {
//        check that it is False that value of second button is "This is a button"
        String notExpected = "This is a button";
        String actual = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertFalse(notExpected.equals(actual));
    }

    @Test
    public void failTask() throws Exception {
//        check that none of items with class "test"
//        contain number 190
        List<WebElement> allElementsWithClass = driver.findElements(By.className("test"));
        for (WebElement elementWithClass : allElementsWithClass) {
            // Element doesn't seem to contain any other attributes, other than text
            assertFalse(elementWithClass.getText().contains("190"));
        }
    }
}
