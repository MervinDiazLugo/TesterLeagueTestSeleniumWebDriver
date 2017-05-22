package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailSingUp {
	
	public static WebElement element = null;
	
	 public static WebElement SignUp_txtNameXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//span[@id='firstname-placeholder']"));

		    return element;

	}
	 
	 public static WebElement SignUp_txtLasnameXpath(WebDriver driver){

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

		    element = driver.findElement(By.xpath("//span[@id='birthday-placeholder']"));

		    return element;

	}
	 
	 
	 public static WebElement SignUp_ComboMonthContainerXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//div[contains(.,'Mes')]"));

		    return element;

	}
	 
	 public static WebElement SignUp_ComboMonthXpath(WebDriver driver, String mes){

		    element = driver.findElement(By.xpath("//div[contains(.,'"+mes+"')]"));
		    
		    //driver.findElement(By.xpath("//div[contains(.,'Enero')]"));

		    return element;

	}
	 
	 public static WebElement SignUp_txtYearXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//input[@id='BirthYear']"));

		    return element;

	}
	 
	 public static WebElement SignUp_ComboGenderXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//div[@aria-posinset='0']"));

		    return element;

	}
	 
	 
	 public static WebElement SignUp_ComboSelectGenderXpath(WebDriver driver, String Genero){

		    element = driver.findElement(By.xpath("//div[contains(.,'"+Genero+"')]"));
		    
		    //driver.findElement(By.xpath("//div[contains(.,'Mujer')]"));
		    
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

		    element = driver.findElement(By.xpath("//img[@src='//www.gstatic.com/images/icons/material/system/2x/keyboard_arrow_down_white_24dp.png']"));
		    
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

		    element = driver.findElement(By.xpath("//div[1]/div[2]/div/div[1]/div/form/div[1]/span[2]"));
		    
		    return element;

	}
	 
	 public static WebElement SignUp_ErrorLastNameXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//span[@id='errormsg_0_LastName']"));
		    
		    return element;

	}
	
	 
	 public static WebElement SignUp_ErrorEmailXpath(WebDriver driver){

		    element = driver.findElement(By.xpath("//span[@id='errormsg_0_GmailAddress']"));
		    
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

		    element =  driver.findElement(By.xpath("//span[contains(.,'Las contraseñas cortas son fáciles de adivinar. Vuelve a intentarlo utilizando como mínimo 8 caracteres.')]"));
		    
		    return element;

	} 
	
	public static WebElement SignUp_ErrorPassDifrentXpath(WebDriver driver){

	    element =  driver.findElement(By.xpath("//span[@id='errormsg_0_PasswdAgain']"));
	    
	    return element;

} 
	
	
	 
}
