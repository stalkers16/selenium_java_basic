package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample6Task {
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
    public void findElementByXPath() throws Exception {
//         TODO:
//        2 ways to find text: "Heading 2 text":
        System.out.println("The Heading 2 text is: " + driver.findElement(By.id("heading_2")).getText());
        System.out.println("The Heading 2 text is: " + driver.findElement(By.xpath("//h2[@id='heading_2']")).getText());
//        1-2 ways to find text: "Test Text 1"
        System.out.println("The Test text 1 is: " + driver.findElement(By.xpath("//p[contains(text(),'Test Text 1')]")).getText());

//        1-2 ways to find text: "Test Text 2"
        System.out.println("The Test text 2 is: " + driver.findElement(By.xpath("//p[contains(text(),'Test Text 2')]")).getText());

//        1-2 ways to find text: "Test Text 3"
        System.out.println("The Test text 3 is: " + driver.findElement(By.xpath("//p[contains(text(),'Test Text 3')]")).getText());

//        1-2 ways to find text: "Test Text 4"
        System.out.println("The Test text 4 is: " + driver.findElement(By.xpath("//p[contains(text(),'Test Text 4')]")).getText());

//        1-2 ways to find text: "Test Text 5"
        System.out.println("The Test text 5 is: " + driver.findElement(By.xpath("//p[contains(text(),'Test Text 5')]")).getText());

//        1-2 ways to find text: "This is also a button"
        System.out.println("\t value of element with name 'randomButton1' is '" +
                driver.findElement(By.xpath("//*[@name='randomButton2']")).getAttribute("value") + "'");
    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
        System.out.println("\t text of element with value 'Heading 2 text: '" +
                driver.findElement(By.cssSelector("#heading_2")).getText() + "'");
//        1-2 ways to find text: "Test Text 1"
        System.out.println("\t The Test text 1 is: "
                + driver.findElement(By.cssSelector("#test1")).getText());
//        1-2 ways to find text: "Test Text 2"
        System.out.println("The Test text 2 is: "
                +  driver.findElement(By.cssSelector("#test2")).getText());
//        1-2 ways to find text: "Test Text 3"
        System.out.println("The Test text 3 is: "
                + driver.findElement(By.cssSelector("#test3")).getText());
        //        1-2 ways to find text: "This is also a button"
        System.out.println("The Test text 3 is: "
                + driver.findElement(By.cssSelector("#buttonId")).getText());
    }
}
