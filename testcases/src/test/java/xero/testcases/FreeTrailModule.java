package xero.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FreeTrailModule extends ReusableMethodsForXEROtestcases {
	public static void t5() throws InterruptedException, IOException {
		startExtentReport();
		initializeDriver();
		launch("https://www.xero.com/us/");
		String[][] recData = readExcelSheet(dt_path, "Sheet4"); 
		WebElement freeTrail = driver.findElement(By.linkText("Free trial"));
		clickObject(freeTrail,"free trail");
		System.out.println("30 days free trail is displayed");
		WebElement firstName = driver.findElement(By.xpath("//input[@name='FirstName']"));
		enterText(firstName,recData[0][0],"first name")	;
		System.out.println("first name is displayed " + recData[0][0] );
		WebElement lastName = driver.findElement(By.xpath("//input[@name='LastName']"));
		enterText(lastName, recData[0][1],"last name");
		WebElement emailAddress = driver.findElement(By.xpath("//input[@name='EmailAddress']"));
		enterText(emailAddress, recData[0][2],"email address");
		WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='PhoneNumber']"));
		enterText(phoneNumber,recData[0][3],"phone number");
		Select country = new Select(driver.findElement(By.xpath("//Select[@name='LocationCode']")));
		country.selectByVisibleText("United States");
		WebElement termsAndpolicy = driver.findElement(By.xpath("//input[@value='true']"));
		clickObject(termsAndpolicy,"terms and policy");
		WebElement getStarted = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		clickObject(getStarted,"get started");
		System.out.println("Inbox is displyed");
		endExtentReport();
	}
	//free trail  testcase2
	public static void t6() throws InterruptedException, IOException {
		startExtentReport();
		initializeDriver();
		launch("https://www.xero.com/us/");
		WebElement freeTrail = driver.findElement(By.linkText("Free trial"));
		clickObject(freeTrail,"free trail");
		WebElement getStarted = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		clickObject(getStarted,"get started");
		String errorMessage = driver.findElement(By.xpath("//input[@name='FirstName']")).getText();
		System.out.println(errorMessage);
		String actualMessage="First name can't be empty";
		CompareString(actualMessage,errorMessage);
		String lastNameerrorMessage = driver.findElement(By.xpath("//input[@name='LastName']")).getText();
		System.out.println(lastNameerrorMessage);
		String lastNameactualMessage="Last name can't be empty";
		CompareString(lastNameactualMessage,lastNameerrorMessage );
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
		enterText(emailAddress1, recData[0][0],"email address");
		System.out.println("email address is invalid displayed");
		WebElement getStarted1 = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		clickObject(getStarted1,"get started");
		System.out.println("terms and Policy codnditons is highlighting");
		endExtentReport();
	}
    // clicking on the links terms of use and privacy notice links testcase
	public static void t7() throws InterruptedException {
		startExtentReport();
		initializeDriver();
		launch("https://www.xero.com/us/");
		WebElement freeTrail = driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickObject(freeTrail,"free trail");
		WebElement termsOfuseLink = driver.findElement(By.xpath("//a[contains(text(),'terms of use')]"));
		clickObject(termsOfuseLink,"terms of use link");
		System.out.println("A new Xero terms of use web page is opened");
		WebElement privacyNoticeLink = driver.findElement(By.xpath("//a[contains(text(),'privacy notice')]"));
		clickObject(privacyNoticeLink,"notice link");
		System.out.println("A new Privay notice page is displayed");
		endExtentReport();

	}
//displaying the offer details page test case
	public static void t8() throws InterruptedException {
		startExtentReport();
		initializeDriver();
		launch("https://www.xero.com/us/");
		WebElement freeTrail = driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickObject(freeTrail,"free trail");
		WebElement offerDetailsLink = driver.findElement(By.xpath("//a[contains(text(),'offer details')]"));
		clickObject(offerDetailsLink,"offer details linl");
		System.out.println("A new offer details page is displayed");
		endExtentReport();

	}
	
//displaying the  get started page
	public static void t9() throws InterruptedException {
		startExtentReport();
		initializeDriver();
		launch("https://www.xero.com/us/");
		WebElement freeTrail = driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickObject(freeTrail,"free trail");
		WebElement accountsOrBrookkeeperLink = driver
				.findElement(By.xpath("//a[contains(text(),'accountant or bookkeeper')]"));
		clickObject(accountsOrBrookkeeperLink,"accounts link");
		System.out.println("A new let's get started page is displayed");
		endExtentReport();
	}
	

}
