package Páginas;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PaginaCadastroParte2 extends PaginaBase {
    public PaginaCadastroParte2(WebDriver navegador) {
        super(navegador);
    }
    public PaginaCadastroParte3 fazCadastroP2(){

        
        navegador.findElement(By.cssSelector("span#tabviewpf\\:formdocumentos\\:dataEmissao  img[alt='...']")).click();
        Select selectYear = new Select(navegador.findElement(By.cssSelector(".ui-datepicker-year")));
        selectYear.selectByValue("2004");
        navegador.findElement(By.cssSelector(".ui-datepicker-month")).click();
        Select selectMonth = new Select(navegador.findElement(By.cssSelector(".ui-datepicker-month")));
        selectMonth.selectByValue("3");
        navegador.findElement(By.className("ui-datepicker-calendar")).findElement(By.linkText("9")).click();

        // Upload de arquivo
        navegador.findElement(By.id("tabviewpf:formdocumentos:j_idt288_input"))
                .sendKeys("D:\\Desktop\\Evidencias\\4-5-0\\Query.png", "u '\\ ue007'");

    return new PaginaCadastroParte3(navegador);
    }

}
