package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class InformacoesUsuarioTest {
    private WebDriver navegador;

    @Before
    public void setUp() {
        // Abrindo Navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Driver\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // navegando para a página do Task!
        navegador.get("http://www.juliodelima.com.br/taskit");
    }


    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
        // Clicar no link que possui o texto "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();

        // Identificado o formulário de login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        // Digitar no campo name "login" que está dentro do formulario de id "signinbox" o texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        // Digitar no campo name "password" que está dentro do formulario de id "signinbox" o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        // Clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        // Validar que dentro do elemento class "me" está do texto "Hi, Julio"
        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();
        assertEquals("Hi, Julio", textoNoElementoMe);

    }
    @After
    public void tearDown(){
        // Fechar o navegador
        navegador.quit();
    }

}
