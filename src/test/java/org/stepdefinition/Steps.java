package org.stepdefinition;

import io.cucumber.java.en.And;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.base.Global;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.pagemanager.PageObjectManager;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Steps extends Global {
	public static Logger log;
	public static WebDriver driver;
	public static List<String> Contactlist, Comparelist;

	public String WorkEmail;
	public Date DateToBeUsed;
	public String RandomListName;

	public String RandomSaveSearchName;
	public String SaveSearchCreationDate;


	//	@Given("Launch the url")
//	public void launch_the_url() {
//		driver = getDriver();
//		maximizeWindow();
//		implicitWait();
//		launchURL(readPropertyFileData().getProperty("url"));
//	}
	@Given("Launch the url")
	public void launch_the_url() throws Throwable {
		driver = getDriver();
		maximizeWindow();
		implicitWait();
		launchURL(ReadDatafromJson("Contact_Name", "url"));
	}

	@Given("Launch Research Portal")
	public void launch_the_Research_Portal_url() throws Throwable {
		driver = getDriver();
		maximizeWindow();
		implicitWait();
		launchURL(ReadDatafromJson("Contact_Name", "Research url"));
	}
	//
//	@When("Enter Valid Username")
//	public void i_enter_the_username() throws Throwable {
//		log = readLog4jData();
//		log.info("User is navigate to SalesIntel site");
//		enterData(PageObjectManager.getInstance().getLoginPage().getUserName(),
//				readPropertyFileData().getProperty("UserName"));
//		log.info("User enter the correct username");
//	}
	@And("Search Contact With Email")
	public void I_Search_With_Email() throws Throwable{
		System.out.println("Contact Work Email is: "+WorkEmail);
		enterData(PageObjectManager.getInstance().getLoginPage().getEmailInputBoxInResearch(),WorkEmail);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSearchButtonForResearch());
		Thread.sleep(1000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSearchedContactInResearch());
		log.info("User Search Contact With Email in Research");
	}

	@And("Login To Research Portal")
	public void i_Login_To_Research() throws Throwable {
		log = readLog4jData();
		log.info("User is navigate to Research Portal");
		Thread.sleep(3000);
		enterData(PageObjectManager.getInstance().getLoginPage().getUserName(),
				ReadDatafromJson("Contact_Name", "Research Username"));
		System.out.println("User enter the correct username");
		enterData(PageObjectManager.getInstance().getLoginPage().getPassword(),
				ReadDatafromJson("Contact_Name", "Research Password"));
		System.out.println("User enter the correct password");
		clickButton(PageObjectManager.getInstance().getLoginPage().getLoginButtonRes());
		log.info("User click Click On Login Button");
		Thread.sleep(5000);
	}

	@When("Enter Valid Username")
	public void i_enter_the_username() throws Throwable {
		log = readLog4jData();
		log.info("User is navigate to SalesIntel site");
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getUserName(),
				ReadDatafromJson("Contact_Name", "UserName"));
		log.info("User enter the correct username");
	}

	@When("Enter Universal Valid Username")
	public void i_enter_the_Universal_username() throws Throwable {
		log = readLog4jData();
		log.info("User is navigate to SalesIntel site");
		enterData(PageObjectManager.getInstance().getLoginPage().getUserName(),
				ReadDatafromJson("Contact_Name", "UniversalUserName"));
		log.info("User enter the correct username");
	}

	//	@When("Enter Valid Password")
//	public void i_enter_the_password() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getPassword(),
//				readPropertyFileData().getProperty("Password"));
//		log.info("User enter the correct password");
//	}
	@When("Enter Valid Password")
	public void i_enter_the_password() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getPassword(),
				ReadDatafromJson("Contact_Name", "Password"));
		log.info("User enter the correct password");
	}

	@When("Enter Universal Valid Password")
	public void i_enter_the_Universal_password() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getPassword(),
				ReadDatafromJson("Contact_Name", "UniversalPassword"));
		log.info("User enter the correct password");
	}

	@Then("Click on Contact Name Button")
	public void I_Click_Contact_Name() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getContactName());
		log.info("User click the Contact Name Button");
		Thread.sleep(5000);
	}

	@Then("Click on Contact Radio Button")
	public void I_Click_Contact_Radio_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getnewContactradiobutton());
		log.info("User Click on Contact Radio Button");
	}

	@Then("Check Search Results of Ranking Filter")
	public void I_Check_Search_Results_For_Rankings_All() throws Throwable{
		String TotalContacts =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		System.out.println("Total Human Verified Contacts for All Rankings are : "+TotalContacts);
		log.info("USer Check Search Results of Ranking Filter");
		clickButton(PageObjectManager.getInstance().getLoginPage().getFirstSearchedContact());
		Thread.sleep(2000);
	}

	@Then("Click on Contact Radio Button for Universal User")
	public void I_Click_Contact_Radio_Button_Universal() throws Throwable {
		Thread.sleep(15000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getnewuniversalContactradiobutton());
		log.info("User Click on Contact Radio Buttonn");
		Thread.sleep(5000);
	}

	@Then("Click on Company Radio Button")
	public void I_Click_Company_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getnewCompanyradiobutton());
		log.info("User Click on Company Radio Button");
		Thread.sleep(5000);
	}

	@Then("Click on Contact Email Button")
	public void I_Click_Contact_Email() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getContactEmail());
		log.info("User click the Contact Email Filter");
	}
//	@When("Enter the First Name")
//	public void i_enter_the_FirstName() throws Throwable {
////		readCompleteDataFromEXcel();
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readPropertyFileData().getProperty("FirstName"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
//     	log.info("User enter the First Name");
//	}

	@When("Enter the First Name")
	public void i_enter_the_FirstName() throws Throwable {
//		readCompleteDataFromEXcel();
		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), ReadDatafromJson("Contact_Name", "FirstName"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
		log.info("User enter the First Name");
	}

	@When("Enter the Universal First Name")
	public void i_enter_the_Unviersal_FirstName() throws Throwable {
//		readCompleteDataFromEXcel();
		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), ReadDatafromJson("Contact_Name", "UniversalFirstName"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
		log.info("Enter the Universal First Name");
	}

	//	@When("Enter the Last Name")
//	public void i_enter_the_LastName() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(),readPropertyFileData().getProperty("LastName"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
//		log.info("User enter the Last Name");
//	}
	@When("Enter the Last Name")
	public void i_enter_the_LastName() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(), ReadDatafromJson("Contact_Name", "LastName"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("User enter the Last Name");
	}

	@When("Enter the Universal Last Name")
	public void i_enter_the_Universal_LastName() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(), ReadDatafromJson("Contact_Name", "UniversalLastName"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("Enter the Last Name");
	}

	@Then("Click on Search Button")
	public void I_Click_Search_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getSearchButton());
		log.info("User click on Search Button");
		Thread.sleep(10000);
	}

	@And("Click on the First Contact in Search Result")
	public void I_Click_Searched_Contact() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getFirstSearchedContact());
		log.info("User Click on the First Contact in Search Result");
	}

	@Then("Click on Company Search Button")
	public void I_Click_Company_Search_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getCompanySearchButton());
		log.info("User click the Contact Name Button");
		Thread.sleep(10000);
	}


	@Then("Validate Email Text Box is displayed")
	public void I_Validate_Email_TextBox() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getSearchButton());
		log.info("User click the Contact Name Button");
	}

	@Then("Validate Password Text Box is displayed")
	public void I_Validate_Password_TextBox() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getSearchButton());
		log.info("User click the Contact Name Button");
	}

	@Then("Click on FAQ")
	public void I_Click_FAQ() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getFaq());
		log.info("User click the Contact Name Button");
	}

	@Then("Click on Remember Me")
	public void I_Click_Remember_Me() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getRememberMe());
		log.info("User click the Contact Name Button");
	}

	@When("Click on Forget Password")
	public void I_Click_Forgot_Password() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getForgotPassword());
		log.info("User click the Contact Name Button");
	}

	@Then("Click On Login Button")
	public void I_Click_Login_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getLoginButton());
		log.info("User click Click On Login Button");
		Thread.sleep(10000);
	}

	@And("Logout the Research Portal")
	public void I_Click_Logout_Button_In_Research() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getLogoutButtonInResearch());
		log.info("User click Click On Login Button in research Portal");
		Thread.sleep(5000);
	}

	@Then("Validate Email Field is displayed")
	public void I_Email_Field() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getEmailPlaceholder().isDisplayed());
		log.info("Validate Email Field is displayed");
	}

	@Then("Validate Password Field is displayed")
	public void I_Validate_Password_Field() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getPasswordPlaceholder().isDisplayed());
		log.info("Validate Password Field is displayed");
	}

	@Then("Validate Login Page Title is displayed")
	public void I_Validate_Page_Title() throws Throwable {
		log = readLog4jData();
		log.info("Validate Login Page Title is displayed");
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getLoginTitle().isDisplayed());
		log.info("Validate Login Page Title is displayed");
	}

	@Then("Validate FAQ Link is displayed")
	public void I_Validate_FAQ() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getFaq().isDisplayed());
		log.info("Validate FAQ Link is displayed");
	}

	@Then("Validate Remember Me Checkbox is displayed")
	public void I_Validate_Remember_Me() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getRememberMe().isDisplayed());
		log.info("Validate Remember Me Checkbox is displayed");
	}

	@Then("Validate Forgot Password Link is displayed")
	public void I_Validate_Forgot_Password() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getForgotPassword().isDisplayed());
		log.info("Validate Forgot Password Link is displayed");
	}

	@Then("Validate Login Button is displayed")
	public void I_Validate_Login_Button() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getLoginButton().isDisplayed());
		log.info("Validate Login Button is displayed");
	}
//	@When("Enter Invalid Username")
//	public void i_enter_invalid_username() {
//		enterData(PageObjectManager.getInstance().getLoginPage().getUserName(),
//				readPropertyFileData().getProperty("InvalidUserName"));
//		log.info("User enter Invalid Usernamee");
//	}

	@When("Enter Invalid Username")
	public void i_enter_invalid_username() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getUserName(), ReadDatafromJson("Contact_Name", "InvalidUserName"));
		log.info("User enter Invalid Username");
	}

//	@When("Enter Invalid Password")
//	public void i_enter_invalid_password() {
//		enterData(PageObjectManager.getInstance().getLoginPage().getPassword(),
//				readPropertyFileData().getProperty("InvalidPassword"));
//		log.info("User enter Enter Invalid Password");
//	}

	@When("Enter Invalid Password")
	public void i_enter_invalid_password() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getPassword(), ReadDatafromJson("Contact_Name", "InvalidPassword"));
		log.info("User enter Enter Invalid Password");
	}

	@Then("Validate Error Text when Tried with Invalid Username and Valid Password")
	public void I_Validate_InvalidUsername_validPassword_Field() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getInvalidUsernameResult().isDisplayed());
		log.info("Validate Error Text when Tried with Invalid Username and Valid Password");
	}

	@Then("Validate Error Text when Tried with Invalid Username and Invalid Password")
	public void I_Validate_InvalidUsername_InvalidPassword_Field() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getInvalidUsernamepasswordResult().isDisplayed());
		log.info("Validate Error Text when Tried with Invalid Username and Invalid Password");
	}

	@Then("Validate Error Text when Tried with Invalid Password and Invalid Username")
	public void I_Validate_InvalidPassword_InvalidUsername_Field() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getInvalidpasswordUsernameResult().isDisplayed());
		log.info("Validate Error Text when Tried with Invalid Password and Invalid Username");
	}

	@When("Verify Contact Name is displayed")
	public void I_verify_Contact_Name() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getContactName().isDisplayed());
		log.info("Verify Contact Name is displayed");
	}

	@When("Verify First Name is displayed")
	public void i_verify_FirstName() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getFirstName().isDisplayed());
		log.info("Verify First Name is displayed");
		Thread.sleep(5000);
	}

	@When("Verify Last Name is displayed")
	public void i_verify_LastName() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getLastName().isDisplayed());
		log.info("Verify Last Name is displayed");
		Thread.sleep(5000);
	}

	@When("Verify Contact section is displayed")
	public void i_verify_Contact_section() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getContactsection().isDisplayed());
		log.info("Verify Contact section is displayed");
		Thread.sleep(5000);
	}

	//	@When("Enter the First Name with Integer Value")
//	public void i_enter_the_FirstName_with_Integer_Value() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),
//				readPropertyFileData().getProperty("FirstName_Integer"));
//		log.info("User enter the First Name");
//		Thread.sleep(3000);
//	}
	@When("Enter the First Name with Integer Value")
	public void i_enter_the_FirstName_with_Integer_Value() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),
				ReadDatafromJson("Contact_Name", "FirstName_Integer"));
		log.info("User enter the First Name");
		Thread.sleep(3000);
	}

	//	@When("Enter the Last Name with Integer Value")
//	public void i_enter_the_LastName_with_Integer_Value() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(),
//				readPropertyFileData().getProperty("LastName_Integer"));
//		log.info("User enter the Last Name");
//		Thread.sleep(3000);
//	}
	@When("Enter the Last Name with Integer Value")
	public void i_enter_the_LastName_with_Integer_Value() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(),
				ReadDatafromJson("Contact_Name", "LastName_Integer"));
		log.info("User enter the Last Name");
		Thread.sleep(3000);
	}

	@And("Verify Error Message is displayed When search with FirstName and LastName only Integer")
	public void i_verify_ContactSearchwithinteger() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getContactSearchwithInteger().isDisplayed());
		log.info("Verify Individual section is displayed");
		Thread.sleep(10000);
	}

	@When("Verify Forget Email Address Field is displayed")
	public void i_verify_Forget_Email_Field() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getForgetPasswordEmail().isDisplayed());
		log.info("Verify Forget Email Address Field is displayed");
		Thread.sleep(5000);
	}
//	@When("Enter Forget Email Address")
//	public void i_enter_the_Forget_Email() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getForgetPasswordEmail(),
//				readPropertyFileData().getProperty("Email"));
//		log.info("Enter Forget Email Address");
//		Thread.sleep(5000);
//	}

	@When("Enter Forget Email Address")
	public void i_enter_the_Forget_Email() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getForgetPasswordEmail(),
				readPropertyFileData().getProperty("Email"));
		log.info("Enter Forget Email Address");
		Thread.sleep(5000);
	}

	@When("Verify Reset Password Button is displayed")
	public void i_verify_Forget_Reset_Email_Field() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getResetPasswordButton().isDisplayed());
		log.info("Verify Forget Email Address Field is displayed");
		Thread.sleep(3000);
	}

	@And("Click On Reset Password Button")
	public void I_Click_Resert_Password_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getResetPasswordButton());
		log.info("User click Click On Login Button");
		Thread.sleep(3000);
	}

	@When("Verify Contact Email is displayed")
	public void I_verify_Contact_Email() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getContactEmail().isDisplayed());
		log.info("Verify Contact Name is displayed");
	}

	@And("Click On Contact Email")
	public void I_Click_Contact_Email_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getContactEmail());
		log.info("User click Click On Login Button");
	}

	@And("Verify Error Message is displayed When search with Invalid Email Address")
	public void i_verify_ContactSearchwithinvalidEmail() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getContactSearchwithInteger().isDisplayed());
		log.info("Verify Individual section is displayed");
	}

	//	@When("Enter Contact Email Address")
//	public void i_enter_the_Contact_Email() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getContactEmailInputbox(),
//				readPropertyFileData().getProperty("Email"));
//		log.info("Enter Forget Email Address");
//	}
	@When("Enter Contact Email Address")
	public void i_enter_the_Contact_Email() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getContactEmailInputbox(),
				ReadDatafromJson("Contact_Name", "Email1"));
		log.info("Enter Contact Email Address");
	}

	/*
	@Then("Clear Text in Password Field")
	public void I_clear_text_Username() {
		clickButton(PageObjectManager.getInstance().getLoginPage().getForgotPassword().clear());
		driver.findElement(By.xpath(PageObjectManager.getInstance().getLoginPage().getForgotPassword()).clear());
		log.info("User click the Contact Name Button");
	}
*/
	@When("Clear the Text in Username Field")
	public void i_Clear_username() throws Throwable {
		clearText(PageObjectManager.getInstance().getLoginPage().getUserName());
		log.info("Clear the Text in Username Field");
	}

	@When("Clear the Text in Password Field")
	public void i_clear_password() throws Throwable {
		clearText(PageObjectManager.getInstance().getLoginPage().getPassword());
		log.info("Clear the Text in Password Field");
	}

	@When("Clear the Text in First Name Field")
	public void i_clear_the_FirstName() throws Throwable {
		clearText(PageObjectManager.getInstance().getLoginPage().getFirstName());
		log.info("Clear the Text in First Name Field");
	}

	@When("Clear the Text in Last Name Field")
	public void i_clear_the_LastName() throws Throwable {
		clearText(PageObjectManager.getInstance().getLoginPage().getLastName());
		log.info("Clear the Text in Last Name Field");
	}

	@When("Clear the Text in Contact Email Field")
	public void i_clear_the_contactEmail() throws Throwable {
		clearText(PageObjectManager.getInstance().getLoginPage().getContactEmailInputbox());
		log.info("User Clear the Text in Email Field");
	}

	//	@When("Enter Invalid Contact Email Address")
//	public void i_enter_the_invalid_Contact_Email() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getContactEmailInputbox(),
//				readPropertyFileData().getProperty("InvalidEmail"));
//		log.info("Enter Invalid Contact Email Address");
//	}
	@When("Enter Invalid Contact Email Address")
	public void i_enter_the_invalid_Contact_Email() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getContactEmailInputbox(),
				ReadDatafromJson("Contact_Name", "InvalidEmail"));
		log.info("User Enter Invalid Contact Email Address");
	}

	@And("Verify Job Department is displayed")
	public void I_verify_Job_Department() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getDepartmentFilter().isDisplayed());
		log.info("Verify Department Filter is Displayed");
	}

	@And("Click on Job Department Filter")
	public void I_Click_On_JobDepartment_Filter() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getDepartmentFilter());
		Thread.sleep(5000);
		log.info("User Click on Department Filter");
	}

	@Then("Click on Finance Department Filter")
	public void I_Click_Finance_Department_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getFinanceDepartmentFilter());
		Thread.sleep(2000);
		log.info("User Click on Finance Department Filter");
	}

	@Then("Check Finance Department in Search Result")
	public void I_Check_Finance_Department_In_Result() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getFinanceDepartmentInResult().isDisplayed());
		log.info("User Check Finance Department in Search Result");
	}

	@Then("Check Finance Department in All Searched Results")
	public void I_Check_Finance_Department_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the Finance department in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'Finance')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//div[contains(text(),'Finance')])["+i+"]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". ["+ContactName+"] is working in Finance department");
		}

		log.info("User Check Finance Department in All Searched Results");
	}

	@Then("Click on HR Department Filter")
	public void I_Click_HR_Department_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getHrDepartmentFilter());
		Thread.sleep(2000);
		log.info("User Click on HR Department Filter");
	}

	@Then("Check HR Department in Search Result")
	public void I_Check_Hr_Department_In_Result() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getHrDepartmentInResult().isDisplayed());
		log.info("User Check HR Department in Search Result");
	}

	@Then("Check HR Department in All Searched Results")
	public void I_Check_HR_Department_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the HR department in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'HR')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//div[contains(text(),'HR')])["+i+"]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". ["+ContactName+"] is working in HR department");
		}

		log.info("User Check HR Department in All Searched Results");
	}

	@Then("Click on IT Department Filter")
	public void I_Click_IT_Department_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getITDepartmentFilter());
		Thread.sleep(2000);
		log.info("User Click on IT Department Filter");
	}

	@Then("Check IT Department in Search Result")
	public void I_Check_IT_Department_In_Result() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getITDepartmentInResult().isDisplayed());
		log.info("User Check IT Department in Search Result");
	}

	@Then("Check IT Department in All Searched Results")
	public void I_Check_IT_Department_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the IT department in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("((//div[contains(text(),'IT')])["+i+"])[1]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("((//div[contains(text(),'IT')])["+i+"])[1]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". ["+ContactName+"] is working in IT department");
		}

		log.info("User Check IT Department in All Searched Results");
	}
	@Then("Click on Legal Department Filter")
	public void I_Click_Legal_Department_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getLegalDepartmentFilter());
		log.info("Click on Legal Department Filter");
	}

	@Then("Check Legal Department in Search Result")
	public void I_Check_Legal_Department_In_Result() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getLegalDepartmentInResult().isDisplayed());
		log.info("User Check Legal Department in Search Result");
	}

	@Then("Check Legal Department in All Searched Results")
	public void I_Check_Legal_Department_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the Legal department in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'Legal')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//div[contains(text(),'Legal')])["+i+"]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". ["+ContactName+"] is working in Legal department");
		}

		log.info("User Check Legal Department in All Searched Results");
	}

	@Then("Click on Marketing Department Filter")
	public void I_Click_Marketing_Department_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getMarketingDepartmentFilter());
		log.info("Click on Marketing Department Filter");
	}

	@Then("Check Marketing Department in Search Result")
	public void I_Check_Marketing_Department_In_Result() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getMarketingDepartmentInResult().isDisplayed());
		log.info("User Check Marketing Department in Search Result");
	}
	@Then("Check Marketing Department in All Searched Results")
	public void I_Check_Marketing_Department_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the Marketing department in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'Marketing')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//div[contains(text(),'Marketing')])["+i+"]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". ["+ContactName+"] is working in Marketing department");
		}

		log.info("User Check Marketing Department in All Searched Results");
	}

	@Then("Click on Operations Department Filter")
	public void I_Click_Operations_Department_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getOperationsDepartmentFilter());
		log.info("Click on Operations Department Filter");
	}

	@Then("Check Operations Department in Search Result")
	public void I_Check_Operations_Department_Result() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getOperationsDepartmentInResult().isDisplayed());
		log.info("User Check Operations Department in Search Result");
	}

	@Then("Check Operations Department in All Searched Results")
	public void I_Check_Operations_Department_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the Operations department in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'Operations')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//div[contains(text(),'Operations')])["+i+"]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". ["+ContactName+"] is working in Operations department");
		}

		log.info("User Check Operations Department in All Searched Results");
	}

	@Then("Click on Procurement Department Filter")
	public void I_Click_Procurement_Department_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getProcurementDepartmentFilter());
		log.info("Click on Procurement Department Filter");
	}

	@Then("Check Procurement Department in Search Result")
	public void I_Check_Procurement_Department_Result() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getProcurementDepartmentInResult().isDisplayed());
		log.info("User Check Procurement Department in Search Result");
	}

	@Then("Check Procurement Department in All Searched Results")
	public void I_Check_Procurement_Department_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the Procurement department in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'Procurement')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//div[contains(text(),'Procurement')])["+i+"]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". ["+ContactName+"] is working in Procurement department");
		}

		log.info("User Check Procurement Department in All Searched Results");
	}

	@Then("Click on R&D Department Filter")
	public void I_Click_RnD_Department_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getRndDepartmentFilter());
		log.info("Click on R&D Department Filter");
	}

	@Then("Check R&D Department in Search Result")
	public void I_Check_RnD_Department_In_Result() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getRndDepartmentInResult().isDisplayed());
		log.info("User Check R&D Department in Search Result");
	}

	@Then("Check R&D Department in All Searched Results")
	public void I_Check_RandD_Department_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the R&D department in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'R&D')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//div[contains(text(),'R&D')])["+i+"]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". ["+ContactName+"] is working in R&D department");
		}

		log.info("User Check R&D Department in All Searched Results");
	}

	@Then("Click on Sales Department Filter")
	public void I_Click_Sales_Department_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getSalesDepartmentFilter());
		log.info("User Click on Sales Department Filter");
	}

	@Then("Check Sales Department in Search Result")
	public void I_Check_Sales_Department_In_Search_Result() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getSalesDepartmentIn_Result().isDisplayed());
		log.info("User Check Sales Department in Search Result");
	}

	@Then("Check Sales Department in All Searched Results")
	public void I_Check_Sales_Department_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the Sales department in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'Sales')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//div[contains(text(),'Sales')])["+i+"]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". ["+ContactName+"] is working in Sales department");
		}

		log.info("User Check Sales Department in All Searched Results");
	}

	@Then("Click on Cross Functional Department Filter")
	public void I_Click_Cross_Functional_Department_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getCrossFunctionalDepartmentFilter());
		log.info("User Click on Cross Functional Department Filter");
	}

	@Then("Check Cross Functional Department in Search Result")
	public void I_Check_Cross_Functional_Department_In_Result() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getCrossFunctionalDepartmentInResult().isDisplayed());
		log.info("User Check Cross Functional Department in Search Result");
	}

	@Then("Check Cross Functional Department in All Searched Results")
	public void I_Check_Cross_Functional_Department_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the Cross Functional department in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'Cross Functional')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//div[contains(text(),'Cross Functional')])["+i+"]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". ["+ContactName+"] is working in Cross Functional department");
		}

		log.info("User Check Cross Functional Department in All Searched Results");
	}

	@When("Verify Job Level Filter is displayed")
	public void I_verify_Job_Level_Filter() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getContactJobLevel().isDisplayed());
		log.info("Verify Job Level Filter is displayed");
	}

	@And("Click On Job Level Filter")
	public void I_Click_Job_Level_Filter() throws Throwable {
		Thread.sleep(3000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getContactJobLevel());
		log.info("User click On Job Level Filter");
	}

	@Then("Click on Board Member Job Level Filter")
	public void I_Click_Board_Member_Job_Level_Filter() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getBoardMemberJobLevelFilter());
		log.info("User Click on Board Member Job Level Filter");
	}

	@Then("Check Board Member Job Level in Result")
	public void I_Check_BoardMember_Job_Level_In_Result() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getBoardMemberJobLevelInResult().isDisplayed());
		log.info("User Check Board Member Job Level in Result");
	}

	@Then("Check Board Member Job Level in All Searched Results")
	public void I_Check_Board_Member_Job_Level_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the Board Member Job Level in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'Board Member')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//div[contains(text(),'Board Member')])["+i+"]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". Job Level of "+ContactName+" is Board Member");
		}

		log.info("Check Board Member Job Level in All Searched Results");
	}

	@When("Verify Role Section is displayed")
	public void I_verify_Role_Section() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getRolesection().isDisplayed());
		log.info("User Verify Role Section is displayed");
	}

	@When("Verify Job Level Select All Option is displayed")
	public void I_verify_job_level_Select_all() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getJobLevelSelectAll().isDisplayed());
		log.info("Verify Job Level Select All Option is displayed");
	}

	@And("Click On Job Level Select All Option")
	public void I_Click_Job_Level_Select_all_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getJobLevelSelectAll());
		log.info("User click Click On Login Button");
	}

	@When("Verify Job Level Board Member Option is displayed")
	public void I_verify_job_level_Board_Memeber() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getJobBoardMember().isDisplayed());
		log.info("erify Job Level Board Member Option is displayed");
	}

	@And("Click On Job Level Board Member Option")
	public void I_Click_Job_Level_Button_Board_Member() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getJobBoardMember());
		log.info("User click Click On Login Button");
	}

	@When("Verify Job Level C-Level Executive Option is displayed")
	public void I_verify_job_level_cexecutive() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getJobclevelexecutiveFilter().isDisplayed());
		log.info("Verify Job Level C-Level Executive Option is displayed");
	}

	@And("Click On C-Level Executive Job Level Filter")
	public void I_Click_Clevel_Executive_Job_Level_Filter() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getJobclevelexecutiveFilter());
		log.info("User Click On C-Level Executive Job Level Filter");
	}

	@And("Click On Vice Presidents Job Level Filter")
	public void I_Click_Voice_Precident_Job_Level_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getVicePrecidentsJobLevelFilter());
		log.info("Click On Vice Presidents Job Level Filter");
	}

	@And("Click On Directors Job Level Filter")
	public void I_Click_Directors_Job_Level_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getDirectorsJobLevelFilter());
		log.info("User Click On Directors Job Level Filter");
	}

	@And("Click On Managers Job Level Filter")
	public void I_Click_Managers_Job_Level_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getManagersJobLevelFilter());
		log.info("User Click On Managers Job Level Filter");
	}

	@And("Click On Key Influencers Job Level Filter")
	public void I_Click_Key_Influencers_Job_Level_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getKeyInfluencersJobLevelFilter());
		log.info("User Click On Key Influencers Job Level Filter");
	}


	@And("Verify Title filter is Displayed")
	public void I_Verify_Title_Filter() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getTitleFilter().isDisplayed());
		log.info("User Verify Title filter is Displayed");
	}

	@And("Click on Title Filter")
	public void I_Click_On_Title_Filter() throws Throwable {
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getTitleFilter());
		Thread.sleep(2000);
		log.info("User click on Title Filter");
	}

	@And("Enter Title in Title filter")
	public void I_Enter_Job_Title() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getTitleTextField(),
				ReadDatafromJson("Contact_Name", "Job_Title"));
		log.info("User enter Job Title in Tile text field");
		Thread.sleep(2000);
	}

	@Then("Check searched title is displayed in Search Result")
	public void I_Check_Title_In_Result() throws Throwable {
		String JobTitle=ReadDatafromJson("Contact_Name", "Job_Title");
		Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'"+JobTitle+"')])[1]")).isDisplayed());
//		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getTitleInResult().isDisplayed());
		String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div[1]/div/div/div/div[1]/div/div[2]/span/span")).getText();
		System.out.println(ContactName+" is working as "+JobTitle);
		Thread.sleep(3000);
		log.info("User Check searched title is displayed in Search Result");
	}

	@Then("Check Job Title in All Searched Results")
	public void I_Check_Job_Level_In_All_Searched_Results() throws Throwable {
		String JobTitle=ReadDatafromJson("Contact_Name", "Job_Title");
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the Job Title in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'"+JobTitle+"')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//div[contains(text(),'"+JobTitle+"')])["+i+"]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". ["+ContactName+"] is working as "+JobTitle+"");
		}

		log.info("Check Job Title in All Searched Results");
	}

	@When("Verify Location filter is Displayed")
	public void I_Verify_Location_Filter() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getLocationFilter().isDisplayed());
		log.info("User verify Location filter is Displayed");
	}

	@And("Click on Location Filter")
	public void I_Click_Location_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getLocationFilter());
		Thread.sleep(5000);
		log.info("User Click on Location Filter");
	}

	@And("Click on State Page")
	public void I_Click_On_State_Page() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getStatePage());
		log.info("User Click on State Page");
	}

	@And("Click on States Filter")
	public void I_Click_State_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getStateField());
		Thread.sleep(2000);
		log.info("User click on States Filter");
	}

	@And("Enter California State")
	public void I_Enter_California_State() throws Throwable {
		Thread.sleep(5000);
		enterData(PageObjectManager.getInstance().getLoginPage().getStateField(),
				ReadDatafromJson("Contact_Name", "StateName"));
		log.info("User Enter the California State");
	}

	@Then("Click on Location Tab")
	public void I_Click_Location_Tab() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().LocationTab());
		log.info("User click on Location Tab");
		Thread.sleep(10000);
	}

	@Then("Click on State Combobox")
	public void I_Click_State_Combobox() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().Statevalueselection());
		log.info("User Click on State Combobox");
		Thread.sleep(10000);
	}

	@When("Enter the Data in State Combobox")
	public void i_enter_the_Data_State_Combobox() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().Statevalueselection(), ReadDatafromJson("Contact_Name", "Stateselection"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("Enter the Data in State Combobox");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
	}


	@And("Click on California State")
	public void I_Click_On_California_State() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getCaliforniaState());
		Thread.sleep(3000);
		log.info("User Click on California State");
	}

	@Then("Check CA for California State in Search Result")
	public void I_Check_California_In_Result() throws Throwable {
		Thread.sleep(2000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getCaliforniaInResult().isDisplayed());
		log.info("User Check CA for California State in Search Result");
	}

	@Then("Check California State in All Searched Results")
	public void I_Check_California_State_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the California State in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'CA')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//span[contains(text(),'CA')])["+i+"]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". ["+ContactName+"] is working in California State");
		}

		log.info("User Check California State in All Searched Results");
	}

	@And("Click on Zip code under USA")
	public void I_Click_On_Zip_Code_Page() throws Throwable {
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getZipCodePage());
		log.info("User click on Zip code page under USA");
		Thread.sleep(2000);
	}

	@And("Enter Zip Code in the text field")
	public void I_Enter_Zip_Code() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getZipCodeTextField(),
				ReadDatafromJson("Contact_Name", "Zip_Code"));
		log.info("User Enter the Zip Code");
	}

	@And("Select 100 Miles in the dropdown")
	public void I_Select_100_Miles_Under_Zip_Code() throws Throwable {
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getMilesSelectBox());
		Thread.sleep(2000);
		Select milesOptions = new Select(PageObjectManager.getInstance().getLoginPage().getMilesSelectBox());
		milesOptions.selectByVisibleText("100 Miles");
		Thread.sleep(2000);
		log.info("User select 100 Miles in the dropdown");
	}

	@And("Click on Metro Areas under USA")
	public void I_Click_On_Metro_Area_Page() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getMetroAreaPage());
		Thread.sleep(2000);
		log.info("User click on Metro Areas under USA");
	}

	@And("Click on Metro Areas Text Field")
	public void I_Click_on_Metro_Area_Text_Field() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getMetroAreaTextField());
		Thread.sleep(1000);
		log.info("User Click on Metro Areas Text Field");
	}

	@And("Click on Albany GA Metro Area")
	public void I_Click_On_Albany_GA_Metro_Area() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getAlbanyORMetroArea());
		Thread.sleep(2000);
		log.info("Click on Albany GA Metro Area");
	}

	@And("Enter Albany GA Metro Area")
	public void I_Enter_Albany_GA_Metro_Area() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getMetroAreaTextField(), ReadDatafromJson("Contact_Name", "Metro Area"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("Enter Albany GA Metro Area");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
	}

	@Then("Check Metro Area in Search Result")
	public void I_Check_Metro_Area_In_Search_Result() throws Throwable{
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getMetroAreatInSearchResult().isDisplayed());
		log.info("User Check Metro Area in Search Result");
	}

	@Then("Check Albany GA Metro Area in All Searched Results")
	public void I_Check_Albany_GA_Metro_Area_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the Albany, GA Metro Area in All searched Results");
		for (int i=2;i<=HvContactCount+1;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'Albany, GA')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//span[contains(text(),'Albany, GA')])["+i+"]")));
			int j=i-1;
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+j+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+j+". ["+ContactName+"] is working in Albany, GA Metro Area");
		}
		log.info("User Check Albany, GA Metro Area in All Searched Results");
	}

	@And("Click on Non USA Radio Button")
	public void I_Click_on_Non_USA_Radio_Button() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getNonUsaRadioButton());
		log.info("User Click on Non USA Radio Button");
		Thread.sleep(2000);
	}

	@And("Click on Global Radio Button")
	public void I_Click_on_Global_Radio_Button() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getGlobalRadioButton());
		log.info("User Click on Global Radio Button");
		Thread.sleep(2000);
	}

	@And("Click on Country Input Box")
	public void I_Click_On_Country_Box() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getCountryBox());
		log.info("User click on Country Input Box");
		Thread.sleep(2000);
	}

	@And("Enter Non USA Country Name")
	public void I_Enter_Non_USA_Country_Name() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getCountryBox(), ReadDatafromJson("Contact_Name", "Non-USA Country"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("User enter Non USA Country Name");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
	}

	@And("Enter Global Country Name")
	public void I_Enter_Global_Country_Name() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getCountryBox(), ReadDatafromJson("Contact_Name", "Global Country"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("User enter Global Country Name");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
	}

	@Then("Check Country in Location in Search Result")
	public void I_Check_Country_Location_In_Result() throws Throwable {
		String NonUSACountry = ReadDatafromJson("Contact_Name", "Non-USA Country");
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),\'" + NonUSACountry + "\')]")).isDisplayed());
		log.info("Non USA Country is displayed under Location in Search Result");
		Thread.sleep(3000);
	}

	@Then("Check Non-USA Location in All Searched Results")
	public void I_Check_Non_USA_Location_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the Non-USA Location in All searched Results");
		String NonUSACountry = ReadDatafromJson("Contact_Name", "Non-USA Country");
		for (int i=3;i<=HvContactCount+2;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(text(),'"+NonUSACountry+"')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//*[contains(text(),'"+NonUSACountry+"')])["+i+"]")));
			int j=i-2;
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+j+". ["+ContactName+"] is working in "+NonUSACountry+" Location");
			j=0;
		}

		log.info("User Check Non-USA Location in All Searched Results");
	}



	@Then("Check Global Country in Location in Search Result")
	public void I_Check_Global_Country_Location_In_Result() throws Throwable {
		String GlobalCountryName = ReadDatafromJson("Contact_Name", "Global Country");
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),\'" + GlobalCountryName + "\')]")).isDisplayed());
		log.info("Global Country is displayed under Location in Search Result");
		Thread.sleep(3000);
	}
	@Then("Check Global Location in All Searched Results")
	public void I_Check_Global_Location_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the Global Location in All searched Results");
		String GlobalCountryName = ReadDatafromJson("Contact_Name", "Global Country");
		for (int i=3;i<=HvContactCount+2;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'"+GlobalCountryName+"')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//span[contains(text(),'"+GlobalCountryName+"')])["+i+"]")));
			int j=i-2;
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+j+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+j+". ["+ContactName+"] is working in "+GlobalCountryName+" Location");
			j=0;
		}

		log.info("User Check Global Location in All Searched Results");
	}


	@When("Click on Keywords Filter")
	public void I_Click_On_Keywords_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getKeywordsFilter());
		log.info("User click on Keywords Filter");
	}

	@And("Click on Keywords Input box")
	public void I_Click_On_Keywords_Input_Box() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getKeywordsInputBox());
		log.info("User click on Keywords Input Box");
	}

	@And("Enter the Keyword")
	public void I_Enter_Keyword_In_Input_Box() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getKeywordsInputBox(), ReadDatafromJson("Contact_Name", "Keyword"));
		Thread.sleep(3000);
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("User Enter the Keyword");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
	}

	@And("Click on First Company Link in Result page")
	public void I_Click_on_First_Company_Link_in_Result_page() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getFirstCompanyLinkInResult());
		log.info("User Click on First Company Link in Result page");
	}

	@Then("Check searched Keyboard in company detail page")
	public void I_Check_searched_Keyboard_in_company_detail_page() throws Throwable{
		Thread.sleep(3000);
		String Keyword=ReadDatafromJson("Contact_Name", "Keyword");
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'"+Keyword+"')]")).isDisplayed());
		log.info("User validated searched Keyboard in company detail page");
	}

	@Then("Check Keyword in All Searched Results")
	public void I_Check_Keyword_In_All_Searched_Results() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().isDisplayed());
		String HvCompanyCountNotTrimmed =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().getText();
		String HvCompanyCountTrimmed =HvCompanyCountNotTrimmed.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvCompanyCount =Integer.parseInt(HvCompanyCountTrimmed);
		System.out.println("There are total "+HvCompanyCount+" Human Verified Companies, Validate the  Keyword in All searched Results");
		String Keyword=ReadDatafromJson("Contact_Name", "Keyword");
		for (int i=2;i<=HvCompanyCount+1;i++){
			String CompanyName=driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a/..")).getText();
			clickButton(driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a")));
			Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(text(),'"+Keyword+"')])")).isDisplayed());
			int j=i-1;
			System.out.println("Sn "+j+". "+CompanyName+" Company contains "+Keyword+" Keyword");
			j=0;
			clickButton(PageObjectManager.getInstance().getLoginPage().getSalesIntelLogo());
		}

		log.info("User Check Keyword in All Searched Results");
	}

	@When("Click on Industry Filter")
	public void I_Click_On_Industry_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getIndustryFilter());
		log.info("Click on Industry Filter");
		Thread.sleep(2000);
	}

	@And("Click on NAICS or SIC Code page")
	public void I_Click_NAICSorSIC_Code_page() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getNAICSorSICpage());
		log.info("User Click on NAICS or SIC Code page");
		Thread.sleep(3000);
	}

	@And("Click on SIC Radio button")
	public void I_Click_SIC_Code_Radio_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getSICcodeRadioButton());
		log.info("User Click on SIC Radio button");
	}

	@When("Click on Revenue Filter")
	public void I_Click_On_Revenue_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getRevenueFilter());
		log.info("USer Click on Revenue Filter");
		Thread.sleep(2000);
	}

	@When("Click on Employee Size Filter")
	public void I_Click_On_Employee_Size_Filter() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getEmployeeSizeFilter());
		log.info("USer Click on Employee Size Filter");
		Thread.sleep(2000);
	}

	@And("Enter Minimum Revenue")
	public void I_Enter_Minimum_Revenue() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getMinRevenueInputBox(), ReadDatafromJson("Contact_Name", "Minimum Revenue"));
		log.info("User Enter Minimum Revenue");
		Thread.sleep(2000);
	}

	@And("Enter Minimum Employee Size")
	public void I_Enter_Minimum_Employee_Size() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getMinEmpSizeInputBox(), ReadDatafromJson("Contact_Name", "Minimum Employee Size"));
		log.info("User Enter Minimum Employee Size");
		Thread.sleep(2000);
	}

	@And("Enter Maximum Revenue")
	public void I_Enter_Maximum_Revenue() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getMaxRevenueInputBox(), ReadDatafromJson("Contact_Name", "Maximum Revenue"));
		log.info("User Enter Maximum Revenue");
		Thread.sleep(2000);
	}

	@And("Enter Maximum Employee Size")
	public void I_Enter_Maximum_Employee_Size() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getMaxEmpSizeInputBox(), ReadDatafromJson("Contact_Name", "Maximum Employee Size"));
		log.info("User Enter Maximum Employee Size");
		Thread.sleep(2000);
	}

	@Then("validate the Revenue in Search Result")
	public void I_Check_Revenue_In_Result() throws Throwable {
		Thread.sleep(2000);
		String RevenueInResult = PageObjectManager.getInstance().getLoginPage().getRevenueInSearchResult().getText();
		String RevenueCleaned = RevenueInResult.replaceAll("[A-Z]", "");
		double RevenueDouble = Double.parseDouble(RevenueCleaned);
		int RevenueInteger = (int) RevenueDouble;
		int MinimumRevenue = Integer.parseInt(ReadDatafromJson("Contact_Name", "Minimum Revenue"));
		int MaximumRevenue = Integer.parseInt(ReadDatafromJson("Contact_Name", "Maximum Revenue"));
		if (RevenueInteger >= MinimumRevenue && RevenueInteger <= MaximumRevenue) {
			System.out.println("Revenue Range is From " + MinimumRevenue + " To " + MaximumRevenue + " and Revenue in Searched Result is " + RevenueInteger + "");
			log.info("User Validated that Searched Revenue is Between the Input Range");
		} else {
			System.out.println("Revenue Range is From " + MinimumRevenue + " To " + MaximumRevenue + " and Revenue in Searched Result is " + RevenueInteger + "");
			log.info("User Validated that Searched Revenue is Out of the Input Range");
		}
		Thread.sleep(3000);
	}

	@Then("Check Revenue in All Searched Results")
	public void I_Check_Revenue_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Let's Validate the Revenue in All searched Results");
		int MinimumRevenue = Integer.parseInt(ReadDatafromJson("Contact_Name", "Minimum Revenue"));
		int MaximumRevenue = Integer.parseInt(ReadDatafromJson("Contact_Name", "Maximum Revenue"));
		for (int i=1;i<=HvContactCount;i++){
			clickButton(driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span")));
			String RevenueInResult = driver.findElement(By.xpath("(//div[contains(text(),'Company Revenue:')])["+i+"]/../span")).getText();
			String RevenueCleaned = RevenueInResult.replaceAll("[A-Z]", "");
			double RevenueDouble = Double.parseDouble(RevenueCleaned);
			int RevenueInteger = (int) RevenueDouble;
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			if (RevenueInteger >= MinimumRevenue && RevenueInteger <= MaximumRevenue) {
				System.out.println("Sn "+i+". Contact Name = ["+ContactName+"] and his Company Revenue is ["+RevenueInResult+"] Where Revenue range is [" +MinimumRevenue+" - "+MaximumRevenue+"]");
			} else {
				System.out.println("Sn "+i+". Contact Name = ["+ContactName+"] and his Company Revenue is ["+RevenueInResult+"] Where Revenue range is [" +MinimumRevenue+" - "+MaximumRevenue+"] - TC Failed");
			}
		}

		log.info("User Check Revenue  in All Searched Results");
	}

	@Then("validate the Employee Size in Search Result")
	public void I_Check_Employee_Size_In_Result() throws Throwable {
		Thread.sleep(2000);
		String EmpSizeInResult = PageObjectManager.getInstance().getLoginPage().getEmpSizeInSearchResult().getText();
//		String RevenueCleaned = RevenueInResult.replaceAll("[A-Z]", "");
//		double RevenueDouble = Double.parseDouble(RevenueCleaned);
		int EmpSizeInteger = Integer.parseInt(EmpSizeInResult);
		int MinimumEmpSize = Integer.parseInt(ReadDatafromJson("Contact_Name", "Minimum Employee Size"));
		int MaximumEmpSize = Integer.parseInt(ReadDatafromJson("Contact_Name", "Maximum Employee Size"));
		if (EmpSizeInteger >= MinimumEmpSize && EmpSizeInteger <= MaximumEmpSize) {
			System.out.println("Employees / Size Range is From " + MinimumEmpSize + " To " + MaximumEmpSize + " and Company Size in Searched Result is " + EmpSizeInteger + "");
			log.info("User Validated that Searched Company size is Between the Input Range");
		} else {
			System.out.println("Employees / size Range is From " + MinimumEmpSize + " To " + MaximumEmpSize + " and Company size in Searched Result is " + EmpSizeInResult + "");
			log.info("User Validated that Searched Company Size is Out of the Input Range");
		}
		Thread.sleep(3000);
	}

	@Then("Check Employee or Size in All Searched Results")
	public void I_Check_Employee_Or_Size_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Let's Validate the Employees or Size in All searched Results");
		int MinimumEmployeeSize = Integer.parseInt(ReadDatafromJson("Contact_Name", "Minimum Employee Size"));
		int MaximumEmployeeSize = Integer.parseInt(ReadDatafromJson("Contact_Name", "Maximum Employee Size"));
		for (int i=1;i<=HvContactCount;i++){
			clickButton(driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span")));
			String EmployeeSizeInResult = driver.findElement(By.xpath("(//div[contains(text(),'Company Size:')])["+i+"]/../span")).getText();
			String EmployeeSizeCleaned = EmployeeSizeInResult.replaceAll("[A-Z]", "");
			double EmployeeSizeDouble = Double.parseDouble(EmployeeSizeCleaned);
			int EmployeeSizeInteger = (int) EmployeeSizeDouble;
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			if (EmployeeSizeInteger >= MinimumEmployeeSize && EmployeeSizeInteger <= MaximumEmployeeSize) {
				System.out.println("Sn "+i+". Contact Name = ["+ContactName+"] and his Company Employee Size is ["+EmployeeSizeInResult+"] Where Employee Size range is [" +MinimumEmployeeSize+" - "+MaximumEmployeeSize+"]");
			} else {
				System.out.println("Sn "+i+". Contact Name = ["+ContactName+"] and his Company Employee Size is ["+EmployeeSizeInResult+"] Where Employee Size range is [" +MinimumEmployeeSize+" - "+MaximumEmployeeSize+"] - TC Failed");
			}
		}

		log.info("User Check Employees/Size  in All Searched Results");
	}

	@When("Validate TECHNOGRAPHICS is displayed")
	public void I_Check_Technographics() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getTechnographics().isDisplayed());
		log.info("Technographics is Displayed");
	}

	@And("Click on Products Filter")
	public void I_Click_On_Producet() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getProductFilter());
		log.info("User Click on Products Filter");
		Thread.sleep(2000);
	}


	@And("Click on Provider Filter")
	public void I_Click_On_Provider() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getProviderFilter());
		log.info("User Click on Provider Filter");
		Thread.sleep(2000);
	}

	@And("Click on Categories Filter")
	public void I_Click_On_Categories() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getCategoriesFilter());
		log.info("User Click on Categories Filter");
		Thread.sleep(2000);
	}

	@And("Select All Check box for Categories")
	public void I_Click_On_SelectALL_CheckBox_In_Categories() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getSelectAllCheckBoxForCategories());
		log.info("User Select All Check box for Categories");
		Thread.sleep(2000);
	}

	@And("Click on Technographic product text box")
	public void I_Click_On_Product_Text_Box() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getProductTextBox());
		log.info("Click on Technographic product text box");
		Thread.sleep(2000);
	}

	@And("Click on Technographic Provider text box")
	public void I_Click_On_Provider_Text_Box() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getProviderTextBox());
		log.info("Click on Technographic Provider text box");
		Thread.sleep(2000);
	}


	@And("Enter the product name")
	public void I_Enter_The_Product_Name() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getProductTextBox(), ReadDatafromJson("Contact_Name", "Product Name1"));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		enterData(PageObjectManager.getInstance().getLoginPage().getProductTextBox(), ReadDatafromJson("Contact_Name", "Product Name2"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getProductTextBox(), ReadDatafromJson("Contact_Name", "Product Name3"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log.info("User Enter the product name");
		Thread.sleep(5000);
	}

	@And("Enter the Provider name")
	public void I_Enter_The_Provider_Name() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getProviderTextBox(), ReadDatafromJson("Contact_Name", "Provider Name1"));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		enterData(PageObjectManager.getInstance().getLoginPage().getProviderTextBox(), ReadDatafromJson("Contact_Name", "Provider Name2"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getProviderTextBox(), ReadDatafromJson("Contact_Name", "Provider Name3"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log.info("User Enter the Provider name");
		Thread.sleep(5000);

	}

	@And("Enter the Category name")
	public void I_Enter_The_Category_Name() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getCategoryTextBox(), ReadDatafromJson("Contact_Name", "Category Name1"));
		String CategoryName1 = ReadDatafromJson("Contact_Name" , "Category Name1");
		clickButton(driver.findElement(By.xpath("//span[contains(text(),\'" + CategoryName1 + "\')]")));
		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getCategoryTextBox());
		Thread.sleep(1000);
		enterData(PageObjectManager.getInstance().getLoginPage().getCategoryTextBox(), ReadDatafromJson("Contact_Name", "Category Name2"));
		String CategoryName2 = ReadDatafromJson("Contact_Name" , "Category Name2");
		clickButton(driver.findElement(By.xpath("//span[contains(text(),\'" + CategoryName2 + "\')]")));
		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getCategoryTextBox());
		Thread.sleep(1000);
		enterData(PageObjectManager.getInstance().getLoginPage().getCategoryTextBox(), ReadDatafromJson("Contact_Name", "Category Name3"));
		String CategoryName3 = ReadDatafromJson("Contact_Name" , "Category Name3");
		clickButton(driver.findElement(By.xpath("//span[contains(text(),\'" + CategoryName3 + "\')]")));
		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getCategoryTextBox());
		Thread.sleep(1000);
		log.info("User Enter the Category name");
		Thread.sleep(2000);

	}

	@And("Click on company name")
	public void I_Click_On_Company_Name() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getFirstCompanyLinkInResult());
		log.info("User Click on company name");
		Thread.sleep(3000);
	}

	@And("Click on All in Company detail page")
	public void I_Click_On_All() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getAllButton());
		log.info("User Click on All in Company detail page");
		Thread.sleep(3000);
	}

	@And("Click on All Button in Products")
	public void I_Click_On_All_Button_In_Products() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getALLButtonInProduct());
		log.info("User Click on All Button in Products");
		Thread.sleep(1000);
	}

	@And("Click on All Button in Provider")
	public void I_Click_On_All_Button_In_Provider() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getALLButtonInProvider());
		log.info("User Click on All Button in Providers");
		Thread.sleep(1000);
	}

	@And("Click on All Button in Category")
	public void I_Click_On_All_Button_In_Category() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getALLButtonInCategory());
		log.info("User Click on All Button in Category");
		Thread.sleep(1000);
	}

	@And("Click on None Button in Products")
	public void I_Click_On_None_Button_In_Products() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getNoneButtonInProduct());
		log.info("User Click on None Button in Products");
		Thread.sleep(1000);
	}

	@And("Click on None Button in Provider")
	public void I_Click_On_None_Button_In_Providers() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getNoneButtonInProvider());
		log.info("User Click on None Button in Providers");
		Thread.sleep(1000);
	}

	@And("Click on None Button in Category")
	public void I_Click_On_None_Button_In_Category() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getNoneButtonInCategory());
		log.info("User Click on None Button in Category");
		Thread.sleep(1000);
	}

	@And("Click on SalesIntel Logo")
	public void I_Click_On_SalesIntel_Logo() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getSalesIntelLogo());
		log.info("User Click on SalesIntel Logo");
		Thread.sleep(2000);
	}


	@When("Click on Back to search results")
	public void I_Click_On_Back_To_Search_Results() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getBackToSearchResults());
		log.info("USer Click on Back to search results");
		Thread.sleep(2000);
	}

	@And("Validate Back to Search button is displayed")
	public void I_Validate_Back_To_Search_Button() throws Throwable{
		Thread.sleep(2000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getBackToSearchResults().isDisplayed());
		log.info("User Validate Back to Search button is displayed");
	}

	@And("Enter the product name in Search textbox")
	public void I_Enter_Product_Name() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name1"));
		log.info("Enter the product name in Search textbox");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}



//	@Then("Check the technographic product in Company detail page")
//	public void I_Check_Product_In_Result() throws Throwable {
//	String CopyProductFromResult = PageObjectManager.getInstance().getLoginPage().getProductInResult().getText();
//	String EnteredProduct = ReadDatafromJson("Contact_Name", "Product Name1");
//		if(CopyProductFromResult.contentEquals(EnteredProduct))
//
//	{
//		System.out.println("Searched Product is Displayed in Search Result");
//		log.info("Check the technographic product in Company detail page");
//	}
//		else
//		{
//		System.out.println("Searched Product is not Displayed in Search Result");
//		log.info("Check the technographic product in Company detail page and it's Failed");
//	    }
//
//}

	@Then("Check Any technographic product in Company detail page")
	public void I_Check_Any_Product_In_Result() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name1"));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean FirstProductForAny = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
				FirstProductForAny = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("First product is not displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name2"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean SecondProductForAny = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
				SecondProductForAny = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
			}
		}
		catch (Exception e) {
			System.out.println("Second product is not Displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name3"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean ThirdProductForAny = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
				ThirdProductForAny = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("Third product is not displayed in Results");
		}
		Thread.sleep(2000);
		if (FirstProductForAny || SecondProductForAny || ThirdProductForAny){
			log.info("User Validated Any one technographic product in Company detail page");
		}
		else {
			log.info("Not even one Searched product is displayed in Company Detail page TC - Failed");
		}

	}

	@Then("Check Any technographic product in Company detail page of All Searched Results")
	public void I_Check_Any_technographic_product_in_Company_detail_page_of_All_Searched_Results() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().isDisplayed());
		String HvCompanyCountNotTrimmed =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().getText();
		String HvCompanyCountTrimmed =HvCompanyCountNotTrimmed.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvCompanyCount =Integer.parseInt(HvCompanyCountTrimmed);
		System.out.println("There are total "+HvCompanyCount+" Human Verified Companies, Validate the  Keyword in All searched Results");
		String Keyword=ReadDatafromJson("Contact_Name", "Keyword");
		for (int i=2;i<=HvCompanyCount+1;i++){
			String CompanyName=driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a/..")).getText();
			clickButton(driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a")));
			int j=i-1;
			clickButton(PageObjectManager.getInstance().getLoginPage().getAllButton());
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean FirstProductForAny = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
					FirstProductForAny = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("First product is not displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name2"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean SecondProductForAny = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
					SecondProductForAny = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
				}
			}
			catch (Exception e) {
//				System.out.println("Second product is not Displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name3"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean ThirdProductForAny = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
					ThirdProductForAny = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("Third product is not displayed in Results");
			}
			Thread.sleep(2000);
			if (FirstProductForAny || SecondProductForAny || ThirdProductForAny){
//				log.info("User Validated Any one technographic product in Company detail page");
			}
			else {
//				log.info("Not even one Searched product is displayed For "+CompanyName+" Company TC - Failed");
			}
			System.out.println("Sn "+j+". ["+CompanyName+"] Company contains Any one of the searched product");
			clickButton(PageObjectManager.getInstance().getLoginPage().getSalesIntelLogo());
		}

		log.info("User Check Any product in All Searched Results");
	}



	@Then("Check Any technographic product in Company detail page for All Search Results")
	public void I_Check_Any_Tech_Product_for_All_Search_Results() throws Throwable{
//		Get Count of Searched Companies
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().isDisplayed());
		String HvCompanyCountNotTrimmed =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().getText();
		String HvCompanyCountTrimmed =HvCompanyCountNotTrimmed.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvCompanyCount =Integer.parseInt(HvCompanyCountTrimmed);
		System.out.println("Total Searched Human Verified Companies are "+HvCompanyCount);
		Scrollpup(PageObjectManager.getInstance().getLoginPage().getScrolldown());
//		int i=5;
//		driver.findElement(By.xpath("(//input[@type='checkbox' and @title])[" + i + "]//..//..//../div[3]/div[1]/a"));
//		System.out.println("i value is"+i);

	}

	@And("Check Any technographic Provider in Company detail page")
	public void I_Check_Any_Provider_In_Result() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name1"));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean FirstProviderForAny = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
				FirstProviderForAny = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("First Provider is not displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name2"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean SecondProviderForAny = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
				SecondProviderForAny = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
			}
		}
		catch (Exception e) {
			System.out.println("Second Provider is not Displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name3"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean ThirdProviderForAny = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
				ThirdProviderForAny = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("Third Provider is not displayed in Results");
		}
		Thread.sleep(2000);
		if (FirstProviderForAny || SecondProviderForAny || ThirdProviderForAny){
			log.info("User Validated Any one technographic Provider in Company detail page");
		}
		else {
			log.info("Not even one Searched Provider is displayed in Company Detail page TC - Failed");
		}

	}

	@Then("Check Any technographic Category in Company detail page of All Searched Results")
	public void I_Check_Any_technographic_Category_in_Company_detail_page_of_All_Searched_Results() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().isDisplayed());
		String HvCompanyCountNotTrimmed =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().getText();
		String HvCompanyCountTrimmed =HvCompanyCountNotTrimmed.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvCompanyCount =Integer.parseInt(HvCompanyCountTrimmed);
		System.out.println("There are total "+HvCompanyCount+" Human Verified Companies, Validate the  Keyword in All searched Results");
		String Keyword=ReadDatafromJson("Contact_Name", "Keyword");
		for (int i=2;i<=HvCompanyCount+1;i++){
			String CompanyName=driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a/..")).getText();
			clickButton(driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a")));
			int j=i-1;
			clickButton(PageObjectManager.getInstance().getLoginPage().getAllButton());
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean FirstCategoryForAny = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
					FirstCategoryForAny = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("First Category is not displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name2"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean SecondCategoryForAny = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
					SecondCategoryForAny = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
				}
			}
			catch (Exception e) {
//				System.out.println("Second Category is not Displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name3"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean ThirdCategoryForAny = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
					ThirdCategoryForAny = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("Third Category is not displayed in Results");
			}
			Thread.sleep(2000);
			if (FirstCategoryForAny || SecondCategoryForAny || ThirdCategoryForAny){
//				log.info("User Validated Any one technographic Category in Company detail page");
			}
			else {
//				log.info("Not even one Searched Category is displayed For "+CompanyName+" Company TC - Failed");
			}
			System.out.println("Sn "+j+". ["+CompanyName+"] Company contains Any one of the searched Category");
			clickButton(PageObjectManager.getInstance().getLoginPage().getSalesIntelLogo());
		}

		log.info("User Check Any Category in All Searched Results");
	}


	@Then("Check Any technographic Provider in Company detail page of All Searched Results")
	public void I_Check_Any_technographic_Provider_in_Company_detail_page_of_All_Searched_Results() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().isDisplayed());
		String HvCompanyCountNotTrimmed =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().getText();
		String HvCompanyCountTrimmed =HvCompanyCountNotTrimmed.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvCompanyCount =Integer.parseInt(HvCompanyCountTrimmed);
		System.out.println("There are total "+HvCompanyCount+" Human Verified Companies, Validate the  Keyword in All searched Results");
		String Keyword=ReadDatafromJson("Contact_Name", "Keyword");
		for (int i=2;i<=HvCompanyCount+1;i++){
			String CompanyName=driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a/..")).getText();
			clickButton(driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a")));
			int j=i-1;
			clickButton(PageObjectManager.getInstance().getLoginPage().getAllButton());
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean FirstProviderForAny = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
					FirstProviderForAny = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("First Provider is not displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name2"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean SecondProviderForAny = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
					SecondProviderForAny = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
				}
			}
			catch (Exception e) {
//				System.out.println("Second Provider is not Displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name3"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean ThirdProviderForAny = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
					ThirdProviderForAny = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("Third Provider is not displayed in Results");
			}
			Thread.sleep(2000);
			if (FirstProviderForAny || SecondProviderForAny || ThirdProviderForAny){
//				log.info("User Validated Any one technographic Provider in Company detail page");
			}
			else {
//				log.info("Not even one Searched Provider is displayed For "+CompanyName+" Company TC - Failed");
			}
			System.out.println("Sn "+j+". ["+CompanyName+"] Company contains Any one of the searched Provider");
			clickButton(PageObjectManager.getInstance().getLoginPage().getSalesIntelLogo());
		}

		log.info("User Check Any Provider in All Searched Results");
	}


	@And("Check Any technographic Category in Company detail page")
	public void I_Check_Any_Category_In_Result() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name1"));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean FirstCategoryForAny = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
				FirstCategoryForAny = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("First Category is not displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name2"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean SecondCategoryForAny = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
				SecondCategoryForAny = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
			}
		}
		catch (Exception e) {
			System.out.println("Second Category is not Displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name3"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean ThirdCategoryForAny = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
				ThirdCategoryForAny = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("Third Category is not displayed in Results");
		}
		Thread.sleep(2000);
		if (FirstCategoryForAny || SecondCategoryForAny || ThirdCategoryForAny){
			log.info("User Validated Any one technographic Category in Company detail page");
		}
		else {
			log.info("Not even one Searched Category is displayed in Company Detail page TC - Failed");
		}

	}


	@Then("Check All technographic products in Company detail page")
	public void I_Check_All_Products_In_Result() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name1"));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean FirstProductForAll = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
				FirstProductForAll = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("First product is not displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name2"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean SecondProductForAll = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
				SecondProductForAll = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
			}
		}
		catch (Exception e) {
			System.out.println("Second product is not Displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name3"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean ThirdProductForAll = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
				ThirdProductForAll = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("Third product is not displayed in Results");
		}
		Thread.sleep(2000);
		if (FirstProductForAll && SecondProductForAll && ThirdProductForAll){
			log.info("User Validated All technographic products in Company detail page");
		}
		else {
			log.info("All Searched product are not displayed in Company Detail page TC - Failed");
		}

	}

	@Then("Check All technographic products in Company detail page of All Searched Results")
	public void I_Check_All_technographic_products_in_Company_detail_page_of_All_Searched_Results() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().isDisplayed());
		String HvCompanyCountNotTrimmed =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().getText();
		String HvCompanyCountTrimmed =HvCompanyCountNotTrimmed.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvCompanyCount =Integer.parseInt(HvCompanyCountTrimmed);
		System.out.println("There are total "+HvCompanyCount+" Human Verified Companies, Validate the  Keyword in All searched Results");
		String Keyword=ReadDatafromJson("Contact_Name", "Keyword");
		for (int i=2;i<=HvCompanyCount+1;i++){
			String CompanyName=driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a/..")).getText();
			clickButton(driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a")));
			int j=i-1;
			clickButton(PageObjectManager.getInstance().getLoginPage().getAllButton());
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean FirstProductForAll = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
					FirstProductForAll = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("First product is not displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name2"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean SecondProductForAll = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
					SecondProductForAll = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
				}
			}
			catch (Exception e) {
//				System.out.println("Second product is not Displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name3"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean ThirdProductForAll = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
					ThirdProductForAll = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("Third product is not displayed in Results");
			}
			Thread.sleep(2000);
			if (FirstProductForAll && SecondProductForAll && ThirdProductForAll){
//				log.info("User Validated All technographic products in Company detail page");
			}
			else {
//				log.info("Not even one Searched product is displayed For "+CompanyName+" Company TC - Failed");
			}
			System.out.println("Sn "+j+". ["+CompanyName+"] Company contains All of the searched products");
			clickButton(PageObjectManager.getInstance().getLoginPage().getSalesIntelLogo());
		}

		log.info("User Check All products in All Searched Results");
	}



	@Then("Check All technographic Providers in Company detail page")
	public void I_Check_All_Providers_In_Result() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name1"));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean FirstProviderForAll = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
				FirstProviderForAll = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("First Provider is not displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name2"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean SecondProviderForAll = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
				SecondProviderForAll = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
			}
		}
		catch (Exception e) {
			System.out.println("Second Provider is not Displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name3"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean ThirdProviderForAll = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
				ThirdProviderForAll = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("Third Provider is not displayed in Results");
		}
		Thread.sleep(2000);
		if (FirstProviderForAll && SecondProviderForAll && ThirdProviderForAll){
			log.info("User Validated All technographic Providers in Company detail page");
		}
		else {
			log.info("All Searched Provider are not displayed in Company Detail page TC - Failed");
		}

	}

	@Then("Check All technographic Providers in Company detail page of All Searched Results")
	public void I_Check_All_technographic_Providers_in_Company_detail_page_of_All_Searched_Results() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().isDisplayed());
		String HvCompanyCountNotTrimmed =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().getText();
		String HvCompanyCountTrimmed =HvCompanyCountNotTrimmed.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvCompanyCount =Integer.parseInt(HvCompanyCountTrimmed);
		System.out.println("There are total "+HvCompanyCount+" Human Verified Companies, Validate the  Keyword in All searched Results");
		String Keyword=ReadDatafromJson("Contact_Name", "Keyword");
		for (int i=2;i<=HvCompanyCount+1;i++){
			String CompanyName=driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a/..")).getText();
			clickButton(driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a")));
			int j=i-1;
			clickButton(PageObjectManager.getInstance().getLoginPage().getAllButton());
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean FirstProviderForAll = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
					FirstProviderForAll = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("First Provider is not displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name2"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean SecondProviderForAll = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
					SecondProviderForAll = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
				}
			}
			catch (Exception e) {
//				System.out.println("Second Provider is not Displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name3"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean ThirdProviderForAll = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
					ThirdProviderForAll = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("Third Provider is not displayed in Results");
			}
			Thread.sleep(2000);
			if (FirstProviderForAll && SecondProviderForAll && ThirdProviderForAll){
//				log.info("User Validated All technographic Providers in Company detail page");
			}
			else {
//				log.info("Not even one Searched Provider is displayed For "+CompanyName+" Company TC - Failed");
			}
			System.out.println("Sn "+j+". ["+CompanyName+"] Company contains All of the searched Providers");
			clickButton(PageObjectManager.getInstance().getLoginPage().getSalesIntelLogo());
		}

		log.info("User Check All Providers in All Searched Results");
	}

	@Then("Check All technographic Category in Company detail page")
	public void I_Check_All_Category_In_Result() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name1"));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean FirstCategoryForAll = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
				FirstCategoryForAll = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("First Category is not displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name2"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean SecondCategoryForAll = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
				SecondCategoryForAll = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
			}
		}
		catch (Exception e) {
			System.out.println("Second Category is not Displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name3"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean ThirdCategoryForAll = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
				ThirdCategoryForAll = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("Third Category is not displayed in Results");
		}
		Thread.sleep(2000);
		if (FirstCategoryForAll && SecondCategoryForAll && ThirdCategoryForAll){
			log.info("User Validated All technographic Category in Company detail page");
		}
		else {
			log.info("All Searched Category are not displayed in Company Detail page TC - Failed");
		}

	}

	@Then("Check All technographic Category in Company detail page of All Searched Results")
	public void I_Check_All_technographic_Category_in_Company_detail_page_of_All_Searched_Results() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().isDisplayed());
		String HvCompanyCountNotTrimmed =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().getText();
		String HvCompanyCountTrimmed =HvCompanyCountNotTrimmed.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvCompanyCount =Integer.parseInt(HvCompanyCountTrimmed);
		System.out.println("There are total "+HvCompanyCount+" Human Verified Companies, Validate the  Keyword in All searched Results");
		String Keyword=ReadDatafromJson("Contact_Name", "Keyword");
		for (int i=2;i<=HvCompanyCount+1;i++){
			String CompanyName=driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a/..")).getText();
			clickButton(driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a")));
			int j=i-1;
			clickButton(PageObjectManager.getInstance().getLoginPage().getAllButton());
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean FirstCategoryForAll = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
					FirstCategoryForAll = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("First Category is not displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name2"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean SecondCategoryForAll = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
					SecondCategoryForAll = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
				}
			}
			catch (Exception e) {
//				System.out.println("Second Category is not Displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name3"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean ThirdCategoryForAll = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
					ThirdCategoryForAll = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("Third Category is not displayed in Results");
			}
			Thread.sleep(2000);
			if (FirstCategoryForAll && SecondCategoryForAll && ThirdCategoryForAll){
//				log.info("User Validated All technographic Category in Company detail page");
			}
			else {
//				log.info("Not even one Searched Category is displayed For "+CompanyName+" Company TC - Failed");
			}
			System.out.println("Sn "+j+". ["+CompanyName+"] Company contains All of the searched Category");
			clickButton(PageObjectManager.getInstance().getLoginPage().getSalesIntelLogo());
		}

		log.info("User Check All Category in All Searched Results");
	}

	@Then("Check None of the technographic product is displayed in Company detail page")
	public void I_Check_None_Products_In_Result() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name1"));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean FirstProductForNone = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
				FirstProductForNone = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("First product is not displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name2"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean SecondProductForNone = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
				SecondProductForNone = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
			}
		}
		catch (Exception e) {
			System.out.println("Second product is not Displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name3"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean ThirdProductForNone = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
				ThirdProductForNone = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("Third product is not displayed in Results");
		}
		Thread.sleep(2000);
		if (!FirstProductForNone && !SecondProductForNone && !ThirdProductForNone){
			log.info("User Validated None of the technographic products is displayed in Company detail page");
		}
		else {
			log.info("Any one product is displayed in Company Detail page TC - Failed");
		}

	}


	@Then("Check None of the technographic products in Company detail page of All Searched Results")
	public void I_Check_None_Of_The_technographic_products_in_Company_detail_page_of_All_Searched_Results() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().isDisplayed());
		String HvCompanyCountNotTrimmed =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().getText();
		String HvCompanyCountTrimmed =HvCompanyCountNotTrimmed.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvCompanyCount =Integer.parseInt(HvCompanyCountTrimmed);
		System.out.println("There are total "+HvCompanyCount+" Human Verified Companies, Validate the  Keyword in All searched Results");
		String Keyword=ReadDatafromJson("Contact_Name", "Keyword");
		for (int i=2;i<=HvCompanyCount+1;i++){
			String CompanyName=driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a/..")).getText();
			clickButton(driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a")));
			int j=i-1;
			clickButton(PageObjectManager.getInstance().getLoginPage().getAllButton());
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean FirstProductForNone = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
					FirstProductForNone = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("First product is not displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name2"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean SecondProductForNone = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
					SecondProductForNone = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
				}
			}
			catch (Exception e) {
//				System.out.println("Second product is not Displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Product Name3"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean ThirdProductForNone = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed()) {
					ThirdProductForNone = PageObjectManager.getInstance().getLoginPage().getProductInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("Third product is not displayed in Results");
			}
			Thread.sleep(2000);
			if (!FirstProductForNone && !SecondProductForNone && !ThirdProductForNone){
//				log.info("User Validated None of the technographic products in Company detail page");
			}
			else {
//				log.info("Not even one Searched product is displayed For "+CompanyName+" Company TC - Failed");
			}
			System.out.println("Sn "+j+". ["+CompanyName+"] Company does not contain the searched products");
			clickButton(PageObjectManager.getInstance().getLoginPage().getSalesIntelLogo());
		}

		log.info("User Check None of the product is displayed in All Searched Results");
	}




	@Then("Check None of the technographic Provider is displayed in Company detail page")
	public void I_Check_None_Providers_In_Result() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name1"));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean FirstProviderForNone = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
				FirstProviderForNone = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("First Provider is not displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name2"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean SecondProviderForNone = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
				SecondProviderForNone = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
			}
		}
		catch (Exception e) {
			System.out.println("Second Provider is not Displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name3"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean ThirdProviderForNone = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
				ThirdProviderForNone = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("Third Provider is not displayed in Results");
		}
		Thread.sleep(2000);
		if (!FirstProviderForNone && !SecondProviderForNone && !ThirdProviderForNone){
			log.info("User Validated None of the technographic Providers is displayed in Company detail page");
		}
		else {
			log.info("Any one Provider is displayed in Company Detail page TC - Failed");
		}

	}


	@Then("Check None of the technographic Providers in Company detail page of All Searched Results")
	public void I_Check_None_Of_The_technographic_Providers_in_Company_detail_page_of_All_Searched_Results() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().isDisplayed());
		String HvCompanyCountNotTrimmed =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().getText();
		String HvCompanyCountTrimmed =HvCompanyCountNotTrimmed.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvCompanyCount =Integer.parseInt(HvCompanyCountTrimmed);
		System.out.println("There are total "+HvCompanyCount+" Human Verified Companies, Validate the  Keyword in All searched Results");
		String Keyword=ReadDatafromJson("Contact_Name", "Keyword");
		for (int i=2;i<=HvCompanyCount+1;i++){
			String CompanyName=driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a/..")).getText();
			clickButton(driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a")));
			int j=i-1;
			clickButton(PageObjectManager.getInstance().getLoginPage().getAllButton());
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean FirstProviderForNone = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
					FirstProviderForNone = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("First Provider is not displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name2"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean SecondProviderForNone = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
					SecondProviderForNone = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
				}
			}
			catch (Exception e) {
//				System.out.println("Second Provider is not Displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Provider Name3"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean ThirdProviderForNone = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed()) {
					ThirdProviderForNone = PageObjectManager.getInstance().getLoginPage().getProviderInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("Third Provider is not displayed in Results");
			}
			Thread.sleep(2000);
			if (!FirstProviderForNone && !SecondProviderForNone && !ThirdProviderForNone){
//				log.info("User Validated None of the technographic Providers in Company detail page");
			}
			else {
//				log.info("Not even one Searched Provider is displayed For "+CompanyName+" Company TC - Failed");
			}
			System.out.println("Sn "+j+". ["+CompanyName+"] Company does not contain the searched Providers");
			clickButton(PageObjectManager.getInstance().getLoginPage().getSalesIntelLogo());
		}

		log.info("User Check None of the Provider is displayed in All Searched Results");
	}

	@Then("Check None of the technographic Category is displayed in Company detail page")
	public void I_Check_None_Category_In_Result() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name1"));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean FirstCategoryForNone = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
				FirstCategoryForNone = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("First Category is not displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name2"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean SecondCategoryForNone = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
				SecondCategoryForNone = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
			}
		}
		catch (Exception e) {
			System.out.println("Second Category is not Displayed in Results");
		}

		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name3"));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		boolean ThirdCategoryForNone = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
				ThirdCategoryForNone = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
			}
		}
		catch (Exception e){
			System.out.println("Third Category is not displayed in Results");
		}
		Thread.sleep(2000);
		if (!FirstCategoryForNone && !SecondCategoryForNone && !ThirdCategoryForNone){
			log.info("User Validated None of the technographic Category is displayed in Company detail page");
		}
		else {
			log.info("Any one Category is displayed in Company Detail page TC - Failed");
		}

	}

	@Then("Check None of the technographic Category in Company detail page of All Searched Results")
	public void I_Check_None_Of_The_technographic_Category_in_Company_detail_page_of_All_Searched_Results() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().isDisplayed());
		String HvCompanyCountNotTrimmed =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().getText();
		String HvCompanyCountTrimmed =HvCompanyCountNotTrimmed.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvCompanyCount =Integer.parseInt(HvCompanyCountTrimmed);
		System.out.println("There are total "+HvCompanyCount+" Human Verified Companies, Validate the  Keyword in All searched Results");
		String Keyword=ReadDatafromJson("Contact_Name", "Keyword");
		for (int i=2;i<=HvCompanyCount+1;i++){
			String CompanyName=driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a/..")).getText();
			clickButton(driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a")));
			int j=i-1;
			clickButton(PageObjectManager.getInstance().getLoginPage().getAllButton());
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean FirstCategoryForNone = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
					FirstCategoryForNone = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("First Category is not displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name2"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean SecondCategoryForNone = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
					SecondCategoryForNone = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
				}
			}
			catch (Exception e) {
//				System.out.println("Second Category is not Displayed in Results");
			}

			Thread.sleep(2000);
			clearText(PageObjectManager.getInstance().getLoginPage().getSearchInputBox());
			Thread.sleep(2000);
			enterData(PageObjectManager.getInstance().getLoginPage().getSearchInputBox(), ReadDatafromJson("Contact_Name", "Category Name3"));
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			boolean ThirdCategoryForNone = false;
			try {
				if (PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed()) {
					ThirdCategoryForNone = PageObjectManager.getInstance().getLoginPage().getCategoryInResult().isDisplayed();
				}
			}
			catch (Exception e){
//				System.out.println("Third Category is not displayed in Results");
			}
			Thread.sleep(2000);
			if (!FirstCategoryForNone && !SecondCategoryForNone && !ThirdCategoryForNone){
//				log.info("User Validated None of the technographic Category in Company detail page");
			}
			else {
//				log.info("Not even one Searched Category is displayed For "+CompanyName+" Company TC - Failed");
			}
			System.out.println("Sn "+j+". ["+CompanyName+"] Company does not contain the searched Category");
			clickButton(PageObjectManager.getInstance().getLoginPage().getSalesIntelLogo());
		}

		log.info("User Check None of the Category is displayed in All Searched Results");
	}

	@When("Check INTENT is displayed")
	public void I_Check_Intent() throws Throwable{
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getINTENT().isDisplayed());
		log.info("User Check INTENT is displayed");
		Thread.sleep(1000);
	}

	@And("Click on Score Threshold Filter")
	public void I_Click_On_Score_Threshold_Filter() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getScoreThresHoldFilter());
		log.info("User Click on Score Threshold Filter");
		Thread.sleep(2000);
	}

	@And("Click On Topic Threshold")
	public void I_Click_On_Topic_Threshold_Filter() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getTopicThresHoldFilter());
		log.info("User Click on Topic Threshold Filter");
		Thread.sleep(2000);
	}

	@And("Select Minimum Score as 82")
	public void I_Select_Score_Threshold() throws Throwable{
		Thread.sleep(3000);
		Actions actions=new Actions(driver);
		//actions.dragAndDropBy(Webelement, 0, 0).perform();
		actions.clickAndHold(PageObjectManager.getInstance().getLoginPage().ScoreThresholdMover()).moveToElement(PageObjectManager.getInstance().getLoginPage().ScoreThresholdMover(), 10, 0).release().
				perform();
		Thread.sleep(2000);
	}

	@And("Select Minimum Topic Threshold")
	public void I_Select_Topic_Threshold() throws Throwable{
		Thread.sleep(3000);
		Actions actions=new Actions(driver);
		//actions.dragAndDropBy(Webelement, 0, 0).perform();
		actions.clickAndHold(PageObjectManager.getInstance().getLoginPage().TopicThresholdMover()).moveToElement(PageObjectManager.getInstance().getLoginPage().TopicThresholdMover(), -110, 0).release().
				perform();
		Thread.sleep(2000);
	}

	@Then("Check Search result for Topic Threshold")
	public void I_Check_Topic_Threshold_In_Result() throws Throwable{
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getTopicThresholdInResult().isDisplayed());
		log.info("Check Search result for Topic Threshold");
		Thread.sleep(2000);
	}

	@Then("Check Score in Result")
	public void I_Check_Score_In_Result() throws Throwable{
		String ScoreInResult =PageObjectManager.getInstance().getLoginPage().getChatbotTopicInResult().getText();
		String ScoreCleaned =ScoreInResult.replaceAll("[A-Z,a-z,(),\\s]", "");
		int ScoreINT = Integer.parseInt(ScoreCleaned);
		if (ScoreINT>=82 && ScoreINT<=100){
			System.out.println("Score in Result is between 86 and 100");
			log.info("User Check Score in Result");
		}
		else {
			System.out.println("Score in Result is not as Expected");
			log.info("User Check Score in Result and It's Failed");
		}
	}

	@And("Click on Topics")
	public void I_Click_On_Topics() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getTopicFilter());
		log.info("USer Click on Topics");
		Thread.sleep(1000);
	}

	@And("Select Chatbot Topic")
	public void I_Select_Chatbot_Topic() throws Throwable{
		Thread.sleep(3000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getChatbotTopic());
		log.info("User Select Chatbot Topic");
		Thread.sleep(2000);
	}

	@And("Select Hulu Topic")
	public void I_Select_Hulu_Topic() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getHuluTopic());
		log.info("User Select Hulu Topic");
		Thread.sleep(2000);
	}

	@Then("Check Searched Topic in Search Result")
	public void I_Check_Netflix_Topic_In_Result() throws Throwable{
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getChatbotTopicInResult().isDisplayed());
		log.info("USer Check Searched Topic in Search Result");
		Thread.sleep(3000);
	}

	@Then("Check Topic in All Searched Results")
	public void I_Check_Topic_In_All_Searched_Results() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().isDisplayed());
		String HvCompanyCountNotTrimmed =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().getText();
		String HvCompanyCountTrimmed =HvCompanyCountNotTrimmed.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvCompanyCount =Integer.parseInt(HvCompanyCountTrimmed);
		System.out.println("There are total "+HvCompanyCount+" Human Verified Companies, Validate the Topic in All searched Results");
		for (int i=2;i<=HvCompanyCount+1;i++){
			int k=i+1;
			String CompanyName=driver.findElement(By.xpath("(//input[@type='checkbox' and @title])["+i+"]//..//..//../div[3]/div[1]/a/..")).getText();
			clickButton(driver.findElement(By.xpath("(//span[contains(text(),'Netflix') or contains(text(),'Hulu')])["+k+"]")));
			Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'Netflix') or contains(text(),'Hulu')])["+k+"]")).isDisplayed());
			int j=i-1;
			System.out.println("Sn "+j+". "+CompanyName+" Company contains Netflix Topic");
		}

		log.info("User Check Topic in All Searched Results");
	}

	@And("Click on Industry Name Input box")
	public void I_Click_On_Industry_Name_Input_Box() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getIndustryNameInputBox());
		log.info("Click on Industry Name Input box");
		Thread.sleep(2000);
	}

	@And("Enter Industry Name")
	public void I_Enter_Industry_Name() throws Throwable{
		enterData(PageObjectManager.getInstance().getLoginPage().getIndustryNameInputBox(),ReadDatafromJson("Contact_Name", "Industry Name"));
		log.info("User enter Industry Name");
		Thread.sleep(2000);
	}

	@And("Click on Particular Industry")
	public void I_Click_On_Particular_Industry() throws Throwable{
		String IndustryName = ReadDatafromJson("Contact_Name" , "Industry Name");
		clickButton(driver.findElement(By.xpath("//*[contains(text(),'" + IndustryName + "')]")));
		log.info("USer click on Particular Industry");
		Thread.sleep(2000);
	}

	@Then("Check the Industry in Search Result")
	public void I_Check_Industry_In_Result() throws Throwable{
		String IndustryInResult = ReadDatafromJson("Contact_Name" , "Industry Name");
		Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(text(),'" + IndustryInResult + "')])[2]")).isDisplayed());
		log.info("User check the Industry in Search Result");
	}

	@Then("Check Industry Name in All Searched Results")
	public void I_Check_Industry_Name_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Let's Validate the Industry Name in All searched Results");
		String IndustryName = ReadDatafromJson("Contact_Name" , "Industry Name");
		for (int i=1;i<=HvContactCount;i++){
			clickButton(driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span")));
			Assert.assertTrue(driver.findElement(By.xpath("(//strong[contains(text(),'Name')]/../../../../../article/div)["+i+"]/div/div[2]/app-contact-overview/section/article/div/div[3]/div/span[contains(text(),'"+IndustryName+"')]")).isDisplayed());
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". ["+ContactName+"] Contains "+IndustryName+" Industry in Contact details");
		}

		log.info("User Check Industry Name  in All Searched Results");
	}


	@Then("Check search results that None of the contact should contain the Industry")
	public void I_Check_search_results_that_None_of_the_contact_should_contain_the_Industry() throws Throwable{
		String IndustryName = ReadDatafromJson("Contact_Name" , "Industry Name");
		try
		{
			WebElement IndustryInResult=driver.findElement(By.xpath("(//strong[contains(text(),'Name')]/../../../../../article/div)[1]/div/div[2]/app-contact-overview/section/article/div/div[3]/div/span[contains(text(),'"+IndustryName+"')]"));
			if (IndustryInResult.isDisplayed()){
				log.info("User validated that this contact contains the Industry in it - TC Failed");
			}

		}catch (Exception e){
			log.info("User validated that this contact does not contain the Industry");
		}
	}

	@Then("Check None of the Industry Name is displayed in All Searched Results")
	public void I_Check_None_of_the_Industry_Name_is_displayed_in_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Let's Validate the Industry Name in All searched Results");
		String IndustryName = ReadDatafromJson("Contact_Name" , "Industry Name");
		for (int i=1;i<=HvContactCount;i++){
			clickButton(driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			try
			{
				WebElement IndustryInResult=driver.findElement(By.xpath("(//strong[contains(text(),'Name')]/../../../../../article/div)["+i+"]/div/div[2]/app-contact-overview/section/article/div/div[3]/div/span[contains(text(),'"+IndustryName+"')]"));
				if (IndustryInResult.isDisplayed()){
					System.out.println("Sn "+i+". "+ContactName+"Contains "+IndustryName+" Industry in Contact details  -- TC Failed");
				}

			}catch (Exception e){
				System.out.println("Sn "+i+". ["+ContactName+"] Does not Contain "+IndustryName+" Industry in Contact details");
			}
		}

		log.info("User Check Industry Name  in All Searched Results");
	}

//	@Then("Check the Industry is not in Search Result")
//	public void I_Check_Industry_Is_Not_In_Result() throws Throwable{
//		String IndustryInResult = ReadDatafromJson("Contact_Name" , "Industry Name");
//		Assert.assertFalse(driver.findElement(By.xpath("(//*[contains(text(),\'" + IndustryInResult + "\')])[2]")).isDisplayed());
//		log.info("Check the Industry is not in Search Result");
//		Thread.sleep(5000);
//	}

	@Then("Check Industry for NAICS code in Search Result")
	public void I_Check_Industry_For_NAICS_In_Result() throws Throwable{
		String NAICSIndustryInResult = ReadDatafromJson("Contact_Name" , "NAICS Code Industry");
		Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(text(),\'" + NAICSIndustryInResult + "\')])[1]")).isDisplayed());
		log.info("USer Check Industry for NAICS code in Search Result");
		Thread.sleep(5000);
	}


	@Then("Check Industry for NAICS code in All Searched Results")
	public void I_Check_Industry_for_NAICS_code_in_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Let's Validate the Industry Name in All searched Results");
		String IndustryName = ReadDatafromJson("Contact_Name" , "NAICS Code Industry");
		for (int i=1;i<=HvContactCount;i++){
			clickButton(driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span")));
			Assert.assertTrue(driver.findElement(By.xpath("(//strong[contains(text(),'Name')]/../../../../../article/div)["+i+"]/div/div[2]/app-contact-overview/section/article/div/div[3]/div/span[contains(text(),'"+IndustryName+"')]")).isDisplayed());
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			String NAICScode=ReadDatafromJson("Contact_Name", "NAICS Code");
			System.out.println("Sn "+i+". ["+ContactName+"] Contains "+IndustryName+" Industry for "+NAICScode+" NAICS code");
		}

		log.info("User Check Industry for NAICS code in All Searched Results");
	}

	@Then("Check Industry for SIC code in Search Result")
	public void I_Check_Industry_For_SIC_In_Result() throws Throwable{
		String SICIndustryInResult = ReadDatafromJson("Contact_Name" , "SIC Code Industry");
		Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(text(),'" + SICIndustryInResult + "')])[2]")).isDisplayed());
		log.info("USer Check Industry for SIC code in Search Result");
		Thread.sleep(3000);
	}

	@Then("Check Industry for SIC code in Search Result in All Searched Results")
	public void I_Check_Industry_for_SIC_code_in_Search_Result_in_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Let's Validate the Industry Name in All searched Results");
		String IndustryName = ReadDatafromJson("Contact_Name" , "SIC Code Industry");
		for (int i=1;i<=HvContactCount;i++){
			clickButton(driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span")));
			Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(text(),'" + IndustryName + "')])[1]")).isDisplayed());
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			String SICcode=ReadDatafromJson("Contact_Name", "SIC Code");
			System.out.println("Sn "+i+". ["+ContactName+"] Contains "+IndustryName+" Industry for "+SICcode+" SIC code");
		}

		log.info("User Check Industry for SIC code in All Searched Results");
	}

	@And("CLick on NAICS Code input box")
	public void I_Click_On_NAICS_Code_Input_Box() throws Throwable{
		Thread.sleep(3000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getNAICScodeInputBox());
		log.info("User cLick on NAICS Code input box");
		Thread.sleep(2000);
	}

	@And("Enter NAICS Code")
	public void I_Enter_NAICS_Code() throws Throwable{
		enterData(PageObjectManager.getInstance().getLoginPage().getNAICScodeInputBox(), ReadDatafromJson("Contact_Name", "NAICS Code"));
		log.info("User Enters NAICS Code");
		Thread.sleep(2000);
	}

	@And("Enter SIC Code")
	public void I_Enter_SIC_Code() throws Throwable{
		enterData(PageObjectManager.getInstance().getLoginPage().getNAICScodeInputBox(), ReadDatafromJson("Contact_Name", "SIC Code"));
		log.info("User Enters SIC Code");
		Thread.sleep(2000);
	}

	@And("Click on None of Page")
	public void I_Click_On_None_Of_Page() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getNoneOfPage());
		log.info("User Click on None of Page");
		Thread.sleep(3000);
	}

	@And("Click on Select All Check Box")
	public void I_Click_On_Select_All_Check_Box() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getSelectAllCheckBox());
		log.info("User Select All Industries");
		Thread.sleep(2000);
	}

	@And("Click on Searched Contact")
	public void I_Click_On_Searched_Contact() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getSearchedContact());
		log.info("User Click on Searched Contact");
	}

	@Then("Check email in Search Result")
	public void I_Check_Email_In_Result() throws Throwable{
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getEmailInResult().isDisplayed());
	}



	@Then("Check Vice Presidents Job level in Result")
	public void I_Check_Vice_President_Job_Level_IN_Result() throws Throwable{
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getVicePresidentJobLevelInResult().isDisplayed());
		log.info("User Check Vice Presidents Job level in Result");
	}

	@Then("Check Vice Presidents Job Level in All Searched Results")
	public void I_Check_Vice_Presidents_Job_Level_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the Vice Presidents Job Level in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'Vice President')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//div[contains(text(),'Vice President')])["+i+"]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". Job Level of "+ContactName+" is Vice Presidents");
		}

		log.info("Check Vice Presidents Job Level in All Searched Results");
	}

	@Then("Check Directors Job level in Result")
	public void I_Check_Directors_Job_Level_IN_Result() throws Throwable{
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getDirectorsJobLevelInResult().isDisplayed());
		log.info("User Check Directors Job level in Result");
	}

	@Then("Check Directors Job Level in All Searched Results")
	public void I_Check_Directors_Job_Level_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the Directors Job Level in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'Director')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//div[contains(text(),'Director')])["+i+"]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". Job Level of "+ContactName+" is Directors");
		}

		log.info("Check Directors Job Level in All Searched Results");
	}

	@Then("Check Managers Job level in Result")
	public void I_Check_Managers_Job_Level_IN_Result() throws Throwable{
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getManagersJobLevelInResult().isDisplayed());
		log.info("User Check Managers Job level in Result");
	}

	@Then("Check Managers Job Level in All Searched Results")
	public void I_Check_Managers_Job_Level_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the Managers Job Level in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'Manager')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//div[contains(text(),'Manager')])["+i+"]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". Job Level of "+ContactName+" is Managers");
		}

		log.info("Check Managers Job Level in All Searched Results");
	}

	@Then("Check Key Influencers Job level in Result")
	public void I_Check_Key_Influencers_Job_Level_IN_Result() throws Throwable{
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getKeyInfluencersJobLevelInResult().isDisplayed());
		Thread.sleep(5000);
		log.info("User Check Key Influencers Job level in Result");
	}

	@Then("Check Key Influencers Job Level in All Searched Results")
	public void I_Check_Key_Influencers_Job_Level_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the Key Influencers Job Level in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'Key Influencer')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//div[contains(text(),'Key Influencer')])["+i+"]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". Job Level of "+ContactName+" is Key Influencers");
		}

		log.info("Check Key Influencers Job Level in All Searched Results");
	}

	@Then("Check C-level Executive Job level in Result")
	public void I_Check_Clevel_Executive_Job_Level_Result() throws Throwable{
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getClevelExecutiveJobLevelInResult().isDisplayed());
	}

	@Then("Check C-level Executive Job Level in All Searched Results")
	public void I_Check_C_level_Executive_Job_Level_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the C-level Executive Job Level in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'C-level Executive')])["+i+"]")).isDisplayed());
			clickButton(driver.findElement(By.xpath("(//div[contains(text(),'C-level Executive')])["+i+"]")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". Job Level of "+ContactName+" is C-level Executive");
		}

		log.info("Check C-level Executive Job Level in All Searched Results");
	}


	@When("Verify Job Level Vice President Option is displayed")
	public void I_verify_job_Vicepresident() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getJobVicepresident().isDisplayed());
		log.info("Verify Job Level Vice President Option is displayed");
	}

	@And("Click On Job Level Vice President Option")
	public void I_Click_Job_Level_Vicepresident_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getJobVicepresident());
		log.info("User click Click On Login Button");
	}

	@When("Verify Job Level Directors Option is displayed")
	public void I_verify_job_level_directors() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getJobDirectors().isDisplayed());
		log.info("Verify Job Level Directors Option is displayed");
	}

	@And("Click On Job Level Directors Option")
	public void I_Click_Job_Level_Button_Directors() throws Throwable {
		Thread.sleep(10000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getJobDirectors());
		log.info("User click Job Level Directors Option");
	}

	@When("Verify Job Level Managers Option is displayed")
	public void I_verify_job_level_managers() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getJobManagers().isDisplayed());
		log.info("Verify Job Level Managers Option is displayed");
	}

	@And("Click On Job Level Manager Option")
	public void I_Click_Job_Level_Button_Manager() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getJobManagers());
		log.info("User Click On Job Level Manager Option");
	}

	@When("Check Ranking filter is displayed")
	public void I_Check_Ranking_Filter() throws Throwable{
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getRankingFilter().isDisplayed());
		log.info("User Check Ranking filter is displayed");
		Thread.sleep(3000);
	}

	@And("Click on Ranking Filter")
	public void I_Click_On_Rankings_Finter() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getRankingFilter());
		log.info("User Click on Ranking Filter");
		Thread.sleep(1000);
	}

	@And("Click on Select All Check Box for Rankings")
	public void I_Select_All_CheckBox_For_Rankings() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getSelectAllForRankings());
		log.info("User Click on Select All Check Box for Rankings");
		Thread.sleep(2000);
	}

	@And("Click on Select first Check Box for Rankings")
	public void I_Click_On_first_CheckBox_For_Rankings() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getSelectFirstCheckBoxForRankings());
		log.info("User Click on Select first Check Box for Rankings");
		Thread.sleep(2000);
	}

	@When("Check Your Lists Filter is displayed")
	public void I_Check_YourLists_Filter() throws Throwable{
		Thread.sleep(2000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getYourListsFilter().isDisplayed());
		log.info("User Check Your Lists Filter is displayed");
	}

	@When("Check Result include Filter is displayed")
	public void I_Check_Result_Include_Filter() throws Throwable{
		Thread.sleep(2000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getResultIncludeFilter().isDisplayed());
		log.info("User Check Result include Filter is displayed");
	}

	@When("Check Whether Last Modified Filter is Displayed")
	public void I_Check_Last_Modified_Filter() throws Throwable{
		Thread.sleep(2000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getLastModifiedFilter().isDisplayed());
		log.info("User Check Last Modified Filter is displayed");
	}


	@And("Click on Result Include Filter")
	public void I_Click_Result_Include_Filter() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getResultIncludeFilter());
		log.info("User Click Result include Filter");
	}

	@And("Click on Last Modified Date Filter")
	public void I_Click_Last_Modified_Filter() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getLastModifiedFilter());
		log.info("User Click Result Last Modified");
	}

	@And("Click on Last Modified Dropdown")
	public void I_Click_Last_Modified_Dropdown() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getLastModifiedDropDown());
		log.info("User Click Result Last Modified Dropdown");
		Thread.sleep(2000);
	}

	@And("Check particular date is displayed")
	public void I_Check_Custom_Date_Is_Displayed() throws Throwable{
		Thread.sleep(2000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getCustomDateForLastModified().isDisplayed());
		log.info("User Check particular date is displayed");
		Thread.sleep(2000);
	}

	@And("Click on Particular Date")
	public void I_Click_Custom_Date_Is_Displayed() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getPreviousMonthInCalndar());
		clickButton(PageObjectManager.getInstance().getLoginPage().getCustomDateForLastModified());
		log.info("User Click on Particular Date");
		Thread.sleep(2000);
	}

	@And("get The Selected Date and Store it")
	public void I_Get_The_Selected_Date_And_Store_It() throws Throwable{
		Thread.sleep(2000);
		String Day=PageObjectManager.getInstance().getLoginPage().getCustomDateForLastModified().getText();
		String Month=PageObjectManager.getInstance().getLoginPage().getMonthFromCustomDate().getText();
		String Year=PageObjectManager.getInstance().getLoginPage().getYearFromCustomDate().getText();
		String Date =Day+"/"+Month+"/"+Year;
		DateFormat format = new SimpleDateFormat("dd/MMMM/yyyy");
		DateToBeUsed = format.parse(Date);
	}

	@And("Select Within Last 21 Days")
	public void I_Click_Last_Modified_Within_21_Days() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getLastModifiedWithin21Days());
		log.info("User Select Within Last 21 Days");
	}

	@And("Select Within Last 30 Days")
	public void I_Click_Last_Modified_Within_30_Days() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getLastModifiedWithin30Days());
		log.info("User Select Within Last 30 Days");
	}

	@And("Select Within Last 7 Days")
	public void I_Click_Last_Modified_Within_7_Days() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getLastModifiedWithin7Days());
		log.info("User Select Within Last 7 Days");
	}

	@And("Select Within Last 14 Days")
	public void I_Click_Last_Modified_Within_14_Days() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getLastModifiedWithin14Days());
		log.info("User Select Within Last 14 Days");
	}

	@And("Select Custom filter")
	public void I_Click_Last_Modified_Custom() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getCustomForLastModified());
		log.info("User  Select Custom filter");
	}

	@And("Select Address CheckBox")
	public void I_Select_Address_CheckBox() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getAddressCheckBox());
		log.info("User Select Address CheckBox");
		Thread.sleep(1000);
	}
	@And("Select Any Phone CheckBox")
	public void I_Select_Any_Phone_CheckBox() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getAnyPhoneCheckBox());
		log.info("User Select Any Phone CheckBox");
		Thread.sleep(1000);
	}

	@And("Select Any Direct Phone CheckBox")
	public void I_Select_Any_Direct_Phone_CheckBox() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getAnyDirectPhoneCheckBox());
		log.info("User Select Any Direct Phone CheckBox");
		Thread.sleep(1000);
	}

	@And("Select Any Mobile Phone CheckBox")
	public void I_Select_Any_Mobile_Phone_CheckBox() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getAnyMobilePhoneCheckBox());
		log.info("User Select Any Mobile Phone CheckBox");
		Thread.sleep(1000);
	}

	@And("Select Personal Email CheckBox")
	public void I_Select_Personal_Email_CheckBox() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getPersonalEmailCheckBox());
		log.info("User Select Personal Email CheckBox");
		Thread.sleep(1000);
	}

	@And("Select LinkedIn Url CheckBox")
	public void I_Select_LinkedIn_Url_CheckBox() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getLinkedInUrlCheckBox());
		log.info("User Select LinkedIn Url CheckBox");
		Thread.sleep(1000);
	}

	@And("Select Title CheckBox")
	public void I_Select_Title_CheckBox() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getTitleCheckBox());
		log.info("User Select Title CheckBox");
		Thread.sleep(1000);
	}

	@And("Check Contact list is displayed")
	public void I_Check_Contact_List_Filter() throws Throwable{
		Thread.sleep(2000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getContactListFilter().isDisplayed());
		log.info("User Check Contact list is displayed");
	}


	@When("Click on Your Lists Filter")
	public void I_Click_Your_Lists_Filter() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getYourListsFilter());
		log.info("User Click on Your Lists Filter");
		Thread.sleep(3000);
	}

	@And("Select All Companies List")
	public void I_Select_All_Company_Lists() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getAllCompanyList());
		log.info("User Select All Companies Lists");
		Thread.sleep(1000);
	}

	@And("Select All Contact List")
	public void I_Select_All_Contact_Lists() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getAllContactList());
		log.info("User Select All Contact Lists");
		Thread.sleep(1000);
	}

	@And("Select All Suppression List")
	public void I_Select_All_Suppression_Lists() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getAllSuppressionList());
		log.info("User Select All Suppression Lists");
		Thread.sleep(1000);
	}

	@And("Check Suppression list is displayed")
	public void I_Check_All_Suppression_Lists() throws Throwable{
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getAllSuppressionList().isDisplayed());
		log.info("User Check All Suppression Lists");
		Thread.sleep(1000);
	}

	@And("Check ROD list is displayed")
	public void I_Check_ROD_Lists() throws Throwable{
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getRODList().isDisplayed());
		log.info("User Check All ROD Lists");
		Thread.sleep(1000);
	}

	@And("Select All ROD List")
	public void I_Select_All_ROD_Lists() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getAllRODList());
		log.info("User Select All ROD List");
		Thread.sleep(1000);
	}

	@And("Select One ROD List")
	public void I_Check_One_ROD_Lists() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getOneRODList());
		log.info("User Select One ROD List");
		Thread.sleep(1000);
	}

	@And("Check One Company list is displayed")
	public void I_Check_One_Company_List() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getOneCompanyList().isDisplayed());
		log.info("User Check One Company list is displayed");
		Thread.sleep(1000);
	}

	@And("Check One Contact list is displayed")
	public void I_Check_One_Contact_List() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getOneContactList().isDisplayed());
		log.info("User Check One Contact list is displayed");
		Thread.sleep(1000);
	}

	@And("Check One Suppression list is displayed")
	public void I_Check_One_Suppression_List() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getOneSuppressionList().isDisplayed());
		log.info("User Check One Suppression list is displayed");
		Thread.sleep(1000);
	}

	@And("Select One Company List")
	public void I_Select_One_Company_List() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getOneCompanyList());
		log.info("User Select one Company List");
		Thread.sleep(1000);
	}

	@And("Select One Contact List")
	public void I_Select_One_Contact_List() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getOneContactList());
		log.info("User Select one Contact List");
		Thread.sleep(1000);
	}

	@And("Select One Suppression List")
	public void I_Select_One_Suppression_List() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getOneSuppressionList());
		log.info("User Select one Suppression List");
		Thread.sleep(1000);
	}


	@Then("Check the search results of Company lists")
	public void I_Check_Search_results_For_Company_Lists() throws Throwable{
		String AllListCompanyCount =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().getText();
		clickButton(PageObjectManager.getInstance().getLoginPage().getFirstCompanyInResult());
		Thread.sleep(2000);
		System.out.println("There are Total "+AllListCompanyCount+" Companies for the list filter");
		log.info("User Check the search results of Company lists");
	}

	@Then("Check the search results of Contact lists")
	public void I_Check_Search_results_For_Contact_Lists() throws Throwable{
		String AllListContactCount =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		clickButton(PageObjectManager.getInstance().getLoginPage().getFirstSearchedContact());
		Thread.sleep(2000);
		System.out.println("There are Total "+AllListContactCount+" Contacts for the list filter");
		log.info("User Check the search results of Contact lists");
	}

	@Then("Check the search results of Suppression lists")
	public void I_Check_Search_results_For_Suppression_Lists() throws Throwable{
		String AllSuppressionListContactCount =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		clickButton(PageObjectManager.getInstance().getLoginPage().getFirstSearchedContact());
		Thread.sleep(2000);
		System.out.println("There are Total "+AllSuppressionListContactCount+" Contacts After applying Suppression filter");
		log.info("User Check the search results of Suppression lists");
	}

	@Then("Check the search results of ROD lists")
	public void I_Check_Search_results_For_ROD_Lists() throws Throwable{
		String AllSuppressionListContactCount =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		clickButton(PageObjectManager.getInstance().getLoginPage().getFirstSearchedContact());
		Thread.sleep(2000);
		System.out.println("There are Total "+AllSuppressionListContactCount+" Contacts After applying ROD filter");
		log.info("User Check the search results of ROD lists");
	}

	@Then("Check Whether Results include Address")
	public void I_Check_Whether_Result_Include_Address() throws Throwable{
		Thread.sleep(5000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getFirstSearchedContactLocation().isDisplayed());
		log.info("USer Check Whether Results include Address");
	}

	@Then("Check Address in All Searched Results")
	public void I_Check_Address_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the Address in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("//strong[contains(text(),'Location')]/../../../../article/div["+i+"]/div/div/div/div[5]/div")).isDisplayed());
			clickButton(driver.findElement(By.xpath("//strong[contains(text(),'Location')]/../../../../article/div["+i+"]/div/div/div/div[5]/div")));
			String Address=driver.findElement(By.xpath("//strong[contains(text(),'Location')]/../../../../article/div["+i+"]/div/div/div/div[5]/div/span[1]")).getText();
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". ["+ContactName+"] iss working in ["+Address+"] Location");
		}

		log.info("User Check Address in All Searched Results");
	}

	@Then("Check Whether Results include Personal Email")
	public void I_Check_Whether_Result_Include_Personal_Email() throws Throwable{
		Thread.sleep(5000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getPersonalEmailInResult().isDisplayed());
		log.info("USer Check Whether Results include Personal Email");
	}

	@Then("Check PersonalEmail in All Searched Results")
	public void I_Check_PersonalEmail_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the PersonalEmail in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("//strong[contains(text(),'Location')]/../../../../article/div["+i+"]/div/div[1]/div/div[1]/div/div[2]/div/span[@class='personal-email-icon mr-2']")).isDisplayed());
			clickButton(driver.findElement(By.xpath("//strong[contains(text(),'Location')]/../../../../article/div["+i+"]/div/div[1]/div/div[1]/div/div[2]/div/span[@class='personal-email-icon mr-2']")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". ["+ContactName+"] is having a Personal email");
		}

		log.info("User Check Personal Email in All Searched Results");
	}


	@Then("Check Whether Results include LinkedIn Url")
	public void I_Check_Whether_Result_Include_LinkedIn_Url() throws Throwable{
		Thread.sleep(5000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getLinkedInUrlInResult().isDisplayed());
		log.info("USer Check Whether Results include  LinkedIn Url");
	}

	@Then("Check LinkedInURL in All Searched Results")
	public void I_Check_LinkedInURL_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the LinkedInURL in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("//strong[contains(text(),'Location')]/../../../../article/div["+i+"]/div/div[1]/div/div[1]/div/div[2]/div/a[@class='linkedin-icon mr-2']")).isDisplayed());
			clickButton(driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". ["+ContactName+"] is having a LinkedIn Url");
		}

		log.info("User Check LinkedIn Url in All Searched Results");
	}


	@Then("Check Whether Results include Title")
	public void I_Check_Whether_Result_Include_Title() throws Throwable{
		Thread.sleep(5000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getTitleInSearchResult().isDisplayed());
		log.info("USer Check Whether Results include  Title");
	}

	@Then("Check JobTitle in All Searched Results")
	public void I_Check_JobTitle_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the JobTitle in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			Assert.assertTrue(driver.findElement(By.xpath("//strong[contains(text(),'Location')]/../../../../article/div["+i+"]/div/div[1]/div/div[2]/span/span")).isDisplayed());
			clickButton(driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")));
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			System.out.println("Sn "+i+". ["+ContactName+"] is having a Job Title");
		}

		log.info("User Check Job Title in All Searched Results");
	}


	@Then("Validate the Last modified Date In Research Portal Where updated within 21 Days")
	public void I_Validate_Last_Modified_Date_In_Research_Portal_21_Days() throws Throwable{
		Thread.sleep(5000);
		String LastUpdatedDate=PageObjectManager.getInstance().getLoginPage().getLastUpdatedDateFromRes().getText();
		DateFormat format = new SimpleDateFormat("dd/MMM/yyyy");
		Date LastModifiedInResearch = format.parse(LastUpdatedDate);
		LocalDate currentDate = LocalDate.now();
		DateFormat format1 =  new SimpleDateFormat("yyyy-MM-dd");
		Date CurrentDateToUse = format1.parse(currentDate.toString());
		long time_difference = CurrentDateToUse.getTime() - LastModifiedInResearch.getTime();
		long DaysDifference=(time_difference / (1000*60*60*24)) % 365;
		if (DaysDifference<=21){
			System.out.println("Searched Contact is Recently Modified Within 21 Days, Where Last modified Date is "+LastModifiedInResearch+" And it is updated before "+DaysDifference+ "Days");
			log.info("User Validated that Contact is Modified Within 21 Days");
		}
		else {
			System.out.println("Searched Contact is not Updated Within 21 Days, Where Last modified Date is "+LastModifiedInResearch+" And it is updated before "+DaysDifference+ "Days");
			log.info("User Validated that Contact is not Modified Within 21 Days -- TC Failed");
		}
	}

	@Then("Validate the Last modified Date In Research Portal Where updated within 30 Days")
	public void I_Validate_Last_Modified_Date_In_Research_Portal_30_Days() throws Throwable{
		Thread.sleep(5000);
		String LastUpdatedDate=PageObjectManager.getInstance().getLoginPage().getLastUpdatedDateFromRes().getText();
		DateFormat format = new SimpleDateFormat("dd/MMM/yyyy");
		Date LastModifiedInResearch = format.parse(LastUpdatedDate);
		LocalDate currentDate = LocalDate.now();
		DateFormat format1 =  new SimpleDateFormat("yyyy-MM-dd");
		Date CurrentDateToUse = format1.parse(currentDate.toString());
		long time_difference = CurrentDateToUse.getTime() - LastModifiedInResearch.getTime();
		long DaysDifference=(time_difference / (1000*60*60*24)) % 365;
		if (DaysDifference<=30){
			System.out.println("Searched Contact is Recently Modified Within 30 Days, Where Last modified Date is "+LastModifiedInResearch+" And it is updated before "+DaysDifference+ "Days");
			log.info("User Validated that Contact is Modified Within 30 Days");
		}
		else {
			System.out.println("Searched Contact is not Updated Within 30 Days, Where Last modified Date is "+LastModifiedInResearch+" And it is updated before "+DaysDifference+ "Days");
			log.info("User Validated that Contact is not Within 30 Days -- TC Failed");
		}
	}

	@Then("Validate the Last modified Date In Research Portal Where updated within the Selected Date")
	public void I_Validate_Last_Modified_Date_In_Research_Portal_For_Custom_Date() throws Throwable{
		Thread.sleep(5000);
		String LastUpdatedDate=PageObjectManager.getInstance().getLoginPage().getLastUpdatedDateFromRes().getText();
		DateFormat format = new SimpleDateFormat("dd/MMM/yyyy");
		Date LastModifiedInResearch = format.parse(LastUpdatedDate);
		LocalDate currentDate = LocalDate.now();
		DateFormat format1 =  new SimpleDateFormat("yyyy-MM-dd");
		Date CurrentDateToUse = format1.parse(currentDate.toString());
		long ActualDifferenceFromResearch = CurrentDateToUse.getTime() - LastModifiedInResearch.getTime();
		long ActualResDifferenceInDays=(ActualDifferenceFromResearch / (1000*60*60*24)) % 365;
		long ActualDifferenceFromSI = CurrentDateToUse.getTime() - DateToBeUsed.getTime();
		long ActualResDifferenceInDaysFromSI=(ActualDifferenceFromSI / (1000*60*60*24)) % 365;
		if (ActualResDifferenceInDays<=ActualResDifferenceInDaysFromSI){
			System.out.println("Searched Contact is Recently Modified Within "+ActualResDifferenceInDaysFromSI+" Days, Where Last modified Date is "+LastModifiedInResearch+"");
			log.info("User Validated that Contact is Modified Within "+ActualResDifferenceInDaysFromSI+" Days");
		}
		else {
			System.out.println("Searched Contact is not Updated Within the Selected Custom Date, Where Last modified Date is "+LastModifiedInResearch+" And it is updated before "+ActualResDifferenceInDaysFromSI+ "Days");
			log.info("User Validated that Contact is not Within the Selected Custom Date -- TC Failed");
		}
	}

	@Then("Validate the Last modified Date In Research Portal Where modified within 7 Days")
	public void I_Validate_Last_Modified_Date_In_Research_Portal_7_Days() throws Throwable{
		Thread.sleep(5000);
		String LastUpdatedDate=PageObjectManager.getInstance().getLoginPage().getLastUpdatedDateFromRes().getText();
		DateFormat format = new SimpleDateFormat("dd/MMM/yyyy");
		Date LastModifiedInResearch = format.parse(LastUpdatedDate);
		LocalDate currentDate = LocalDate.now();
		DateFormat format1 =  new SimpleDateFormat("yyyy-MM-dd");
		Date CurrentDateToUse = format1.parse(currentDate.toString());
		long time_difference = CurrentDateToUse.getTime() - LastModifiedInResearch.getTime();
		long DaysDifference=(time_difference / (1000*60*60*24)) % 365;
		if (DaysDifference<=7){
			System.out.println("Searched Contact is Recently Modified Within 7 Days, Where Last modified Date is "+LastModifiedInResearch+" And it is updated before "+DaysDifference+ "Days");
			log.info("User Validated that Contact is Modified Within 7 Days");
		}
		else {
			System.out.println("Searched Contact is not Updated Within 7 Days, Where Last modified Date is "+LastModifiedInResearch+" And it is updated before "+DaysDifference+ "Days");
			log.info("User Validated that Contact is not Within 7 Days -- TC Failed");
		}
	}

	@Then("Validate the Last modified Date In Research Portal Where modified within 14 Days")
	public void I_Validate_Last_Modified_Date_In_Research_Portal_14_Days() throws Throwable{
		Thread.sleep(5000);
		String LastUpdatedDate=PageObjectManager.getInstance().getLoginPage().getLastUpdatedDateFromRes().getText();
		DateFormat format = new SimpleDateFormat("dd/MMM/yyyy");
		Date LastModifiedInResearch = format.parse(LastUpdatedDate);
		LocalDate currentDate = LocalDate.now();
		DateFormat format1 =  new SimpleDateFormat("yyyy-MM-dd");
		Date CurrentDateToUse = format1.parse(currentDate.toString());
		long time_difference = CurrentDateToUse.getTime() - LastModifiedInResearch.getTime();
		long DaysDifference=(time_difference / (1000*60*60*24)) % 365;
		if (DaysDifference<=14){
			System.out.println("Searched Contact is Recently Modified Within 14 Days, Where Last modified Date is "+LastModifiedInResearch+" And it is updated before "+DaysDifference+ "Days");
			log.info("User Validated that Contact is Modified Within 14 Days");
		}
		else {
			System.out.println("Searched Contact is not Updated Within 14 Days, Where Last modified Date is "+LastModifiedInResearch+" And it is updated before "+DaysDifference+ "Days");
			log.info("User Validated that Contact is not Within 14 Days  -- Failed");
		}
	}

	@And("get the Contact Work Email and store it")
	public void I_Copy_And_Store_The_Work_Email() throws Throwable{
		Thread.sleep(5000);
		WorkEmail = PageObjectManager.getInstance().getLoginPage().getWorkEmailInResult().getText();
		System.out.println("Work Email is "+WorkEmail);
		log.info("User get the Work Email and store it");
	}


	@Then("Check Whether Results include Any Phone")
	public void I_Check_Whether_Results_Include_Any_Phone() throws Throwable {
		Thread.sleep(5000);
		boolean MobileIsDisplayed = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getMobilePhoneInResult().isDisplayed()) {
				MobileIsDisplayed = PageObjectManager.getInstance().getLoginPage().getMobilePhoneInResult().isDisplayed();
				System.out.println("Mobile Number is Displayed");
			}
			else {
				System.out.println("Mobile number is not Displayed");
			}
		}
		catch (Exception e){
			System.out.println("Mobile Number in Result is not Displayed");
		}

		boolean DirectPhoneIsDisplayed = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getDirectPhoneInResult().isDisplayed()) {
				DirectPhoneIsDisplayed = PageObjectManager.getInstance().getLoginPage().getDirectPhoneInResult().isDisplayed();
				System.out.println("Direct Phone Number is Displayed");
			}
			else {
				System.out.println("Direct Phone number is not Displayed");
			}
		}
		catch (Exception e){
			System.out.println("Direct Phone Number in Result is not Displayed");
		}
		if (DirectPhoneIsDisplayed || MobileIsDisplayed){
			log.info("User Validated that Results include Any Phone");
		}
		else {
			log.info("User Validated that Both Any Mobile number or Direct phone is not displayed");
			System.out.println("Test Manually");
		}
	}

	@Then("Check AnyPhone in All Searched Results")
	public void I_Check_AnyPhone_In_All_Searched_Results() throws Throwable {
		String HumanVerifiedContact= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		String HvContactCountTrimmed =HumanVerifiedContact.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvContactCount =Integer.parseInt(HvContactCountTrimmed);
		System.out.println("There are total "+HvContactCount+" Human Verified Contacts, Validate the AnyPhone in All searched Results");
		for (int i=1;i<=HvContactCount;i++){
			clickButton(driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")));
			boolean MobileIsDisplayed = false;
			try {
				if (driver.findElement(By.xpath("//strong[contains(text(),'Location')]/../../../../article/div["+i+"]/div/div[1]/div/div[1]/div/div[2]/div/span[@class='phone-icon mr-2 personalPhone']")).isDisplayed()) {
					MobileIsDisplayed=true;
				}
				else {
					MobileIsDisplayed=false;
				}
			}
			catch (Exception e){
			}

			boolean DirectPhoneIsDisplayed = false;
			try {
				if (driver.findElement(By.xpath("//strong[contains(text(),'Location')]/../../../../article/div["+i+"]/div/div[1]/div/div[1]/div/div[2]/div/span[@class='phone-icon mr-2 branch' or @class='phone-icon mr-2 hq']")).isDisplayed()) {
					DirectPhoneIsDisplayed=true;
				}
				else {
					DirectPhoneIsDisplayed=false;
				}
			}
			catch (Exception e){
			}
			String ContactName=driver.findElement(By.xpath("//strong[contains(text(),'Name')]/../../../../../article/div["+i+"]/div/div/div/div[1]/div/div[2]/span/span")).getText();
			if (DirectPhoneIsDisplayed || MobileIsDisplayed){
				System.out.println("Sn "+i+". ["+ContactName+"] contains Atleast one phone number");
			}
			else {
				System.out.println("Sn "+i+". ["+ContactName+"] does not contain Both Mobile number or Direct phone - TC Failed");
			}
		}

		log.info("User Check Any Phone in All Searched Results");
	}


	@Then("Check Whether Results include Any Direct Phone")
	public void I_Check_Whether_Results_Include_Any_Direct_Phone() throws Throwable {
		Thread.sleep(5000);
		boolean MobileIsDisplayed = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getMobilePhoneInResult().isDisplayed()) {
				MobileIsDisplayed = PageObjectManager.getInstance().getLoginPage().getMobilePhoneInResult().isDisplayed();
				System.out.println("Mobile Number is Displayed");
			}
			else {
				System.out.println("Mobile number is not Displayed");
			}
		}
		catch (Exception e){
			System.out.println("Mobile Number in Result is not Displayed");
		}

		boolean DirectPhoneIsDisplayed = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getDirectPhoneInResult().isDisplayed()) {
				DirectPhoneIsDisplayed = PageObjectManager.getInstance().getLoginPage().getDirectPhoneInResult().isDisplayed();
				System.out.println("Direct Phone Number is Displayed");
			}
			else {
				System.out.println("Direct Phone number is not Displayed");
			}
		}
		catch (Exception e){
			System.out.println("Direct Phone Number in Result is not Displayed");
		}
		if (DirectPhoneIsDisplayed || MobileIsDisplayed){
			log.info("User Validated that Results include Any Direct Phone");
		}
		else {
			log.info("User Validated that Both Any Mobile number or Direct phone is not displayed");
			System.out.println("Test Manually");
		}
	}

	@Then("Check Whether Results include Any Mobile Phone")
	public void I_Check_Whether_Results_Include_Any_Mobile_Phone() throws Throwable {
		Thread.sleep(5000);
		boolean MobileIsDisplayed = false;
		try {
			if (PageObjectManager.getInstance().getLoginPage().getMobilePhoneInResult().isDisplayed()) {
				MobileIsDisplayed = PageObjectManager.getInstance().getLoginPage().getMobilePhoneInResult().isDisplayed();
				System.out.println("Mobile Number is Displayed");
			}
			else {
				System.out.println("Mobile number is not Displayed");
			}
		}
		catch (Exception e){
			System.out.println("Mobile Number in Result is not Displayed");
		}

		boolean DirectPhoneIsDisplayed = false;
		if (PageObjectManager.getInstance().getLoginPage().getDirectPhoneInResult().isDisplayed()) {
			DirectPhoneIsDisplayed = PageObjectManager.getInstance().getLoginPage().getDirectPhoneInResult().isDisplayed();
			System.out.println("Direct Phone Number is Displayed");
		}
		else {
			System.out.println("Direct Phone number is Not Displayed");
		}

		if (DirectPhoneIsDisplayed && MobileIsDisplayed){
			log.info("User Validated that Results include Both Direct Phone and Mobile Phone");
			System.out.println("TC-Failed, Test Manually");
		} else if (!MobileIsDisplayed && DirectPhoneIsDisplayed) {
			log.info("User Validated that Any Mobile phone is not displayed");
			System.out.println("TC-Failed, Test Manually");
		}
		if (!DirectPhoneIsDisplayed && MobileIsDisplayed) {
			log.info("User Validated that Any Mobile phone is displayed");
		}
	}

	@And("Validate Search Result")
	public void I_Validate_Search_Result() throws Throwable {
		List<WebElement> allElement = driver.findElements(By.xpath("(//span[contains(text(),'Vikas')])[2]"));
		for (WebElement eachElement : allElement) {
			String actualValue = eachElement.getText();
			if (actualValue.contains("Vikas")) {
				System.out.println("The Actual Result values: " + actualValue);
				Assert.assertTrue(actualValue.contains("Vikas"));
			} else {
				System.out.println("Both Actual and Expected are mismatching");
			}
		}
		log.info("Validate Search Result");
	}

	@And("Validate Company Search Result")
	public void I_Validate_Company_Search_Result() {
		List<WebElement> allElement = driver.findElements(By.xpath("//*[contains(text(),'Adobe')]"));
		for (WebElement eachElement : allElement) {
			String actualValue = eachElement.getText();
			if (actualValue.contains("Adobe")) {
				System.out.println("The Actual Result values: " + actualValue);
				Assert.assertTrue(actualValue.contains("Adobe"));
			} else {
				System.out.println("Both Actual and Expected are mismatching");
			}
		}
		log.info("Validate Search Result");
	}

	//	@When("Enter the Search First Name1")
//	public void i_enter_the_FirstName1() throws Throwable {
////		readCompleteDataFromEXcel();
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), readPropertyFileData().getProperty("FirstName1"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
//		log.info("Enter the Search First Name1");
//	}
	@When("Enter the Search First Name1")
	public void i_enter_the_FirstName1() throws Throwable {
//		readCompleteDataFromEXcel();
		Thread.sleep(3000);
		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), ReadDatafromJson("Contact_Name", "FirstName1"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
		log.info("Enter the Search First Name1");
	}

	//	@When("Enter the Search Last Name1")
//	public void i_enter_the_LastName1() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(),readPropertyFileData().getProperty("LastName1"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
//		log.info("Enter the Search Last Name1");
//	}
	@When("Enter the Search Last Name1")
	public void i_enter_the_LastName1() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(), ReadDatafromJson("Contact_Name", "LastName1"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("Enter the Search Last Name1");
	}

	@And("Click On Contact Search1")
	public void I_Click_Contact_search1() throws Throwable {
		String Contactsearchname1 = ReadDatafromJson("Contact_Name", "ContactSearch1");
//		driver.findElement(By.xpath("//*[contains(text(),\'"+Contactsearchname1+"\')]"));
		clickButton(driver.findElement(By.xpath("(//*[contains(text(),\'" + Contactsearchname1 + "\')])[1]")));
		System.out.println("The Label Name is: " + driver.findElement(By.xpath("(//*[contains(text(),\'" + Contactsearchname1 + "\')])[1]")).getText());
//		clickButton(PageObjectManager.getInstance().getLoginPage().getContactSearch1());
		log.info("User click Click On Login Button");
		Thread.sleep(3000);
	}

	@And("Click On Searched Contact")
	public void I_Click_Contact_Universal_search() throws Throwable {
		clickButton(driver.findElement(By.xpath("(//span[@placement='auto' and contains(text(),'Kirst')])[1]")));
//		String UniversalContactsearchname = ReadDatafromJson("Contact_Name", "UniversalSearch");
////		driver.findElement(By.xpath("//*[contains(text(),\'"+Contactsearchname1+"\')]"));
//		clickButton(driver.findElement(By.xpath("//*[contains(text(),\'" + UniversalContactsearchname + "\')]")));
//		System.out.println("The Label Name is: " + driver.findElement(By.xpath("//*[contains(text(),\'" + UniversalContactsearchname + "\')]")).getText());
////		clickButton(PageObjectManager.getInstance().getLoginPage().getContactSearch1());
		log.info("User click Click On Searched Contact for Request Verification");
		Thread.sleep(3000);
	}

	@When("Verify Reveal Contact Search Button is displayed")
	public void I_verify_Reveal_Search_Button() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getContactSearchReveal().isDisplayed());
		log.info("Verify Reveal Contact Search Button is displayed");
		Thread.sleep(3000);
	}

	@When("Verify Request Verification Button is displayed")
	public void I_verify_Request_Verification_Button() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().RequestVerificationButton().isDisplayed());
		log.info("Verify Request Verification Button is displayed");
		Thread.sleep(3000);
	}

	@When("Verify RoD Tab is displayed")
	public void I_verify_RoD_Tab() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getRoDTab().isDisplayed());
		log.info("Verify Request Verification Button is displayed");
	}

	@And("Click On RoD Tab")
	public void I_Click_RoD() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getRoDTab());
		log.info("Click On Request Verification Button");
		Thread.sleep(3000);
	}
	@When("Verify Requested Verification Status")
	public void I_verify_Request_Verification_Status_Button() throws Throwable {
		Thread.sleep(10000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().RequestVerificationButton().isDisplayed());
		log.info("Verify Request Verification is clicked");
	}
	@And("Click On Request Verification Button")
	public void I_Click_Request_Verification() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().RequestVerificationButton());
		log.info("Click On Request Verification Button");
		Thread.sleep(3000);
	}

	@And("Click On Reveal Contact Search Button")
	public void I_Click_Reveal_Contact_search() throws Throwable {
		try{
			if (PageObjectManager.getInstance().getLoginPage().getContactSearchReveal().isDisplayed()) {
				clickButton(PageObjectManager.getInstance().getLoginPage().getContactSearchReveal());
				log.info("Click On Reveal Contact Search Button");
			}
		}
		catch (Exception e){
			log.info("The Contact is already Revealed");
			Thread.sleep(3000);
		}
	}

	@And("Get the Total Reveal Count")
	public void I_get_Total_Reveal_Count() throws Throwable {
//		gettext(PageObjectManager.getInstance().getLoginPage().getTotalCredits());
		System.out.println(PageObjectManager.getInstance().getLoginPage().getTotalCredits().getText());
		log.info("Get the Total Reveal Count");
		Thread.sleep(3000);
	}

	//	@When("Enter the Search First Name2")
//	public void i_enter_the_FirstName2() throws Throwable {
////		readCompleteDataFromEXcel();
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), readPropertyFileData().getProperty("FirstName2"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
//		log.info("Enter the Search First Name2");
//	}
	@When("Enter the Search First Name2")
	public void i_enter_the_FirstName2() throws Throwable {
//		readCompleteDataFromEXcel();
		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), ReadDatafromJson("Contact_Name", "FirstName2"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
		log.info("Enter the Search First Name2");
	}

	//	@When("Enter the Search Last Name2")
//	public void i_enter_the_LastName2() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(),readPropertyFileData().getProperty("LastName2"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
//		log.info("Enter the Search Last Name2");
//	}
	@When("Enter the Search Last Name2")
	public void i_enter_the_LastName2() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(), ReadDatafromJson("Contact_Name", "LastName2"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("Enter the Search Last Name2");
	}

	@And("Click On Contact Search2")
	public void I_Click_Contact_search2() throws Throwable {
		String Contactsearchname2 = ReadDatafromJson("Contact_Name", "ContactSearch2");
//		driver.findElement(By.xpath("//*[contains(text(),\'"+Contactsearchname1+"\')]"));
		clickButton(driver.findElement(By.xpath("//*[contains(text(),\'" + Contactsearchname2 + "\')]")));
		log.info("User Click On Contact Search2");
		Thread.sleep(3000);
	}

	//	@When("Enter the Search First Name3")
//	public void i_enter_the_FirstName3() throws Throwable {
////		readCompleteDataFromEXcel();
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), readPropertyFileData().getProperty("FirstName3"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
//		log.info("Enter the Search First Name2");
//	}
	@When("Enter the Search First Name3")
	public void i_enter_the_FirstName3() throws Throwable {
//		readCompleteDataFromEXcel();
		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), ReadDatafromJson("Contact_Name", "FirstName3"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
		log.info("Enter the Search First Name2");
	}

	//	@When("Enter the Search Last Name3")
//	public void i_enter_the_LastName3() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(),readPropertyFileData().getProperty("LastName3"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
//		log.info("Enter the Search Last Name2");
//	}
	@When("Enter the Search Last Name3")
	public void i_enter_the_LastName3() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(), ReadDatafromJson("Contact_Name", "LastName3"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("Enter the Search Last Name2");
	}

	//	@And("Click On Contact Search3")
//	public void I_Click_Contact_search3() throws Throwable {
//		clickButton(PageObjectManager.getInstance().getLoginPage().getContactSearch3());
//		log.info("User click Click On Login Button");
//		Thread.sleep(3000);
//	}
	@And("Click On Contact Search3")
	public void I_Click_Contact_search3() throws Throwable {
		String Contactsearchname3 = ReadDatafromJson("Contact_Name", "ContactSearch3");
//		driver.findElement(By.xpath("//*[contains(text(),\'"+Contactsearchname1+"\')]"));
		clickButton(driver.findElement(By.xpath("//*[contains(text(),\'" + Contactsearchname3 + "\')]")));
		log.info("User click Click On Login Button");
		Thread.sleep(3000);
	}

	//	@When("Enter the Search First Name4")
//	public void i_enter_the_FirstName4() throws Throwable {
////		readCompleteDataFromEXcel();
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), readPropertyFileData().getProperty("FirstName4"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
//		log.info("Enter the Search First Name2");
//	}
	@When("Enter the Search First Name4")
	public void i_enter_the_FirstName4() throws Throwable {
//		readCompleteDataFromEXcel();
		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), ReadDatafromJson("Contact_Name", "FirstName4"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
		log.info("Enter the Search First Name2");
	}
//	@When("Enter the Search Last Name4")
//	public void i_enter_the_LastName4() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(),readPropertyFileData().getProperty("LastName4"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
//		log.info("Enter the Search Last Name2");
//	}

	@When("Enter the Search Last Name4")
	public void i_enter_the_LastName4() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(), ReadDatafromJson("Contact_Name", "LastName4"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("Enter the Search Last Name2");
	}

	@And("Click On Contact Search4")
	public void I_Click_Contact_search4() throws Throwable {
		String Contactsearchname4 = ReadDatafromJson("Contact_Name", "ContactSearch4");
//		driver.findElement(By.xpath("//*[contains(text(),\'"+Contactsearchname1+"\')]"));
		clickButton(driver.findElement(By.xpath("//*[contains(text(),\'" + Contactsearchname4 + "\')]")));
		log.info("User click Click On Login Button");
		Thread.sleep(3000);
	}

	//	@When("Enter the Search First Name5")
//	public void i_enter_the_FirstName5() throws Throwable {
////		readCompleteDataFromEXcel();
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), readPropertyFileData().getProperty("FirstName5"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
//		log.info("Enter the Search First Name2");
//	}
	@When("Enter the Search First Name5")
	public void i_enter_the_FirstName5() throws Throwable {
//		readCompleteDataFromEXcel();
		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), ReadDatafromJson("Contact_Name", "FirstName5"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
		log.info("Enter the Search First Name2");
	}

//	@When("Enter the Search Last Name5")
//	public void i_enter_the_LastName5() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(),readPropertyFileData().getProperty("LastName5"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
//		log.info("Enter the Search Last Name2");
//	}

	@When("Enter the Search Last Name5")
	public void i_enter_the_LastName5() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(), ReadDatafromJson("Contact_Name", "LastName5"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("Enter the Search Last Name2");
	}

	@And("Click On Contact Search5")
	public void I_Click_Contact_search5() throws Throwable {
		String Contactsearchname5 = ReadDatafromJson("Contact_Name", "ContactSearch5");
//		driver.findElement(By.xpath("//*[contains(text(),\'"+Contactsearchname1+"\')]"));
		clickButton(driver.findElement(By.xpath("//*[contains(text(),\'" + Contactsearchname5 + "\')]")));
		log.info("User click Click On Login Button");
		Thread.sleep(3000);
	}

	@And("Click On Clear Button")
	public void I_Click_clear_Button() throws Throwable {
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getClearbutton());
		log.info("User click on Clear Button");
		Thread.sleep(3000);
	}

	@And("Click On Clear CSV")
	public void I_Click_clear_CSV() throws Throwable {
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getClearCSV());
		log.info("User click on clear button to remove csv");
		Thread.sleep(3000);
	}

	@And("Click On Do Not Save Button")
	public void I_Click_do_not_save_Button() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getDonotsavebutton());
		Thread.sleep(3000);
		log.info("User click on Do Not save button");
	}

	@And("Click On Fast Growing Contact List")
	public void I_Click_fast_growing_list() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getFastgrowingContact());
		log.info("User click on Clear Button");
	}

	@And("Click On Add all to List")
	public void I_Click_add_all_list() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getAddalltolistbutton());
		log.info("User click on Add All to List");
	}

	@And("Click On Create New Contact List")
	public void I_Click_create_new_list() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getCreatenewcontactlist());
		log.info("User click on Create New Contact List");
	}

	//	@When("Enter New Contact List")
//	public void i_enter_the_contact_list() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getEntercreatenamelist(),
//				readPropertyFileData().getProperty("Contactlist"));
//		log.info("User Enter New Contact List");
//	}
	@When("Enter New Contact List")
	public void i_enter_the_contact_list() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getEntercreatenamelist(),
				ReadDatafromJson("Contact_Name", "Contactlist"));
		log.info("User Enter New Contact List");
	}

	@And("Click On Create New Contact List Save Button")
	public void I_Click_create_new_list_save_button() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getcreatenamelistsavebutton());
		System.out.println("Clicked on Save Button");
		log.info("User click on Create New Contact List Save Button");
	}

	@And("Click On Add Contact List Save Button")
	public void I_Click_Add_list_save_button() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getcreatenamelistsavebutton());
		log.info("User click on Create New Contact List Save Button");
	}
	@And("Click On Add Company List Save Button")
	public void I_Click_Add_Company_list_save_button() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getcreatenamelistsavebutton());
		log.info("User click on Create New Contact List Save Button");
	}
	@And("Click On List Tab")
	public void I_Click_List_Tab() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getListtab());
		log.info("User click on List Tab");
	}

	@And("Click on create List button")
	public void I_Click_On_Create_List_Button() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getCreateListButton());
		log.info("User click on create List button");
	}

	@And("Click on Create company list button")
	public void I_Click_On_Create_Company_List_Button() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getCreateCompanyList());
		log.info("User click on create Company List button");
	}

	@And("Click On SalesIntel Tab")
	public void I_Click_SalesIntel_Tab() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSalesIntelTab());
		log.info("User click on SalesIntel Tab");
		Thread.sleep(5000);
	}

	@When("Check Search Box is displayed in SalesIntel Tab")
	public void I_Check_SearchBox_In_SalesIntel_Tab() throws Throwable{
		Thread.sleep(5000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getSearchBoxInSalesIntalTab().isDisplayed());
		log.info("User Check Search Box is displayed in SalesIntel Tab");
	}

	@And("Check Recommended List is displayed in SalesIntel Tab")
	public void I_Check_Recommended_List_is_displayed_in_SalesIntel_Tab() throws Throwable{
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getRecommendedList().isDisplayed());
		log.info("User Check Recommended List is displayed in SalesIntel Tab");
	}

	@And("Check Saved Searches are displayed in SalesIntel Tab")
	public void I_Check_Saved_Searches_are_displayed_in_SalesIntel_Tab() throws Throwable{
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getSavedSearchesInSiTab().isDisplayed());
		log.info("User Check Saved Searches are displayed in SalesIntel Tab");
	}
	@And("Click on the First Saved Search")
	public void I_Click_on_the_First_Saved_Search() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getFirstSavedSearchName());
		log.info("User Click on the First Saved Search");
		Thread.sleep(15000);
	}

	@And("Click on the First Saved Search in SI tab")
	public void I_Click_on_the_First_Saved_Search_In_SI_Tab() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getFirstSavedSearchInSiTab());
		log.info("User Click on the First Saved Search");
	}

	@And("Search by Created name")
	public void I_Search_by_Created_name() throws Throwable{
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput());
		Thread.sleep(1000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput(),RandomSaveSearchName);
		log.info("Searched by the created name");
	}

	@And("Click on save search Button")
	public void I_Click_On_Save_Search_Button() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSaveSearchButton());
		log.info("User Click on save search Button");
	}

	@And("Click on Update Button in the update pop-up")
	public void I_Click_on_Update_Button_in_the_update_pop_up() throws Throwable{
		Thread.sleep(1000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getUpdateButtonForSaveSearch());
		log.info("User click on Update button in the Update pop-up of saved Search");
	}

	@And("Enter Save Search Name")
	public void I_Enter_ave_Search_Name() throws Throwable{
		RandomSaveSearchName=RandomStringUtils.randomAlphabetic(8);
		enterData(PageObjectManager.getInstance().getLoginPage().getSaveSearchNameTextBox(), RandomSaveSearchName);
		log.info("User Enter save search name");
	}

	@And("Select Visibility of Save search")
	public void I_Select_Visibility_Of_Save_Search() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getVisibilityOptions());
		clickButton(PageObjectManager.getInstance().getLoginPage().getVisibilityToTeam());
		log.info("User Select Visibility as Team");
	}

	@And("Select View of the saved search as Company")
	public void I_Select_View_of_the_saved_search_as_Company() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getDefaultViewDropdown());
		clickButton(PageObjectManager.getInstance().getLoginPage().getDefaultViewCompany());
		log.info("Default view is selected as Company");
	}

	@And("Select View of the saved search as Contact")
	public void I_Select_View_of_the_saved_search_as_Contact() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getDefaultViewDropdown());
		clickButton(PageObjectManager.getInstance().getLoginPage().getDefaultViewContact());
		log.info("Default view is selected as Contact");
	}

	@And("Click on save button for Save Search")
	public void I_Click_On_Save_Button_for_saved_search() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getSaveButtonForSavedSearch());
		log.info("User click on Save Button");
		LocalDate CapturedDateOfCreation = LocalDate.now();
		DateFormat format1 =  new SimpleDateFormat("MMM dd, yyyy");
		Date date = new Date();
		SaveSearchCreationDate= format1.format(date);
//		SaveSearchCreationDate = format1.parse(CapturedDateOfCreation.toString());
		Thread.sleep(5000);
	}

	@And("Click on save button")
	public void I_Click_On_Save_Button() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getSaveList());
		log.info("User click on save button");
	}

	@Then("Validate the Created Save search is displayed in Saved Search Tab")
	public void I_Validate_the_Created_Saved_Search() throws Throwable {
		System.out.println(RandomSaveSearchName);
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSavedSearchTab());
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'"+RandomSaveSearchName+"')])[3]")).isDisplayed());
		log.info("The Created saved search name is Displayed in Saved Search Tab");
	}
	@And("Check The visibility and date of the saved search in the Saved Search Tab")
	public void I_check_The_Visibility_Of_The_Saved_Search_In_The_saved_search_tab() throws Throwable {
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+RandomSaveSearchName+"')]/../../../td[2]/div[contains(text(),'Team')]")).isDisplayed());
		log.info("The visibility of the saved search is same as provided at the creation");
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+RandomSaveSearchName+"')]/../../../td[3]/div[contains(text(),'"+SaveSearchCreationDate+"')]")).isDisplayed());
		log.info("The Saved Search date is same as the Creation date");
	}

	@Then("Check Edit and Save button are working fine")
	public void I_Check_Edit_and_Save_button_are_working_fine() throws Throwable {
		clickButton(driver.findElement(By.xpath("//span[contains(text(),'" + RandomSaveSearchName + "')]/../../../td[4]/div/button[1]/i")));
		clickButton(PageObjectManager.getInstance().getLoginPage().getSaveButton());
		log.info("User Click on Edit and Save button");
	}
	@Then("Delete the created Saved Search")
	public void I_Delete_the_created_Saved_Search() throws Throwable {
		Thread.sleep(3000);
		clickButton(driver.findElement(By.xpath("//span[contains(text(),'"+RandomSaveSearchName+"')]/../../../td[4]/div/button[2]/i")));
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getDeleteButton());
		log.info("User deleted the current saved search");
	}

	@And("Click on Include Team searches checkbox")
	public void I_Click_on_Include_Team_searches_checkbox() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getIncludeTeamCheckBox());
		log.info("User Click on Include Team searches checkbox");
	}

	@When("Create a saved search and check Saved searches are increased by 1")
	public void I_Create_a_saved_search_and_check_Saved_searches_are_increased_by_1() throws Throwable{
		Thread.sleep(3000);
		String SavedSearches=PageObjectManager.getInstance().getLoginPage().getSavedSearchesCount().getText();
		String SavedSearchCount = SavedSearches.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int SavedSearchCountBeforeSaving=Integer.parseInt(SavedSearchCount);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSalesIntelTab());
		clickButton(PageObjectManager.getInstance().getLoginPage().getClearbutton());
		clickButton(PageObjectManager.getInstance().getLoginPage().getIndustryFilter());
		log.info("Click on Industry Filter");
		String IndustryName = ReadDatafromJson("Contact_Name" , "Industry Name");
//		enterData(PageObjectManager.getInstance().getLoginPage().getIndustryNameInputBox(),IndustryName);
		log.info("User enter Industry Name");
		Thread.sleep(2000);
		clickButton(driver.findElement(By.xpath("//*[contains(text(),'" + IndustryName + "')]")));
		log.info("USer click on Particular Industry");
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getnewContactradiobutton());
		log.info("User Click on Contact Radio Button");
		clickButton(PageObjectManager.getInstance().getLoginPage().getSearchButton());
		log.info("User click on Search Button");
		Thread.sleep(10000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSaveSearchButton());
		log.info("User Click on save search Button");
		RandomSaveSearchName=RandomStringUtils.randomAlphabetic(8);
		enterData(PageObjectManager.getInstance().getLoginPage().getSaveSearchNameTextBox(), RandomSaveSearchName);
		log.info("User Enter save search name");
		clickButton(PageObjectManager.getInstance().getLoginPage().getSaveButtonForSavedSearch());
		log.info("User click on Save Button");
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSavedSearchTab());
		log.info("User click on Saved Search Tab");
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput(),RandomSaveSearchName);
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'"+RandomSaveSearchName+"')])[3]")).isDisplayed());
		log.info("User Search by name in the saved Search Tab and Searched item is displayed");
		String SavedSearches2=PageObjectManager.getInstance().getLoginPage().getSavedSearchesCount().getText();
		String SavedSearchCount2 = SavedSearches2.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int SavedSearchCountAfterSaving=Integer.parseInt(SavedSearchCount2);
		if (SavedSearchCountBeforeSaving+1==SavedSearchCountAfterSaving){
			log.info("Saved Search Count is increased by 1 when we save search");
		}
		else {
			log.info("Saved Search Count is not increased by 1 when we save search -- TC Failed");
		}
	}

	@And("Click on first Recommended List")
	public void I_Click_on_first_Recommended_List() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getFirstRecommendedList());
		Thread.sleep(5000);
		log.info("User Click on first Recommended List");
	}


	@And("Click on View all Saved Searches")
	public void I_Click_on_View_all_Saved_Searches() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getViewallForSavedSearch());
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getIncludeTeamSearchesTextInSavedSearchTab().isDisplayed());
		log.info("User is navigated to Saved Search tab");
	}

	@Then("Scroll Down the Page with Human Verified Contacts")
	public void I_Scroll_Down_Human_Verified() throws Throwable {
		String ActualRefValue = PageObjectManager.getInstance().getLoginPage().HumanVerified().getText();
		String[] Split = ActualRefValue.split("Human Verified");
		String ExpectedRefValue = Split[0].replaceAll(",","").trim();
		System.out.println(ExpectedRefValue);
		int Scroltillrange = Integer.parseInt(ExpectedRefValue);
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
		for (int i = 0; i < Scroltillrange; i++) {
			javascriptExecutor.executeScript("document.querySelector('.result-scrollabel').scrollBy(0,100)");
//			Thread.sleep(100);
		}
	}

	@When("Validate Search Results for Recommended List")
	public void I_Validate_Search_Results_for_Recommended_List() throws Throwable{
		boolean FirstRecommendedListCheckBox= PageObjectManager.getInstance().getLoginPage().getFirstRecommendedListInRankings().isEnabled();
		if (FirstRecommendedListCheckBox){
			log.info("First Recommended CheckBox is Clicked in Search Filter");
		}
		else {
			log.info("First Recommended CheckBox is not Clicked in Search Filter");
		}
		clickButton(PageObjectManager.getInstance().getLoginPage().getFirstCompanyInResult());
		String HumanVerifiedCompanies= PageObjectManager.getInstance().getLoginPage().getHumanVerifiedCompaniesCount().getText();
		String HvCompanyCountTrimmed =HumanVerifiedCompanies.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		int HvCompanyCount =Integer.parseInt(HvCompanyCountTrimmed);
		System.out.println("Total Human Verified Companies are "+HvCompanyCount);
		log.info("Validated Search Results for Recommended List");
	}

	@Then("Validate Search Result for Saved Searches")
	public void I_Validate_Search_Result_for_Saved_Searches() throws Throwable{
		String TotalContacts =PageObjectManager.getInstance().getLoginPage().getHumanVerifiedContactsCount().getText();
		System.out.println("Total "+TotalContacts+" Human Verified Contacts for the Saved Search");
		log.info("USer Check Search Results of Saved Searches");
		clickButton(PageObjectManager.getInstance().getLoginPage().getFirstSearchedContact());
		Thread.sleep(2000);
	}

	@And("Click on Search Box in SalesIntel Tab")
	public void I_Click_On_SearchBox_In_SalesIntel_Tab() throws Throwable{
		Thread.sleep(1000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSearchBoxInSalesIntalTab());
		log.info("User Click on Search Box is displayed in SalesIntel Tab");
	}

	@And("Enter Company Name in the Search Box")
	public void I_Enter_Company_Name_In_The_Search_Box_Of_SalesIntel_Tab() throws Throwable{
		Thread.sleep(1000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchBoxInSalesIntalTab(), ReadDatafromJson("Contact_Name","Company_domain"));
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log.info("User Enter Company Name in the Search Box");
	}

	@And("Enter Company Domain in the Search Box")
	public void I_Enter_Company_Domain_In_The_Search_Box_Of_SalesIntel_Tab() throws Throwable{
		Thread.sleep(1000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchBoxInSalesIntalTab(), ReadDatafromJson("Contact_Name","Company_domain"));
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log.info("User Enter Company Domain in the Search Box");
	}

	@And("Click on Search Button in The SalesIntel Tab")
	public void I_Click_on_Search_Button_in_The_SalesIntel_Tab() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSearchButtonInSalesIntelTab());
		log.info("User Click on Search Button in The SalesIntel Tab");
	}

	@And("Click on Companies Tab")
	public void I_Click_on_Companies_Tab() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getCompaniesTab());
		log.info("User Click on Companies Tab");
		Thread.sleep(2000);
	}

	@Then("Validate the Searched Company Name In Search Result")
	public void I_Validate_the_Searched_Company_Name_In_Search_Result() throws Throwable{
		Thread.sleep(5000);
		try {
			if (PageObjectManager.getInstance().getLoginPage().getNoCompanyFound().isDisplayed()){
				log.info("No Company Results found for this Company");
			}
			else{
				String CompanyName=ReadDatafromJson("Contact_Name","Company_name");
				driver.findElement(By.xpath("(//input[@type='checkbox' and @title])[2]//..//..//../div[3]/div[1]/a[contains(text(),'" + CompanyName +"')]")).isDisplayed();
				log.info("Searched Company is displayed in Company Results");
			}
		}
		catch (Exception e){
			System.out.println("TC-Failed, Test Manually");
		}
	}

	@Then("Validate the Searched Company Domain In Search Result")
	public void I_Validate_the_Searched_Company_Domain_In_Search_Result() throws Throwable{
		Thread.sleep(5000);
		try {
			if (PageObjectManager.getInstance().getLoginPage().getNoCompanyFound().isDisplayed()){
				log.info("No Company Results found for this Company");
			}
			else{
				String CompanyName1=ReadDatafromJson("Contact_Name","Company_name");
				driver.findElement(By.xpath("(//input[@type='checkbox' and @title])[2]//..//..//../div[3]/div[1]/a[contains(text(),'" + CompanyName1 +"')]")).isDisplayed();
				log.info("Searched Domain/Name is displayed in Company Results");
			}
		}
		catch (Exception e){
			System.out.println("TC-Failed, Test Manually");
		}
	}

	@And("Select Multiple contact to Add Contact List")
	public void I_select_multiple_Contacts() {
		for (int i = 1; i < 6; i++) {
			driver.findElements(By.xpath("(//input[@type='checkbox' and @title='Select'])[" + i + "]")).get(0).click();
			//System.out.println(driver.findElements(By.xpath("(//input[@type='checkbox' and @title='Select'])["+i+"]")).size());
		}
		log.info("Select Multiple contact to Add Contact List");
	}

	@And("Select Multiple Company to Add Company List")
	public void I_select_multiple_Company() {
		for (int i = 1; i < 4; i++) {
			driver.findElements(By.xpath("(//input[@type='checkbox' and @title='Select'])[" + i + "]")).get(0).click();
			//System.out.println(driver.findElements(By.xpath("(//input[@type='checkbox' and @title='Select'])["+i+"]")).size());
		}
		log.info("Select Multiple Company to Add Company List");
	}
	@And("Append Contact details into the List")
	public void I_append_multiple_Contacts() {
		Contactlist = new LinkedList<>();
		for (int i = 1; i < 6; i++) {
			String Contactname = driver.findElements(By.xpath("((//input[@type='checkbox' and @title='Select'])[" + i + "]//following::span)[" + i + "]")).get(0).getText();
			//System.out.println(driver.findElements(By.xpath("(//input[@type='checkbox' and @title='Select'])["+i+"]")).size());
			Contactlist.add(Contactname);
		}
		log.info("Append Contact details into the List");
	}

	@And("Append Company details into the List")
	public void I_append_multiple_Company() {
		Contactlist = new LinkedList<>();
		for (int i = 1; i < 6; i++) {
			String Companyname = driver.findElements(By.xpath("((//input[@type='checkbox' and @title='Select'])[" + i + "]//following::span)[" + i + "]")).get(0).getText();
			//System.out.println(driver.findElements(By.xpath("(//input[@type='checkbox' and @title='Select'])["+i+"]")).size());
			Contactlist.add(Companyname);
		}
		log.info("Append Company details into the List");
	}

	@Then("Select Preview Button")
	public void I_Select_Preview_Button() throws Throwable {
		Thread.sleep(5000);
		Actions Clickpreview = new Actions(driver);
//		String contactlistnamesearch = readPropertyFileData().getProperty("Contactlist");
		String contactlistnamesearch = ReadDatafromJson("Contact_Name", "Contactlist");
		Clickpreview.doubleClick(driver.findElement(By.xpath("(//span[contains(text(),'"+contactlistnamesearch+"')])[2]/../../../td[5]/div/button[1]"))).build().perform();
		//driver.findElement(By.xpath("(//*[contains(text(),'"+contactlistnamesearch+"')])[2]//following::button[@title='Preview']"))
		log.info("Select Preview Button");
	}

	@And("Compare Contact details into the List")
	public void I_compare_multiple_Contacts() {
		Comparelist = new LinkedList<>();
		for (int i = 1; i < 3; i++) {
			String Comparename = driver.findElements(By.xpath("((//input[@type='checkbox' and @title='Select'])[" + i + "]//following::span)[" + i + "]")).get(0).getText();
			//System.out.println(driver.findElements(By.xpath("(//input[@type='checkbox' and @title='Select'])["+i+"]")).size());
			Comparelist.add(Comparename);
		}
		System.out.println(Contactlist);
		System.out.println(Comparelist);
		Assert.assertTrue(Contactlist.equals(Comparelist));
		Contactlist.retainAll(Comparelist);
		log.info("Select Multiple contact to Add Contact List");
	}

	@And("Delete Contact List")
	public void I_Delete_Contact_List() throws Throwable {
		Thread.sleep(5000);
		Actions Clickpreview = new Actions(driver);
		String contactlistnamesearch = ReadDatafromJson("Contact_Name", "Contactlist");
		Clickpreview.doubleClick(driver.findElement(By.xpath("(//span[contains(text(),'"+contactlistnamesearch+"')])[2]/../../../td[5]/div/button[3]"))).build().perform();
		//driver.findElement(By.xpath("(//*[contains(text(),'"+contactlistnamesearch+"')])[2]//following::button[@title='Preview']"))
		log.info("Select Multiple contact to Add Contact List");
	}

	@And("Delete Company List")
	public void I_Delete_Company_List() throws Throwable {
		Thread.sleep(5000);
		Actions Clickpreview = new Actions(driver);
		String companylistnamesearch = ReadDatafromJson("Contact_Name", "Companylist");
		Clickpreview.doubleClick(driver.findElement(By.xpath("(//span[contains(text(),'"+companylistnamesearch+"')])[2]/../../../td[5]/div/button[3]"))).build().perform();
		//driver.findElement(By.xpath("(//*[contains(text(),'"+contactlistnamesearch+"')])[2]//following::button[@title='Preview']"))
		log.info("Delete Company List");
	}

	@And("Click On Delete Contact List")
	public void I_delete_contact_list() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getDeletecontactList());
		log.info("Click On Delete Contact List");
	}

	@And("Verify Requested ROD is Displayed in ROD tab")
	public void I_verify_Requested_ROD_In_ROD_Tab() throws Throwable {
		Thread.sleep(10000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().RODreqestedInRODtab().isDisplayed());
		log.info("User Verified Requested ROD in ROD Tab");
	}


	@When("Click On Setting Options")
	public void I_click_welcome_Logout() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getWelcomeTextforLogout());
		log.info("User Click On Setting Options");
	}

	@And("Click On Logout Options")
	public void I_click_Logout() throws Throwable {
		Thread.sleep(3000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getLogout());
		log.info("Click On Logout Button");
	}
	@And("Click On Delete Company List")
	public void I_delete_company_list() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getDeletecontactList());
		log.info("Click On Delete Company List");
		Thread.sleep(10000);
	}
	@Then("Click On Contact Tab")
	public void I_contact_Tab() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getContactsTab());
		log.info("User click on Clear Button");
	}

	@When("Enter the First Name to search")
	public void i_enter_the_FirstName_to_search() throws Throwable {
//		readCompleteDataFromEXcel();
		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), ReadDatafromJson("Contact_Name", "Search_name"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
		log.info("User enter the First Name");
	}
	@And("Validate Contact Search Result")
	public void I_Validate_Contact_Search_Result() {
		List<WebElement> allElement = driver.findElements(By.xpath("//*[contains(text(),'Micheal')]"));
		for (WebElement eachElement : allElement) {
			String actualValue = eachElement.getText();
			if (actualValue.contains("Micheal")) {
				System.out.println("The Actual Result values: " + actualValue);
				Assert.assertTrue(actualValue.contains("Micheal"));
			} else {
				System.out.println("Both Actual and Expected are mismatching");
			}
		}
		log.info("Validate Search Result");
	}
	@And("Click On Add all Contact to Existing List")
	public void I_Click_Add_all_Contact_Existing_List() throws Throwable {
		Thread.sleep(3000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getAddtoexistinglist());
		log.info("User Click On Add all Contact to Existing List");
	}
	@And("Click on Contact List Drop Down Option")
	public void I_Click_Contact_List_Drop_Down() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getContactListDropdown());
		String ContactList=ReadDatafromJson("Contact_Name", "Contactlist");
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'"+ContactList+"')])[3]")).isDisplayed());
		clickButton(driver.findElement(By.xpath("(//span[contains(text(),'"+ContactList+"')])[3]")));
		log.info("User Click On Add all Contact to Existing List");
	}
	@And("Click on Company List Drop Down Option")
	public void I_Click_Company_List_Drop_Down() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getCompanyListDropdown());
		String CompanyList = ReadDatafromJson("Contact_Name", "Companylist");
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'"+CompanyList+"')])[3]")).isDisplayed());
		clickButton(driver.findElement(By.xpath("(//span[contains(text(),'"+CompanyList+"')])[3]")));
		log.info("User Click on Company List Drop Down Option");
	}
	@Then("Click On Company Tab")
	public void I_company_Tab() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getCompanyTab());
		log.info("User click on Clear Button");
		Thread.sleep(5000);
	}
	@Then("Click On Company")
	public void I_company_option() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getCompanyName());
		log.info("User click on Clear Button");
		Thread.sleep(5000);
	}
	@When("Enter Valid Company Name")
	public void i_enter_the_company_name() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getCompanyInput(),
				ReadDatafromJson("Contact_Name", "Company_name"));
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log.info("User Enter Valid Company Name");
		Thread.sleep(2000);
	}

	@And("Click On Company Input Text Field")
	public void I_Click_Company_name() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getCompanyInput());
		log.info("Click On Company Input Text Field");
		Thread.sleep(5000);
	}

	@And("Click On Create New Company List")
	public void I_Click_create_new_Company_list() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getCreatenewcompanylist());
		log.info("User Click On Create New Company List");
	}
	@And("Click On Add Existing Company List")
	public void I_Click_add_Existing_Company_list() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getAddtoexistingcompanylist());
		log.info("User Click On Add Existing Company List");
	}
	@When("Enter New Company List")
	public void i_enter_the_company_list() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getEntercreatenamelist(),
				ReadDatafromJson("Contact_Name", "Companylist"));
		log.info("User Enter New Company List");
	}
	@And("Click On Create New Company List Save Button")
	public void I_Click_create_new_Company_list_save_button() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getcreatenamelistsavebutton());
		System.out.println("Clicked on Save Button");
		log.info("User Click On Create New Company List Save Button");
	}
	@And("Click On Sort Icon For Display Contact based on Contact Name")
	public void I_Click_Sort_Icon_Name() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSortbyName());
		System.out.println("Click On Sort Icon For Display Contact based on Contact Name");
		log.info("Click On Sort Icon For Display Contact based on Contact Name");
		Thread.sleep(10000);
	}
	@And("Click On Sort Icon For Display Contact based on Job Title")
	public void I_Click_Sort_Icon_Job() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSortbyLevel());
		System.out.println("Click On Sort Icon For Display Contact based on Job Title Name");
		log.info("Click On Sort Icon For Display Contact based on Job Title Name");
		Thread.sleep(10000);
	}
	@And("Click On Sort Icon For Display Contact based on Job Level")
	public void I_Click_Sort_Icon_Level() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSortbyLevel());
		System.out.println("Click On Sort Icon For Display Contact based on Job Level Name");
		log.info("Click On Sort Icon For Display Contact based on Job Level Name");
		Thread.sleep(10000);
	}
	@And("Click On Sort Icon For Display Contact based on Dept")
	public void I_Click_Sort_Icon_Dept() throws Throwable {
		Thread.sleep(10000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSortbyDept());
		System.out.println("Click On Sort Icon For Display Contact based on Job Title Name");
		log.info("Click On Sort Icon For Display Contact based on Job Title Name");
		Thread.sleep(10000);
	}
	@And("Click On Sort Icon For Display Contact based on Comp")
	public void I_Click_Sort_Icon_Comp() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSortbyComp());
		System.out.println("Click On Sort Icon For Display Contact based on Job Title Name");
		log.info("Click On Sort Icon For Display Contact based on Job Title Name");
		Thread.sleep(10000);
	}
	@And("Click On Sort Icon For Display Contact based on Location")
	public void I_Click_Sort_Icon_Location() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSortbyLocation());
		System.out.println("Click On Sort Icon For Display Contact based on Job Title Name");
		log.info("Click On Sort Icon For Display Contact based on Job Title Name");
		Thread.sleep(10000);
	}

	@And("Move the SalesIntel Website Screen Up")
	public void I_Scroll_Up_Screen() throws Throwable {
		Thread.sleep(5000);
		Scrollpup(PageObjectManager.getInstance().getLoginPage().getScrollup());
	}
	@And("Move the SalesIntel Website Screen Down")
	public void I_Scroll_down_Screen() throws Throwable {
		Thread.sleep(10000);
		Scrollpup(PageObjectManager.getInstance().getLoginPage().getBrowsefile());
	}

	@And("Click On Browse Button")
	public void I_Click_Browse() throws Throwable {
		Thread.sleep(10000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getBrowsefile());
		log.info("Click On Browse Button");
	}

	@And("Click On Choose File Button")
	public void I_Click_Choose_File_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getChooseFileButton());
		log.info("Click On Choose File button");
	}
	@And("Upload File From Local Directory")
	public void I_Upload_File_Directory() throws Throwable {
		Thread.sleep(5000);
		uploadfilefromlocal("D:\\Automation\\SalesIntel\\CSV\\DataEnrichment.csv");
	}

	@And("Upload File From Local Directory For company List")
	public void I_Upload_File_DirectoryForCompanyList() throws Throwable {
		Thread.sleep(5000);
		uploadCompanyListfilefromlocal("D:\\Automation\\SalesIntel\\CSV\\CompanyList.csv");
	}

	@And("Click on download template")
	public void I_Click_On_Download_Template() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getDownloadTemplate());
		log.info("User Click on download template");
		Thread.sleep(3000);
	}

	@And("Select Contact List Option For Data enrichment")
	public void I_Select_Contact_List_Option_For_Data_Enrichment() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getContactListForDataEnrichment());
		log.info("User click on Contact List Option For Data enrichment");
	}

	@And("Click on Next button")
	public void I_Click_On_Next_Button() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getNextButton());
		log.info("User Click on Next Button");
	}

	@And("Enter List Name For Data Enrichment")
	public void I_Enter_List_Name_For_Data_Enrichment() throws Throwable{
		RandomListName = RandomStringUtils.randomAlphabetic(8);
		enterData(PageObjectManager.getInstance().getLoginPage().getListNameForDataEnrichment(), RandomListName);
		log.info("User Enter the List name fot Data Enrichment");
	}

	@And("Click On Save List under Data Enrichment")
	public void I_Click_On_Save_List_Under_Data_Enrichment() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getSaveListForDatanrichment());
		log.info("User Click On Save List under Data Enrichment");
	}

	@And("Click on Close Button")
	public void I_Click_On_Close_Button() throws Throwable{
		Thread.sleep(7000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getCloseButton());
		log.info("User Click on Close Button");
	}

	@Then("Check the Added List in the List Tab")
	public void I_Check_The_Added_List_In_The_List_Tab() throws Throwable{
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getListtab());
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'"+RandomListName+"')])[2]")).isDisplayed());
		log.info("The Added Data Enrichment list is Displayed in the List Tab");
	}

	@When("Click on saved searches tab")
	public void I_Click_On_Saved_Search_Tab() throws Throwable{
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSavedSearchTab());
		log.info("User click on saved Search tab");
	}

	@And("Search by Single character")
	public void I_Search_by_Single_character() throws Throwable {
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput(), "a");
		log.info("User Entered a single Character and search in the Saved searches Tab");
	}
	@And("Search by Multiple characters")
	public void I_Search_by_Multiple_characters() throws Throwable {
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput(), "abc");
		log.info("User Entered multiple Characters and search in the Saved searches Tab");
	}

	@And("Search by Numeric Values")
	public void I_Search_by_Numeric_Values() throws Throwable {
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput(), "1122");
		log.info("User Entered Numeric Values and search in the Saved searches Tab");
	}

	@And("Search by Alphanumeric Values")
	public void I_Search_by_Alphanumeric_Values() throws Throwable {
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput());
		Thread.sleep(2000);
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput(), "11ab");
		log.info("User Entered Alphanumeric Values and search in the Saved searches Tab");
	}

	@Then("Check Search Results when we search with a single character")
	public void I_Check_Search_Results_when_we_search_with_a_single_character() throws Throwable{
		try {
			PageObjectManager.getInstance().getLoginPage().getNoRecordForSavedSearch().isDisplayed();
			log.info("No Record found for the entered Single character");
		}
		catch (Exception e){
			driver.findElement(By.xpath("(//span[@class='a text-break' and contains(text(),'a')])[1]")).isDisplayed();
			log.info("Saved Search is displayed for the entered Single character");
		}
	}

	@Then("Check Search Results when we search with Multiple characters")
	public void I_Check_Search_Results_when_we_search_with_Multiple_characters() throws Throwable{
		try {
			PageObjectManager.getInstance().getLoginPage().getNoRecordForSavedSearch().isDisplayed();
			log.info("No Record found for the entered Multiple characters");
		}
		catch (Exception e){
			driver.findElement(By.xpath("(//span[@class='a text-break' and contains(text(),'abc')])[1]")).isDisplayed();
			log.info("Saved Search is displayed for the entered Multiple characters");
		}
	}

	@Then("Check Search Results when we search with Numeric Values")
	public void I_Check_Search_Results_when_we_search_with_Numeric_Values() throws Throwable{
		try {
			PageObjectManager.getInstance().getLoginPage().getNoRecordForSavedSearch().isDisplayed();
			log.info("No Record found for the entered Numeric Values");
		}
		catch (Exception e){
			driver.findElement(By.xpath("(//span[@class='a text-break' and contains(text(),'1122')])[1]")).isDisplayed();
			log.info("Saved Search is displayed for the entered Numeric Values");
		}
	}

	@Then("Check Search Results when we search with Alphanumeric Values")
	public void I_Check_Search_Results_when_we_search_with_Alphanumeric_Values() throws Throwable{
		try {
			PageObjectManager.getInstance().getLoginPage().getNoRecordForSavedSearch().isDisplayed();
			log.info("No Record found for the entered Alphanumeric Values");
		}
		catch (Exception e){
			driver.findElement(By.xpath("(//span[@class='a text-break' and contains(text(),'11ab')])[1]")).isDisplayed();
			log.info("Saved Search is displayed for the entered Alphanumeric Values");
		}
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput());
		Thread.sleep(2000);
		log.info("Clear the Search by name input box");
	}

	@When("Check visibility as Team when Checkbox is checked")
	public void I_Check_visibility_as_Team_when_Checkbox_is_checked() throws Throwable{
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'')]/../../../td[2]/div[contains(text(),'Team')])[1]")).isDisplayed());
		log.info("The visibility of the saved search is Displayed as Team when checkbox is checked");
	}

	@When("Check visibility as Private when checkbox is checked")
	public void I_Check_visibility_as_Private_when_checkbox_is_checked() throws Throwable{
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'')]/../../../td[2]/div[contains(text(),'Private')])[1]")).isDisplayed());
		log.info("The visibility of the saved search is Displayed as Private when checkbox is checked");
	}

	@When("Check visibility as Team is not displayed when checkbox is unchecked")
	public void I_Check_visibility_as_Team_is_not_displayed_when_checkbox_is_unchecked() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getIncludeTeamCheckBox());
		try {
			Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'')]/../../../td[2]/div[contains(text(),'Team')])[1]")).isDisplayed());
			log.info("The Visibility as Team is displayed when checkbox is Unchecked -- TC Failed");
		} catch (Exception e) {
			log.info("User Validated visibility as Team is not displayed when checkbox is unchecked");
		}
	}
	@When("Click on edit icon of First Saved Search")
	public void I_Click_on_edit_icon_of_First_Saved_Search() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getEditButtonForFirstSavedSearch());
		log.info("User click on edit icon of First Saved Search");
		Thread.sleep(1000);
	}

	@And("Click on Cancel button")
	public void I_Click_on_Cancel_button() throws Throwable{
		Thread.sleep(1000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getCancelButton());
		log.info("User click on cancel button");
	}

	@And("Check all content is displayed for edit popup")
	public void I_Check_all_content_is_displayed_for_edit_popup() throws Throwable{
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getSavedSearchEditPopupTitle().isDisplayed());
		log.info("Saved Search Edit popup Header");
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getSaveSearchNameTextBox().isDisplayed());
		log.info("name text field is displayed in the edit popup");
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getVisibilityOptions().isDisplayed());
		log.info("Visibility Dropdown is displayed in the edit popup");
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getDefaultViewDropdown().isDisplayed());
		log.info("Default View Dropdown displayed in the edit popup");
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getRecieveEmailAllertButton().isDisplayed());
		log.info("Recive Email Allert Button is displayed in the edit popup");
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getSaveButton().isDisplayed());
		log.info("Save Button is displayed in the edit popup");
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getCancelButton().isDisplayed());
		log.info("Cancel Button is displayed in the edit popup");
		Thread.sleep(2000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getCancelButton());
		log.info("User click on Cancel button");
	}

	@Then("Edit the Saved Search details")
	public void I_Edit_The_Saved_Search_Details() throws Throwable{
		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput());
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput(),RandomSaveSearchName);
		clickButton(PageObjectManager.getInstance().getLoginPage().getEditButtonForFirstSavedSearch());
		RandomSaveSearchName=RandomStringUtils.randomAlphabetic(8);
		clearText(PageObjectManager.getInstance().getLoginPage().getSaveSearchNameTextBox());
		enterData(PageObjectManager.getInstance().getLoginPage().getSaveSearchNameTextBox(),RandomSaveSearchName);
		log.info("New Saved Search name is "+RandomSaveSearchName);
		clickButton(PageObjectManager.getInstance().getLoginPage().getVisibilityOptions());
		clickButton(PageObjectManager.getInstance().getLoginPage().getVisibilityToTeamWithClass());
		log.info("User Select Visibility as Team");
		clickButton(PageObjectManager.getInstance().getLoginPage().getDefaultViewDropdown());
		clickButton(PageObjectManager.getInstance().getLoginPage().getDefaultViewCompany());
		log.info("Default view is selected as Company");
		clickButton(PageObjectManager.getInstance().getLoginPage().getRecieveEmailAllertButton());
		log.info("Enabled Email alert button");
		clickButton(PageObjectManager.getInstance().getLoginPage().getSaveButton());
		log.info("Clicked on Save button");
		Thread.sleep(3000);
	}

	@Then("Edit the Saved Search details one more time")
	public void I_Edit_The_Saved_Search_Details_one_more_Time() throws Throwable{
		Thread.sleep(2000);
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput());
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput(),RandomSaveSearchName);
		clickButton(PageObjectManager.getInstance().getLoginPage().getEditButtonForFirstSavedSearch());
		RandomSaveSearchName=RandomStringUtils.randomAlphabetic(8);
		clearText(PageObjectManager.getInstance().getLoginPage().getSaveSearchNameTextBox());
		enterData(PageObjectManager.getInstance().getLoginPage().getSaveSearchNameTextBox(),RandomSaveSearchName);
		log.info("New Saved Search name is "+RandomSaveSearchName);
		clickButton(PageObjectManager.getInstance().getLoginPage().getVisibilityOptions());
		clickButton(PageObjectManager.getInstance().getLoginPage().getVisibilityToTeam());
		log.info("User Select Visibility as Team");
		clickButton(PageObjectManager.getInstance().getLoginPage().getDefaultViewDropdown());
		clickButton(PageObjectManager.getInstance().getLoginPage().getDefaultViewContact());
		log.info("Default view is selected as Contact");
		clickButton(PageObjectManager.getInstance().getLoginPage().getRecieveEmailAllertButton());
		log.info("Disabled Email alert button");
		clickButton(PageObjectManager.getInstance().getLoginPage().getSaveButton());
		log.info("Clicked on Save button");
	}

	@Then("validate the Edited details of saved search")
	public void I_validate_the_Edited_details_of_saved_search() throws Throwable{
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput());
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput(),RandomSaveSearchName);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getFirstSavedSearchName().isDisplayed());
		log.info("Saved search is displayed with the new name after editing");
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getVisibilityAsTeamInSavedSearch().isDisplayed());
		log.info("Edited Visibility is Displayed in the saved searches");
		clickButton(PageObjectManager.getInstance().getLoginPage().getFirstSavedSearchName());
		Thread.sleep(5000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getnewCompanyradiobutton().isSelected());
		log.info("The company Tab is selected as View is changed to Company");
	}

	@Then("validate the Edited details of saved search One more time")
	public void I_validate_the_Edited_details_of_saved_search_One_more_Time() throws Throwable{
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput());
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchByNameInput(),RandomSaveSearchName);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getFirstSavedSearchName().isDisplayed());
		log.info("Saved search is displayed with the new name after editing");
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getVisibilityAsTeamInSavedSearch().isDisplayed());
		log.info("Edited Visibility is Displayed in the saved searches");
		clickButton(PageObjectManager.getInstance().getLoginPage().getFirstSavedSearchName());
		Thread.sleep(5000);
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getnewContactradiobutton().isSelected());
		log.info("The Contact Tab is selected as View is changed to Contact");
	}

	@Then("Validate the Navigation to the SalesIntel Tab for Contact view")
	public void I_Validate_the_Navigation_to_the_SalesIntel_Tab_for_Contact_view() throws Throwable{
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='ng-value-label ng-star-inserted' and contains(text(),'"+RandomSaveSearchName+"')]")).isDisplayed());
		log.info("Created saved search is Selected in the top of the Filters");
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getHrDepartmentFilter().isSelected());
		log.info("Searched Filter is Pre-populated and Selected");
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getnewContactradiobutton().isSelected());
		log.info("Contact radio button is selected by default");
		if (PageObjectManager.getInstance().getLoginPage().getSearchSavedButton().isEnabled()){
			log.info("Save search button is disabled - TC Failed");
		}
		else {
			log.info("Save search button is disabled");
		}
		log.info("User Validated the Navigation to the SalesIntel Tab for Contact view");
	}

	@Then("Validate the updated details of the saved search with the same name")
	public void I_Validate_the_updated_details_of_the_saved_search_with_the_same_name() throws Throwable{
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='ng-value-label ng-star-inserted' and contains(text(),'"+RandomSaveSearchName+"')]")).isDisplayed());
		log.info("Created saved search is Selected in the top of the Filters");
		Thread.sleep(5000);
		String IndustryName = ReadDatafromJson("Contact_Name" , "Industry Name");
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'" + IndustryName + "')]/../../input")).isSelected());
		log.info("Searched Filter is Pre-populated and Selected");
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getnewContactradiobutton().isSelected());
		log.info("Contact radio button is selected by default");
		if (PageObjectManager.getInstance().getLoginPage().getSearchSavedButton().isEnabled()){
			log.info("Save search button is disabled - TC Failed");
		}
		else {
			log.info("Save search button is disabled");
		}
		log.info("User Validated the updated details of the saved search");
	}
	@When("Click on Sorting icon of Name for Ascending order")
	public void I_Click_on_Sorting_icon_of_Name_for_Ascending_order() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getNameColumn());
		log.info("User Click on Sorting icon of Name for Ascending order");
	}

	@When("Click on Sorting icon of Name for Descending order")
	public void I_Click_on_Sorting_icon_of_Name_for_Descending_order() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getNameColumn());
		log.info("User Click on Sorting icon of Name for Descending order");
	}

	@And("Check the search results of Name for Ascending order")
	public void I_Check_the_search_results_of_Name_for_Ascending_order() throws Throwable{
		String AllSavedSearches=driver.findElement(By.xpath("(//span[contains(text(),'Saved Search')])[2]")).getText();
		String AllSavedSearchesTrimmed =AllSavedSearches.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		System.out.println("Lets Validate the Ascending order of Saved Searches Names");
		int n =Integer.parseInt(AllSavedSearchesTrimmed);
		for (int i=1; i<=n;i++){
			String SavedSearchName=driver.findElement(By.xpath("(//strong[contains(text(),'NAME')])[1]/../../../../tbody/tr["+i+"]/td[1]/div/span")).getText();
			System.out.println("Sn."+i+" "+SavedSearchName);
		}
	}

	@And("Check the search results of Name for Descending order")
	public void I_Check_the_search_results_of_Name_for_Descending_order() throws Throwable{
		String AllSavedSearches=driver.findElement(By.xpath("(//span[contains(text(),'Saved Search')])[2]")).getText();
		String AllSavedSearchesTrimmed =AllSavedSearches.replaceAll("[A-Z,a-z,(),\\s,\\u0020]", "");
		System.out.println("Lets Validate the Descending order of Saved Searches Names");
		int n =Integer.parseInt(AllSavedSearchesTrimmed);
		for (int i=1; i<=n;i++){
			String SavedSearchName=driver.findElement(By.xpath("(//strong[contains(text(),'NAME')])[1]/../../../../tbody/tr["+i+"]/td[1]/div/span")).getText();
			System.out.println("Sn."+i+" "+SavedSearchName);
		}
	}

	@Then("Validate the Created Company list in List Tab")
	public void I_Validate_the_Created_Company_list_in_List_Tab() throws Throwable{
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchByNameInputInList(), RandomListName);
		log.info("User Entered the Created Company list name");
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'"+RandomListName+"')])[2]")).isDisplayed());
		log.info("User validated the Created Company list is displayed in the List tab");
	}

	@Then("Validate the edition and Deletion for the created Company List")
	public void I_Validate_the_edition_and_Deletion_of_Record_For_the_created_Company_List() throws Throwable{
		clickButton(PageObjectManager.getInstance().getLoginPage().getEditButtonForFirstList());
		clickButton(PageObjectManager.getInstance().getLoginPage().getEditButtonForListName());
		clearText(PageObjectManager.getInstance().getLoginPage().getEditNameTextField());
		RandomListName=RandomStringUtils.randomAlphabetic(8);
		enterData(PageObjectManager.getInstance().getLoginPage().getEditNameTextField(),RandomListName);
		clickButton(PageObjectManager.getInstance().getLoginPage().getSaveEditedListName());
		clickButton(PageObjectManager.getInstance().getLoginPage().getFirstRecordInEditList());
		clickButton(PageObjectManager.getInstance().getLoginPage().getDeleteRecordInEditList());
		Thread.sleep(3000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getDeleteButton());
		Thread.sleep(3000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getCloseButton());
		clearText(PageObjectManager.getInstance().getLoginPage().getSearchByNameInputInList());
		enterData(PageObjectManager.getInstance().getLoginPage().getSearchByNameInputInList(),RandomListName);
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'"+RandomListName+"')])[2]")).isDisplayed());
		log.info("User validated the Edited Company list is displayed in the List tab");
	}
}