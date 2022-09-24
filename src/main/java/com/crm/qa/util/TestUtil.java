package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String PATH = "C:\\SeleniumWorkspace\\NaveenPOM\\src\\main\\java\\com\\crm\\qa\\testdata\\testdata.xlsx";
	public static Object data[][];

	public void webElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public Object[][] getDataValues(String sheetName) {
		try {
			FileInputStream fins = new FileInputStream(new File(PATH));
			XSSFWorkbook workbook = new XSSFWorkbook(fins);
			Sheet desiredSheet = workbook.getSheet(sheetName);
			data= new Object[desiredSheet.getLastRowNum()][desiredSheet.getRow(0).getLastCellNum()];
			for (int i = 1; i <= desiredSheet.getLastRowNum(); i++) 
			{
				for(int j = 0 ; j < desiredSheet.getRow(0).getLastCellNum() ; j++ )
				{
					
					data[i-1][j] = desiredSheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
			workbook.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return data;
	}

}
