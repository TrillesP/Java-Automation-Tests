package ml;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import common.Evidencias;
import common.Logs;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.time.temporal.ChronoUnit.SECONDS;


public class Usuario {
        public String url;
        public WebDriver driver;

        Logs logs;
        Evidencias evidencias;
        static String dataHora = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());

        @Before
        public void iniciar(){
            url = "https://www.mercadolivre.com.br";
            System.setProperty("webdriver.chrome.driver", "drivers/chrome/100/chromedriver.exe");
            driver = new ChromeDriver();
            evidencias = new Evidencias();
            logs = new Logs();
        }

        @After
        public void finalizar(){
            driver.quit();
        }

        @Test
        public void buscar() throws IOException {
            String casoDeTeste = "Pesquisa Mercado Livre";
            String dataLog = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());
            logs.registrarCabecalho(dataLog);
            driver.navigate().to(url);
            logs.registrarCSV(casoDeTeste, "Abriu navegador.");
            driver.findElement(By.name("as_word")).clear();
            driver.findElement(By.name("as_word")).sendKeys("smartphone");
            logs.registrarCSV(casoDeTeste, "Digitou pesquisa.");
            evidencias.print(driver,dataHora,casoDeTeste, "Digitou pesquisa");
            driver.findElement(By.cssSelector("button.nav-search-btn")).click();
            logs.registrarCSV(casoDeTeste, "Clicou na lupa.");
            WebDriverWait wait = new WebDriverWait(driver, Duration.of(3,SECONDS));
            try {
                wait.until(ExpectedConditions.titleContains("Smartphone"));
            } catch(TimeoutException ex) {
                Assert.fail("Demorou mais de 3 segundos pra carregar a página.");
            }
            evidencias.print(driver,dataHora,casoDeTeste, "Pesquisa realizada");
            logs.registrarCSV(casoDeTeste, "Carregou a página.");
            Assert.assertEquals("Smartphone",driver.findElement(By.cssSelector("h1.ui-search-breadcrumb__title")).getText());
            logs.registrarCSV(casoDeTeste, "Confirmou pesquisa de Smartphones.");
            String frase = "128 GB";
            if (driver.findElement(By.partialLinkText("Samsung Galaxy A52")).getText().contains(frase))
            {
                System.out.println("Achou.");
                logs.registrarCSV(casoDeTeste, "Achou Samsung Galaxy A52 de 128GB");
            }
            else{
                System.out.println("Erro.");
                logs.registrarCSV(casoDeTeste, "Não achou o celular.");
            }
        }


}