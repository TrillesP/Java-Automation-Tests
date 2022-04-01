package ml;


import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.junit.*;


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
            print();
            Assert.assertEquals("Smartphone",driver.findElement(By.cssSelector("h1.ui-search-breadcrumb__title")).getText());
        }

}