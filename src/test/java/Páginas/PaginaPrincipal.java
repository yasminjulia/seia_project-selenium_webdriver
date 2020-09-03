package Páginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaPrincipal extends PaginaBase {
    public PaginaPrincipal(WebDriver navegador) {
        super(navegador);
    }
    public PaginaConsultaPF fazConsulta(){
        navegador.findElement(By.linkText("Consultas")).click();
        navegador.findElement(By.linkText("Pessoa Física")).click();

        return new PaginaConsultaPF(navegador);
    }

}
