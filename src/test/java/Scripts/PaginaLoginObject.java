package Scripts;

import Páginas.*;
import Suporte.Navegador;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "PaginaLoginObject.csv")

public class PaginaLoginObject {
    private WebDriver navegador;

    @Before
    public void configuracao() {
        navegador = Navegador.createChrome();
    }

    @Test
    public
    void realizaTest() {
        PaginaPrincipal exe = new PaginaLogin(navegador)
                .fazLogin("farluse.gomes", "@123456");



        PaginaConsultaPF exe2 = new PaginaPrincipal(navegador)
                .fazConsulta();

        PaginaCadastroParte2 exe3 = new PaginaConsultaPF(navegador)
                .fazCadastroPF("47916763001","Teste Automatizado", "testeautomatizado@gmail.com", "Nome da Mãe", "Nome da cidade");
        PaginaCadastroParte3 exe4 = new PaginaCadastroParte2(navegador)
                .fazCadastroP2();

    }
    @After
        public void fechaNavegador () {

            navegador.findElement(By.xpath("//div[@id='login']/form[@name='j_idt34']/table[@class='middle']//a[@title='Sair']")).click();
            navegador.quit();
        }
    }

