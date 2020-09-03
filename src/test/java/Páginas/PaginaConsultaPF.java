//Este teste destina-se ao preenchimento da tela de cadastro de pessoa fisica no menu Consultas.
package Páginas;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;


public class PaginaConsultaPF extends PaginaBase {
    public PaginaConsultaPF(WebDriver navegador) {
        super(navegador);
    }
    public PaginaCadastroParte2 fazCadastroPF(String cpf, String nome, String email, String mae, String cidade ){
        //navega ate a pagina de cadastro de pessoa fisica
        navegador.findElement(By.cssSelector("td:nth-of-type(2) > button[role='button'] > .ui-button-text")).click();
        navegador.findElement(By.cssSelector("input#tabviewpf\\:formpesquisacpf\\:cpf")).click();
        navegador.findElement(By.cssSelector("input#tabviewpf\\:formpesquisacpf\\:cpf")).sendKeys(cpf);
        navegador.findElement(By.cssSelector("[title='Consultar']")).click();

                    //preenche o nome da pessoa se o input estiver visivel
                 try{
                    navegador.findElement(By.name("tabviewpf:formpessoafisica:nomepessoafisica")).click();
                  //  return !element.isDisplayed();
                }catch (StaleElementReferenceException elementHasDisappeared){
                     navegador.findElement(By.name("tabviewpf:formpessoafisica:nomepessoafisica")).sendKeys(nome);
                }

        // seleciona ano
        navegador.findElement(By.cssSelector(".ui-datepicker-trigger > img[alt='...']")).click();
        Select selectYear = new Select(navegador.findElement(By.cssSelector(".ui-datepicker-year")));
        selectYear.selectByValue("1999");

        // seleciona mes e dia
        navegador.findElement(By.cssSelector(".ui-datepicker-month")).click();
        Select selectMonth = new Select(navegador.findElement(By.cssSelector(".ui-datepicker-month")));
        selectMonth.selectByValue("2");
        navegador.findElement(By.className("ui-datepicker-calendar")).findElement(By.linkText("9")).click();

        //preenche os inputs e-mail, nome da mae e cidade
        navegador.findElement(By.id("tabviewpf:formpessoafisica:j_idt231")).sendKeys(email);
        navegador.findElement(By.id("tabviewpf:formpessoafisica:j_idt232")).sendKeys(mae);
        navegador.findElement(By.id("tabviewpf:formpessoafisica:naturalidadePF")).sendKeys(cidade);

        // seleciona pais
        Select selectPais = new Select(navegador.findElement(By.id("tabviewpf:formpessoafisica:idcombopais")));
        selectPais.selectByValue("1");

        //Botões salvar, aguardar pagina e avançar
        navegador.findElement(By.cssSelector("span > button:nth-of-type(2)")).click();
        navegador.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        //navegador.getWindowHandle().contains("Inclusão efetuada com sucesso!");
        Assert.assertEquals("Inclusão efetuada com sucesso!", navegador.findElement(By.cssSelector(".ui-growl-message")));
        navegador.findElement(By.xpath("//form[@id='form_avancar']//button[@role='button']/span[@class='ui-button-text']")).click();

        //SEGUNDA ABA = DOCUMENTOS
        // btn Incluir documento
        navegador.findElement(By.cssSelector("a#tabviewpf\\:formExpandirDoc\\:linkDialogTelefone")).click();
        navegador.findElement(By.cssSelector("div#tabviewpf\\:formdocumentos\\:dialogdocumentos > .ui-dialog-content.ui-widget-content")).isDisplayed();
        Assert.assertEquals("Documento",navegador.findElement(By.cssSelector("div#tabviewpf\\:formdocumentos\\:dialogdocumentos  .ui-dialog-title")));

        //Seleciona tipo de documento
        Select selectType = new Select(navegador.findElement(By.id("tabviewpf:formdocumentos:tipoDocumento")));
        selectType.selectByValue("1");
        //Numero do documento
        navegador.findElement(By.id("tabviewpf:formdocumentos:numDocumento")).sendKeys("123456");
        //Orgao emissor
        Select selectOrg = new Select(navegador.findElement(By.id("tabviewpf:formdocumentos:orgaoEmissor")));
        selectOrg.selectByValue("30");
        //UF
        Select ufOrgaoEmissor = new Select(navegador.findElement(By.id("tabviewpf:formdocumentos:uforgaoemissor")));
        ufOrgaoEmissor.selectByValue("2");
        //Data de emissao ano mes e dia
        navegador.findElement(By.id("tabviewpf:formdocumentos:dataEmissao")).findElement(By.cssSelector("span#tabviewpf\\:formdocumentos\\:dataEmissao  img[alt='...']"))
                .click();
        Select selectAno = new Select(navegador.findElement(By.cssSelector(".ui-datepicker-year")));
        selectAno.selectByValue("1999");
        navegador.findElement(By.cssSelector(".ui-datepicker-month")).click();
        Select selectMes = new Select(navegador.findElement(By.cssSelector(".ui-datepicker-month")));
        selectMes.selectByValue("2");
        navegador.findElement(By.className("ui-state-default")).findElement(By.linkText("9")).click();
        //data validade

        navegador.findElement(By.id("tabviewpf:formdocumentos:dataValidade")).findElement(By.cssSelector("span#tabviewpf\\:formdocumentos\\:dataValidade  img[alt='...']"))
                .click();
        Select selectAnoVal = new Select(navegador.findElement(By.cssSelector(".ui-datepicker-year")));
        selectAnoVal.selectByValue("1999");
        navegador.findElement(By.cssSelector(".ui-datepicker-month")).click();
        Select selectMesVal = new Select(navegador.findElement(By.cssSelector(".ui-datepicker-month")));
        selectMesVal.selectByValue("2");
        navegador.findElement(By.className("ui-state-default")).findElement(By.linkText("9")).click();

        // seleciona ano






        return new PaginaCadastroParte2(navegador);
    }
}
