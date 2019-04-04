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
	
	protected static WebDriver driver;
	static ExtentReports report;
	protected static ExtentTest Logger;
	static final String dt_path ="Xero.xlsx";
	/*  Name of the method:startExtentReport
	 * Brief Description:starting the extent report
	 * Created By:Automation  Team
	 * Created date:03/29/2019
	 * Last Modified:
	 */
	public static void startExtentReport(){
	System.out.println("start");
		
	//initialize extent report
	String path = "Test1.html";
	report = new ExtentReports(path,false);
		
	//initialize logger
	Logger = report.startTest("Login to Xero application");
	}
	
	/*  Name of the method:inializing driver
	 * Brief Description:driver initialization
	 * Created By:Automation  Team
	 * Created date:03/29/2019
	 * Last Modified:
	 */
	public static void initializeDriver() {
		
	System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SankarA\\Downloads\\chromedriver_win32\\chromedriver.exe ");
	driver = new ChromeDriver();
	}	
	
	/*Name of the method:Launching Url
	* Created By:Automation  Team
	 * Created date:03/29/2019
	 * Last Modified:
	 */
	public static void launch(String url) {

		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("Pass:Xero application page is displayed");
		Logger.log(LogStatus.PASS, url + "Xero application is displayed");
	}
	
	/*  Name of the method:find element
	 * Brief Description:finding the element in the application
	 arguments:String element,By location
	 * Created By:Automation  Team
	 * Created date:03/29/2019
	 * Last Modified:
	 */
	public static WebElement findElement(By location, String element) {

		WebElement obj = null;
		try {
			obj = driver.findElement(location);
			System.out.println("pass:" + element + " " + "found on the page");
			Logger.log(LogStatus.PASS, element + " found on the page");

		} catch (NoSuchElementException errMessage) {
			System.out.println("Fail:" + element + "not found on the page");
			Logger.log(LogStatus.FAIL, element+"not found on the page");

		}
		return obj;
	}

	/*
	 * Name of the method:enterText Brief Description:entering the value in the text
	 * field arguments:Webelement,string Created By:Automation Team Created
	 * date:03/29/2019 Last Modified:
	 */
	public static void enterText(WebElement element,String textVal,String elementName) throws InterruptedException
	{
		if (element.isDisplayed()) {
			Thread.sleep(4000);
			element.sendKeys(textVal);
			System.out.println("Pass:"+textVal+"value enterd in"+elementName+"fields");
			Logger.log(LogStatus.PASS, textVal + "value entered in "+elementName+"field");
		} else {
			System.out.println("Failed, doesn't exit please chek");
			Logger.log(LogStatus.FAIL, textVal +  "value is not entered in "+elementName+"field");
		}
	}
	
	/*  Name of the method:clickObject--->Button
	 * Brief Description:Clicking on the button
	 * Arguments :WebElement,String
	 * Created By:Automation  Team
	 * Created date:03/29/2019
	 * Last Modified:
	 */
	public static void clickObject(WebElement element,String elementName) throws InterruptedException
	{
		if (element.isDisplayed()) {
			Thread.sleep(4000);
			element.click();
			System.out.println("Pass:"+elementName+ "is successfully clicked");
			Logger.log(LogStatus.PASS,elementName+ "clicked successfully");
		} else {
			System.out.println("Uanble to find the Button");
			Logger.log(LogStatus.FAIL, elementName + "not clicked");
		}
	}
	
	/*  Name of the method:clickCheckBox
	 * Brief Description:Clicking on the CheckBox
	 * Arguments :WebElement,string
	 * Created By:Automation  Team
	 * Created date:03/29/2019
	 * Last Modified:
	 */
	public static void clickCheckBox(WebElement element, String value) {

		if (element.isDisplayed()) {
			if (element.isSelected()) {
				element.click();
			}
			System.out.println("check box is selected");
			Logger.log(LogStatus.PASS, value + "is selected");
			// System.out.println("pass: " + objName + "found on the page");
		} else {
			Logger.log(LogStatus.FAIL, value + "is selected");
		}
	}
	
	/*  Name of the method:selectByValue
	 * Brief Description:selecting the element by value
	 * Arguments :WebElement,string
	 * Created By:Automation  Team
	 * Created date:03/29/2019
	 * Last Modified:
	 */
		public static void selectByValue(WebElement element,String value) throws InterruptedException
	{
		if (element.isDisplayed()) {
			Select select = new Select(element);
			select.selectByValue(value);
			System.out.println("Element is selected");
			Logger.log(LogStatus.PASS, value+ "Selected  successfully");
		} else {
			System.out.println("Unable to select the element");
			Logger.log(LogStatus.FAIL, value + "is not selected");
		}
	}

		/*  Name of the method:selectByVisibleText
		 * Brief Description:selecting the element by VisibleText
		 * Arguments :
		 * Created By:Automation  Team
		 * Created date:03/29/2019
		 * Last Modified:
		 */
		public static void selectByVisibleText(WebElement element,String value) throws InterruptedException
	{
		if (element.isDisplayed()) {
			Select state = new Select(element);
			state.selectByVisibleText(value);
			System.out.println("Element is selected");
			Logger.log(LogStatus.PASS,value+ "is selected");
		} else {
			System.out.println("Unable to select the element");
			Logger.log(LogStatus.FAIL, value + "unable to select the element");
		}
	}
		
		
		/*  Name of the method:CompareString
		 * Brief Description:comaparting the one string with another string
		 * Arguments :two strings
		 * Created By:Automation  Team
		 * Created date:03/29/2019
		 * Last Modified:
		 */
		public static void CompareString(String s1,String s2){
			SoftAssert assertion=new SoftAssert();
		try {
			assertion.assertEquals(s1, s2);
			Logger.log(LogStatus.PASS, "both messages are same");
			System.out.println("both messages are same");
		} catch (AssertionError a) {
			System.out.println("Strings are not the same");
			Logger.log(LogStatus.FAIL, "both messages are not same");
		}
	}

		/*  Name of the method:windowClose
		 * Brief Description:closing the window
		
		 * Created By:Automation  Team
		 * Created date:03/29/2019
		 * Last Modified:
		 */
		
		public static void windowClose(){
			Set<String> getAllWindows=driver.getWindowHandles();
			String[] window=getAllWindows.toArray(new String[getAllWindows.size()]);
			driver.switchTo().window(window[1]).close();
			System.out.println("window is closed");
			Logger.log(LogStatus.PASS, "window is closed");
			Logger.log(LogStatus.FAIL, "window is  not closed");
		}
		/*  Name of the method:readExcelSheet
		 * Brief Description:reading the test data from excel sheet
		 * Arguments :TWo strings
		 * Created By:Automation  Team
		 * Created date:03/29/2019
		 * Last Modified:
		 */
		
		public static String[][] readExcelSheet(String dataTablepath, String sheetName) throws IOException {

		// Step 1:get the xl path
		File xlFile = new File(dataTablepath);
		// Step 2:Access the xl file
		FileInputStream xlDoc = new FileInputStream(xlFile);
		// Step 3:Access the workBook
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(xlDoc);
		// Step 4:Access the Sheet
		XSSFSheet sheet = xssfWorkbook.getSheet(sheetName);

		int iRowCount = sheet.getLastRowNum() + 1;
		int iColCount = sheet.getRow(0).getLastCellNum();
		String[][] xldata = new String[iRowCount][iColCount];
		for (int i = 0; i < iRowCount; i++) {
			for (int j = 0; j < iColCount; j++) {
				if (sheet.getRow(i).getCell(j).getCellTypeEnum() == CellType.STRING)
					xldata[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				else if (sheet.getRow(i).getCell(j).getCellTypeEnum() == CellType.NUMERIC)
					xldata[i][j] = new Double(sheet.getRow(i).getCell(j).getNumericCellValue()).toString();
			}
			System.out.println("reading the data from excel sheet");
			Logger.log(LogStatus.PASS, "reading the data from excel sheet");
			Logger.log(LogStatus.FAIL, "data is not reading from excel sheet");

		}

		return xldata;
		
	}

		/*  Name of the method:endExtentReport
		 * Brief Description:closing the report
		 
		 * Created By:Automation  Team
		 * Created date:03/29/2019
		 * Last Modified:
		 */
	public static void endExtentReport() {

		driver.quit();
		report.endTest(Logger);
		report.flush();
		System.out.println("end");
		Logger.log(LogStatus.PASS, "extent report is ending");
		Logger.log(LogStatus.FAIL, "extent report is not ending");
		

	}
			
}






