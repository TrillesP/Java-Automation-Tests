package stepsPO;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks {

    WebDriver driver;
    WebDriverWait wait;


    @Before
    public void iniciar() {
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/100/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofMillis(1));
        System.out.println("1o - primeiro passo sempre.");
    }

    @After
    public void finalizar(){

        System.out.println("xo - ultimo passo sempre.");
        driver.quit();
    }
}
