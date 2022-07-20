package com.cts.automation.base;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperClass {
	public static WebDriver driver = null;
	public static File f;
	public static Workbook w;
	public static TakesScreenshot ts ;
	public static Actions acc;
	public static Robot r;
	public static  JavascriptExecutor js;
	public static int ScreesnshotCounter = 0;
	

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		WebDriverManager.firefoxdriver().setup();
//		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	public static String[][] excelReading(String path,String sheetName) throws IOException {

		String arr[][] = new String[2][2];
		f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		w = new XSSFWorkbook(fis);
		Sheet s = w.getSheet(sheetName);
		for(int i = 0;i<s.getPhysicalNumberOfRows();i++) {
			Row r = s.getRow(i);
			for(int j=0;j<r.getPhysicalNumberOfCells();j++) {
				Cell c = r.getCell(j);
				String eachCellValue = c.getStringCellValue();
				arr[i][j]= eachCellValue;
			}}
		return arr;
	}

	public static Object[][] readExcel(String filePath,String sheetName) throws IOException {

		FileInputStream fis = new FileInputStream(filePath);
		w = new XSSFWorkbook(fis);
		Sheet s = w.getSheet(sheetName);
		int totalRows = s.getPhysicalNumberOfRows();
		int totalCols = s.getRow(0).getPhysicalNumberOfCells();
		Object[][] dataArr = new Object[totalRows][totalCols] ;
		for(int i = 0;i<s.getPhysicalNumberOfRows();i++) {
			Row r = s.getRow(i);
			for(int j=0;j<r.getPhysicalNumberOfCells();j++) {
				Cell c = r.getCell(j);
			    String eachCellValue = c.getStringCellValue();
				dataArr[i][j]= eachCellValue;
			}}
		return dataArr;
	}

	public static String[][] mainReadExcel(String filePath,String sheetName) throws IOException {
		
		
		String[][] strArr = new String[10][10];
        FileInputStream fis = new FileInputStream(filePath);
		w = new XSSFWorkbook(fis);
		Sheet s = w.getSheet(sheetName);
		  for(int i = 0;i<s.getPhysicalNumberOfRows();i++) {
			Row r = s.getRow(i);
			for(int j=0;j<r.getPhysicalNumberOfCells();j++) {
				Cell c = r.getCell(j);
				int cellType = c.getCellType();
				if(cellType==1)
				{
					strArr[i][j] = c.getStringCellValue();
				}
				else if (cellType==0)   //if cellType ==0,then it means either it can date cell or numeric cell
				{
				    if(DateUtil.isCellDateFormatted(c)) 
				    {
				    	Date date = c.getDateCellValue();
				    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
				    	strArr[i][j] = sdf.format(date);
				    	}
				    else
				    {
				    	double d = c.getNumericCellValue();  //double d = c.getNumericCellValue();
				    	long l = (long)d;                    //long l = (long)d;
				    	strArr[i][j] = String.valueOf(l);    //strArr[i][j] = String.valueOf(d);
				    }
				}
			   System.out.println(strArr[i][j]);
			   //String eachValue = c.getStringCellValue();
			   //strArr[i][j]= eachValue
			}}
		return strArr;
	}

	
	
	
	public static void excelWriting(String filePath,String sheetName,int rowNum,int cellNum,String cellValue) throws IOException {
		FileOutputStream fos = new FileOutputStream (filePath);
		//Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet(sheetName);
		Row r = s.createRow(rowNum);
		Cell c = r.createCell(cellNum);
		c.setCellValue(cellValue);
		w.write(fos);

	}

	public static void selectByText(WebElement e,String text) {
		Select s = new Select(e);
		s.selectByVisibleText(text);


	}

	public static void screenShotwithdateFormat(String fileName) throws IOException {
		ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		String dateStamp = sdf.format(d);
		//FileUtils.copyFile(src, new File ("C:\\Users\\San\\eclipse-workspace\\BaseClass1\\src\\test\\resources\\Screenshot\\"+fileName+dateStamp+".jpeg"));
		FileUtils.copyFile(src, new File ("C:\\Users\\San\\eclipse-workspace\\TestNG\\src\\test\\resources\\Screenshots"+fileName+dateStamp+".jpeg"));

	}

	public static Actions returnActionsobj()
			
			{
		          acc= new Actions(driver);
		          return acc;
		
			}

	//returns an obj of Actions class
	public static void pressKey (int n)
	{
	      for (int i=0; i<n ;i++)
	      {
	    	  returnActionsobj().sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform(); 
	    	  
	      }
	}
	public static void screenShot(String fileName) throws IOException 
	{
	   ts = (TakesScreenshot)driver;
	   File src = ts.getScreenshotAs(OutputType.FILE);
	   String currentDir = System.getProperty("user.dir");
	   File dest = new File((currentDir+"\\src\\test\\resources\\Output\\Screenshot\\"+fileName+".jpeg"));
	   FileUtils.copyFile(src, dest);
	   
	}
	
	public static JavascriptExecutor returnJSobj()
	
	{
          js =  (JavascriptExecutor)driver;
          return js;

	}

	
	
	public static void elementClick (WebElement e) 
	{
	      
		returnJSobj().executeScript("arguments[0].click();", e);
	}


	public static void scrollIntoView (WebElement e) 
	{
	      
		returnJSobj().executeScript("arguments[0].scrollIntoView();", e);
	}

	
	
	
	
	
	
	
	
	
}
