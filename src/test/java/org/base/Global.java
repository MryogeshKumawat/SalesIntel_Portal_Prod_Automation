package org.base;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;

import cucumber.api.Result;
import io.cucumber.core.api.Scenario;

import com.aventstack.extentreports.MediaEntityBuilder;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Text;

import javax.swing.*;

public class Global {

	public static WebDriver driver;
	public static FileInputStream fileInputStream;
	public static Properties properties;
	public static Workbook workbook;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	public static Logger logger;
	public static File file;

	public static WebDriver getDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}

	public static void enterData(WebElement webElement, String data) {
		webElement.sendKeys(data);
	}

	public static void clickButton(WebElement webElement) {
		webElement.click();
	}
	public static void clearText(WebElement webElement) {
		webElement.clear();
	}
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public static void launchURL(String url) {
		driver.get(url);
	}
	public static void Scrollpup(WebElement webElement) {
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",webElement);
	}
	public static void Scrolldown(WebElement webElement) {
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);",webElement);
	}
	public static void uploadfilefromlocal(String file) throws InterruptedException, AWTException {
		StringSelection stringSelection=new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Thread.sleep(5000);
        Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        System.out.println("Uploaded Sucessfully");
	}

	public static void uploadCompanyListfilefromlocal(String file) throws InterruptedException, AWTException {
		StringSelection stringSelection=new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Thread.sleep(5000);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("Uploaded Sucessfully");
	}

	public static Properties readPropertyFileData() {
		try {
			fileInputStream = new FileInputStream(new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\Global_Data.properties"));
			properties = new Properties();
			try {
				properties.load(fileInputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}

	public static String readData(int rowNo, int cellNo) throws IOException {
		String name = null;
		try {
			fileInputStream = new FileInputStream(
					new File("D:/Automation/Projects/SalesIntel/src/test/resources/Excel_Data/TestData.xlsx"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileInputStream.close();
		workbook = new XSSFWorkbook();
		sheet = workbook.getSheet("Sheet_1");
		row = sheet.getRow(rowNo);
		cell = row.getCell(cellNo);
		int type = cell.getCellType();
		if (type == 1) {
			name = cell.getStringCellValue();
		} else if (type == 0) {
			boolean cellF = DateUtil.isCellDateFormatted(cell);
			if (cellF == true) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat fr = new SimpleDateFormat("dd-MMM-yy");
				name = fr.format(date);
			} else {
				double d = cell.getNumericCellValue();
				long l = (long) d;
				name = String.valueOf(l);
			}
		}
		return name;

	}

	public static void readCompleteDataFromEXcel() throws IOException {
		try {
			fileInputStream = new FileInputStream(
					new File("D:/Automation/Projects/SalesIntel/src/test/resources/Excel_Data/TestData.xlsx"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileInputStream.close();
		workbook = new XSSFWorkbook();
		sheet = workbook.getSheet("Sheet_1");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row2 = sheet.getRow(i);
			for (int j = 0; j < row2.getPhysicalNumberOfCells(); j++) {
				Cell cell2 = row2.getCell(j);
				System.out.println(cell2);
			}
		}
	}

	public static Logger readLog4jData() {
		logger = Logger.getLogger(Global.class);
		try {
			PropertyConfigurator.configure(new FileInputStream(
					new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\Log4j.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return logger;
	}

	public static void generateJVMReport(String jsonFile) {
		Configuration configuration = new Configuration(
				new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Reports\\CucumberReports"),
				"SalesIntel Site Automation");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("OS Name", System.getProperty("os.name"));
		try {
			configuration.addClassifications("Host Name", InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();

	}

	public static String ReadDatafromJson(String arg1, String arg2) throws Throwable {
		FileReader fileReader=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData_Folder\\TestData.json");
		JSONParser jsonParser=new JSONParser();
		Object parse = jsonParser.parse(fileReader);
		JSONObject jsonObject=(JSONObject) parse;
		Object object = jsonObject.get(arg1);
		JSONObject jsonObject1=(JSONObject) object;
		return jsonObject1.get(arg2).toString();
	}

//	protected void rangeSlidePointer(String locator, int xOffset, int yOffset) {
//		WebDriverWait explicitWait = new WebDriverWait( driver, 1000 * 60 * 2 );
//		By findBy = By.xpath( locator );
//		WebElement sliderElement = explicitWait.until(ExpectedConditions.elementToBeClickable( findBy ));
//		Actions moveSlider = new Actions(driver);
////		Actions action = moveSlider.dragAndDropBy(sliderElement,xOffset,yOffset).release()
////		Actions action = moveSlider.dragAndDropBy(sliderElement, xOffset, yOffset).release().build();
//		 Actions action = moveSlider.moveToElement(sliderElement).clickAndHold().moveByOffset(xOffset,yOffset).release();
//		action.perform();
//	}


}
