package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Sample4Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void enterNumber() throws Exception {


        //         TODO:
//        enter a number under "Number"
//        check that button is not clickable "Clear Result"
//        check that text is not displayed
//        click on "Result" button
//        check that text is displayed
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
//        check that the button "Clear Result" is clickable now
//        click on "Clear Result"
//        check that the text is still (""), but it is not displayed

        WebElement numberInput = driver.findElement(By.id("number"));
        String origNumber = "10";

        numberInput.clear();

        numberInput.sendKeys(origNumber);

        assertEquals(numberInput.getText(), "");
        assertEquals(numberInput.getAttribute("value"), origNumber);

        WebElement clearButton = driver.findElement(By.id("clear_result_button_number"));
        assertFalse(clearButton.isEnabled()); //

        WebElement text = driver.findElement(By.id("result_number"));
        assertFalse(text.isDisplayed());

        WebElement resNumber = driver.findElement(By.id("result_button_number"));
        // assertFalse(resNumber.isEnabled());

        resNumber.click();
        assertTrue(text.isDisplayed());
        assertEquals(text.getText(), ("You entered number: " + "\"" + origNumber + "\""));

        assertTrue(clearButton.isEnabled());

        clearButton.click();
        assertEquals(text.getText(), "");
        assertFalse(text.isDisplayed());
    }

    @Test
    public void clickOnLink() throws Exception {
        //         TODO:
//        check current url is base_url
//        click on "This is a link to Homepage"
//        check that current url is not base_url
//        verify that current url is homepage
        assertEquals(base_url, driver.getCurrentUrl());
        driver.findElement(By.id("homepage_link")).click();
        assertFalse(driver.getCurrentUrl().equals(base_url));
        assertEquals("https://kristinek.github.io/site/", driver.getCurrentUrl());
    }
}
