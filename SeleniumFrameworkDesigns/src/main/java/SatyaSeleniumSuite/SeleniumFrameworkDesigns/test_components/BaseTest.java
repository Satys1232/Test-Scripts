package SatyaSeleniumSuite.SeleniumFrameworkDesigns.test_components;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException {
		Properties properties = new Properties();
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("GlobalData.properties")) {
			if (input == null) {
				throw new FileNotFoundException("Property file 'GlobalData.properties' not found in the classpath");
			}
			properties.load(input);
		}
		
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: properties.getProperty("browser");
		// String browserName = properties.getProperty("browser");
		if (browserName == null) {
			throw new IllegalArgumentException("'browser' property is missing in GlobalData.properties");
		}
		boolean isHeadless = browserName.toLowerCase().contains("headless");
		if (browserName.toLowerCase().contains("chrome")) {
			// WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\satya\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			if (isHeadless) {
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1440,900");
			}
			driver = new ChromeDriver(options);
			
		} else if ("firefox".equalsIgnoreCase(browserName)) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\satya\\Desktop\\geckodriver-v0.36.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if ("edge".equalsIgnoreCase(browserName)) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException(
					"Browser '" + browserName + "' is not supported. Use chrome, firefox, or edge.");
		}
		if(!isHeadless) {
			 driver.manage().window().maximize();	
		}
		
		return driver;
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goToLoginPage();
		return landingPage;
	}

	@AfterMethod(alwaysRun = true)
	public void close() {
		driver.close();
	}

	public List<HashMap<String, String>> getJsonDataToMap(String jsonFileName) throws IOException {
		// Load resource from classpath
		URL resource = getClass().getClassLoader().getResource("PurchaseOrder.json");
		File file = new File(resource.getFile());
		String jsonContent = FileUtils.readFileToString(file, "UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String takeScreenshot(String fileName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir") + "/Screenshots/" + fileName + ".png";
		File dest = new File(destPath);
		FileUtils.copyFile(src, dest);
		// Return relative path from ExtentReport.html to Screenshots
		return "../../Screenshots/" + fileName + ".png";
	}

}
