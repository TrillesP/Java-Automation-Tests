package ml;


import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.junit.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.temporal.ChronoUnit.SECONDS;


public class Usuario {
        public String url;
        public WebDriver driver;


        public void print() throws Exception {
            TakesScreenshot camera = ((TakesScreenshot) driver);
            File foto = camera.getScreenshotAs(OutputType.FILE);
            File localFoto = new File("C:\\Users\\trill\\Pictures\\print1.png");
            FileUtils.copyFile(foto,localFoto);
        }

        @Before
        public void iniciar(){
            url = "https://www.mercadolivre.com.br";
            System.setProperty("webdriver.chrome.driver", "drivers/chrome/99/chromedriver.exe");
            driver = new ChromeDriver();
        }

        @After
        public void finalizar(){
            driver.quit();
        }

        @Test
        public void buscar() throws Exception {
            driver.navigate().to(url);
            driver.findElement(By.name("as_word")).clear();
            driver.findElement(By.name("as_word")).sendKeys("smartphone");
            driver.findElement(By.cssSelector("button.nav-search-btn")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.of(3,SECONDS));
            try {
                wait.until(ExpectedConditions.titleContains("Smartphone"));
            } catch(TimeoutException ex) {
                Assert.fail("Demorou mais de 3 segundos pra carregar a página.");
            }
            print();
            Assert.assertEquals("Smartphone",driver.findElement(By.cssSelector("h1.ui-search-breadcrumb__title")).getText());
            String frase = "128 GB";
            if (driver.findElement(By.partialLinkText("Samsung Galaxy A52")).getText().contains(frase))
            {
                System.out.println("Achou.");
            }
            else{
                System.out.println("Erro.");
            }
        }


}