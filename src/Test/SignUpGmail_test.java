package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Lib.CaptureScreenshot;
import Lib.ExcelDataConfig;
import Lib.Reportes;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.*;



public class SignUpGmail_test {
	//Variables de Extent Reports y 

	ExcelDataConfig EscribirExcel, LeerExcel;
	
	//Tear Down Variables
	StringBuffer verificationErrors = new StringBuffer();
	boolean acceptNextAlert = true;
	
	String ReportName, TestCaptura, baseUrl, ScreenShot_Path, Url, msj;
	int CaptureN, Reporte;
	
	//web driver
	WebDriver driver;
	
	
	//Path of excel
	String ExcelPath = ".\\DataProviders\\inputData.xlsx";
	

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {

		// Inicializar Reporte
		ReportName = "Registro Gmail";
		String ReportURL=".\\Reports\\" + ReportName + ".html";
		Reportes.CrearReporte(ReportName, ReportURL);

		// Inicializar Excel
		LeerExcel = new ExcelDataConfig(ExcelPath);
		EscribirExcel = new ExcelDataConfig(ExcelPath);

		//Url de la Aplicacion
		Url = "https://accounts.google.com/SignUp";
		GChrome();
	}

	@Test
	public void T00_Validar_Mensajes_de_Error() throws Exception {
		//Seteamos los parametros para reportes y ScreenShots
		ReportName = "Validar Mensajes de Error";
		TestCaptura = "T00_Test_Mensajes_de_Error";
		Reportes.CrearPrueba(ReportName);
		Reportes.EnviarStatus(LogStatus.INFO, "Se inicio la Prueba");
		
		GmailSingUp.SignUp_txtNameXpath(driver).click();
		GmailSingUp.SignUp_txtLasnameXpath(driver).click();


	
	}

	/////// EVALUAR RESULTADOS DEL TEST//////////
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException, InterruptedException {

		if (result.getStatus() == ITestResult.FAILURE) {

			Reportes.TomarCaptura(driver, LogStatus.INFO, ScreenShot_Path, TestCaptura);
			Reportes.EnviarStatus(LogStatus.FAIL, "Ha fallado la Prueba");
			msj = "NOK";
			Thread.sleep(3000);

		} else {

			Reportes.TomarCaptura(driver, LogStatus.INFO, ScreenShot_Path, TestCaptura);
			Reportes.EnviarStatus(LogStatus.PASS, "Se culmino la prueba Exitosamente");

		}

		Reportes.CerrarReporte();

	}



	////////////// NAVEGADORES//////////////

	public void IExplorer() {

		System.setProperty("webdriver.ie.driver", ".\\ExternalJars\\IExplorer\\IEDriverServer.exe");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);

		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Url);

	}

	public void GChrome() {

		System.setProperty("webdriver.chrome.driver", ".\\ExternalJars\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Url);

	}


///////OTRAS CONFIGURACIONES//////////
@AfterClass(alwaysRun = true)
  public void tearDown() {
    driver.quit();
    
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
    }
  }

  @SuppressWarnings("unused")
private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  @SuppressWarnings("unused")
private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

}


