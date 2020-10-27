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

        // TODO:
        // check how many element with class "test" there are on page (5)
        int expected = 5;
        int real = (driver.findElements(By.className("test")).size());
        assertEquals(expected, real);

        //  check that value of second button is "This is also a button"
        String expected2 = "This is also a button";
        String real2 = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertEquals(expected2, real2);

    }

    @Test
    public void assertTrueTask() throws Exception {

//         TODO:
//         check that it is True that value of second button is
//         "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
        String expected = "this is Also a Button";
        String real = driver.findElement(By.id("buttonId")).getAttribute("value");
        assertEquals(expected.toLowerCase(), real);
        fail("I want this test to fail, so it did!");
    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
//        check that it is False that value of second button is "This is a button"
        String expected = "This is a button";
        String real = (driver.findElement(By.name("randomButton2")).getAttribute("value"));
        assertEquals(expected, real);
        fail("Condition is False");
    }

    @Test
    public void failTask() throws Exception {

        int flag = 0;
        List<WebElement> allElementsWithClass = driver.findElements(By.className("test"));
        for (WebElement elementWithClass : allElementsWithClass) {
            String elem = elementWithClass.getText();
            if (elem == "190") {
                flag++;
            }
        }
        assert (flag == 0);
        fail("There are elements, which consist string 190");
    }
}
   // https://kristinek.github.io/site/examples/actions
        //        TODO:
//        check that none of items with class "test"
//        contain number 190
