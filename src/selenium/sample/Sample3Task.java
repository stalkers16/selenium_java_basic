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
    String value;

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
        value = driver.findElement(By.id("buttonId")).getAttribute("value");


    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void assertEqualsTask() throws Exception {
        System.out.println(value);

        int a = driver.findElements(By.className("test")).size();
        assertEquals(5,a);

        assertEquals(value, "This is also a button");
//         TODO:
//         check how many element with class "test" there are on page (5)
//         check that value of second button is "This is also a button"
    }

    @Test
    public void assertTrueTask() throws Exception {
        assertTrue(value.equalsIgnoreCase("this is Also a Button"));
//         TODO:
//         check that it is True that value of second button is
//         "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
    }

    @Test
    public void assertFalseTask() throws Exception {
        assertFalse(value.equals("This is a button"));
//         TODO:
//        check that it is False that value of second button is "This is a button"
    }

    @Test
    public void failTask() throws Exception {
        List<WebElement> allElementsWithClass = driver.findElements(By.className("test"));
        int a = 190;
        for (WebElement elementWithClass : allElementsWithClass){
            assertFalse(allElementsWithClass.contains("190"));
            assertFalse(allElementsWithClass.contains(a));

        }

//        TODO:
//        check that none of items with class "test"
//        contain number 190
    }
}
