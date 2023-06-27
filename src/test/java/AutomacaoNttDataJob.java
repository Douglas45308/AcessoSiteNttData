import io.cucumber.java.pt.Dado;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AutomacaoNttDataJob {
    private String job = "Pessoa Engenheira de Dados - Híbrido";
    private String nttDataBrasil = "//h3[contains(.,'NTT DATA: Global IT Services Provider & Consultant')]";
    private WebDriver driver;
    private Map<String, Object> vars;

    @Test
    public void acessarGoogle() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com.br/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.id("APjFqb")).sendKeys("ntt data Brasil");
        driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
        //driver.findElement(By.cssSelector("#rso > .MjjYud:nth-child(1) .LC20lb")).click();
        driver.findElement(By.xpath(nttDataBrasil)).click();
        driver.findElement(By.xpath("//a[contains(text(),'Careers')]")).click();
        System.out.println("CLICOU EM CAREES");
        driver.findElement(By.linkText("Job opportunities")).click();
        System.out.println("CLICOU EM JOBS");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera até 10 segundos
        Thread.sleep(5000);
        Assert.assertEquals("Global IT Services Provider & Consultant | NTT DATA", driver.getTitle());
        System.out.println("TÍTULO DA PÁGINA ENCONTRADO COM SUCESSO!");
        driver.switchTo().frame("ifrmCookieBanner");
        System.out.println("ENTROU NO FRAME");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("//button[@class='intro-banner-btn save-consents evSpAcceptBtn'][contains(.,'Accept')].click()");
        Thread.sleep(5000);
        driver.findElement(By.id("banner-0")).click();

    }
    @After
    public void fecharNavagador() {
        driver.quit();
    }

}