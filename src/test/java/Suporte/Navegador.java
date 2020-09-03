package Suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Navegador {

    public static WebDriver createChrome() {
        //Abrindo navegador
        System.setProperty("webdriver.chrome.driver", "C:/Users/Yasmin/IdeaProjects/Seia/chromedriver.exe");
        WebDriver navegador  = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        // Navegando para a pagina
        navegador.get("http://10.90.2.65");
        return navegador;
    }
    public static final String USERNAME = "juliaguimaraes1";
    public static final String AUTOMATE_KEY = "2py4qJzMSr8yjmh5eTWq";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createBrowserStack(){
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("browser", "Firefox");
        caps.setCapability("browser_version", "65.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1280x800");
        caps.setCapability("name", "juliaguimaraes1's First Test");

        WebDriver navegador = null;
        try {
            navegador = new RemoteWebDriver(new URL(URL), caps);
           // navegador.manage().timeouts().implicitlyWait(120000, TimeUnit.SECONDS);
            navegador.get("http://www.google.com/");
        } catch (MalformedURLException e) {
            System.out.println("Erro na URL"+e.getMessage());
        }
        return navegador;
    }
}
