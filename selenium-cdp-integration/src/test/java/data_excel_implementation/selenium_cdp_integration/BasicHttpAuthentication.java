package data_excel_implementation.selenium_cdp_integration;

import java.net.URI;
import java.util.function.Predicate;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicHttpAuthentication {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\satya\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");
	((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("foo", "bar"));
	driver.get("http://httpbin.org/basic-auth/foo/bar");
}
}
