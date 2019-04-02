package xero.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReusableMethodsForXEROtestcases {
	
	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest Logger;
	//Name of the method:ExtentReport
	public static void stratExtentReport(){
		System.out.println("start");
		//initialize extent report
		String path = "C:\\Swetha\\JanQaReports\\Test1.html";
		report = new ExtentReports(path,false);
		//initialize logger
		Logger = report.startTest("Login to SFDC");
	}
	//Name of the method:InitialzindDriver
	public static void initializeDriver() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SankarA\\Downloads\\chromedriver_win32\\chromedriver.exe ");
		driver = new ChromeDriver();

	}
	//Name of the method:Launching Url
	public static void launch(String url) {

		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("Pass:Salesforce application page is displayed");
		Logger.log(LogStatus.PASS, url + "Salesforce application is displayed");
	}
	//Name of the method:FindElement
	public static WebElement findElement(By location, String element) {

		WebElement obj = null;
		try {
			obj = driver.findElement(location);
			System.out.println("pass:" + element+" " + "found on the page");
			Logger.log(LogStatus.PASS, element + " found on the page");

		} catch (NoSuchElementException errMessage) {
			System.out.println("Fail:" + element + "not found on the page");
			 Logger.log(LogStatus.FAIL, element);

		}
		return obj;
	}
	//Creating the method for enterText
	public static void enterText(WebElement element,String textVal) throws InterruptedException
	{
		if(element.isDisplayed()){
			Thread.sleep(4000);
			element.sendKeys(textVal);
			System.out.println("Entering into text field is success");
			Logger.log(LogStatus.PASS, element + " entered text successfully");
		}else
			{
			System.out.println("Failed, doesn't exit please chek");
			Logger.log(LogStatus.FAIL, element+"unable to enter the text in the text field");
		}
	}
	/*  Name of the method:clickObject--->Button
	 * Brief Description:Clicking on the button
	 * Arguments :WebElement
	 * Created By:Automation  Team
	 * Created date:03/12/2019
	 * Last Modified:
	 */
	public static void clickObject(WebElement element) throws InterruptedException
	{
		if(element.isDisplayed()){
			Thread.sleep(4000);
			element.click();
			System.out.println("Element is successfully clicked");
			Logger.log(LogStatus.PASS, element + "clicked button successfully");
		}
			else{
				System.out.println("Uanble to find the Button");
				Logger.log(LogStatus.FAIL, element+"unable to click the button");
			}
	}
	public static void clickCheckBox(WebElement element, String value) {
		
		if (element.isDisplayed()) {
			if (element.isSelected()) {
				element.click();
			}
			System.out.println("check box is selected");
			Logger.log(LogStatus.PASS, element+"Checkbox selected");
			// System.out.println("pass: " + objName + "found on the page");
		} else {
			Logger.log(LogStatus.FAIL, element+"checkbox selected");
		}
	}
		public static void selectByValue(WebElement element,String value) throws InterruptedException
		{
			if(element.isDisplayed()){
				Select select=new Select(element);
				select.selectByValue(value);
				System.out.println("Element is selected");
				Logger.log(LogStatus.PASS, element + "Selected element successfully");
			}
			else{
				System.out.println("Unable to select the element");
				Logger.log(LogStatus.FAIL, element+"unable to select the element");
			}
		}
		public static void selectByVisibleText(WebElement element,String value) throws InterruptedException
		{
			if(element.isDisplayed()){
				Select state=new Select(element);
				state.selectByVisibleText(value);
				System.out.println("Element is selected");
				Logger.log(LogStatus.PASS, element + "Selected element successfully");
			}
			else{
				System.out.println("Unable to select the element");
				Logger.log(LogStatus.FAIL, element+"unable to select the element");
			}
		}
		public static void CompareString(String s1,String s2){
			SoftAssert assertion=new SoftAssert();
			try{
				assertion.assertEquals(s1, s2);
				Logger.log(LogStatus.PASS, "both messages are same");
				System.out.println("both messages are same");
			}
			catch(AssertionError a){
				System.out.println("Strings are not the same");
			}
		}
		public static void windowClose(){
			Set<String> getAllWindows=driver.getWindowHandles();
			String[] window=getAllWindows.toArray(new String[getAllWindows.size()]);
			driver.switchTo().window(window[1]).close();
			System.out.println("executed");
		}
		public static String[][] readExcelSheet(String dataTablepath, String sheetName) throws IOException {

			// Step 1:get the xl path
			File xlFile = new File(dataTablepath);
			// Step 2:Access the xl file
			FileInputStream xlDoc = new FileInputStream(xlFile);
			// Step 3:Access the workBook
			XSSFWorkbook  xssfWorkbook= new XSSFWorkbook(xlDoc);
			// Step 4:Access the Sheet
			XSSFSheet sheet = xssfWorkbook.getSheet(sheetName);
			
			int iRowCount = sheet.getLastRowNum() + 1;
			int iColCount = sheet.getRow(0).getLastCellNum();
			String[][] xldata = new String[iRowCount][iColCount];
			for (int i = 0; i < iRowCount; i++) {
				for (int j = 0; j < iColCount; j++) {
					if(sheet.getRow(i).getCell(j).getCellTypeEnum() == CellType.STRING)
					xldata[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
					else if(sheet.getRow(i).getCell(j).getCellTypeEnum() == CellType.NUMERIC)
						xldata[i][j] = new Double(sheet.getRow(i).getCell(j).getNumericCellValue()		).toString();
						}

			}
			
			
		
			return xldata;

		}
			
			
			public static void endExtentReport(){
				
				driver.close();
				report.endTest(Logger);
				report.flush();
				System.out.println("end");
	
			}
			
	


		
}






