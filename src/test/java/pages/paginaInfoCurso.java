package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paginaInfoCurso {
    WebDriver driver;

    //1 - mapeamento de elementos da página
    @FindBy(css = "p.content-price-installments-amount")
    WebElement indicadorPreco;


    //2 - construtor

    public paginaInfoCurso(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String checarPreco(){
        return indicadorPreco.getText();
    }
    public String verTitulo() {
        return driver.getTitle();
    }
}
