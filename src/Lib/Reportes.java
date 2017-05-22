package Lib;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Lib.CaptureScreenshot;

public class Reportes {
	static String NombreReporte,ReportName, ReportURL;
	static ExtentReports Extentreport;
	static ExtentTest TestReport; 
	
	 public static void CrearReporte(String ReportName, String ReportURL){
		
		NombreReporte= ReportName;  
		Extentreport= new ExtentReports(ReportURL);
		TestReport=Extentreport.startTest(ReportName);
		
	}
	 
	 public static void CerrarReporte(){
			
		 Extentreport.endTest(TestReport);
		 Extentreport.flush();
		
	}
	 
	 public static void CrearPrueba(String ReportName){
			
			NombreReporte= ReportName;  
			TestReport=Extentreport.startTest(ReportName);
			
	}
	 
	 public static void EnviarStatus(LogStatus Result, String mensaje){
			
		 TestReport.log(Result, mensaje);
		
		 
	}
	 
	 
	 public static void TomarCaptura(WebDriver driver, LogStatus Result, String ScreenShot_Path,String TestCaptura){
		 
		 ScreenShot_Path= "<img src="+ CaptureScreenshot.ScreenShot(driver, TestCaptura) + ">"; 
		 TestReport.log(Result, ScreenShot_Path);
		
		 
	}
	 

}
