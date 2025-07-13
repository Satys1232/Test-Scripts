package data_excel_implementation.excel_dataprovider_integration;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Upload_Download {
	public static void main(String[] args) throws IOException {
		
		Assignment_9 obj = new Assignment_9();
		String fruit = "Mango", header = "price", updatedPrice = "300";
		String filePath = "C:\\Users\\satya\\Desktop\\download.xlsx";
		FileInputStream instream = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(instream);
		instream.close();
		XSSFSheet sheet = workbook.getSheet("Fruits");
		int fruitRowIndex = Assignment_9.getFruitRowIndex(sheet, fruit);
		int headerColumnIndex = Assignment_9.getHeaderColumnNumber(sheet, header);
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\satya\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		
		
		// download
		driver.findElement(By.id("downloadButton")).click();
		
		
		// edit excel & //upload
		WebElement upload = driver.findElement(By.id("fileinput"));
		Assignment_9.updateCell(sheet, fruitRowIndex, headerColumnIndex, updatedPrice, filePath, workbook);
		upload.sendKeys("C:\\Users\\satya\\Desktop\\download.xlsx");
		
		
		
		// wait for success message to show up and disappear
		By toastElement = By.cssSelector(".Toastify__toast-body div:nth-child(2)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(toastElement));
		String toastMessage = driver.findElement(toastElement).getText();
		String expectedMessage = "Updated Excel Data Successfully.";
		Assert.assertEquals(toastMessage, expectedMessage);
		System.out.println(toastMessage);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastElement));
		
		

		// verify updated excel data
		String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getDomAttribute("data-column-id");
		String price = driver.findElement(By.xpath("//div[text()='"+fruit+"']/parent::div/parent::div/div[@id='cell-"+priceColumn+"-undefined']/div")).getText();
	    Assert.assertEquals(updatedPrice,price);
	    System.out.println("Price of " +fruit+ " is "+updatedPrice +" rupees");
	    driver.close();

	}

}
