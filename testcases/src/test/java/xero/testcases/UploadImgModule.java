package xero.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UploadImgModule  extends ReusableMethodsForXEROtestcases{
	
	//test Upload profile image
		public static void t12() throws InterruptedException, IOException {
			startExtentReport();
			initializeDriver();
			launch("https://login.xero.com/");
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

}
