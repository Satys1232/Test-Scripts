package selenium_jdbc_connection.mysql_selenium_integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sql_Jdbc_Connection {
	public static void main(String[] args) throws SQLException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\satya\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		final String host = "localhost";
		final String port = "3306";
		Connection conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/credentials","root","Satya@123");
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from cardDetails where cardType ='Visa';");
		while(resultSet.next()) {
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("#username")).sendKeys(resultSet.getString("userName"));
		driver.findElement(By.cssSelector("#password")).sendKeys(resultSet.getString("password"));
		driver.findElement(By.cssSelector("#terms")).sendKeys(Keys.RETURN);
		driver.findElement(By.cssSelector("#signInBtn")).sendKeys(Keys.RETURN);
		
		}
	}
}
