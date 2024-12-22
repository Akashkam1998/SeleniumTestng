package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModel.HomePageObjects;
import PageObjectModel.LoginPageObjects;
import Resources.BaseClass;

public class LoginTestCases extends BaseClass {
	
	@Test
	public void VerifyLoginWithValidData() throws IOException {
		
				
		HomePageObjects hpo = new HomePageObjects(driver);
		
		hpo.ClickOnMyAccount().click();		
		hpo.ClickOnLogin().click();
		
		LoginPageObjects lpo = new LoginPageObjects(driver);
		
		lpo.EnterEmailAdress().sendKeys(EmailAddress);
		lpo.EnterPassWord().sendKeys("123456789");
		lpo.ClickOnLogin().click();	
		
		String ExpectedResult = "Account";
		String ActualResult = lpo.VerifyLoggedInSuccessfully().getText();
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ActualResult, ExpectedResult);	
		sa.assertAll();
		}
	
	}
	

