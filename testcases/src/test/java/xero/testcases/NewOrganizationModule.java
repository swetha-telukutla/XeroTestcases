package xero.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class NewOrganizationModule extends ReusableMethodsForXEROtestcases {
	public static void t13() throws InterruptedException, IOException {
	startExtentReport();
	initializeDriver();
	launch("https://login.xero.com/");
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

public static void t14() throws InterruptedException, IOException {
	startExtentReport();
	initializeDriver();
	launch("https://login.xero.com/");
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

}




