package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cursos {
    WebDriver driver;
    //1 - mapeamento de elementos da página
    @FindBy(id = "auto_2")
    WebElement caixaDePesquisa;

    //2 - construtor

    public Cursos(WebDriver driver) {
        this.driver = driver;
    }
    //3 - funcoes e metodos
    public void pesquisarPorCurso (String curso){
        caixaDePesquisa.clear();
        caixaDePesquisa.sendKeys(curso);
    }

}
