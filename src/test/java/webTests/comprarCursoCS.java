package webTests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class comprarCursoCS {

    WebDriver driver;
    WebDriverWait wait;


    @Before
    public void iniciar() {
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/100/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofMillis(1));
    }


    @Given("^I access Iterasys website$")
    public void i_access_Iterasys_website() {
        driver.navigate().to("https://iterasys.com.br/pt/cursos");
        System.out.println("1 - Acessou o site.");
    }

    @When("^I search for \"([^\"]*)\" and click on search button$")
    public void i_search_for_and_click_on_search_button(String curso) {
        wait.until(driver -> driver.findElement(By.cssSelector("h3.content-card-name")));
        driver.findElement(By.id("auto-2")).click();
        driver.findElement(By.id("auto-2")).clear();
        driver.findElement(By.id("auto-2")).sendKeys(curso);
        System.out.println("2 - Escreveu o curso e clicou na lupa.");
    }

    @When("^move the mouse to button to load more and click$")
    public void move_the_mouse_to_button_to_load_more_and_click() {
        wait.until(driver -> driver.findElement(By.xpath("//span[contains(text(),'Carregar Mais')]")));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Carregar Mais')]"))).perform();
        driver.findElement(By.xpath("//span[contains(text(),'Carregar Mais')]")).click();
        System.out.println("2aa - Moveu e clickou em carregar");
        wait.until(driver -> driver.findElement(By.cssSelector("div.landing main.website-page:nth-child(3) section.content-list.website-component div.container.no-sidebar.divider-NONE div.component-content div.list-content:nth-child(2) main.content-list-main a.no-link-style.content-card:nth-child(14) main:nth-child(2) > h3.content-card-name.variant-primary")));
        WebElement ele = driver.findElement(By.cssSelector("div.landing main.website-page:nth-child(3) section.content-list.website-component div.container.no-sidebar.divider-NONE div.component-content div.list-content:nth-child(2) main.content-list-main a.no-link-style.content-card:nth-child(14) main:nth-child(2) > h3.content-card-name.variant-primary"));
        action.moveToElement(ele).perform();
        ele.click();
        System.out.println("2ab - Moveu o mouse e clickou no curso.");
    }

    @Then("^I see the search results for \"([^\"]*)\"$")
    public void i_see_the_search_results_for(String curso) {
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("h3.content-card-name")),curso));
        System.out.println("3 - Mostrou resultados da pesquisa.");
    }

    @When("^I click on class name")
    public void i_click_on() {
        driver.findElement(By.cssSelector("h3.content-card-name")).click();
        System.out.println("4 - Clicou no nome do curso.");
    }

    @Then("^I confirm the Class' name as \"([^\"]*)\" and it's free$")
    public void i_confirm_the_Class_name_as_and_it_s_free(String nome){
        wait.until(driver -> driver.findElement(By.cssSelector("div.content-price")));
        wait.until(ExpectedConditions.titleContains(nome));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("div.content-price"),"R$ 0,00"));
        System.out.println("3a - Confirmou que o nome da classe é "+nome+" e é grátis.");
    }

    @Then("^I confirm the Class' name as \"([^\"]*)\" and it's price as \"([^\"]*)\"$")
    public void i_confirm_the_Class_name_as_and_it_s_price_as(String nome, String preco) {
        wait.until(driver -> driver.findElement(By.cssSelector("p.content-price-installments-amount")));
        wait.until(ExpectedConditions.titleContains(nome));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("p.content-price-installments-amount"),preco));
        System.out.println("5 - Confirmou que o nome da classe é "+nome+" e o preço é "+preco+".");
    }

    @After
    public void finalizar(){
        driver.quit();
    }
}
