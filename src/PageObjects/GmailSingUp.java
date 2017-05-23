package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailSingUp {
	
	public static WebElement element = null;
	
	 public static WebElement SignUp_txtNameXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//input[@id='FirstName']"));

		    return element;

	}
	 
	 public static WebElement SignUp_txtLastnameXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//input[@id='LastName']"));

		    return element;

	}
	 
	 
	 public static WebElement SignUp_txtUserNameXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//input[@id='GmailAddress']"));

		    return element;

	}
	 
	 
	 public static WebElement SignUp_txtPasswordXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//input[@id='Passwd']"));

		    return element;

	}
	 
	 public static WebElement SignUp_txtPasswordConfirmXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//input[@id='PasswdAgain']"));

		    return element;

	}
	 
	 public static WebElement SignUp_txtDayXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//input[@id='BirthDay']"));

		    return element;

	}
	 
	 
	 public static WebElement SignUp_ComboMonthContainerXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//*[@id='month-label']"));

		    return element;

	}
	 
	 public static WebElement SignUp_ComboMonthXpath(WebDriver driver, String mes){

		    element = driver.findElement(By.xpath("//*[@id=':"+mes+"']"));
		    
		    ////*[@id=":0"]

		    return element;

	}
	 
	 public static WebElement SignUp_txtYearXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//input[@id='BirthYear']"));

		    return element;

	}
	 
	 public static WebElement SignUp_ComboGenderContainerXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//*[@id='Gender']/div[1]"));

		    return element;

	}
	 
	 
	 public static WebElement SignUp_ComboSelectGenderXpath(WebDriver driver, String Genero){

		    element = driver.findElement(By.xpath("//*[@id=':"+Genero+"']"));

		  //*[@id=":e"]
		    
		    return element;

	}
	 
	 
	 public static WebElement SignUp_txtPhoneXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//input[@id='RecoveryPhoneNumber']"));
		    
		    return element;

	}
	
	 public static WebElement SignUp_txtEmailRecoveryXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//input[@id='RecoveryEmailAddress']"));
		    
		    return element;

	}
	 
	 public static WebElement SignUp_btnArrowDownXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//img[contains(@src,'24dp.png')]"));
		    
		    return element;

	}
	 
	 public static WebElement SignUp_btnNextStepXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//input[@id='submitbutton']"));
		    
		    return element;

	}
	 
	 public static WebElement SignUp_btnAgreeXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//input[@id='iagreebutton']"));
		    
		    return element;

	}
	 
	 public static WebElement SignUp_ErrorNameXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//span[contains(@id,'errormsg_0_FirstName')]"));
		    
		    return element;

	}
	 
	 public static WebElement SignUp_ErrorLastNameXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//*[@id='errormsg_0_LastName']"));
		    
		    return element;

	}
	
	 
	 public static WebElement SignUp_ErrorEmailXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//*[@id='errormsg_0_GmailAddress']"));
		    
		    return element;

	}
	
	 public static WebElement SignUp_ErrorEmailCaractersXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//span[contains(.,'Debes usar entre 6 y 30 caracteres.')]"));
		    
		    return element;

	}
	 
	 public static WebElement SignUp_ErrorBlankPassXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//span[@id='errormsg_0_Passwd']"));
		    
		    return element;

	}
	 
	 public static WebElement SignUp_ErrorShortPassXpath(WebDriver driver){

		    element =  driver.findElement(By.xpath("//*[contains(.,'Las contraseñas cortas son fáciles de adivinar. Vuelve a intentarlo utilizando como mínimo 8 caracteres.')]"));
		    
		    return element;

	} 
	
	public static WebElement SignUp_ErrorPassDifrentXpath(WebDriver driver){

	    element =  driver.findElement(By.xpath("//*[contains(.,'Las contraseñas no coinciden. ¿Quieres volver a intentarlo?')]"));
	    
	    return element;

} 
	
	
	 
}
