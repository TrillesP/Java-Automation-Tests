package stepsPO;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.Cursos;
import pages.paginaInfoCurso;

import java.time.Duration;
import java.util.Objects;

public class comprarCursoPO {
    WebDriver driver;
    WebDriverWait wait;
    Cursos cursos;
    paginaInfoCurso resultado;

    @Before
    public void iniciar() {
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/100/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        cursos = new Cursos(driver);
        resultado = new paginaInfoCurso(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofMillis(1));
        System.out.println("1o - primeiro passo sempre.");
    }

    @After
    public void finalizar(){
        System.out.println("xo - ultimo passo sempre.");
        driver.quit();
    }


    @Given("^I access Iterasys website PO$")
    public void iAccessIterasysWebsitePO() {
        cursos.visitCursos();
        System.out.println("passo 1");
    }

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchForAndClickOnSearchButtonPO(String curso) {
        cursos.pesquisarPorCurso(curso);
        System.out.println("passo 2");
    }

    @Then("^I see the search results for \"([^\"]*)\" PO$")
    public void iSeeTheSearchResultsForPO(String curso) {
        Assert.assertTrue(cursos.verificarCurso(curso));
        System.out.println("passo 3");
    }

    @When("^I click on class name PO$")
    public void iClickOnClassNamePO() {
        cursos.clicarCurso();
        System.out.println("passo 4");
    }

    @Then("^I confirm the Class' name as \"([^\"]*)\" and it's price as \"([^\"]*)\" PO$")
    public void iConfirmTheClassNameAsAndItSPriceAsPO(String nome, String preco) {
        Assert.assertEquals(resultado.checarPreco(),preco);
        Assert.assertTrue(resultado.verTitulo().contains(nome));
        System.out.println("passo 5");
    }
}
