package flight_booking_testing.anthropic_model_testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlightBookingTest {
	@Test
	public void basicTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\satya\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"https://www.cheapoair.com/flights/booknow/cheap-flight-tickets?fpaffiliate=coa-googledesktop-global-generic&fpsub=&utm_campaign=Generic_Exact_ATLAS_Global_SP&utm_term=airline%20travel&utm_term_id=kwd-15034210&utm_source={google}&utm_medium={cpc}&device=c&fpprice=&campaignID=21771907160&adgroupId=172153806190&gad_source=1&gad_campaignid=21771907160&gbraid=0AAAAA-RU5jWHGplYGB4CqgKWVKZg8Bjsg&gclid=Cj0KCQjwyvfDBhDYARIsAItzbZEjfn-oJdZsEQLUiIo2-E38EwLBM6fGyjWRgygy4HdRmq9IGr42LsIaAshxEALw_wcB");
		driver.quit();
	}
}
