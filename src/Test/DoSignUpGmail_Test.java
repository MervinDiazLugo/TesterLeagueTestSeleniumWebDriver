package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.Assert;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertEquals;

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



public class DoSignUpGmail_Test {
	//Tear Down Variables
	StringBuffer verificationErrors = new StringBuffer();
	boolean acceptNextAlert = true;
	
	String ReportName, TestCaptura, baseUrl, ScreenShot_Path, Url, msj;
	int CaptureN, Reporte;
	
	//web driver
	WebDriver driver;
	
	
	//Configuracion de  excel
	String ExcelPath = ".\\DataProviders\\inputData.xlsx";
	ExcelDataConfig EscribirExcel, LeerExcel;
	String[] DataProviderExcel = new String[11];
	

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {

		// Inicializar Reporte
		ReportName = "02 Registro Gmail";
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
	public void T00_RegistroGmail() throws Exception {
	//Seteamos los parametros para reportes y ScreenShots
		ReportName = "Registrar Cuenta Gmail";
		TestCaptura = "T00_Registro_Gmail";
		Reportes.CrearPrueba(ReportName);
		Reportes.EnviarStatus(LogStatus.INFO, "Se inicio la Prueba");
		
		DataProviders();
		
		GmailSingUp.SignUp_txtNameXpath(driver).sendKeys(DataProviderExcel[0]);
		GmailSingUp.SignUp_txtLastnameXpath(driver).sendKeys(DataProviderExcel[1]);
		GmailSingUp.SignUp_txtUserNameXpath(driver).sendKeys(DataProviderExcel[2]);
		GmailSingUp.SignUp_txtPasswordXpath(driver).sendKeys(DataProviderExcel[3]);
		GmailSingUp.SignUp_txtPasswordConfirmXpath(driver).sendKeys(DataProviderExcel[4]);
		GmailSingUp.SignUp_txtDayXpath(driver).sendKeys(DataProviderExcel[5]);
		GmailSingUp.SignUp_ComboMonthContainerXpath(driver).click();
		GmailSingUp.SignUp_ComboMonthXpath(driver, DataProviderExcel[6]).click();
		GmailSingUp.SignUp_txtYearXpath(driver).sendKeys(DataProviderExcel[7]);
		GmailSingUp.SignUp_ComboGenderContainerXpath(driver).click();
		GmailSingUp.SignUp_ComboSelectGenderXpath(driver, DataProviderExcel[8]).click();
		GmailSingUp.SignUp_txtPhoneXpath(driver).sendKeys(DataProviderExcel[9]);
		GmailSingUp.SignUp_txtEmailRecoveryXpath(driver).sendKeys(DataProviderExcel[10]);
		GmailSingUp.SignUp_btnNextStepXpath(driver).click();
		GmailSingUp.SignUp_btnArrowDownXpath(driver).click();
		GmailSingUp.SignUp_btnArrowDownXpath(driver).click();
		
		
	}
	
	public String[] DataProviders(){
		
		
		DataProviderExcel[0]= LeerExcel.GetData(0, 3, 0);
		DataProviderExcel[1]= LeerExcel.GetData(0, 3, 1);
		DataProviderExcel[2]= LeerExcel.GetData(0, 3, 2);
		DataProviderExcel[3]= LeerExcel.GetData(0, 3, 3);
		DataProviderExcel[4]= LeerExcel.GetData(0, 3, 4);
		DataProviderExcel[5]= LeerExcel.GetData(0, 3, 5);
		DataProviderExcel[6]= LeerExcel.GetData(0, 3, 6);
		DataProviderExcel[7]= LeerExcel.GetData(0, 3, 7);
		DataProviderExcel[8]= LeerExcel.GetData(0, 3, 8);
		DataProviderExcel[9]= LeerExcel.GetData(0, 3, 9);
		DataProviderExcel[10]= LeerExcel.GetData(0, 3, 10);
		
		try {
			EscribirExcel.WriteData(0, 3, (DataProviderExcel.length+1), "Enviados");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*		for (int i = 0; i < DataProviderExcel.length; i++){
			
			System.out.println(DataProviderExcel[i]);
		}
		*/
		return DataProviderExcel;
		
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


