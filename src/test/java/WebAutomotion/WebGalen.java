package WebAutomotion;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;

public class WebGalen {

	private static WebDriver driver;

	@Before
	public void setUpd() {

		// Setando local do driver
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		// Criando Chrome Driver
		driver = new ChromeDriver();
		// Setando o tamanho do browser
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(1024, 768));
		// URL para navegar
		driver.get("http://testapp.galenframework.com/");

	}

	@Test
	public void homePageLayoutTest() throws IOException {

		// Create a layoutReport object
		// checkLayout function checks the layout and returns a LayoutReport object
		LayoutReport layoutReport = Galen.checkLayout(driver, "specs/homepage.gspec", Arrays.asList("desktop"));

		// Criando a lista com GalenTestInfo
		List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

		// Estanciando o objeto do GalenTestInfo
		GalenTestInfo test = GalenTestInfo.fromString("homepage layout");

		// Selecionando com get para check layout
		test.getReport().layout(layoutReport, "check homepage layout");

		// Add test object to the tests list
		tests.add(test);

		// Estanciando o objeto do htmlReportBuilder
		HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

		// Criando reportbuild em target
		htmlReportBuilder.build(tests, "target");

		// If para validar se o layout retornar erros
		if (layoutReport.errors() > 0) {
			Assert.fail("Layout test failed");
		}
	}

	@Test
	public void MyNotesLayoutTest() throws IOException, InterruptedException {

		// Clicar o botao login na welcomepage
		WebElement Botao = driver.findElement(By.cssSelector("button"));
		Botao.click();

		// Realizar o login na pagina
		WebElement usuario = driver.findElement(By.name("login.username"));
		WebElement senha = driver.findElement(By.name("login.password"));
		WebElement Button = driver.findElement(By.cssSelector("button"));

		usuario.sendKeys("testuser@example.com");
		senha.sendKeys("test123");
		Button.click();

		Thread.sleep(1000);
		// Create a layoutReport object
		// checkLayout function checks the layout and returns a LayoutReport object
		LayoutReport layoutReport = Galen.checkLayout(driver, "specs/mynotes.gspec", Arrays.asList("desktop"));

		// Criando a lista com GalenTestInfo
		List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

		// Estanciando o objeto do GalenTestInfo
		GalenTestInfo test = GalenTestInfo.fromString("mynotes layout");

		// Selecionando com get para check layout
		test.getReport().layout(layoutReport, "check mynotes layout");

		// Add test object to the tests list
		tests.add(test);

		// Estanciando o objeto do htmlReportBuilder
		HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

		// Criando reportbuild em target
		htmlReportBuilder.build(tests, "target");

	}

	@Test
	public void EventTest() throws IOException, InterruptedException {

		// Clicar o botao login na welcomepage
		WebElement Botao = driver.findElement(By.cssSelector("button"));
		Botao.click();

		// Realizar o login na pagina
		WebElement usuario = driver.findElement(By.name("login.username"));
		WebElement senha = driver.findElement(By.name("login.password"));
		WebElement Button = driver.findElement(By.cssSelector("button"));

		usuario.sendKeys("testuser@example.com");
		senha.sendKeys("test123");
		Button.click();

		Thread.sleep(1000);

		// Ainda na mynotes realizar o teste abaixo
		// Mover o cursor em cima do botao
		WebElement searchBtn = driver.findElement(By.cssSelector("button"));
		Actions action = new Actions(driver);
		action.moveToElement(searchBtn).perform();
		Thread.sleep(3000);

		// Create a layoutReport object
		// checkLayout function checks the layout and returns a LayoutReport object
		LayoutReport layoutReport = Galen.checkLayout(driver, "specs/eventTeste.gspec", Arrays.asList("desktop"));

		// Criando a lista com GalenTestInfo
		List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

		// Estanciando o objeto do GalenTestInfo
		GalenTestInfo test = GalenTestInfo.fromString("eventTeste layout");

		// Selecionando com get para check layout
		test.getReport().layout(layoutReport, "check eventTest layout");

		// Add test object to the tests list
		tests.add(test);

		// Estanciando o objeto do htmlReportBuilder
		HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

		// Criando reportbuild em target
		htmlReportBuilder.build(tests, "target");

		// If para validar se o layout retornar erros
		if (layoutReport.errors() > 0) {
			Assert.fail("Layout test failed");
		}

		Thread.sleep(3000);
	}

	// Para fechar o navegador
	@After
	public void tearDown() {
		driver.quit();
	}

	/*
	 * @AfterClass public static void HomeReport() { driver.get(
	 * "file:///C:/Users/745093/Desktop/Galen_WEB/GalenAPI_Selenium%20JUNIT/AutomacaoWeb/target/1-homepage-layout.html"
	 * ); }
	 */

}
