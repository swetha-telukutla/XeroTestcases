package xero.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

/**
 * 
 * @author Swetha
 *
 */
public class LoginModule extends ReusableMethodsForXEROtestcases {
	public static void t1 () throws InterruptedException, IOException {
		//Navigate to Xero application
				startExtentReport();
				initializeDriver();
				launch("https://login.xero.com/");
				String[][] recData = readExcelSheet(dt_path, "Sheet1");
				WebElement emailAdress = driver.findElement(By.xpath(" //input[@placeholder='Email address']"));
				enterText(emailAdress, recData[0][0], "username");
				WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
				enterText(passWord, recData[0][1], "password");
				WebElement login =driver.findElement(By.xpath("//button[@id='submitButton']"));
				clickObject(login, "login");
				Thread.sleep(2000);
				endExtentReport();
			}
			
			//Incorrect pwd testcase

			public static void t2() throws InterruptedException, IOException {
				startExtentReport();
				initializeDriver();
				launch("https://login.xero.com/");
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

}
