package xero.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountsModule extends ReusableMethodsForXEROtestcases {
	//Displaying report page
		public static void t16() throws InterruptedException, IOException {
		startExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
		
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
