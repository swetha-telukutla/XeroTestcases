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
		startExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet1");
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		enterText(emailAdress, recData[0][0], "username");
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(passWord, recData[0][1], "password");
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login, "login");
		Thread.sleep(2000);
		endExtentReport();
	}
	
	//Incorrect pwd testcase

	public static void t2() throws InterruptedException, IOException {
		startExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet2");
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		enterText(emailAdress, recData[0][0], "username");
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(passWord, recData[0][1], "password");
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login, "login");
		String errorMessage = driver.findElement(By.xpath("//button[@id='submitButton']")).getText();
		System.out.println(errorMessage);
		String actualMessage = ("Your email or password is incorrect");
		CompareString(actualMessage, errorMessage);
		Thread.sleep(2000);
		endExtentReport();

	}
	//Incorrect username testcase

	public static void t3() throws InterruptedException, IOException {
		startExtentReport();
		initializeDriver();
		Thread.sleep(4000);
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet3"); 
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		enterText(emailAdress, recData[0][0], "username");
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(passWord, recData[0][1], "password");
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login, "login");
		String errorMessage = driver.findElement(By.xpath("//button[@id='submitButton']")).getText();
		 System.out.println(errorMessage);
		String actualMessage=("Your email or password is incorrect");
		CompareString(actualMessage, errorMessage);
		Thread.sleep(2000);
		endExtentReport();

	}
	//forgot pwd testcase

	public static void t4() throws InterruptedException, IOException {
		startExtentReport();
		Thread.sleep(4000);
		initializeDriver();
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet1"); 
		WebElement forgotpw = driver.findElement(By.xpath("//a[contains(@class,'forgot-password-advert')]"));
		clickObject(forgotpw,"forgot password");
		System.out.println("Salesforce forgot password page is displayed");
		Logger.log(LogStatus.PASS, forgotpw + "Salesforce forgot password page is displayed ");
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		enterText(emailAdress, recData[0][0], "username");
		WebElement sendLinkbutton = driver.findElement(By.xpath("//a[@class='x-btn blue']"));
		sendLinkbutton.click();
		System.out.println("Password reset message page is displayed.");
		Logger.log(LogStatus.PASS, " Password reset message page is displayed");
		endExtentReport();

	}
//free trail  testcase1
	
//test all tabs page
	public static void t10() throws InterruptedException, IOException {
		startExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet1"); 
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		enterText(emailAdress,recData[0][0],"email address");
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(passWord,recData[0][1],"password");
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login,"login");
		WebElement dashBoard = driver.findElement(By.linkText("Dashboard"));
		clickObject(dashBoard,"dash board");
		WebElement business = driver.findElement(By.xpath("//button[contains(text(),'Business')]"));
		clickObject(business,"business");
		WebElement accounting = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/ol[1]/li[3]/button[1]"));
		clickObject(accounting,"accounting");
		WebElement contacts = driver.findElement(By.xpath("//button[contains(text(),'Contacts')]"));
		clickObject(contacts,"contacts");
		WebElement newButton = driver.findElement(By.xpath("//button[@title='Create new']//*[@class='xrh-icon xrh-icon-svg']"));
		clickObject(newButton,"new button");
		WebElement search = driver
				.findElement(By.xpath("//button[@title='Search']//*[@class='xrh-icon xrh-icon-svg']"));
		clickObject(search,"search");
		WebElement notification = driver.findElement(
				By.xpath("//button[@title='Notifications']//div[@class='xrh-focusable--child xrh-iconwrapper']"));
		clickObject(notification,"notifiction");
		WebElement help = driver.findElement(By.xpath("//button[@title='Help']//*[@class='xrh-icon xrh-icon-svg']"));
		clickObject(help,"help");
		endExtentReport();

	}
//test logout functionality
	public static void t11() throws InterruptedException, IOException {
		startExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet1");
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
    	enterText(emailAdress, recData[0][0], "email address");
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(passWord, recData[0][1], "pass word");
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login, "login");
		WebElement userMenudropDown = driver.findElement(By.xpath("//abbr[@class='xrh-avatar xrh-avatar-color-10']"));
		clickObject(userMenudropDown, "user menu dd");
		WebElement logOut = driver.findElement(
				By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/ol[2]/li[5]/div[1]/div[2]/div[1]/ol[1]/li[5]/a[1]"));
		clickObject(logOut, "log out");
		System.out.println("User name and password field page is displayed");
		endExtentReport();
	}
	
//test Upload profile image
	public static void t12() throws InterruptedException, IOException {
		startExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet1"); 
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		enterText(emailAdress,recData[0][0],"email address");
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(passWord,recData[0][1],"pass word");
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login,"login");
		WebElement userMenudropDown = driver.findElement(By.xpath("//abbr[@class='xrh-avatar xrh-avatar-color-10']"));
		clickObject(userMenudropDown,"user menu dd");
		WebElement editProfile = driver.findElement(By.xpath("//span[@class='xrh-verticalmenuitem--subheading']"));
		clickObject(editProfile,"edit profile");
		System.out.println("Edit profile page is displayed");
		WebElement uploadImage = driver.findElement(By.xpath("//span[@id='button-1041-btnInnerEl']"));
		clickObject(uploadImage,"upoload image");
		WebElement browseButton=driver.findElement(By.xpath("//input[@name='file']"));
		clickObject(browseButton,"browser button");
		WebElement upLoadbutton = driver.findElement(By.xpath("//input[@id='filefield-1174-button-fileInputEl']"));
		clickObject(upLoadbutton,"upload button");
		endExtentReport();
	}
	
//Add another organization trail version
	public static void t13() throws InterruptedException, IOException {
		startExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet5"); 
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		enterText(emailAdress,recData[0][0],"email address");
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
				enterText(passWord,recData[0][1],"pass word");
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login,"login");
		WebElement verizonButton = driver.findElement(By.xpath("//span[@class='xrh-appbutton--text']"));
		clickObject(verizonButton,"verizon button");
		Thread.sleep(4000);
		WebElement addNewograganizationButton = driver.findElement(By.linkText("Add a new organization"));
		clickObject(addNewograganizationButton,"adding new organization");
		WebElement organization = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/table[2]/tbody[1]/tr[1]/td[2]/input[1]"));
		enterText(organization,"self","organization name");
		WebElement timeZone=driver.findElement(By.xpath("//input[@id='cmbTimeZone-inputEl']"));
		enterText(timeZone,"(UTC-05:00) Eastern Time (US & Canada)","time zone");
		WebElement whatDoesOrganization = driver
				.findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"));
		enterText(whatDoesOrganization,"Plumbing Services","organization work");enterText(whatDoesOrganization, "Plumbing Services","organization work");
		WebElement startTrail = driver.findElement(By.linkText("Start Trial"));
		clickObject(startTrail,"free trail");
		Thread.sleep(4000);
		Logger.log(LogStatus.PASS,"Welcome to Xero page is displayed");
		endExtentReport();
	}
//clicking on buy now button   
	public static void t14() throws InterruptedException, IOException {
		startExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet5"); 
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		enterText(emailAdress,recData[0][0],"email address");
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
				enterText(passWord,recData[0][1],"pass word");
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login,"login");
		WebElement verizonButton = driver.findElement(By.xpath("//span[@class='xrh-appbutton--text']"));
		clickObject(verizonButton,"verizon button");
		Thread.sleep(4000);
		WebElement addNewograganizationButton = driver.findElement(By.linkText("Add a new organization"));
		clickObject(addNewograganizationButton,"adding new organization");
		WebElement organization = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/table[2]/tbody[1]/tr[1]/td[2]/input[1]"));
		enterText(organization,"self","organization name");
		WebElement timeZone=driver.findElement(By.xpath("//input[@id='cmbTimeZone-inputEl']"));
		enterText(timeZone,"(UTC-05:00) Eastern Time (US & Canada)","time zone");
		WebElement whatDoesOrganization = driver
				.findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"));
		enterText(whatDoesOrganization,"Plumbing Services","organization work");
		Thread.sleep(4000);
		WebElement buyNow = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[2]"));
		clickObject(buyNow,"buy now");
		
		Logger.log(LogStatus.PASS,"Subscriptions page is displayed");
		endExtentReport();
	}

	public static void t15() throws InterruptedException, IOException {
		startExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
		String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
		String[][] recData = readExcelSheet(dt_path, "Sheet1"); 
		WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
		enterText(emailAdress, recData[0][0], "username");
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(passWord, recData[0][1], "password");
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(login, "login");
		WebElement verizonButton = driver.findElement(By.xpath("//span[@class='xrh-appbutton--text']"));
		clickObject(verizonButton,"verizon button");
		Thread.sleep(4000);
		WebElement addNewograganizationButton = driver.findElement(By.linkText("Add a new organization"));
		clickObject(addNewograganizationButton,"adding new organization");
		endExtentReport();
	}
	//Displaying report page
	public static void t16() throws InterruptedException, IOException {
	startExtentReport();
	initializeDriver();
	launch("https://login.xero.com/");
	String dt_path = "C:\\Users\\SankarA\\Documents\\Xero.xlsx";
	String[][] recData = readExcelSheet(dt_path, "Sheet1"); 
	WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
	enterText(emailAdress,recData[0][0],"email address");
	WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
	enterText(passWord,recData[0][1],"password");
	WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
	clickObject(login,"login");
	WebElement accounting = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/ol[1]/li[3]/button[1]"));
	clickObject(accounting,"aaccounting");
	WebElement accountPayableSummary=driver.findElement(By.xpath("//a[contains(text(),'Aged Payables Summary')]"));
	clickObject(accountPayableSummary,"account payable summary");
	System.out.println("Reports page is displayed");
	}
}


