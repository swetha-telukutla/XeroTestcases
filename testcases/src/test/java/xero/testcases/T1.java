package xero.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class T1 extends ReusableMethodsForXEROtestcases{
	public static void t1 () throws InterruptedException, IOException {
		
//Navigate to Xero application
		stratExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet1"); 
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		//enterText(emailAdress,"sanka.teluk@gmail.com");
		enterText(emailAdress,recData[0][0]);
		 //findElement(By location, String objName)
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		//enterText(passWord,"Praneel@143");
		enterText(passWord,recData[0][1]);
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login);
		Thread.sleep(2000);
		endExtentReport();
	}
	
	//Incorrect pwd testcase

	public static void t2() throws InterruptedException, IOException {
		stratExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet2"); 
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		enterText(emailAdress,recData[0][0]);
		//enterText(emailAdress, "sanka.teluk@gmail.com");
		// findElement(By location, String objName)
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(passWord,recData[0][1]);
		//enterText(passWord, "Praneel@13");
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login);
		String errorMessage = driver.findElement(By.xpath("//button[@id='submitButton']")).getText();
		 System.out.println(errorMessage);
		 String actualMessage=("Your email or password is incorrect");
		CompareString(actualMessage, errorMessage);
		System.out.println("both messages are same");
		Thread.sleep(2000);
		endExtentReport();

	}
	//Incorrect username testcase

	public static void t3() throws InterruptedException, IOException {
		stratExtentReport();
		initializeDriver();
		Thread.sleep(4000);
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet3"); 
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		enterText(emailAdress,recData[0][0]);
		
		// findElement(By location, String objName)
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(passWord,recData[0][1]);
		
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login);
		String errorMessage = driver.findElement(By.xpath("//button[@id='submitButton']")).getText();
		 System.out.println(errorMessage);
		String actualMessage=("Your email or password is incorrect");
		CompareString(actualMessage, errorMessage);
		Thread.sleep(2000);
		endExtentReport();

	}
	//forgot pwd testcase

	public static void t4() throws InterruptedException, IOException {
		stratExtentReport();
		Thread.sleep(4000);
		initializeDriver();
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet1"); 
		WebElement forgotpw = driver.findElement(By.xpath("//a[contains(@class,'forgot-password-advert')]"));
		clickObject(forgotpw);
		System.out.println("Salesforce forgot password page is displayed");
		Logger.log(LogStatus.PASS, forgotpw + "Salesforce forgot password page is displayed ");

		WebElement emailAdress = driver.findElement(By.xpath("//input[@id='UserName']"));
		enterText(emailAdress,recData[0][0]);
		
		WebElement sendLinkbutton = driver.findElement(By.xpath("//a[@class='x-btn blue']"));
		sendLinkbutton.click();
		System.out.println("Password reset message page is displayed.");
		
		System.out.println("Please check ur email is displayed.");
		//Logger.log(LogStatus.PASS, returntologin + " Password reset message page is displayed");
		endExtentReport();

	}
//free trail application testcase
	public static void t5() throws InterruptedException, IOException {
		stratExtentReport();
		initializeDriver();
		launch("https://www.xero.com/us/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet4"); 
		WebElement freeTrail = driver.findElement(By.linkText("Free trial"));
		clickObject(freeTrail);
		System.out.println("30 days free trail is displayed");
		WebElement firstName = driver.findElement(By.xpath("//input[@name='FirstName']"));
		enterText(firstName,recData[0][0])	;
		System.out.println("first name is displayed " + recData[0][0] );
		WebElement lastName = driver.findElement(By.xpath("//input[@name='LastName']"));
		enterText(lastName, recData[0][1]);
		WebElement emailAddress = driver.findElement(By.xpath("//input[@name='EmailAddress']"));
		enterText(emailAddress, recData[0][2]);
		WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='PhoneNumber']"));
		enterText(phoneNumber,recData[0][3]);
		Select country = new Select(driver.findElement(By.xpath("//Select[@name='LocationCode']")));
		country.selectByVisibleText("United States");
		WebElement termsAndpolicy = driver.findElement(By.xpath("//input[@value='true']"));
		clickObject(termsAndpolicy);
		WebElement getStarted = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		clickObject(getStarted);
		System.out.println("Inbox is displyed");
		endExtentReport();
	}

	public static void t6() throws InterruptedException, IOException {
		stratExtentReport();
		initializeDriver();
		launch("https://www.xero.com/us/");
		WebElement freeTrail = driver.findElement(By.linkText("Free trial"));
		clickObject(freeTrail);
		WebElement getStarted = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		clickObject(getStarted);
		String errorMessage = driver.findElement(By.xpath("//input[@name='FirstName']")).getText();
		System.out.println(errorMessage);
		String actualMessage="First name can't be empty";
		CompareString(actualMessage,errorMessage);
		System.out.println("");
		
		String lastNameerrorMessage = driver.findElement(By.xpath("//input[@name='LastName']")).getText();
		System.out.println(lastNameerrorMessage);
		String lastNameactualMessage="Last name can't be empty";
		CompareString(lastNameactualMessage,lastNameerrorMessage );
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet3"); 
		String emailAddressErrorMessage = driver.findElement(By.xpath("//input[@name='EmailAddress']")).getText();
		System.out.println(emailAddressErrorMessage);
		String actualMsgEmailAddress="Email address can't be empty";
		CompareString(actualMsgEmailAddress,emailAddressErrorMessage);
		String phoneNumberErrorMsg = driver.findElement(By.xpath("//input[@name='LastName']")).getText();
		System.out.println(phoneNumberErrorMsg);
		String phoneNoActalMsg="Phone number can't be empty";
		CompareString(phoneNoActalMsg,phoneNumberErrorMsg);
		
		WebElement emailAddress1 = driver.findElement(By.xpath("//input[@name='EmailAddress']"));
		enterText(emailAddress1, recData[0][0]);
		System.out.println("email address is invalid displayed");
		WebElement getStarted1 = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		clickObject(getStarted1);
		System.out.println("terms and Policy codnditons is highlighting");
		endExtentReport();
	}

	public static void t7() throws InterruptedException {
		stratExtentReport();
		initializeDriver();
		launch("https://www.xero.com/us/");
		WebElement freeTrail = driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickObject(freeTrail);
		WebElement termsOfuseLink = driver.findElement(By.xpath("//a[contains(text(),'terms of use')]"));
		clickObject(termsOfuseLink);
		System.out.println("A new Xero terms of use web page is opened");
		WebElement privacyNoticeLink = driver.findElement(By.xpath("//a[contains(text(),'privacy notice')]"));
		clickObject(privacyNoticeLink);
		System.out.println("A new Privay notice page is displayed");
		endExtentReport();

	}

	public static void t8() throws InterruptedException {
		stratExtentReport();
		initializeDriver();
		launch("https://www.xero.com/us/");
		WebElement freeTrail = driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickObject(freeTrail);
		WebElement offerDetailsLink = driver.findElement(By.xpath("//a[contains(text(),'offer details')]"));
		clickObject(offerDetailsLink);
		System.out.println("A new offer details page is displayed");
		endExtentReport();

	}

	public static void t9() throws InterruptedException {
		stratExtentReport();
		initializeDriver();
		launch("https://www.xero.com/us/");
		WebElement freeTrail = driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickObject(freeTrail);
		WebElement accountsOrBrookkeeperLink = driver
				.findElement(By.xpath("//a[contains(text(),'accountant or bookkeeper')]"));
		clickObject(accountsOrBrookkeeperLink);
		System.out.println("A new let's get started page is displayed");
		endExtentReport();
	}

	public static void t10() throws InterruptedException, IOException {
		stratExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet1"); 
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		//enterText(emailAdress,"sanka.teluk@gmail.com");
		enterText(emailAdress,recData[0][0]);
		 //findElement(By location, String objName)
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		//enterText(passWord,"Praneel@143");
		enterText(passWord,recData[0][1]);
		
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login);
		WebElement dashBoard = driver
				.findElement(By.linkText("Dashboard"));
		clickObject(dashBoard);
		WebElement business = driver.findElement(By.xpath("//button[contains(text(),'Business')]"));
		clickObject(business);
		WebElement accounting = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/ol[1]/li[3]/button[1]"));
		clickObject(accounting);
		WebElement contacts = driver.findElement(By.xpath("//button[contains(text(),'Contacts')]"));
		clickObject(contacts);
		WebElement newButton = driver
				.findElement(By.xpath("//button[@title='Create new']//*[@class='xrh-icon xrh-icon-svg']"));
		clickObject(newButton);
		WebElement search = driver
				.findElement(By.xpath("//button[@title='Search']//*[@class='xrh-icon xrh-icon-svg']"));
		clickObject(search);
		WebElement notification = driver.findElement(
				By.xpath("//button[@title='Notifications']//div[@class='xrh-focusable--child xrh-iconwrapper']"));
		clickObject(notification);
		WebElement help = driver.findElement(By.xpath("//button[@title='Help']//*[@class='xrh-icon xrh-icon-svg']"));
		clickObject(help);
		endExtentReport();

	}

	public static void t11() throws InterruptedException, IOException {
		stratExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet1"); 
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		//enterText(emailAdress,"sanka.teluk@gmail.com");
		enterText(emailAdress,recData[0][0]);
		 //findElement(By location, String objName)
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		//enterText(passWord,"Praneel@143");
		enterText(passWord,recData[0][1]);
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login);
		WebElement userMenudropDown = driver.findElement(By.xpath("//abbr[@class='xrh-avatar xrh-avatar-color-10']"));
		clickObject(userMenudropDown);
		WebElement logOut = driver.findElement(
				By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/ol[2]/li[5]/div[1]/div[2]/div[1]/ol[1]/li[5]/a[1]"));
		clickObject(logOut);
		System.out.println("User name and password field page is displayed");
		endExtentReport();
	}

	public static void t12() throws InterruptedException, IOException {
		stratExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet1"); 
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		//enterText(emailAdress,"sanka.teluk@gmail.com");
		enterText(emailAdress,recData[0][0]);
		 //findElement(By location, String objName)
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		//enterText(passWord,"Praneel@143");
		enterText(passWord,recData[0][1]);
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login);
		WebElement userMenudropDown = driver.findElement(By.xpath("//abbr[@class='xrh-avatar xrh-avatar-color-10']"));
		clickObject(userMenudropDown);
		WebElement editProfile = driver.findElement(By.xpath("//span[@class='xrh-verticalmenuitem--subheading']"));
		clickObject(editProfile);
		System.out.println("Edit profile page is displayed");
		WebElement uploadImage = driver.findElement(By.xpath("//span[@id='button-1041-btnInnerEl']"));
		clickObject(uploadImage);
		WebElement browseButton = driver.findElement(By.xpath("//input[@id='filefield-1174-button-fileInputEl']"));
		clickObject(browseButton);
		WebElement upLoadbutton = driver.findElement(By.xpath("//input[@id='filefield-1174-button-fileInputEl']"));
		clickObject(upLoadbutton);
		endExtentReport();
	}

	/*public static void t13() throws InterruptedException, IOException {
		stratExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet5"); 
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		//enterText(emailAdress,"sanka.teluk@gmail.com");
		enterText(emailAdress,recData[0][0]);
		 //findElement(By location, String objName)
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		//enterText(passWord,"Praneel@143");
		enterText(passWord,recData[0][1]);
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login);
		WebElement verizonButton = driver.findElement(By.xpath("//span[@class='xrh-appbutton--text']"));
		clickObject(verizonButton);
		WebElement addNewograganizationButton = driver.findElement(By.linkText("Add a new organization"));
		clickObject(addNewograganizationButton);
		
		WebElement organization = driver.findElement(By.xpath(" //input[@id='text-1022-inputEl']"));
		enterText(organization, "recData[0][2]");
		Select payingTaxesIncountry = new Select(driver.findElement(By.xpath("//div[@id='ext-gen1096']")));
		payingTaxesIncountry.selectByVisibleText("United States");

		Select timeZone = new Select(driver.findElement(By.xpath("//input[@id='cmbTimeZone-inputEl']")));
		timeZone.selectByVisibleText("");
		Select currency = new Select(driver.findElement(By.xpath("//div[@id='ext-gen1096']")));
		currency.selectByVisibleText("currency");
		WebElement whatDoesOrganization = driver
				.findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"));
		enterText(whatDoesOrganization, "recData[0][3]");
		WebElement startTrail = driver.findElement(By.linkText("Start Trial"));
		clickObject(startTrail);
		endExtentReport();
	}

	public static void t14() throws InterruptedException {
		stratExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		enterText(emailAdress, "sanka.teluk@gmail.com");
		// findElement(By location, String objName)
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(passWord, "Praneel@13");
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login);
		WebElement verizonButton = driver.findElement(By.xpath("//span[@class='xrh-appbutton--text']"));
		clickObject(verizonButton);
		WebElement addNewograganizationButton = driver.findElement(By.linkText(" Add a new organization"));
		clickObject(addNewograganizationButton);
		WebElement organization = driver.findElement(By.xpath(" //input[@id='text-1022-inputEl']"));
		enterText(organization, "");
		Select payingTaxesIncountry = new Select(driver.findElement(By.xpath("//div[@id='ext-gen1096']")));
		payingTaxesIncountry.selectByVisibleText("United States");

		Select timeZone = new Select(driver.findElement(By.xpath("//input[@id='cmbTimeZone-inputEl']")));
		timeZone.selectByVisibleText("");
		Select currency = new Select(driver.findElement(By.xpath("//div[@id='ext-gen1096']")));
		currency.selectByVisibleText("currency");
		WebElement whatDoesOrganization = driver
				.findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"));
		enterText(whatDoesOrganization, "");
		WebElement buyNow = driver.findElement(By.linkText("Buy Now"));
		clickObject(buyNow);
		endExtentReport();
	}*/

	public static void t15() throws InterruptedException, IOException {
		stratExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet1"); 
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		//enterText(emailAdress,"sanka.teluk@gmail.com");
		enterText(emailAdress,recData[0][0]);
		 //findElement(By location, String objName)
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		//enterText(passWord,"Praneel@143");
		enterText(passWord,recData[0][1]);
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login);
		WebElement verizonButton = driver.findElement(By.xpath("//span[@class='xrh-appbutton--text']"));
		clickObject(verizonButton);
		WebElement addNewograganizationButton = driver.findElement(By.linkText("Add a new organization"));
		clickObject(addNewograganizationButton );
		endExtentReport();
	}
	public static void t16() throws InterruptedException, IOException {
	stratExtentReport();
	initializeDriver();
	launch("https://login.xero.com/");
	String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
	String[][] recData = readExcelSheet(dt_path, "Sheet1"); 
	WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
	//enterText(emailAdress,"sanka.teluk@gmail.com");
	enterText(emailAdress,recData[0][0]);
	 //findElement(By location, String objName)
	WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
	//enterText(passWord,"Praneel@143");
	enterText(passWord,recData[0][1]);
	WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
	clickObject(login);
	WebElement accounting = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/ol[1]/li[3]/button[1]"));
	clickObject(accounting);
	WebElement accountPayableSummary=driver.findElement(By.xpath("//a[contains(text(),'Aged Payables Summary')]"));
	clickObject(accountPayableSummary);
	System.out.println("Reports page is displayed");
	}
}


