package selenium.sample;

import javafx.scene.control.Alert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Sample5Task {
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
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");

    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void goToAlertedPageViaButton() throws Exception {
//         TODO:
//        click on "To go to alerted page press Ok. Or stay here" button
        org.openqa.selenium.Alert alert;
        driver.findElement(By.xpath("//button[contains(text(),'To go to alerted page press Ok')]")).click();
//        switch to alert

        alert = driver.switchTo().alert();

//        click ok
        alert.accept ();

//        switch to second alert
        driver.switchTo().alert();


//        verify alert text
        assertEquals("Booooooooo!", alert.getText());


//        click ok on second alert
        alert.accept ();

//        verify that the correct page is opened
        assertEquals("https://kristinek.github.io/site/examples/alerted_page", driver.getCurrentUrl());
    }

    @Test
    public void doNotGoToAlertedPageViaButton() throws Exception {
//         TODO:
//        click on "To go to alerted page press Ok. Or stay here" button
        org.openqa.selenium.Alert alert = null;
        driver.findElement(By.xpath("//button[contains(text(),'To go to alerted page press Ok')]")).click();

//        switch to alert
        driver.switchTo().alert();

//        click cancel
        alert.dismiss ();
        Thread.sleep(4000);
//        verify the text on page
        String expected =  "So you desided to say? Good!";
        String real = driver.findElement(By.xpath("//p[@id='textForAlerts']")).getText();
        assertEquals(expected, real );
    }
}
