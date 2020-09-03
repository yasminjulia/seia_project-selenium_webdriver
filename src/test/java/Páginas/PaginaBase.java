package Páginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class PaginaBase {
    protected WebDriver navegador;
    public PaginaBase(WebDriver navegador){
        this.navegador = navegador;
    }

    public PaginaBase() {

    }

    public WebElement capturarTextToast(){
        navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        navegador.findElement(By.className("ui-icon ui-icon-closethick")).click();
        return (WebElement) navegador;
    }
}
