package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cursos {
    WebDriver driver;
    //1 - mapeamento de elementos da página
    @FindBy(how = How.ID, using = "auto-2")
    WebElement caixaDePesquisa;
    WebDriverWait wait;

    //2 - construtor

    public Cursos(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //3 - funcoes e metodos
    public void visitCursos (){
        driver.get("https://iterasys.com.br/pt/cursos");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofMillis(1));
        wait.until(driver -> driver.findElement(By.cssSelector("h3.content-card-name")));
    }
    public boolean verificarCurso(String curso){
        return wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("h3.content-card-name")),curso));
    }
    public void pesquisarPorCurso (String curso){
        caixaDePesquisa.clear();
        caixaDePesquisa.sendKeys(curso);
    }
    public void clicarCurso() {
        driver.findElement(By.cssSelector("h3.content-card-name")).click();
        wait.until(driver -> driver.findElement(By.cssSelector("p.content-price-installments-amount")));
    }

}
