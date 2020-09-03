package Páginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PaginaLogin extends PaginaBase{
    public PaginaLogin(WebDriver navegador) {

        super(navegador);
    }

    public PaginaPrincipal fazLogin(String login, String senha){

        navegador.findElement(By.xpath("//div[@id='_dialogAlertaIndex']//a[@href='#']/span[@class='ui-icon ui-icon-closethick']")).click();
        navegador.findElement(By.id("j_idt220_content")).findElement(By.id("j_username")).sendKeys(login);
        navegador.findElement(By.id("j_idt220_content")).findElement(By.id("j_password")).sendKeys(senha);
        navegador.findElement(By.id("j_idt220_content")).findElement(By.cssSelector(".buttonLogin")).click();


            /*navegador.findElement(By.cssSelector("div > center:nth-of-type(1)")).isDisplayed();
            navegador.findElement(By.xpath("//div[@id='_dialogAlertaIndex']//a[@href='#']/span[@class='ui-icon ui-icon-closethick']")).click();
            navegador.findElement(By.id("j_idt220_content")).findElement(By.id("j_username")).sendKeys(login);
            navegador.findElement(By.id("j_idt220_content")).findElement(By.id("j_password")).sendKeys(senha);
            navegador.findElement(By.id("j_idt220_content")).findElement(By.cssSelector(".buttonLogin")).click();

            navegador.findElement((By.cssSelector("#recaptcha-anchor [role='presentation']:nth-of-type(1)"))).click();*/




        return new PaginaPrincipal(navegador);
    }

    }
