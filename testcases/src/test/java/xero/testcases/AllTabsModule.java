package xero.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AllTabsModule extends ReusableMethodsForXEROtestcases{
	//test all tabs page
		public static void t10() throws InterruptedException, IOException {
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

}
