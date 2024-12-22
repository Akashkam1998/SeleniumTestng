package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModel.HomePageObjects;
import PageObjectModel.RegisterPageObjects;
import Resources.BaseClass;
import Resources.constants;

public class RegisterTestCases extends BaseClass {

	@Test
	public void VerifyRegistrationWithValidData() throws IOException {

		HomePageObjects hpo = new HomePageObjects(driver);

		hpo.ClickOnMyAccount().click();
		hpo.ClickOnRegister().click();

		RegisterPageObjects rpo = new RegisterPageObjects(driver);

		rpo.EnterFirstName().sendKeys(constants.FirstName);
		rpo.EnterLastName().sendKeys(constants.LastName);
		rpo.EnterEmail().sendKeys(EmailAddress);
		rpo.EnterTelephone().sendKeys(constants.Telephone);
		rpo.EnterPassword().sendKeys(constants.Password);
		rpo.EnterConfirmPassword().sendKeys(constants.ConfirmPassword);
		rpo.CheckCheckbox().click();
		rpo.ClickContinue().click();

		String ExpectedResult = constants.RegistrationExpectedResult;
		String ActualResult = rpo.RegisteredSuccessfullyMessage().getAccessibleName();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ActualResult, ExpectedResult);
		sa.assertAll();

	}
	
	@Test
	public void VerifyRegistrationWithBlankData() {

		HomePageObjects hpo = new HomePageObjects(driver);

		hpo.ClickOnMyAccount().click();
		hpo.ClickOnRegister().click();

		RegisterPageObjects rpo = new RegisterPageObjects(driver);
		
		rpo.ClickContinue().click();
		
		SoftAssert sa = new SoftAssert();
		
		String FirstNameExpectedResult = constants.FirstNameRegistrationErrorMessage;
		String FirstNameActualResult = rpo.FirstNameErrorMessage().getText();
		
		sa.assertEquals(FirstNameActualResult, FirstNameExpectedResult);
		
		String LastNameExpectedResult = constants.LastNameRegistrationErrorMessage;
		String LastNameActualResult = rpo.LastNameErrorMessage().getText();
		
		sa.assertEquals(LastNameActualResult, LastNameExpectedResult);
		
		String EmailExpectedResult = constants.EmailRegistrationErrorMessage;
		String EmailActualResult = rpo.EmailErrorMessage().getText();
		
		sa.assertEquals(EmailActualResult, EmailExpectedResult);
		
		String TelePhoneExpectedResult = constants.TelephoneRegistrationErrorMessage;
		String TelePhoneActualResult = rpo.TelePhoneErrorMessage().getText();
		
		sa.assertEquals(TelePhoneActualResult, TelePhoneExpectedResult);
		
		String PasswordExpectedResult = constants.PasswordRegistrationErrorMessage;
		String PasswordActualResult = rpo.PasswordErrorMessage().getText();
		
		sa.assertEquals(PasswordActualResult, PasswordExpectedResult);
		
		String CheckBoxExpectedResult = constants.CheckBoxRegistrationErrorMessage;
		String CheckBoxActualResult = rpo.CheckBoxErrorMessage().getText();
		
		sa.assertEquals(CheckBoxActualResult, CheckBoxExpectedResult);
		
		sa.assertAll();
	}

}
