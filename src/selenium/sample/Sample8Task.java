package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Sample8Task {
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
        driver.get("https://kristinek.github.io/site/examples/po");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void styleChecks() throws Exception {
//         TODO:
     //   body:nth-child(2) div.w3-light-grey.w3-padding.w3-margin-bottom.w3-center:nth-child(2) > h1.w3-jumbo
        WebElement backGrnd = driver.findElement(By.className("w3-jumbo"));

//        assertEquals("block", h1.getCssValue("display"));
        assertEquals("rgba(241, 241, 241, 1)", backGrnd.getCssValue("background-color"));
//
       // assertEquals("rgba(241, 241 241, 1)", h1.getCssValue("background-color"));

        WebElement div_h1 = driver.findElement(By.tagName("h1"));
        assertEquals("64px", div_h1.getCssValue("font-size"));

//        check the background of top 2 sections
//        rgba(241, 241, 241, 1);
//        check h1 element font-size 64px
    }
}
