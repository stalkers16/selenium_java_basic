package selenium.sample;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        //        TODO:
        //       define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //       start & open driver
        driver.get("https://kristinek.github.io/site/index2.html");
        //driver.findElement(By.id("header"));
        System.out.println(driver.findElement(By.id("header")));
        System.out.println(driver.getCurrentUrl()); //get URL of page
        //        System.out.println(driver.getCurrentUrl()); //get URL of page
        driver.quit(); //stop & close driver


//         go to https://kristinek.github.io/site/index2.html
//         get title of page
//         get URL of current page
//         close browser
    }
}
