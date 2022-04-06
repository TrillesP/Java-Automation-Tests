package webTests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class comprarCursoCS {

    WebDriver driver;
    WebDriverWait wait;


    @Before
    public void iniciar() {
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/99/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(5),Duration.ofMillis(1));
    }


    @Given("^I access Iterasys website$")
    public void i_access_Iterasys_website() {
        driver.navigate().to("https://iterasys.com.br/pt/cursos");
        System.out.println("1 - Acessou o site.");
    }

    @When("^I search for \"([^\"]*)\" and click on search button$")
    public void i_search_for_and_click_on_search_button(String curso) throws InterruptedException {
        wait.until(ExpectedConditions.titleContains("Cursos"));
        driver.findElement(By.id("auto-2")).click();
        driver.findElement(By.id("auto-2")).clear();
        Thread.sleep(3000);
        driver.findElement(By.id("auto-2")).sendKeys(curso+ Keys.ENTER);
        System.out.println("2 - Escreveu o curso e clicou na lupa.");
    }

    @Then("^I see the search results for \"([^\"]*)\"$")
    public void i_see_the_search_results_for(String curso) {
        WebElement teste = new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> driver.findElement(By.cssSelector("h3.content-card-name")));
        wait.until(ExpectedConditions.textToBePresentInElement(teste,curso));
        assertThat(teste.getText(), containsString(curso));
        System.out.println("3 - Mostrou resultados da pesquisa.");
    }

    @When("^I click on class name")
    public void i_click_on() {
        driver.findElement(By.cssSelector("h3.content-card-name")).click();
        System.out.println("4 - Clicou no nome do curso.");
    }

    @Then("^I confirm the Class' name as \"([^\"]*)\" and it's price as \"([^\"]*)\"$")
    public void i_confirm_the_Class_name_as_and_it_s_price_as(String nome, String preco) {
        WebElement teste = new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> driver.findElement(By.cssSelector("p.content-price-installments-amount")));
        wait.until(ExpectedConditions.titleContains(nome));
        wait.until(ExpectedConditions.textToBePresentInElement(teste,preco));
        System.out.println("5 - Confirmou que o nome da classe é "+nome+" e o preço é "+preco+".");
    }

    @After
    public void finalizar(){
        driver.quit();
    }
}
