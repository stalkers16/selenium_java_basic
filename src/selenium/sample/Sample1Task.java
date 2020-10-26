package selenium.sample;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {

     System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
     WebDriver drive = new ChromeDriver();

     drive.get("https://kristinek.github.io/site/index2.html");

     System.out.println(drive.getTitle());
     System.out.println(drive.getCurrentUrl());

     drive.quit();
    }
}
