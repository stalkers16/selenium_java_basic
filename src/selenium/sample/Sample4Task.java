package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;

import static org.junit.Assert.*;

public class Sample4Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";
    String home_page = "https://kristinek.github.io/site/";

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
        String num = "7";
        WebElement numBar = driver.findElement(By.id("number"));
        numBar.click();
        numBar.sendKeys(num);

        Thread.sleep(4000);
        driver.navigate().refresh();

//        check that button is not clickable "Clear Result"

        WebElement clearButton = driver.findElement(By.id("clear_result_button_number"));
        assertFalse(clearButton.isEnabled());

//        check that text is not displayed
        WebElement textField = driver.findElement(By.id("text"));
         String val= textField.getAttribute("value");
         System.out.println(val);
         assertEquals("", val);
         fail("Text is displayed. There must be placeholder instead");
        Thread.sleep(4000);
//        click on "Result" button
        WebElement textResultBtn = driver.findElement(By.id("result_button_text"));
//        check that text is displayed
        assertTrue(textResultBtn.isDisplayed());
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
        assertEquals("You entered number 7", textResultBtn.getText());
//        check that the button "Clear Result" is clickable now
        WebElement clearButtonText = driver.findElement(By.id("clear_result_button_text"));
        assertTrue(clearButtonText.isEnabled());
//        click on "Clear Result"
        clearButtonText.click();

//        check that the text is still (""), but it is not displayed
        assertEquals("",textResultBtn.getText());
        assertFalse(textResultBtn.isDisplayed());
    }

    @Test
    public void clickOnLink() throws Exception {
//         TODO:
//        check current url is base_url
        assertTrue(driver.getCurrentUrl().equals(base_url));
        WebElement hpLink = driver.findElement(By.id("homepage_link"));
//        click on "This is a link to Homepage"
        hpLink.click();
//        check that current url is not base_url
        assertFalse(driver.getCurrentUrl().equals(base_url));
//        verify that current url is homepage
        hpLink.click();
        assertEquals(driver.getCurrentUrl(), home_page);


    }
}
