package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Sample9Task {
    WebDriver driver;
    private static WebDriverWait wait;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");

        driver = new ChromeDriver();
        wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);

        driver.get("https://kristinek.github.io/site/examples/loading_color");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void loadGreenSleep() throws Exception {
//         TODO:
//         * 1) click on start loading green button
        driver.findElement(By.id("start_green")).click();
//         * 2) check that button does not appear,
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
//         * but loading text is seen instead   "Loading green..."
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());
        assertEquals("Loading green...",driver.findElement(By.id("loading_green")).getText());
//         * 3) check that both button
//         * and loading text is not seen,
        Thread.sleep(10000);
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());

//         * success is seen instead "Green Loaded"
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("loading_green"))));

        assertTrue(driver.findElement(By.id("finish_green")).isDisplayed());
        assertEquals("Green Loaded",driver.findElement(By.id("finish_green")).getText());
    }

    @Test
    public void loadGreenExplicit() throws Exception {
//         TODO:
        //         * 1) click on start loading green button
        driver.findElement(By.id("start_green")).click();
//         * 2) check that button does not appear,
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
//         * but loading text is seen instead   "Loading green..."
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());
        assertEquals("Loading green...",driver.findElement(By.id("loading_green")).getText());
//         * 3) check that both button
//         * and loading text is not seen,
        Thread.sleep(10000);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("loading_green"))));
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());

//         * success is seen instead "Green Loaded"
        // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("loading_green"))));

        assertTrue(driver.findElement(By.id("finish_green")).isDisplayed());
        assertEquals("Green Loaded",driver.findElement(By.id("finish_green")).getText());

//         * 1) click on start loading green button
        driver.findElement(By.id("start_green")).click();
//         * 2) check that button does not appear,
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
//         * but loading text is seen instead   "Loading green..."
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());
//        * 3) check that both button
//         * and loading text is not seen,
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("loading_green"))));
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertEquals("Loading green...",driver.findElement(By.id("loading_green")).getText());
//      * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"


        assertTrue(driver.findElement(By.id("finish_green")).isDisplayed());
        assertEquals("Green Loaded",driver.findElement(By.id("finish_green")).getText());
    }

    @Test
    public void loadGreenImplicit() throws Exception {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//         TODO:
//         * 1) click on start loading green button
        driver.findElement(By.id("start_green")).click();

//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());
        assertEquals("Loading green...", driver.findElement(By.id("loading_green")).getText());

//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
        assertTrue(driver.findElement(By.id("finish_green")).isDisplayed());
        assertEquals("Green Loader", driver.findElement(By.id("finish_green")).getText());
    }

    @Test
    public void loadGreenAndBlueBonus() {
        /* TODO:
         * 0) wait until button to load green and blue appears
         * 1) click on start loading green and blue button
         * 2) check that button does not appear, but loading text is seen instead for green
         * 3) check that button does not appear, but loading text is seen instead for green and blue
         * 4) check that button and loading green does not appear,
         * 		but loading text is seen instead for blue and success for green is seen
         * 5) check that both button and loading text is not seen, success is seen instead
         */
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("start_green"))));
        //0
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("start_green_and_blue"))));

        driver.findElement(By.id("start_green_and_blue")).click();
        assertFalse(driver.findElement(By.id("start_green_and_blue")).isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green_without_blue")).isDisplayed());
        assertEquals("Loading green...", driver.findElement(By.id("loading_green_without_blue")).getText());

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("loading_green_with_blue"))));
        assertFalse(driver.findElement(By.id("start_green_and_blue")).isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green_without_blue")).isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green_with_blue")).isDisplayed());
        assertEquals("Loading green...", driver.findElement(By.id("loading_green_without_blue")).getText());
        assertEquals("Loading blue...", driver.findElement(By.id("loading_green_with_blue")).getText());

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("loading_blue_without_green"))));
        assertFalse(driver.findElement(By.id("start_green_and_blue")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green_without_blue")).isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green_with_blue")).isDisplayed());
        assertEquals("Loading blue...", driver.findElement(By.id("loading_green_with_blue")).getText());
        assertEquals("Green finished waiting for blue", driver.findElement(By.id("loading_blue_without_green")).getText());


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finish_green_and_blue"))));
        assertFalse(driver.findElement(By.id("start_green_and_blue")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green_without_blue")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green_with_blue")).isDisplayed());
        assertEquals("Green and Blue Loaded", driver.findElement(By.id("finish_green_and_blue")).getText());
    }



}