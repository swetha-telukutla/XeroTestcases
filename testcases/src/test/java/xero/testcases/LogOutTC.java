package xero.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogOutTC extends ReusableMethodsForXEROtestcases {
	public static void logOutTestCase() throws InterruptedException, IOException {
		startExtentReport();
		initializeDriver();
		launch("https://login.xero.com/");
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

}
